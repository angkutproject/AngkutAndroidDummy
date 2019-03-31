package app.slme.angkutcom;

import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.os.Handler;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

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

import app.slme.angkutcom.Model.Account;

public class Splash extends AppCompatActivity {

    TextView txtLogo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        txtLogo = findViewById(R.id.txtLogo);
        AssetManager AManager = getApplicationContext().getAssets();

        Typeface LogoTypeFace = Typeface.createFromAsset(AManager, String.format(Locale.US, "fonts/%s", "Pacifico.ttf"));
        txtLogo.setTypeface(LogoTypeFace);

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                // Do something after 1.5s = 1500ms
                Intent intent = new Intent(Splash.this, Login.class);
                startActivity(intent);
            }
        }, 2500);
    }

    @Override
    protected void onStop() {
        super.onStop();
        finish();
    }
}
