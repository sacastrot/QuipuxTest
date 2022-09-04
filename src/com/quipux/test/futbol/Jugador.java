package com.quipux.test.futbol;

public class Jugador {
    private String nombre;
    private String posicion;
    private boolean titular;

    public Jugador(String nombre, String posicion, boolean titular) {
        this.nombre = nombre;
        this.posicion = posicion;
        this.titular = titular;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public boolean isTitular() {
        return titular;
    }

    public void setTitular(boolean titular) {
        this.titular = titular;
    }
}
