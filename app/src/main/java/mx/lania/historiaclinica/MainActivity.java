package mx.lania.historiaclinica;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    String tag = "Loggin";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        //actionBar.hide();
        //actionBar.setDisplayHomeAsUpEnabled(true);



    }



    public void onClick(View v){
        //Log.d(tag,"entre al clcik");
        startActivity(new Intent("mx.lania.usingintent.FichaId"));
    }


}