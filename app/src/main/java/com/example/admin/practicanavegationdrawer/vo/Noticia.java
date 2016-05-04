package com.example.admin.practicanavegationdrawer.vo;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Clase Noticia
 * @author Luisa Fernanda Arango Valencia
 * @author Luis Esteban Valencia Moreno
 * 28 de Abril de 2016
 */
public class Noticia implements Parcelable
{
    //Atributos de la noticia

    //titulo
    private String titulo;
    //descripción
    private String descripcion;

    /**
     * Metodo contructor de la clase
     * @param titulo titulo
     * @param descripcion descripción
     */
    public Noticia(String titulo, String descripcion)
    {
        this.titulo = titulo;
        this.descripcion = descripcion;
    }

    /**
     * Metodo encargado de realizar el envio de los datos
     * @param in Parcel
     */
    protected Noticia(Parcel in) {
        titulo = in.readString();
        descripcion = in.readString();
    }
    public static final Creator<Noticia> CREATOR = new Creator<Noticia>() {
        @Override
        public Noticia createFromParcel(Parcel in) {
            return new Noticia(in);
        }

        @Override
        public Noticia[] newArray(int size) {
            return new Noticia[size];
        }
    };

    /**
     * Metodo get de titulo
     * @return titulo
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * Metodo set de titulo
     * @param titulo titulo a modificar
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * Metodo get de la descripción
     * @return descripción
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Metodo ser de Descripción
     * @param descripcion a modificar
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(titulo);
        dest.writeString(descripcion);
    }
}
