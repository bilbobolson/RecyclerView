package com.ajsb.test_recycler;

/**
 * Antonio José Sánchez Bujaldón
 * Programación Multimedia y de Dispositivos Móviles
 * Curso 2020/21
 */

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ContactosAdapter extends RecyclerView.Adapter<ContactosHolder>
{
    // Información que va a manejar el ADAPTADOR y que se mostrará en el RECYCLER
    private List<Contacto> datos ;

    // Guarda el CONTEXTO de la actividad que crea el ADAPTADOR
    private Context context ;

    private onContactoItemListener interfaz ;

    /**
     * @param datos
     */
    public ContactosAdapter(Context context, List<Contacto> datos,
                            onContactoItemListener interfaz)
    {
        this.datos    = datos ;
        this.context  = context ;
        this.interfaz = interfaz ;
    }

    /**
     * Por cada elemento de la lista de datos tenemos que:
     * 1. Inflar el layout
     *
     * @param parent
     * @param viewType
     * @return
     */
    @NonNull
    @Override
    public ContactosHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View layout = LayoutInflater.from(context)
                                    .inflate(R.layout.item_contactos, parent, false) ;
        //
        return new ContactosHolder(layout, interfaz) ;
    }

    /**
     * Recibe el contenedor que hemos creado en ContactosHolder y la posición (en la lista
     * de datos) del elemento para el que acabamos de crear dicho contenedor. Con esto, ¿qué
     * tenemos que hacer? Como queremos que el contenedor muestre los datos de cada elemento,
     * y en este método tenemos acceso a un elemento en particular, vinculamos dicho elemento
     * con el contenedor.
     *
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(@NonNull ContactosHolder holder, int position)
    {
        holder.mostrarInfo(datos.get(position)) ;
    }

    /**
     * Devuelve SIEMPRE el tamaño de la lista de datos
     * @return
     */
    @Override
    public int getItemCount() {
        return datos.size() ;
    }
}


