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

public class AntGinecoObstetricos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ant_gineco_obstetricos);

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
        Dialogo dialogFragment = Dialogo.newInstance("¿ Son correctos los datos capturados ?", datos,5);
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
        extras.putString("Menarquia",((EditText) findViewById(R.id.txtMenarquia)).getText().toString());
        extras.putString("Ritmo",((EditText) findViewById(R.id.txtRitmo)).getText().toString());
        extras.putString("F.U.M.",((EditText) findViewById(R.id.txtFUM)).getText().toString());
        extras.putString("G",((EditText) findViewById(R.id.txtG)).getText().toString());
        extras.putString("P",((EditText) findViewById(R.id.txtP)).getText().toString());
        extras.putString("A",((EditText) findViewById(R.id.txtA)).getText().toString());
        extras.putString("C",((EditText) findViewById(R.id.txtC)).getText().toString());
        extras.putString("I.V.S.A.",((EditText) findViewById(R.id.txtIVSA)).getText().toString());

        String anticonceptivos;

        if( ((RadioButton) findViewById(R.id.rdbAntC1)).isChecked() ){
            anticonceptivos = "SI";
        }else if( ((RadioButton) findViewById(R.id.rdbAntC2)).isChecked() ){
            anticonceptivos = "NO";
        }else{
            anticonceptivos = "";
        }

        extras.putString("UsoAnticonceptivos",anticonceptivos);
        extras.putString("MetodosAnticonceptivos",((EditText) findViewById(R.id.txtCuales)).getText().toString());
        extras.putString("PEEA",((EditText) findViewById(R.id.txtPEEA)).getText().toString());
        extras.putString("DNR",((EditText) findViewById(R.id.txtDNR)).getText().toString());
        extras.putString("DPR",((EditText) findViewById(R.id.txtDPR)).getText().toString());
        extras.putString("I.P.A.S.",((EditText) findViewById(R.id.txtIPAS)).getText().toString());

        return extras;
    }
}