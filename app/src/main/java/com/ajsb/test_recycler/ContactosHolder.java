package com.ajsb.test_recycler;

/**
 * Antonio José Sánchez Bujaldón
 * Programación Multimedia y de Dispositivos Móviles
 * Curso 2020/21
 */

import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ContactosHolder extends RecyclerView.ViewHolder
{
    private TextView nombre  ;
    private TextView telefono ;

    /**
     * A través del LAYOUT que se nos pasa como parámetro, buscamos y guardamos
     * las vistas correspondientes.
     *
     * @param layout
     */
    public ContactosHolder(@NonNull View layout, onContactoItemListener interfaz)
    {
        super(layout);
        nombre   = layout.findViewById(R.id.itemNombre) ;
        telefono = layout.findViewById(R.id.itemTelefono) ;

        layout.setOnClickListener(v ->
        {
            interfaz.onContactoClick(getAdapterPosition());
        });
    }

    /**
     * Mostramos los datos del contacto en cada una de las vistas que guardamos
     * anteriormente.
     *
     * @param item
     */
    public void mostrarInfo(Contacto item)
    {
        nombre.setText(item.getNombre()) ;
        telefono.setText(item.getTelefono()) ;
    }
}
