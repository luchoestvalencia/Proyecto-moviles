package com.example.admin.practicanavegationdrawer.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.example.admin.practicanavegationdrawer.R;
import com.example.admin.practicanavegationdrawer.fragments.DestalleDeNoticiasFragment;
import com.example.admin.practicanavegationdrawer.fragments.ListaDeNoticiasFragment;
import com.example.admin.practicanavegationdrawer.util.GestionDelIdioma;
import com.example.admin.practicanavegationdrawer.vo.Noticia;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Actividad de la noticia
 * @author Luisa Fernanda Arango Valencia
 * @author Luis Esteban Valencia Moreno
 * 27 de Abril de 2016
 */
public class NoticiasActivity extends AppCompatActivity implements ListaDeNoticiasFragment.OnNoticiaSeleccionadaListener {

    //Llista de las noticias
    private ArrayList<Noticia> noticias = new ArrayList<>();
    ListaDeNoticiasFragment listaDeNoticiasFragment;

    /**
     * Método que se ejecuta al iniciar la actividad
     * @param savedInstanceState Datos entregados
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        GestionDelIdioma.obtenerLenguaje(this);
        Firebase.setAndroidContext(this);
        obtenerDatos();
        sleep();
        setContentView(R.layout.activity_noticias);


         listaDeNoticiasFragment = (ListaDeNoticiasFragment)
                getSupportFragmentManager().findFragmentById(R.id.fragmento_lista_noticias);

        listaDeNoticiasFragment.setNoticias(noticias);
        System.out.println(noticias.size() + "   fuera 2");
        getSupportActionBar().setTitle("Las Noticias");

    }
    public void obtenerDatos()
    {
        //enlace con la base de datos

        Firebase rfFireBase = new Firebase("https://proyectomoviles.firebaseio.com/ListaNoticias");
        // Attach an listener to read the data at our posts reference
        rfFireBase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                for (final DataSnapshot response : snapshot.getChildren()) {
                    Noticia noticia = response.getValue(Noticia.class);
                    noticias.add(noticia);

                    System.out.println(noticias.size());
                    System.out.println(noticia.getTitulo());

                }
                Collections.shuffle(noticias);
                listaDeNoticiasFragment.setNoticias(noticias);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {
                System.out.println("The read failed: " + firebaseError.getMessage());
            }
        });
    }

    /**
     * Entrega el menú seleccionado
     * @param item Menú seleccionado
     * @return true si fue seleccionado
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }
    /**
     * Posicion de la noticia seleccionada
     * @param position
     */
    @Override
    public void onNoticiaSeleccionada(int position) {
       // Intent intent = new Intent(NoticiasActivity.this, DetalleDeNoticiaActivity.class);
       // intent.putExtra("noticia", noticias.get(position));
       // startActivity(intent);


        boolean esFragmento = getSupportFragmentManager().findFragmentById(R.id.fragmento_detalle_noticia) != null;
        if (esFragmento) {
            ((DestalleDeNoticiasFragment)
                    getSupportFragmentManager().findFragmentById(R.id.fragmento_detalle_noticia)).mostrarNoticia(noticias.get(position));
        } else {
            Intent intent = new Intent(NoticiasActivity.this,
                    DetalleDeNoticiaActivity.class);
            intent.putExtra("noticia", noticias.get(position));
            startActivity(intent);
        }
    }

    /**
     * Metodo hace que la app se tarde un poco
     */
    public void sleep()
    {

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
