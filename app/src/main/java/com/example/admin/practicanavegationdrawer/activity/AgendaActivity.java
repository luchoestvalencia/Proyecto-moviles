package com.example.admin.practicanavegationdrawer.activity;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.view.MenuItemCompat.OnActionExpandListener;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.SearchView.OnQueryTextListener;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.admin.practicanavegationdrawer.R;
import com.example.admin.practicanavegationdrawer.util.AgendaArrayAdapter;
import com.example.admin.practicanavegationdrawer.util.ConectionDB;
import com.example.admin.practicanavegationdrawer.util.GestionDelIdioma;
import com.example.admin.practicanavegationdrawer.vo.Agenda;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import java.util.ArrayList;
import java.util.Collections;

public class AgendaActivity extends AppCompatActivity implements OnQueryTextListener, OnActionExpandListener {

    private ListView list;
    private ArrayList<Agenda> datos = new ArrayList<>();
    private ArrayList<Agenda> contactos =  new ArrayList<>();
    private ArrayAdapter adapter;
    private ConectionDB  db = new ConectionDB(this);
    private TextView texto;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        GestionDelIdioma.obtenerLenguaje(this);
        Firebase.setAndroidContext(this);
        obtenerDatos();

        setContentView(R.layout.activity_agenda);
        texto = (TextView) findViewById(R.id.texto);
        list = (ListView) findViewById(R.id.listView);

        showNotes();
        list.setAdapter(new AgendaArrayAdapter(this, R.layout.lista_agenda, contactos) {
            @Override
            public void onEntrada(Object entrada, View view) {
                if (entrada != null) {
                    TextView nombre = (TextView) view.findViewById(R.id.nombre);
                    if (nombre != null)
                        nombre.setText(((Agenda) entrada).getNombre());

                    TextView numero = (TextView) view.findViewById(R.id.numero);
                    if (numero != null)
                        numero.setText(((Agenda) entrada).getNumero());

                }
            }
        });


        System.out.println("tamaño despues de  sss " + contactos.size());


    }

    public void obtenerDatos() {
        //enlace con la base de datos

        Firebase rfFireBase = new Firebase("https://proyectomoviles.firebaseio.com/Agenda");
        // Attach an listener to read the data at our posts reference
        rfFireBase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                for (final DataSnapshot response : snapshot.getChildren()) {
                    Agenda noticia = response.getValue(Agenda.class);
                    datos.add(noticia);

                    System.out.println(datos.size());
                    System.out.println(noticia.getNombre());
                    //adapter.notifyDataSetChanged();
                }
                Collections.shuffle(datos);

              // addDatosDB();
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {
                System.out.println("The read failed: " + firebaseError.getMessage());
            }
        });
    }

    private void addDatosDB(){
        int i=0;
        for (Agenda p:datos)
        {
            db.addContacto(datos.get(i).getNombre(), datos.get(i).getNumero());
            i++;
        }

    }

    private void showNotes(){

        Cursor c = db.getContactos();
     //  item = new ArrayList<String>();
       String nombre = "",numero = "";
        Agenda a;
        if (c.moveToFirst()){
            //Recorremos el cursor hasta que no haya más registros
            do{
                    nombre =  c.getString(2);
                    numero =  c.getString(1);
                   contactos.add(a = new Agenda(nombre, numero));
            }while (c.moveToNext());
        }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.buscador, menu);

        MenuItem searchItem = menu.findItem(R.id.menu3_buscar);

        SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchItem);
        searchView.setOnQueryTextListener(this);

        MenuItemCompat.setOnActionExpandListener(searchItem, this);

        return super.onCreateOptionsMenu(menu);
    }

    /*
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }*/

    @Override
    public boolean onMenuItemActionExpand(MenuItem item) {
      // Toast.makeText(getApplicationContext(), "EXPAND", Toast.LENGTH_SHORT).show();
        return true;
    }

    @Override
    public boolean onMenuItemActionCollapse(MenuItem item) {
        texto.setText("");
       // Toast.makeText(getApplicationContext(), "COLLAPSE", Toast.LENGTH_SHORT).show();
        return true;
    }

    @Override
    public boolean onQueryTextSubmit(String s) {
      //texto.setText("Texto a buscar\n\n" + s);
        int i=0;
        boolean marca=false;
        for (Agenda p:contactos)
        {
            if(s.equals(contactos.get(i).getNombre())){
                marca=true;
            }
            else{
                System.out.println("no" + i);
                i++;
            }
        }
        if(marca==true){
            texto.setText("Numero del contacto : "+contactos.get(i).getNumero());
        }
        else
        {
            texto.setText("No se encontro el contacto");
        }
        return false;
    }

    @Override
    public boolean onQueryTextChange(String s) {

      //  texto.setText("Escribiendo texto...\n\n" + s);

        return false;
    }


}




