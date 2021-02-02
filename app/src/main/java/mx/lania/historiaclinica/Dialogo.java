package mx.lania.historiaclinica;

import android.app.Dialog;
import android.os.Bundle;
import android.content.DialogInterface;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

public class Dialogo extends DialogFragment {

    String tag = "Loggin";

    static Dialogo newInstance(String title, Bundle datos, int tipo) {
        Dialogo fragment = new Dialogo();
        datos.putInt("tipo",tipo);
        datos.putString("title", title);
        fragment.setArguments(datos);
        return fragment;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        Bundle datos = getArguments();
        String title = getArguments().getString("title");
        StringBuilder cadena = new StringBuilder("Datos:\n");
        Integer tipo = getArguments().getInt("tipo");

        for (String key : datos.keySet()) { //datos is the Bundle containing info
            Object value = datos.get(key); //get the current object
            if(!key.contains("title") && !key.contains("tipo")){
                cadena.append(key).append(": ").append(value).append("\n"); //add the key-value pair to the
            }
        }

        return new AlertDialog.Builder(getActivity())
                .setIcon(R.drawable.ic_launcher_foreground)
                .setTitle(title)
                .setMessage(cadena.toString())
                .setPositiveButton("OK",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int whichButton) {
                                Log.d(tag,"el tipo es : "+tipo.toString());
                                switch (tipo){
                                    case 1:
                                        ((FichaId) getActivity()).doPositiveClick("Datos Almacenados");
                                        break;
                                    case 2:
                                        ((AntPatologicos) getActivity()).doPositiveClick("Datos Almacenados");
                                        break;
                                    case 3:
                                        ((AntNoPatologicos) getActivity()).doPositiveClick("Datos Almacenados");
                                        break;
                                    case 4:
                                        ((AntFamiliares) getActivity()).doPositiveClick("Datos Almacenados");
                                        break;
                                    default:
                                        Toast.makeText(getContext(),"Respuesta generica",Toast.LENGTH_SHORT).show();
                                        break;
                                }
                            }
                        })
                .setNegativeButton("Cancel",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int whichButton) {
                                Log.d(tag,"el tipo es : "+tipo.toString());
                                switch (tipo){
                                    case 1:
                                        ((FichaId) getActivity()).doNegativeClick("Sigue capturando");
                                        break;
                                    case 2:
                                        ((AntPatologicos) getActivity()).doNegativeClick("Sigue capturando");
                                        break;
                                    case 3:
                                        ((AntNoPatologicos) getActivity()).doNegativeClick("Sigue capturando");
                                        break;
                                    case 4:
                                        ((AntFamiliares) getActivity()).doNegativeClick("Sigue capturando");
                                        break;
                                    default:
                                        Toast.makeText(getContext(),"Respuesta generica cancelar",Toast.LENGTH_SHORT).show();
                                        break;
                                }

                            }
                        }).create();
    }
}


