package com.example.admin.proyectofinal.activity;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;

import android.net.NetworkInfo;
import android.net.Uri;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.admin.proyectofinal.R;
import com.example.admin.proyectofinal.fragments.DirectorioFragment;
import com.example.admin.proyectofinal.fragments.HomeFragment;
import com.example.admin.proyectofinal.fragments.SugerenciasFragment;
import com.example.admin.proyectofinal.util.GestionDelIdioma;

/**
 * Actividad encargada navegar
 * @author Luisa Fernanda Arango Valencia
 * @author Luis Esteban Valencia Moreno
 * 27 de Abril de 2016
 */
public class NavegationActivity extends AppCompatActivity {

    DrawerLayout drawerLayout;

    /**
     * Este metodo se ejecuta al iniciar la actividad
     * @param savedInstanceState Datos entregados
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (!verificaConexion(this)) {
            Toast.makeText(getBaseContext(),
                    "Comprueba tu conexión a Internet. Saliendo ... ", Toast.LENGTH_SHORT)
                    .show();
            this.finish();
        }
        else{
            setContentView(R.layout.activity_navegation);
            getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_nav_menu); //agraga en la parte alta
            getSupportActionBar().setDisplayHomeAsUpEnabled(true); //abilitar que se abra
            //se inicializan los dos controles
            drawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);
            NavigationView navView = (NavigationView)findViewById(R.id.navview);
            navView.setItemIconTintList(null); //para que no tenga tinta

            remplazarFragmento(new HomeFragment());
            //evento del navegation
            navView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener()
            {
                /**
                 * Metodo encargado de darle accion al item seleccionado
                 * @param item
                 * @return
                 */
                @Override
                public boolean onNavigationItemSelected(MenuItem item) {
                    switch (item.getItemId()) {
                        case R.id.menu_seccion_6:
                            remplazarFragmento(new HomeFragment());

                            break;
                        case R.id.menu_seccion_1:
                            Intent intent= new Intent(NavegationActivity.this, NoticiasActivity.class);
                            startActivity(intent);
                            break;
                        case R.id.menu_seccion_2:
                            remplazarFragmento(new DirectorioFragment());

                            break;
                        case R.id.menu_seccion_3:
                            remplazarFragmento(new SugerenciasFragment());
                            Log.i("NavigationView", "Pulsada seccion 3");

                            break;
                        case R.id.menu_seccion_4:
                            //El brindamos el dato necesario a Uri
                            Uri uriUrl = Uri.parse("https://www.uniquindio.edu.co/");
                            //Especificamos la accion a realizar con el ACTION_VIEW
                            //para que elija lo mas razonable
                            Intent intent3 = new Intent(Intent.ACTION_VIEW, uriUrl);
                            startActivity(intent3);

                            Log.i("NavigationView", "Pulsada opción 1");
                            break;
                        case R.id.menu_seccion_5:



                            GestionDelIdioma.cambiarIdioma(NavegationActivity.this);
                            Intent intent2 = getIntent();
                            finish();
                            startActivity(intent2);

                            Log.i("NavigationView", "Pulsada opción 2");
                            break;
                    }
                    item.setChecked(true);
                    drawerLayout.closeDrawers();
                    return true;
                }
            });
        }



    }

    /**
     * Obtiene el evento del menu
     * @param item
     * @return
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * Este metodo es usado para mostrar un fragmento
     * @param fragment
     */
    private void remplazarFragmento(Fragment fragment) {
        getSupportFragmentManager().beginTransaction() //para realizar una transación
                .replace(R.id.content_frame, fragment).addToBackStack(null)
                //reeemplaza el contenido por el nuevo fragmento y
                // cuando se da atras se regresa en donde se encontraba
                .commit();  // se da commit para que el cambio se efectue

    }

    /**
     * Metodo encargado de verificar la concexion a internet
     * @param ctx
     * @return true en si hay conexion, false no conexion
     */
    public static boolean verificaConexion(Context ctx) {

        ConnectivityManager cm =
                (ConnectivityManager) ctx.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        if (netInfo != null && netInfo.isConnected()) {
            return true;
        }
        return false;
    }






}
