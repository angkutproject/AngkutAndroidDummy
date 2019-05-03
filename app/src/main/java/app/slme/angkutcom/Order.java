package app.slme.angkutcom;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import app.slme.angkutcom.Instance.ActiveID;

public class Order extends AppCompatActivity {

    ActiveID active = ActiveID.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        Toolbar toolbar = (Toolbar) findViewById(R.id.OrderToolbar);
        toolbar.setTitle("Order A Service");
        setSupportActionBar(toolbar);

    }
}
