package com.example.admin.proyectofinal.fragments;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.admin.proyectofinal.R;
import com.example.admin.proyectofinal.vo.Noticia;

/**
 * Fragmente del detalle de la noticia
 * @author Luisa Fernanda Arango Valencia
 * @author Luis Esteban Valencia Moreno
 * 27 de Abril de 2016
 */
public class DestalleDeNoticiasFragment extends Fragment implements View.OnClickListener {

    //titulo
    private TextView titulo;
    //noticia a ver detalle
    private Noticia noticia;


    /**
     * Metodo contructor de la clase
     */
    public DestalleDeNoticiasFragment() {
        // Required empty public constructor
    }


    /**
     * Se ejecuta al inciiar el detalle de la noticia
     * @param inflater inflador
     * @param container contexto
     * @param savedInstanceState Datos
     * @return Vista inflada
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detalle_noticia, container, false);
    }
    /**
     * Muestra la noticia seleccionada en el fragmento
     * @param noticia Película a mostrar
     */
    public void mostrarNoticia (Noticia noticia) {
        this.noticia = noticia;
        titulo = (TextView) getView().findViewById(R.id.titulo_de_detalle_noticia);
        titulo.setText(noticia.getTitulo());

    }
    /**
     * Redirecciona al detalle de la noticia
     * @param v Vista
     */
    @Override
    public void onClick(View v) {
        Intent intent = new Intent(Intent.ACTION_VIEW,
                Uri.parse(noticia.getDescripcion()));
        startActivity(intent);
    }
}
