package mx.lania.historiaclinica;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class AntPatologicos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ant_patologicos);

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
        Dialogo dialogFragment = Dialogo.newInstance("¿ Son correctos los datos capturados ?", datos,2);
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
        String cardio = ((CheckBox) findViewById(R.id.chkCardio)).isChecked() ? "SI" : "NO";
        String pulmon = ((CheckBox) findViewById(R.id.chkPulmo)).isChecked() ? "SI" : "NO";
        String diges = ((CheckBox) findViewById(R.id.chkDiges)).isChecked() ? "SI" : "NO";
        String diab = ((CheckBox) findViewById(R.id.chkDiab)).isChecked() ? "SI" : "NO";
        String ren = ((CheckBox) findViewById(R.id.chkRen)).isChecked() ? "SI" : "NO";
        String quir = ((CheckBox) findViewById(R.id.chkQuir)).isChecked() ? "SI" : "NO";
        String ale = ((CheckBox) findViewById(R.id.chkAle)).isChecked() ? "SI" : "NO";
        String trans = ((CheckBox) findViewById(R.id.chkTrans)).isChecked() ? "SI" : "NO";

        extras.putString("Cardiovasculares",cardio);
        extras.putString("Pulmonares",pulmon);
        extras.putString("Digestivos",diges);
        extras.putString("Diabetes",diab);
        extras.putString("Renales",ren);
        extras.putString("Quirurgicos",quir);
        extras.putString("Alérgicos",ale);
        extras.putString("Transfusiones",trans);
        extras.putString("medicamentos",((EditText) findViewById(R.id.txtMedicamentos)).getText().toString());
        extras.putString("especifique",((EditText) findViewById(R.id.txtEspecifique)).getText().toString());

        return extras;
    }


}