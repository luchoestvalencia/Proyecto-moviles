package com.example.admin.practicanavegationdrawer.util;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Clase ConnectionDB encargada de gestionar SQLite
 * @author Luisa Fernanda Arango Valencia
 * @author Luis Esteban Valencia Moreno
 * 29 de Mayo de 2016
 */
public class ConectionDB extends SQLiteOpenHelper
{
    // Strings finales que contienen las cadenas de lo que se guardará en la BD
    public static final String TABLE_ID = "_idAgenda";
    public static final String NOMBRE = "nombre";
    public static final String NUMERO = "numero";
    // Nombre de la base de datos, de la tabla de la base de datos a utilizar.
    private static final String DATABASE= "Juego";
    private static final String TABLE = "agenda";

    public ConectionDB(Context context) {
        super(context, DATABASE, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE + " (" +
               TABLE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
              NOMBRE + " TEXT," + NUMERO + " TEXT)");
          //  onUpgrade(db,1,2);


    }



    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE);
        onCreate(db);
    }
    public void close(){
        this.close();
    }
    public void addContacto(String nombre,String numero){
        ContentValues valores = new ContentValues();
        valores.put(NOMBRE ,nombre);
        valores.put(NUMERO,numero);
        this.getWritableDatabase().insert(TABLE, null, valores);
    }
    // Mediante este metodo se devuelven todos los contactos de la agenda.
    public Cursor getContactos(){
        String columnas[]={TABLE_ID,NOMBRE,NUMERO};
        Cursor c = this.getReadableDatabase().query(TABLE, columnas, null, null, null, null, null);
        return c;
    }
}
