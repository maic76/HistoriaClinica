package mx.lania.historiaclinica;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class AntFamiliares extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ant_familiares);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        //Log.d(tag,"click al boton de la app");
        Intent i = new Intent(getBaseContext(), MainActivity.class);
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(i);
        return true;
    }

    public void onClickGuardar(View v){
        Bundle datos = obtainValues();
        Dialogo dialogFragment = Dialogo.newInstance("¿ Son correctos los datos capturados ?", datos,4);
        dialogFragment.show(getSupportFragmentManager(), "dialog");
    }

    public void onClickCancelar(View v){
        showMessage("Cancelaste");
        Intent i = new Intent();
        setResult(RESULT_CANCELED,i);
        finish();
    }

    public void doPositiveClick(String message) {
        showMessage(message);
        Intent i = new Intent();
        setResult(RESULT_OK,i);
        finish();
    }

    public void doNegativeClick(String message) {
        showMessage(message);
    }

    public void showMessage(String message){
        Toast.makeText(getBaseContext(),message,Toast.LENGTH_SHORT).show();
    }

    public Bundle obtainValues(){

        Bundle extras = new Bundle();
        String respPadreVivo,respMadreViva,respHnosVivos;

        if( ((RadioButton) findViewById(R.id.rdbPadre1)).isChecked() ){
            respPadreVivo = "SI";
        }else if( ((RadioButton) findViewById(R.id.rdbPadre2)).isChecked() ){
            respPadreVivo = "NO";
        }else{
            respPadreVivo = "";
        }

        if( ((RadioButton) findViewById(R.id.rdbMadre1)).isChecked() ){
            respMadreViva = "SI";
        }else if( ((RadioButton) findViewById(R.id.rdbMadre2)).isChecked() ){
            respMadreViva = "NO";
        }else{
            respMadreViva = "";
        }

        if( ((RadioButton) findViewById(R.id.rdbHnos1)).isChecked() ){
            respHnosVivos = "SI";
        }else if( ((RadioButton) findViewById(R.id.rdbPadre2)).isChecked() ){
            respHnosVivos = "NO";
        }else{
            respHnosVivos = "";
        }

        extras.putString("PadreVivo",respPadreVivo);
        extras.putString("MadreViva",respMadreViva);
        extras.putString("HermanosVivos",respHnosVivos);
        extras.putString("Enfermedades_Padre",((EditText) findViewById(R.id.txtEnfPadre)).getText().toString());
        extras.putString("Enfermedades_Madre",((EditText) findViewById(R.id.txtEnfMadre)).getText().toString());
        extras.putString("Enfermedades_Hnos",((EditText) findViewById(R.id.txtEnfHnos)).getText().toString());
        extras.putString("Num_Hnos",((EditText) findViewById(R.id.txtCuantos)).getText().toString());
        extras.putString("Otros",((EditText) findViewById(R.id.txtOtros)).getText().toString());

        return extras;
    }
}