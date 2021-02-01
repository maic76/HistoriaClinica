package mx.lania.historiaclinica;

import android.app.Dialog;
import android.os.Bundle;
import android.content.DialogInterface;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

public class Dialogo extends DialogFragment {

    static Dialogo newInstance(String title, Bundle datos, int tipo) {
        Dialogo fragment = new Dialogo();
        //Bundle args = new Bundle();
        datos.putInt("tipo",tipo);
        datos.putString("title", title);
        //datos.putString;
        fragment.setArguments(datos);
        return fragment;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Bundle datos = getArguments();
        String title = getArguments().getString("title");
        String nombre = getArguments().getString("nombre");
        StringBuilder cadena = new StringBuilder("Datos:\n");
        for (String key : datos.keySet()) { //datos is the Bundle containing info
            Object value = datos.get(key); //get the current object
            if(!key.contains("title") && !key.contains("tipo")){
                cadena.append(key).append(": ").append(value).append("\n"); //add the key-value pair to the
            }
        }
        //String cadena = String.format(" nombre: %s \n apellido : landa",nombre);
        return new AlertDialog.Builder(getActivity())
                .setIcon(R.drawable.ic_launcher_foreground)
                .setTitle(title)
                .setMessage(cadena.toString())
                .setPositiveButton("OK",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int whichButton) {
                                switch (getArguments().getInt("tipo")){
                                    case 1:
                                        ((FichaId) getActivity()).doPositiveClick("Datos Almacenados");
                                        break;
                                    case 2:
                                        ((AntPatologicos) getActivity()).doPositiveClick("Datos Almacenados");
                                    default:
                                        Toast.makeText(getContext(),"Respuesta generica",Toast.LENGTH_SHORT).show();
                                }
                            }
                        })
                .setNegativeButton("Cancel",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int whichButton) {
                                switch (getArguments().getInt("tipo")){
                                    case 1:
                                        ((FichaId) getActivity()).doNegativeClick("Sigue capturando");
                                        break;
                                    case 2:
                                        ((AntPatologicos) getActivity()).doNegativeClick("Sigue capturando");
                                    default:
                                        Toast.makeText(getContext(),"Respuesta generica cancelar",Toast.LENGTH_SHORT).show();
                                }

                            }
                        }).create();
    }
}


