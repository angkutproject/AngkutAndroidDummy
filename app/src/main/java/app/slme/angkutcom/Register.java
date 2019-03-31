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

import java.util.Locale;

import app.slme.angkutcom.Model.Account;

public class Register extends AppCompatActivity {
    TextView txtLogo;
    EditText edtFullName;
    EditText edtUsername;
    EditText edtPassword;
    EditText edtConfirmPassword;
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

        btnRegister = findViewById(R.id.btnRegister);
        btnLogin = findViewById(R.id.btnLogin);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usn = edtFullName.getText().toString();
                String em = edtUsername.getText().toString();
                String pw = edtPassword.getText().toString();
                String confpw = edtConfirmPassword.getText().toString();

                if(usn.equals("") || em.equals("") || pw.equals("") || confpw.equals("")){
                    Toast.makeText(Register.this, "All forms must be filled!", Toast.LENGTH_SHORT).show();
                }else if(!isValidEmail(em)){
                    Toast.makeText(Register.this, "Email invalid!", Toast.LENGTH_SHORT).show();
                    edtUsername.setText("");
                    edtPassword.setText("");
                    edtConfirmPassword.setText("");
                } else if(confpw.equals(pw)) {
                    Intent intent = new Intent(Register.this, Homepage.class);
                    intent.putExtra("username", usn);
                    intent.putExtra("password", pw);
                    intent.putExtra("email", em);
                    startActivity(intent);
                    finish();
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
