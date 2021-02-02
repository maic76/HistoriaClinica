package mx.lania.historiaclinica;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class ExploracionFisica extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exploracion_fisica);

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
        Dialogo dialogFragment = Dialogo.newInstance("¿ Son correctos los datos capturados ?", datos,6);
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

        extras.putString("T.A.BrazoDer",((EditText) findViewById(R.id.txtTAD)).getText().toString());
        extras.putString("T.A.BrazoIzq",((EditText) findViewById(R.id.txtTAI)).getText().toString());
        extras.putString("Frec_Cardiaca",((EditText) findViewById(R.id.txtFC)).getText().toString());
        extras.putString("Frec_Respiratoria",((EditText) findViewById(R.id.txtFrecR)).getText().toString());
        extras.putString("Temperatura",((EditText) findViewById(R.id.txtTemp)).getText().toString());
        extras.putString("Peso",((EditText) findViewById(R.id.txtPeso2)).getText().toString());
        extras.putString("Talla",((EditText) findViewById(R.id.txtTalla2)).getText().toString());
        extras.putString("IMC",((EditText) findViewById(R.id.txtIMC)).getText().toString());
        extras.putString("Cabeza_Cuello",((EditText) findViewById(R.id.txtCabeza)).getText().toString());
        extras.putString("Torax",((EditText) findViewById(R.id.txtTorax)).getText().toString());
        extras.putString("Abdomen",((EditText) findViewById(R.id.txtAbdomen)).getText().toString());
        extras.putString("Extremidades",((EditText) findViewById(R.id.txtExtremidades)).getText().toString());
        extras.putString("Neurologico_Mental",((EditText) findViewById(R.id.txtNeurologico)).getText().toString());

        return extras;
    }
}