package com.example.admin.proyectofinal.fragments;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.admin.proyectofinal.R;
import com.example.admin.proyectofinal.util.AdaptadorNoticia;
import com.example.admin.proyectofinal.vo.Noticia;

import java.util.ArrayList;

/**
 * Fragmente de la lista de noticias
 * @author Luisa Fernanda Arango Valencia
 * @author Luis Esteban Valencia Moreno
 * 27 de Abril de 2016
 */
public class ListaDeNoticiasFragment extends Fragment implements AdaptadorNoticia.OnClickAdaptadorNoticia {

    //Lista contenedora de noricias
    private RecyclerView listadoDeNoticias;
    //lista de noticias
    private ArrayList<Noticia> noticias;
    //Adaptador de noticia
    private AdaptadorNoticia adaptador;
    //noticia seleccionada
    private OnNoticiaSeleccionadaListener listener;


    /**
     * Metodo constructor de la clase
     */
    public ListaDeNoticiasFragment() {
        // Required empty public constructor
    }


    /**
     * Actualiza cuál es la noticia seleccionada
     * @param context contexto
     */
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Activity activity;
        if (context instanceof Activity){
            activity = (Activity) context;
            try {
                listener = (OnNoticiaSeleccionadaListener) activity;
            } catch (ClassCastException e) {
                throw new ClassCastException(activity.toString() + " debe implementar la interfaz OnNoticiaSeleccionadaListener");
            }
        }
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
        return inflater.inflate(R.layout.fragment_lista_de_noticias, container, false);
    }

    /**
     * Crea la actividad
     * @param savedInstanceState datos
     */
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        listadoDeNoticias =(RecyclerView) getView().findViewById(R.id.RecView);
        adaptador = new AdaptadorNoticia(noticias, this);
        listadoDeNoticias.setAdapter(adaptador);
        listadoDeNoticias.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL,false));
    }
    /**
     * Cambia la noticia seleccionada
     * @param pos Posicion
     */
    @Override
    public void onClickPosition(int pos) {
        listener.onNoticiaSeleccionada(pos);
    }

    /**
     * Metodo set de la lista de noticias
     * @param noticias a ser modificada
     */
    public void setNoticias(ArrayList<Noticia> noticias) {
        this.noticias = noticias;
    }

    /**
     * Interface del listener
     */
    public interface OnNoticiaSeleccionadaListener {
        void onNoticiaSeleccionada(int position);
    }
}
