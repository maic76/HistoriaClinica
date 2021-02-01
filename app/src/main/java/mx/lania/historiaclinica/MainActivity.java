package mx.lania.historiaclinica;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String tag = "Loggin";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();

    }

    public void showMessage(String message){
        Toast.makeText(getBaseContext(),message,Toast.LENGTH_SHORT).show();
    }

    public void onClickFicha(View v){
        //Log.d(tag,"entre al clcik");
        Intent iFicha = new Intent("mx.lania.usingintent.FichaId");
        startActivityForResult(iFicha,1);
    }

    public void onClickPato(View v){
        //Log.d(tag,"entre al clcik");
        Intent iPato = new Intent("mx.lania.usingintent.AntPatologicos");
        startActivityForResult(iPato,2);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==1){
            if(resultCode == RESULT_OK){
                showMessage("De vuelta al Menú desde Ficha");
            }
            if(resultCode == RESULT_CANCELED){
                showMessage("No guardaste los datos de Ficha de Identificación");
            }
        }
        if(requestCode==2){
            if(resultCode == RESULT_OK){
                showMessage("De vuelta al Menú desde Antecedentes Patológicos");
            }
            if(resultCode == RESULT_CANCELED){
                showMessage("No guardaste los datos de Antecedentes Patológicos");
            }
        }
    }




}