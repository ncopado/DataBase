package com.ncopado.miscontactosapp.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ncopado.miscontactosapp.R;
import com.ncopado.miscontactosapp.adapter.ContactoAdaptador;
import com.ncopado.miscontactosapp.pojo.Contacto;
import com.ncopado.miscontactosapp.presentador.IRecyclerViewFragmentPresenter;
import com.ncopado.miscontactosapp.presentador.RecyclerViewFragmentPresenter;

import java.util.ArrayList;

/**
 * Created by ncopado on 03/09/17.
 */

public class RecyclierViewFragment  extends Fragment implements IRecyclerViewFragmentView{

    ArrayList<Contacto> lstContacto;
    private RecyclerView listaContactos;
    private IRecyclerViewFragmentPresenter presenter;


    public RecyclierViewFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v= inflater.inflate(R.layout.fragment_recyclerview,container,false);


        listaContactos=(RecyclerView) v.findViewById(R.id.rvContactos);

        presenter=new RecyclerViewFragmentPresenter(this,getContext());

        return  v;

    }


/*
    public  void  InicilizarListaContactos(){

        lstContacto=new ArrayList<Contacto>();

        lstContacto.add(new Contacto(R.drawable.rayo,"Neme Copado","2291615266","ncopado@gmail.com", 1));
        lstContacto.add(new Contacto(R.drawable.rayo,"Paco Copado","2291615266","ncopado@gmail.com", 2));
        lstContacto.add(new Contacto(R.drawable.rayo,"Kary Copado","2291615266","ncopado@gmail.com", 3));
        lstContacto.add(new Contacto(R.drawable.rayo,"Carolina","2291615266","ncopado@gmail.com", 4));
        lstContacto.add(new Contacto(R.drawable.rayo,"Samy Copado","2291615266","ncopado@gmail.com", 5));


    }
*/
    @Override
    public void generarLinearLayoutVertical() {
        LinearLayoutManager llm=new LinearLayoutManager(getActivity());

        llm.setOrientation(LinearLayoutManager.VERTICAL);


        listaContactos.setLayoutManager(llm);

    }

    @Override
    public ContactoAdaptador crearAdaptatodr(ArrayList<Contacto> contactos) {
        ContactoAdaptador adaptador=new ContactoAdaptador(contactos,getActivity());

        return adaptador;

    }

    @Override
    public void inicializarAdaptadorRv(ContactoAdaptador adaptador) {

        listaContactos.setAdapter(adaptador);
    }
}
