package com.ncopado.miscontactosapp.presentador;

import android.content.Context;
import android.widget.ArrayAdapter;

import com.ncopado.miscontactosapp.db.ConstructorContactos;
import com.ncopado.miscontactosapp.fragment.IRecyclerViewFragmentView;
import com.ncopado.miscontactosapp.pojo.Contacto;

import java.util.ArrayList;

/**
 * Created by ncopado on 11/09/17.
 */

public class RecyclerViewFragmentPresenter implements IRecyclerViewFragmentPresenter {

    private  IRecyclerViewFragmentView iRecyclerViewFragmentView;
    private  Context context;
    private ConstructorContactos constructorContactos;
    private ArrayList<Contacto> contactos;

    public RecyclerViewFragmentPresenter(IRecyclerViewFragmentView iRecyclerViewFragmentView, Context context) {
        this.iRecyclerViewFragmentView=iRecyclerViewFragmentView;
        this.context=context;
        obtenerContactos();

    }

    @Override
    public void obtenerContactos() {
        constructorContactos=new ConstructorContactos(context);

        contactos= constructorContactos.obtenerDatos();

        mostrarDatos();


    }

    @Override
    public void mostrarDatos() {

        iRecyclerViewFragmentView.inicializarAdaptadorRv(iRecyclerViewFragmentView.crearAdaptatodr(contactos));
        iRecyclerViewFragmentView.generarLinearLayoutVertical();

    }
}
