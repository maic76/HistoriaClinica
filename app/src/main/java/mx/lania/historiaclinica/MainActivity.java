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

    public void onClickNoPato(View v){
        Intent iNoPato = new Intent("mx.lania.usingintent.AntNoPatologicos");
        startActivityForResult(iNoPato,3);
    }

    public void onClickFamiliares(View v){
        Intent iFami = new Intent("mx.lania.usingintent.AntFamiliares");
        startActivityForResult(iFami,4);
    }

    public void onClickGinecoObste(View v){
        Intent iGine = new Intent("mx.lania.usingintent.AntGinecoObstetricos");
        startActivityForResult(iGine,5);
    }

    public void onClickExploracion(View v){
         Intent iExp = new Intent("mx.lania.usingintent.ExploracionFisica");
        startActivityForResult(iExp,6);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==1){
            if(resultCode == RESULT_OK){
                showMessage("Datos Almacenados de Ficha de Identificación");
            }
            if(resultCode == RESULT_CANCELED){
                showMessage("No guardaste los datos de Ficha de Identificación");
            }
        }
        if(requestCode==2){
            if(resultCode == RESULT_OK){
                showMessage("Datos Almacenados de Antecedentes Patológicos");
            }
            if(resultCode == RESULT_CANCELED){
                showMessage("No guardaste los datos de Antecedentes Patológicos");
            }
        }
        if(requestCode==3){
            if(resultCode == RESULT_OK){
                showMessage("Datos Almacenados de Antecedentes No Patológicos");
            }
            if(resultCode == RESULT_CANCELED){
                showMessage("No guardaste los datos de Antecedentes No Patológicos");
            }
        }
        if(requestCode==4){
            if(resultCode == RESULT_OK){
                showMessage("Datos Almacenados de Antecedentes Familiares");
            }
            if(resultCode == RESULT_CANCELED){
                showMessage("No guardaste los datos de Antecedentes Familiares");
            }
        }
        if(requestCode==5){
            if(resultCode == RESULT_OK){
                showMessage("Datos Almacenados de Antecedentes Gineco-obstétricos");
            }
            if(resultCode == RESULT_CANCELED){
                showMessage("No guardaste los datos de Antecedentes Gineco-obstétricos");
            }
        }
        if(requestCode==6){
            if(resultCode == RESULT_OK){
                showMessage("Datos Almacenados de Exploración Física");
            }
            if(resultCode == RESULT_CANCELED){
                showMessage("No guardaste los datos de Exploración Física");
            }
        }
    }




}