package com.example.univalle_android_tutorial.Entidades;

public class User {
    private int id;
    private String nombre;
    private String edad;
    private String url;

    public User(int id, String nombre, String edad, String url) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
        this.url = url;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}