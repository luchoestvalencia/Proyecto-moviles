package com.example.admin.practicanavegationdrawer.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


import com.example.admin.practicanavegationdrawer.R;
import com.example.admin.practicanavegationdrawer.fragments.DestalleDeNoticiasFragment;
import com.example.admin.practicanavegationdrawer.fragments.ListaDeNoticiasFragment;
import com.example.admin.practicanavegationdrawer.util.GestionDelIdioma;
import com.example.admin.practicanavegationdrawer.vo.Noticia;

import java.util.ArrayList;
/**
 * Actividad de la noticia
 * @author Luisa Fernanda Arango Valencia
 * @author Luis Esteban Valencia Moreno
 * 27 de Abril de 2016
 */
public class NoticiasActivity extends AppCompatActivity implements ListaDeNoticiasFragment.OnNoticiaSeleccionadaListener {

    //Llista de las noticias
    private ArrayList<Noticia> noticias;

    /**
     * Método que se ejecuta al iniciar la actividad
     * @param savedInstanceState Datos entregados
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        GestionDelIdioma.obtenerLenguaje(this);
        setContentView(R.layout.activity_noticias);

        noticias = new ArrayList();

        noticias.add(new Noticia("Uniquindío realizó VII Seminario en campo de formación biomédica", "El 5 de abril de 2016 se realizó el VII Seminario “Actividad Física y Salud” orgama de Educación Física "));
        noticias.add(new Noticia("Cervantes y Shakespeare o la celebración de un misterio", "Hoy es . "));
        noticias.add(new Noticia("Un espacio académico desde la Física para la comunidad", "Todos los jueves el programa de Física además de presentar objetivos epresentar objetivos específicos"));
        noticias.add(new Noticia("Nahum Montt  ", "El próximo "));
        noticias.add(new Noticia("Calidad que nos conecta Abril 20 de 2016", "En el espacio gunda parte de esta "));
        noticias.add(new Noticia("Nahum Montt  Uniquindío ", "El próximo miércoles 27 de abril de 2016 en el auditorio de Ciencias Básicas y Ciencias Humanas"));
        noticias.add(new Noticia("Cervantes y Shakespeare o la celebración de un misterio", "Hoy es el día del idioma, el día mundial del libro y de los derechos de autor. "));
        noticias.add(new Noticia("Un espacio académico desde la Física para la comunidad", "Todos los acio de extensión académica en donde además de presentar objetivos específicos"));
        noticias.add(new Noticia("Calidad que nos conecta Abril 20 de 2016", "En el espacio para la pela sociedad, continuamos hoy con la segunda parte de esta "));
        noticias.add(new Noticia("Uniquindío realizó VII Seminario en campo de formación biomédica", " organizado por los docentes del campo de Formación Biomédico del Programa de Educación Física "));
        noticias.add(new Noticia("Nahum Montt presenta su nueva novela en Uniquindío ", "El próximo miércoles 27 de abril de 2016 en el auditorio de Ciencias Básicas y Ciencias Humanas"));
        noticias.add(new Noticia("Cervantes y Shakespeare o la celebración de un misterio", "Hoy es el día del idioma, el día mundial del libro y de los derechos de autor. "));
        noticias.add(new Noticia("Un espacio dad", "Todos los jueves el programa de Física de la ás de presentar objetivos específicos"));
        noticias.add(new Noticia("Calidad que nos conecta Abril 20 de 2016", "En el espacio para la permanente rendición de cuentas de la Universidad del Quindío ante la sociedad, continda parte de esta "));
        noticias.add(new Noticia("Uniquindío realizó VII Seminario en campo de formación biomédica", "El 5 de abril de 2016 se realizó el VII Seminario “Actividad Física y Salud” organiograma de Educación Física "));
        noticias.add(new Noticia("Nahum Montt presenta su nueva novela en Uniquindío ", "El próximo miércoles 27 de abril de 2016 en el auditorio de Ciencias Básicas y Ciencias Humanas"));
        noticias.add(new Noticia("Cervantes y Shakespeare o la celebración de un misterio", "Hoy es el día del idioma, el día mundial del libro y de los derechos de autor. "));
        noticias.add(new Noticia("Un espacio académico desde la Física para la comunidad", "Todos los eademás de presentar objetivos específicos"));
        noticias.add(new Noticia("Calidad que nos conecta Abril 20 de 2016", "En el espacio para la pendío ante la sociedad, continuamos hoy con la segunda parte de esta "));
        noticias.add(new Noticia("Uniquindío realizó VII Seminario en campo de formación biomédica", "or los docentes del campo de Formación Biomédico del Programa de Educación Física "));

        ListaDeNoticiasFragment listaDeNoticiasFragment = (ListaDeNoticiasFragment)
                getSupportFragmentManager().findFragmentById(R.id.fragmento_lista_noticias);

        listaDeNoticiasFragment.setNoticias(noticias);

        getSupportActionBar().setTitle("Las Noticias");

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

}
