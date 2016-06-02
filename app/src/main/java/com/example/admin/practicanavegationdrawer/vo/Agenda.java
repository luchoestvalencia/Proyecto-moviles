package com.example.admin.practicanavegationdrawer.vo;

/**
 * Created by luinix on 28/05/16.
 */
public class Agenda
{
    private String numero;
    private String nombre;
    private String dependencia;


    /**
     * Metodo constructor de la clase
     * @param numero
     * @param nombre
     */
    public Agenda(String numero, String nombre) {
        this.numero = numero;
        this.nombre = nombre;
    }

    public Agenda(){
        // empty default constructor, necessary for Firebase to be able to deserialize blog posts
    }

    /**
     * Metodo que obtiene el numero
     * @return numeor
     */
    public String getNumero() {
        return numero;
    }

    /**
     * Metodo que setea el numero
     * @param numero nuemro
     */
    public void setNumero(String numero) {
        this.numero = numero;
    }

    /**
     * Metodo que obtiene el nombre
     * @return nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Metodo que setea el nombre
     * @param nombre nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Metodo que obtiene la dependencia
     * @return dependencia
     */
    public String getDependencia() {
        return dependencia;
    }

    /**
     * Metoco encargado d esetear la dependencia
     * @param dependencia dependencia
     */
    public void setDependencia(String dependencia) {
        this.dependencia = dependencia;
    }
}
