package com.example.admin.proyectofinal.util;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.admin.proyectofinal.R;
import com.example.admin.proyectofinal.fragments.ListaDeNoticiasFragment;
import com.example.admin.proyectofinal.vo.Noticia;

import java.util.ArrayList;
/**
 * Fragmente del detalle de la noticia
 * @author Luisa Fernanda Arango Valencia
 * @author Luis Esteban Valencia Moreno
 * 28 de Abril de 2016
 */
public class AdaptadorNoticia extends RecyclerView.Adapter<AdaptadorNoticia.NoticiaViewHolder>
{

    //lista de noticias
    private ArrayList<Noticia> noticias;
    //noticia seleccionada
    private static OnClickAdaptadorNoticia listener;

    /**
     * Metodo constructor de la clase
     * @param noticias lista de noticias
     */
    public AdaptadorNoticia(ArrayList<Noticia> noticias) {
        this.noticias = noticias;
    }

    /**
     * Segundo Metodo constructorde la clase
     * @param noticias lista de noticias
     * @param listaDeNoticiasFragment     lista de fragmentos de pelicula
     */
    public AdaptadorNoticia(ArrayList<Noticia> noticias, ListaDeNoticiasFragment listaDeNoticiasFragment)
    {
        this.noticias= noticias;
        listener = (OnClickAdaptadorNoticia) listaDeNoticiasFragment;
    }

    /**
     * Metodo que infla un view con base a el fragment
     * @param parent
     * @param viewType
     * @return
     */
    @Override
    public NoticiaViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.resumen_noticia, parent, false);
        NoticiaViewHolder noticiaVH = new NoticiaViewHolder(itemView);
        return noticiaVH;

    }

    /**
     * Metodo encargado de actualizar el contenido del VH
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(NoticiaViewHolder holder, int position){
        Noticia noticia = noticias.get(position);
        holder.binNoticia(noticia);
    }
    /**
     * Cuenta el número de noticias
     * @return Tamaño de la lista de noticias
     */
    @Override
    public int getItemCount() {
        return noticias.size();
    }

    /**
     * Interfaz
     */
    public interface OnClickAdaptadorNoticia{
        public void onClickPosition(int pos);
    }

    /**
     * Clase de la noticia View Holder
     */
    public static class NoticiaViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {
        //titulo
        private TextView txtTitulo;
        //descripción
        private TextView txtDescripcion;

        /**
         * Metodo contructor del VH
         * @param itemView vista
         */
        public NoticiaViewHolder(View itemView)
        {
            super(itemView);
            txtTitulo = (TextView) itemView.findViewById(R.id.titulo);
            txtDescripcion = (TextView) itemView.findViewById(R.id.descripcion);
            itemView.setOnClickListener(this);
        }

        /**
         * setea la noticia
         * @param n noticia a modificar
         */
        public void binNoticia(Noticia n) {
            txtTitulo.setText(n.getTitulo());
            txtDescripcion.setText(n.getDescripcion());
        }

        /**
         * Metodo onClick
         * @param v vista
         */
        @Override
        public void onClick(View v) {
            listener.onClickPosition(getAdapterPosition());
            Log.d("TAG", "Element " + getAdapterPosition() + " clicked. " + txtTitulo.getText());
        }
    }
}
