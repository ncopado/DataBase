package com.ncopado.miscontactosapp.db;

import android.content.ContentValues;
import android.content.Context;

import com.ncopado.miscontactosapp.R;
import com.ncopado.miscontactosapp.pojo.Contacto;

import java.util.ArrayList;

/**
 * Created by ncopado on 11/09/17.
 */

public class ConstructorContactos {

    private static final  int LIKE=1;
    private Context context;
    public ConstructorContactos(Context context) {
        this.context=context;
    }

    public ArrayList<Contacto> obtenerDatos(){
       /* ArrayList<Contacto>  lstContacto=new ArrayList<Contacto>();

        lstContacto.add(new Contacto(R.drawable.rayo,"Neme Copado","2291615266","ncopado@gmail.com", 1));
        lstContacto.add(new Contacto(R.drawable.rayo,"Paco Copado","2291615266","ncopado@gmail.com", 2));
        lstContacto.add(new Contacto(R.drawable.rayo,"Kary Copado","2291615266","ncopado@gmail.com", 3));
        lstContacto.add(new Contacto(R.drawable.rayo,"Carolina","2291615266","ncopado@gmail.com", 4));
        lstContacto.add(new Contacto(R.drawable.rayo,"Samy Copado","2291615266","ncopado@gmail.com", 5));

        return lstContacto;*/

        BaseDatos db=new BaseDatos(context);
        insertarContactos(db);

        return   db.obtenerTodosContactos();

    }

    public  void insertarContactos(BaseDatos db){

        ContentValues contentValues=new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_NOMBRE,"NEMESIO COPADO");
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_TELEFONO,"22222");
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_EMAIL,"22222");
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_FOTO,R.drawable.rayo);

        db.insertarContacto(contentValues);

        ContentValues contentValues2=new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_NOMBRE,"KARY COPADO");
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_TELEFONO,"22222");
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_EMAIL,"22222");
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_FOTO,R.drawable.rayo);

        db.insertarContacto(contentValues);

    }

    public  void insertaLikeContacto(Contacto contacto){
        BaseDatos db=new BaseDatos(context);

        ContentValues contentValues=new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_LIKES_CONTACTS_ID_CONTACTO,contacto.getId());
        contentValues.put(ConstantesBaseDatos.TABLE_LIKES_CONTACTS_NUMERO,LIKE);
        db.insertarLikeContacto(contentValues);
    }

    public int obtenerLikesContacto(Contacto contacto){
        BaseDatos db=new BaseDatos(context);

        return db.obtenerLikesContacto(contacto);
    }


}
