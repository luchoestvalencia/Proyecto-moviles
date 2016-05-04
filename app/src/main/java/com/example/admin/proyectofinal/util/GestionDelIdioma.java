package com.example.admin.proyectofinal.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;

import java.util.Locale;

/**
 * Es la clase encargada de gestionar el cambio de idioma (Internacionalización)
 * @author Luisa Fernanda Arango Valencia
 * @author Luis Esteban Valencia Moreno
 * 27 de Abril de 2016
 */
public class GestionDelIdioma
{
    //Atributos de clase.
    public final static String MIS_PREFERENCIAS = "MisPreferencias";
    public final static String LENGUAJE_DE_PREFERENCIA = "languaje_preferences";
    public final static String LENGUAJE_ES = "es";
    public final static String  LENGUAJE_EN = "en";


    /**
     * Metodo encargada de realizar el cambio del idioma
     * @param context idioma que tenga predeterminado
     */
    public static void cambiarIdioma(Context context){
        SharedPreferences prefs =  context.getSharedPreferences(MIS_PREFERENCIAS, context.MODE_PRIVATE); //crear una isntancia
        String language = prefs.getString(LENGUAJE_DE_PREFERENCIA, LENGUAJE_ES); // se le manda el lenguaje de preferencia

        if(language.equals(LENGUAJE_ES)){
            language = LENGUAJE_EN;
        }
        else if(language.equals(LENGUAJE_EN)){
            language = LENGUAJE_ES;
        }
        SharedPreferences.Editor editor = prefs.edit();//se guarda en la lista de preferiencias
        editor.putString(LENGUAJE_DE_PREFERENCIA, language); //se setea la nueva preferencia
        editor.commit(); //actualiza el nuevo lenguaje
        obtenerLenguaje(context);
    }

    /**
     * Metodo encargado de obtener el lenguaje del dispositivo movil
     * @param context
     */
    public static void obtenerLenguaje(Context context){
        SharedPreferences prefs = context.getSharedPreferences(MIS_PREFERENCIAS,context.MODE_PRIVATE);
        String language = prefs.getString(LENGUAJE_DE_PREFERENCIA,LENGUAJE_ES);
        Locale locale = new Locale(language); //meter el lenguaje que se carggo
        Locale.setDefault(locale); //se le cambia el lenguaje
        Configuration config = new Configuration(); // se le crea la nueva configuracion
        config.locale = locale;
        context.getApplicationContext().getResources().updateConfiguration(config, null);
    }
}
