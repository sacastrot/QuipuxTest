package com.quipux.test.futbol;

import java.util.ArrayList;
import java.util.List;

public class Equipo {
    private String nombre;
    private String estadio;
    private int titulos;
    private List<Jugador> jugadores;

    public Equipo(String nombre, String estadio, int titulos) {
        this.nombre = nombre;
        this.estadio = estadio;
        this.titulos = titulos;
        this.jugadores = new ArrayList<>();
    }

    public void agregarJugador(String nombre, String posicion, boolean titular){
        Jugador jugador = new Jugador(nombre, posicion, titular);
        jugadores.add(jugador);
    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEstadio() {
        return estadio;
    }

    public void setEstadio(String estadio) {
        this.estadio = estadio;
    }

    public int getTitulos() {
        return titulos;
    }

    public void setTitulos(int titulos) {
        this.titulos = titulos;
    }

    public List<Jugador> getJugadores() {
        return jugadores;
    }

    public int getTotalJugadores(){
        return jugadores.size();
    }

}
