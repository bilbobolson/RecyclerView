package com.ajsb.test_recycler;

/**
 * Antonio José Sánchez Bujaldón
 * Programación Multimedia y de Dispositivos Móviles
 * Curso 2020/21
 */

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
{

    private Button boton ;
    private List<Contacto> contactos ;
    private RecyclerView recycler ;
    private ContactosAdapter adaptador ;
    private onContactoItemListener interfaz ;

    /**
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inicializamos la lista
        contactos = new ArrayList<>() ;

        // Generamos y guardamos datos aleatorios en la lista
        for (int i=0; i < 50; i++)
            contactos.add(new Contacto("Persona " + i, "55555555" + i)) ;
        //
        // Creamos el adaptador
        adaptador = new ContactosAdapter(this, contactos,
                position ->
                {
                    // Recuperamos el contacto sobre el que hemos hecho click
                    Contacto contacto = contactos.get(position) ;

                    // Mostramos un mensaje notificándolo
                    Snackbar.make(recycler, "Has pulsado sobre " + contacto.getNombre(), Snackbar.LENGTH_LONG)
                            .show() ;
                }) ;

        // Gestionamos el layout de forma lineal vertical
        LinearLayoutManager manager = new LinearLayoutManager(this) ;

        // Gestionamos el layout en forma de rejilla
        //GridLayoutManager manager = new GridLayoutManager(this, 2) ;

        // Acceder al recycler y le indicamos quién es su ADAPTADOR y qué tipo
        // de GESTOR de LAYOUTS va a tener que utilizar.
        recycler = findViewById(R.id.recycler) ;
        recycler.setAdapter(adaptador) ;
        recycler.setLayoutManager(manager) ;

        // Se recomienda utilizar cuando prevemos que el RECYCLER no va a cambiar
        // de tamaño, mejorando de esta forma el rendimiento.
        recycler.setHasFixedSize(true) ;
        
        // Cambiamos datos de algunos registros y notificamos al adaptador.
        boton = findViewById(R.id.button) ;
        boton.setOnClickListener(v ->
        {
            contactos.get(1).setNombre("Miguel Cano") ;
            adaptador.notifyItemChanged(1) ;

            contactos.get(2).setNombre("Pedro Torres") ;
            contactos.get(3).setNombre("Luca Lago") ;
            adaptador.notifyDataSetChanged();
        });


    }
}