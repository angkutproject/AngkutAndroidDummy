package app.slme.angkutcom;

import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.JsonRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.util.Locale;

import app.slme.angkutcom.Model.Account;

public class Register extends AppCompatActivity {
    TextView txtLogo;
    EditText edtFullName;
    EditText edtUsername;
    EditText edtPassword;
    EditText edtConfirmPassword;
    EditText edtPhone;
    Button btnRegister;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        txtLogo = findViewById(R.id.txtLogo);

        AssetManager AManager = getApplicationContext().getAssets();

        Typeface LogoTypeFace = Typeface.createFromAsset(AManager, String.format(Locale.US, "fonts/%s", "Pacifico.ttf"));
        txtLogo.setTypeface(LogoTypeFace);

        edtFullName = findViewById(R.id.edtFullName);
        edtUsername = findViewById(R.id.edtUsername);
        edtPassword = findViewById(R.id.edtPassword);
        edtConfirmPassword = findViewById(R.id.edtConfirmPassword);
        edtPhone = findViewById(R.id.edtPhone);

        btnRegister = findViewById(R.id.btnRegister);
        btnLogin = findViewById(R.id.btnLogin);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usn = edtFullName.getText().toString();
                String em = edtUsername.getText().toString();
                String pw = edtPassword.getText().toString();
                String confpw = edtConfirmPassword.getText().toString();
                String phone = edtPhone.getText().toString();

                int countAcc = getIntent().getIntExtra("AccountCount", 1);

                if(usn.equals("") || em.equals("") || pw.equals("") || confpw.equals("") || phone.equals("")){
                    Toast.makeText(Register.this, "All forms must be filled!", Toast.LENGTH_SHORT).show();
                }else if(!isValidEmail(em)) {
                    Toast.makeText(Register.this, "Email invalid!", Toast.LENGTH_SHORT).show();
                    edtUsername.setText("");
                    edtPassword.setText("");
                    edtConfirmPassword.setText("");
                }else if(phone.length() < 10){
                    Toast.makeText(Register.this, "Phone number has invalid form!", Toast.LENGTH_SHORT).show();
                    edtPhone.setText("");
                } else if(confpw.equals(pw)) {
                    String URL = Account.getAccountTableURL();
                    JSONObject request = new JSONObject();
                    try{
                        request.put("AccountID", countAcc+1);
                        request.put("FullName", usn);
                        request.put("Password", pw);
                        request.put("Email", em);
                        request.put("Phone", phone);
                    }catch (Exception e){
                        Toast.makeText(Register.this, "Failed Creating JSON OBJECT", Toast.LENGTH_LONG).show();
                    }

                    JsonObjectRequest objRequest = new JsonObjectRequest(
                            Request.Method.PUT,
                            URL,
                            request,
                            new Response.Listener<JSONObject>() {
                                @Override
                                public void onResponse(JSONObject response) {
                                    Intent intent = new Intent(Register.this, Homepage.class);
                                    startActivity(intent);
                                    finish();
                                }
                            },
                            new Response.ErrorListener() {
                                @Override
                                public void onErrorResponse(VolleyError error) {
                                    Toast.makeText(Register.this, "Volley Error: " + error.toString(), Toast.LENGTH_LONG).show();
                                }
                            }
                    );
                    RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
                    requestQueue.add(objRequest);
                }else{
                    Toast.makeText(Register.this, "Password and confirm passwords not match!", Toast.LENGTH_SHORT).show();
                    edtPassword.setText("");
                    edtConfirmPassword.setText("");
                }
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Register.this, Login.class);
                startActivity(intent);
                finish();
            }
        });
    }

    public final static boolean isValidEmail(CharSequence target) {
        return !TextUtils.isEmpty(target) && android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches();
    }

}
