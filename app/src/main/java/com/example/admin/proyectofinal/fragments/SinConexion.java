package com.example.admin.proyectofinal.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.admin.proyectofinal.R;

/**
 * Fragmente del Home
 * @author Luisa Fernanda Arango Valencia
 * @author Luis Esteban Valencia Moreno
 * 4 de Mayo de 2016
 */
public class SinConexion extends Fragment {


    /**
     * Metodo contructor de la clase
     */
    public SinConexion() {
        // Required empty public constructor
    }


    /**
     * Se ejecuta al inciar el fragmento
     * @param inflater inflador
     * @param container contexto
     * @param savedInstanceState Datos
     * @return Vista inflada
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sin_conexion, container, false);
    }

}
