package mx.lania.historiaclinica;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class FichaId extends AppCompatActivity {

    String tag = "Loggin";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ficha_id);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        //actionBar.hide();
        actionBar.setDisplayHomeAsUpEnabled(true);



    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        Log.d(tag,"click al boton de la app");
        Intent i = new Intent(getBaseContext(), MainActivity.class);
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(i);
        return true;
    }

    public void onClickGuardar(View v){
        if(validarCampos()){
            Bundle datos = obtainValues();
            Dialogo dialogFragment = Dialogo.newInstance("¿ Son correctos los datos capturados ?", datos,1);
            dialogFragment.show(getSupportFragmentManager(), "dialog");
        }

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

      //  RadioGroup radioGroup = (RadioGroup)  findViewById(R.id.rdGp1);
        RadioButton rb1 = (RadioButton) findViewById(R.id.rdb1);
        RadioButton rb2 = (RadioButton) findViewById(R.id.rdb2);

        String sexo;
        if (rb1.isChecked()) {
            sexo = "Masculino";
        }
        else if (rb2.isChecked()) {
            sexo = "Femenino";
        }else{
            sexo = "Sin información";
        }

        Bundle extras = new Bundle();
        extras.putString("nombre",((EditText) findViewById(R.id.txtNombre)).getText().toString());
        extras.putString("apellido",((EditText)  findViewById(R.id.txtApellido)).getText().toString());
        extras.putString("curp",((EditText)  findViewById(R.id.txtCurp)).getText().toString());
        extras.putString("edad",((EditText) findViewById(R.id.txtEdad)).getText().toString());
        extras.putString("peso",((EditText) findViewById(R.id.txtPeso)).getText().toString());
        extras.putString("talla",((EditText) findViewById(R.id.txtTalla)).getText().toString());
        extras.putString("altura",((EditText)  findViewById(R.id.txtAltura)).getText().toString());
        extras.putString("ocupacion",((EditText)  findViewById(R.id.txtOcupacion)).getText().toString());
        extras.putString("motivo",((EditText)  findViewById(R.id.txtMotivo)).getText().toString());
        extras.putString("sexo",sexo);

        return extras;
    }

    public boolean validarCampos(){

        if( ((EditText) findViewById(R.id.txtNombre)).getText().toString().isEmpty() ){
                showMessage("Campo Nombre está vacío");
        }else{
            if ( ((EditText)  findViewById(R.id.txtApellido)).getText().toString().isEmpty() ){
                showMessage("Campo Apellido está vacío");
            }else{
                if ( ((EditText)  findViewById(R.id.txtCurp)).getText().toString().isEmpty() ){
                    showMessage("Campo CURP está vacío");
                }else{
                    if( ((EditText)  findViewById(R.id.txtEdad)).getText().toString().isEmpty() ){
                        showMessage("Campo Edad está vacío");
                    }else{
                        Integer edad = Integer.parseInt( ((EditText)  findViewById(R.id.txtEdad)).getText().toString());
                        if( edad < 1 || edad > 120){
                            showMessage("La edad debe ser entre 1 y 120 años");
                        }else{
                            if( ((EditText)  findViewById(R.id.txtPeso)).getText().toString().isEmpty() ){
                                showMessage("El campo Peso está vacío");
                            } else{
                                Double peso = Double.parseDouble( ((EditText)  findViewById(R.id.txtPeso)).getText().toString());
                                if(peso < 0.5 || peso > 500 ){
                                    showMessage("El peso debe ser mayor a 0.5kg y menor a 500kg");
                                }else{
                                    if( ((EditText)  findViewById(R.id.txtTalla)).getText().toString().isEmpty() ){
                                        showMessage("El campo Talla está vacío");
                                    }else{
                                        if( ((EditText)  findViewById(R.id.txtAltura)).getText().toString().isEmpty() ){
                                            showMessage("El campo Altura está vacío");
                                        }else{
                                            if( ((EditText)  findViewById(R.id.txtOcupacion)).getText().toString().isEmpty()){
                                                showMessage("El campo Ocupación está vacío");
                                            }else{
                                                if( ((EditText)  findViewById(R.id.txtMotivo)).getText().toString().isEmpty() ){
                                                    showMessage("El campo Motivo de consulta está vacío");
                                                }else{
                                                    RadioButton rb1 = (RadioButton) findViewById(R.id.rdb1);
                                                    RadioButton rb2 = (RadioButton) findViewById(R.id.rdb2);
                                                    if( !rb1.isChecked() && !rb2.isChecked() ){
                                                        showMessage("Debe elegir Masculino ó Femenino");
                                                    }else{
                                                        showMessage("Validación OK");
                                                        return true;
                                                    }

                                                }
                                            }

                                        }

                                    }

                                }

                            }
                        }
                    }
                }
            }
        }
        return false;

    }


}