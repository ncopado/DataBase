package com.ncopado.miscontactosapp.pojo;

/**
 * Created by ncopado on 18/08/17.
 */

public class Contacto {



    private int id;
    private String Nombre;
    private String Telefono;
    private String Email;
    private  int Foto;
    private  int likes;

    public Contacto(String nombre, String telefono) {
       this.Nombre = nombre;
        this.Telefono = telefono;
    }

    public Contacto(int foto, String nombre, String telefono, String email, int likes) {
        this.Foto=foto;
        Nombre = nombre;
        Telefono = telefono;
        Email = email;
        this.likes = likes;
    }

    public Contacto() {

    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String telefono) {
        Telefono = telefono;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }


    public int getFoto() {
        return Foto;
    }

    public void setFoto(int foto) {
        Foto = foto;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
