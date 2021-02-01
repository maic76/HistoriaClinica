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
import android.widget.Toast;

public class AntNoPatologicos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ant_no_patologicos);

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
        Dialogo dialogFragment = Dialogo.newInstance("¿ Son correctos los datos capturados ?", datos,3);
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

        extras.putString("Alcohol",((EditText) findViewById(R.id.txtAlcohol)).getText().toString());
        extras.putString("Tabaquismo",((EditText) findViewById(R.id.txtTabaquismo)).getText().toString());
        extras.putString("Drogas",((EditText) findViewById(R.id.txtDrogas)).getText().toString());
        extras.putString("Inmunizaciones",((EditText) findViewById(R.id.txtInmunizaciones)).getText().toString());
        extras.putString("Otros",((EditText) findViewById(R.id.txtOtros)).getText().toString());

        return extras;
    }
}