package com.example.admin.practicanavegationdrawer.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.admin.practicanavegationdrawer.R;

public class SugerenciaActivity extends AppCompatActivity {

    private Button enviar;
    private EditText correo, sugerencia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sugerencia);

        enviar = (Button) findViewById(R.id.buttonEnviar);
        correo = (EditText)findViewById(R.id.editTextEmail);
        sugerencia = (EditText)findViewById(R.id.editTextSugerencia);

        enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                enviarEmail();
            }
        });
    }

    public void enviarEmail(){
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("plain/text");
        String destinatatio="wbmaster@uniquindio.edu.co";
        // colocamos los datos para el envío
        intent.putExtra(android.content.Intent.EXTRA_EMAIL, new String[]{destinatatio});
        intent.putExtra(android.content.Intent.EXTRA_SUBJECT, correo.getText().toString());
        intent.putExtra(android.content.Intent.EXTRA_TEXT, sugerencia.getText());

        try {
            startActivity(Intent.createChooser(intent,"Enviando Sugerencia"));
            correo.setText("");
            sugerencia.setText("");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
