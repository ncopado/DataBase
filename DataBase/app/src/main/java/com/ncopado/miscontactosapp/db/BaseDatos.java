package com.ncopado.miscontactosapp.db;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.ncopado.miscontactosapp.pojo.Contacto;

import java.util.ArrayList;

/**
 * Created by ncopado on 11/09/17.
 */

public class BaseDatos extends SQLiteOpenHelper {

    private Context context;
    public BaseDatos(Context context) {
        super(context, ConstantesBaseDatos.DATABASE_NAME, null, ConstantesBaseDatos.DATABASE_VERSION);
        this.context=context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String queryCrearTablaContacto="CREATE TABLE " +ConstantesBaseDatos.TABLE_CONTACTS + "("+
                                        ConstantesBaseDatos.TABLE_CONTACTS_ID +" INTEGER PRIMARY KEY AUTOINCREMENT,"+
                                        ConstantesBaseDatos.TABLE_CONTACTS_NOMBRE +" TEXT,"+
                                        ConstantesBaseDatos.TABLE_CONTACTS_TELEFONO+" TEXT, "+
                                        ConstantesBaseDatos.TABLE_CONTACTS_EMAIL+" TEXT, "+
                                        ConstantesBaseDatos.TABLE_CONTACTS_FOTO+" INTEGER "+
                                        ")";

        String queryCrearTablaLikesContacto="CREATE TABLE " +ConstantesBaseDatos.TABLE_LIKES_CONTACTS + "("+
                                        ConstantesBaseDatos.TABLE_LIKES_CONTACTS_ID +" INTEGER PRIMARY KEY AUTOINCREMENT,"+
                                        ConstantesBaseDatos.TABLE_LIKES_CONTACTS_ID_CONTACTO +" INTEGER,"+
                                        ConstantesBaseDatos.TABLE_LIKES_CONTACTS_NUMERO+" INTEGER, "+
                                        "FOREIGN KEY ("+ConstantesBaseDatos.TABLE_LIKES_CONTACTS_ID_CONTACTO+ ")  "+
                                        "REFERENCES "+ ConstantesBaseDatos.TABLE_CONTACTS + "("+ConstantesBaseDatos.TABLE_CONTACTS_ID+")"+
                                        ")";

        sqLiteDatabase.execSQL(queryCrearTablaContacto);
        sqLiteDatabase.execSQL(queryCrearTablaLikesContacto);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXIST "+ ConstantesBaseDatos.TABLE_CONTACTS);
        db.execSQL("DROP TABLE IF EXIST "+ ConstantesBaseDatos.TABLE_LIKES_CONTACTS);
        onCreate(db);

    }

    public ArrayList<Contacto> obtenerTodosContactos(){

        ArrayList<Contacto>contactos=new ArrayList<Contacto>();

        String query= "SELECT * FROM "+ ConstantesBaseDatos.TABLE_CONTACTS  ;

        SQLiteDatabase db=this.getWritableDatabase();

        Cursor registros= db.rawQuery(query,null);


        while (registros.moveToNext()){

            Contacto contacto=new Contacto();

            contacto.setId(registros.getInt(0));
            contacto.setNombre(registros.getString(1));
            contacto.setTelefono(registros.getString(2));
            contacto.setEmail(registros.getString(3));
            contacto.setFoto(registros.getInt(4));

            String queryLikes="SELECT COUNT("+ConstantesBaseDatos.TABLE_LIKES_CONTACTS_NUMERO+")" +
                    " FROM "+ConstantesBaseDatos.TABLE_LIKES_CONTACTS +
                    " WHERE "+ ConstantesBaseDatos.TABLE_LIKES_CONTACTS_ID_CONTACTO +" = " +contacto.getId();


            Cursor registroLikes=db.rawQuery(queryLikes,null);

            if(registroLikes.moveToNext()){
                contacto.setLikes(registroLikes.getInt(0));
            }
            else{
                contacto.setLikes(0);
            }


            contactos.add(contacto);


        }

        db.close();



        return  contactos;


    }

    public  void  insertarContacto(ContentValues contentValues){

        SQLiteDatabase db=this.getWritableDatabase();
        db.insert(ConstantesBaseDatos.TABLE_CONTACTS,null,contentValues);
        db.close();


    }

    public  void  insertarLikeContacto(ContentValues contentValues){
        SQLiteDatabase db=this.getWritableDatabase();
        db.insert(ConstantesBaseDatos.TABLE_LIKES_CONTACTS,null,contentValues);
        db.close();
    }


    public  int obtenerLikesContacto(Contacto contacto){
        int likes=0;

        String query="SELECT COUNT("+ConstantesBaseDatos.TABLE_LIKES_CONTACTS_NUMERO+")" +
                      " FROM "+ConstantesBaseDatos.TABLE_LIKES_CONTACTS +
                      " WHERE "+ ConstantesBaseDatos.TABLE_LIKES_CONTACTS_ID_CONTACTO +" = " +contacto.getId();

        SQLiteDatabase db=this.getWritableDatabase();

        Cursor registro=db.rawQuery(query,null);

        while (registro.moveToNext()){
            likes=registro.getInt(0);
        }

        db.close();

        return  likes;
    }
}
