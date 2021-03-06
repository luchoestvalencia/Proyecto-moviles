package com.example.admin.practicanavegationdrawer.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.admin.practicanavegationdrawer.R;
import com.example.admin.practicanavegationdrawer.fragments.DestalleDeNoticiasFragment;
import com.example.admin.practicanavegationdrawer.vo.Noticia;

/**
 * Actividad del detalle de la noticia
 * @author Luisa Fernanda Arango Valencia
 * @author Luis Esteban Valencia Moreno
 * 27 de Abril de 2016
 */
public class DetalleDeNoticiaActivity extends AppCompatActivity {

    /**
     * Método que se ejecuta al iniciar la actividad
     * @param savedInstanceState Datos entregados
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_de_noticia);

        DestalleDeNoticiasFragment detalleDeNoticia = (DestalleDeNoticiasFragment) getSupportFragmentManager().findFragmentById(R.id.fragmento_detalle_noticia);
        Noticia noticia = (Noticia) getIntent().getExtras().get("noticia");
        detalleDeNoticia.mostrarNoticia(noticia);
    }
}
