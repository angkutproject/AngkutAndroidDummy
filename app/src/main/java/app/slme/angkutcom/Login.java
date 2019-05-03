package app.slme.angkutcom;

import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import app.slme.angkutcom.Instance.ActiveID;
import app.slme.angkutcom.Model.Account;

public class Login extends AppCompatActivity {

    TextView txtLogo;
    EditText edtUsername;
    EditText edtPassword;
    Button btnLogin;
    Button btnRegister;
    List<Account> getAccount = new ArrayList<>();
    ActiveID active = ActiveID.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        txtLogo = findViewById(R.id.txtLogo);

        AssetManager AManager = getApplicationContext().getAssets();

        Typeface LogoTypeFace = Typeface.createFromAsset(AManager, String.format(Locale.US, "fonts/%s", "Pacifico.ttf"));
        txtLogo.setTypeface(LogoTypeFace);
        init();
        edtUsername = findViewById(R.id.edtUsername);
        edtPassword = findViewById(R.id.edtPassword);
        btnLogin = findViewById(R.id.btnLogin);
        btnRegister = findViewById(R.id.btnRegister);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isEmpty(edtUsername.getText().toString())){
                    Toast.makeText(getApplicationContext(),"Username must be filled!", Toast.LENGTH_LONG).show();
                }else if(isEmpty(edtPassword.getText().toString())){
                    Toast.makeText(getApplicationContext(),"Password must be filled!", Toast.LENGTH_LONG).show();
                }else{
                    String Email = edtUsername.getText().toString();
                    String Password = edtPassword.getText().toString();
                    boolean chck = checkLoginData(Email, Password);
                    if(chck){
                        Intent intent = new Intent(Login.this, Homepage.class);
                        startActivity(intent);
                        finish();
                    }else{
                        Toast.makeText(getApplicationContext(), "Email or Password invalid!", Toast.LENGTH_LONG).show();
                        edtPassword.setText("");
                        edtUsername.setText("");
                    }
                }
            }
        });
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this, Register.class);
                intent.putExtra("AccountCount", getAccount.size());
                startActivity(intent);
                finish();
            }
        });
//
//        String URL = Account.getAccountTableURL();
//        JsonArrayRequest request = new JsonArrayRequest(
//                Request.Method.GET,
//                URL,
//                null,
//                new Response.Listener<JSONArray>() {
//                    @Override
//                    public void onResponse(JSONArray response) {
//                        try {
//                            for (int i = 0; i < response.length(); i++) {
//                                Account account = new Account();
//                                account.setAccountID((Integer) response.getJSONObject(i).get("AccountID"));
//                                account.setEmail(response.getJSONObject(i).getString("Email"));
//                                account.setFullName(response.getJSONObject(i).getString("FullName"));
//                                account.setPassword(response.getJSONObject(i).getString("Password"));
//                                account.setPhone(response.getJSONObject(i).getString("Phone"));
//                                getAccount.add(account);
//                            }
//                        } catch (Exception ex) {
//                            Toast.makeText(Login.this, "Volley Error", Toast.LENGTH_LONG).show();
//                        }
//                    }
//                },
//                new Response.ErrorListener() {
//                    @Override
//                    public void onErrorResponse(VolleyError error) {
//                        Log.e("errorVolley", error.toString());
//                    }
//                }
//        );
//
//        RequestQueue requestQueue = Volley.newRequestQueue(this);
//        requestQueue.add(request);
    }

    public void init(){
        Account acc = new Account();
        acc.setAccountID(1);
        acc.setEmail("admin@email.com");
        acc.setFullName("admin");
        acc.setPassword("admin");
        acc.setPhone("0812345767");
        getAccount.add(acc);

        Account acc2 = new Account();
        acc2.setAccountID(2);
        acc2.setEmail("mikhmuhteguh12@gmail.com");
        acc2.setFullName("Muhammad Teguh Pangestu");
        acc2.setPassword("mikha");
        acc.setPhone("0812345678");
        getAccount.add(acc2);
    }

    public boolean isEmpty(String input){
        boolean isTrue = false;
        if(input.trim().equals("")){
            isTrue = true;
        }
        return isTrue;
    }

    public boolean checkLoginData(String Email, String Password){
        boolean checker = false;
        for(int i = 0; i < getAccount.size(); i++){
            if(Email.equals(getAccount.get(i).getEmail())){
                if(Password.equals(getAccount.get(i).getPassword())){
                    checker = true;
                    active.setActiveEmail(Email);
                    active.setActiveUsername(getAccount.get(i).getFullName());
                    active.setActiveID(getAccount.get(i).getAccountID());
                    break;
                }
            }
        }

        return checker;
    }
}
