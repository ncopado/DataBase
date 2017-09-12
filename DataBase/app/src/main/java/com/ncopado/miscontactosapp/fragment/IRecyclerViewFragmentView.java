package com.ncopado.miscontactosapp.fragment;

import com.ncopado.miscontactosapp.adapter.ContactoAdaptador;
import com.ncopado.miscontactosapp.pojo.Contacto;

import java.util.ArrayList;

/**
 * Created by ncopado on 11/09/17.
 */

public interface IRecyclerViewFragmentView {


    public void generarLinearLayoutVertical();


    public ContactoAdaptador crearAdaptatodr(ArrayList<Contacto> contactos);

    public void inicializarAdaptadorRv(ContactoAdaptador adaptador);
}
