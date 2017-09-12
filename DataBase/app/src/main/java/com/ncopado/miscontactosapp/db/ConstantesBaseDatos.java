package com.ncopado.miscontactosapp.db;

import java.net.PortUnreachableException;

/**
 * Created by ncopado on 11/09/17.
 */

public final class ConstantesBaseDatos {


    public static final String DATABASE_NAME="contactos";

    public static final int DATABASE_VERSION=1;

    public static final String TABLE_CONTACTS="contacto";

    public static final String TABLE_CONTACTS_ID="id";
    public static final String TABLE_CONTACTS_NOMBRE="nombre";
    public static final String TABLE_CONTACTS_TELEFONO="telefono";
    public static final String TABLE_CONTACTS_EMAIL="email";
    public static final String TABLE_CONTACTS_FOTO="foto";


    public static final String TABLE_LIKES_CONTACTS="contacto_likes";
    public static final String TABLE_LIKES_CONTACTS_ID="id";
    public static final String TABLE_LIKES_CONTACTS_ID_CONTACTO="id_contacto";
    public static final String TABLE_LIKES_CONTACTS_NUMERO="numero_likes";





}
