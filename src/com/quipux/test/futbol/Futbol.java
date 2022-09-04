package com.quipux.test.futbol;

import com.quipux.test.IOpcionMenu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Futbol implements IOpcionMenu {
    private List<Equipo> equipos = new ArrayList<>();
    boolean continuar = true;
    @Override
    public void mostrarOpciones() {
        continuar = true;
        System.out.println("Bienvenido a la gestión de equipos de fútbol \n " +
                "\t Ingrese la opción \n" +
                "\t \t 1. Registrar equipo \n" +
                "\t \t 2. Agregar jugadores a un equipo \n" +
                "\t \t 3. Generar reporte básico \n" +
                "\t \t 4. Generar reporte detallado \n" +
                "\t \t 5. Salir de la prueba"

        );
    }

    @Override
    public void procesarOpcion(int opcion) {
        Equipo equipo = null;
        switch (opcion) {
            case 1: 
                registrarEquipo();
                break;
            case 2:
                agregarJugador(mostrarEquipos());
                break;
            case 3:
                generarSencillo();
                break;
            case 4:
                generarDetallado();
                break;
            case 5:
                continuar = false;
                break;
            default:
                
        }
    }

    private void generarDetallado() {
        for (Equipo equipo:
                equipos) {
            List<Jugador> jugadores = equipo.getJugadores();
            System.out.println("----- " + equipo.getNombre() + " -----\n" +
                            "\t ----- Jugadores -----\n");
            System.out.println("\t\t ----- Jugadores titulares -----\n");
            for (Jugador jugador:
                 jugadores) {
                if (jugador.isTitular()){
                    System.out.println("\t \t Nombre: "+ jugador.getNombre() + " Posición: " + jugador.getPosicion());
                }
            }
            System.out.println("\n\t\t ----- Jugadores suplentes -----\n");
            for (Jugador jugador:
                    jugadores) {
                if (!jugador.isTitular()){
                    System.out.println("\t\tNombre: "+ jugador.getNombre() + " Posición: " + jugador.getPosicion());
                }
            }
        }
    }

    private void generarSencillo() {
        for (Equipo equipo:
             equipos) {
            System.out.println("----- " + equipo.getNombre() + " -----\n" +
                    "\t Titulos ganados: " + equipo.getTitulos() + "\n" +
                    "\t Cantidad de jugadores: " + equipo.getTotalJugadores() + "\n" +
                    "-------------------------------------------------------------");
        }
    }



    @Override
    public boolean continuar() {
        return continuar;
    }

    private Equipo mostrarEquipos(){
        Equipo equipo;
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < equipos.size(); i++) {
            System.out.println(i+1+". " + equipos.get(i).getNombre());
        }
        System.out.println("Ingresa el número del equipo al que le desea ingresar jugadores");
        int index = sc.nextInt();
        equipo = equipos.get(index-1);
        return(equipo);
    }


    private void agregarJugador(Equipo equipo) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Ingresa el nombre del jugador (texto)");
        String nombre = sc.nextLine();
        System.out.println("Ingresa la posición del jugador (texto)");
        String posicion = sc.nextLine();
        System.out.println("Ingresa 1 si es titular o 2 si es suplente (número)");
        int titularNum = sc.nextInt();
        boolean titular = titularNum==1;
        equipo.agregarJugador(nombre,posicion,titular);
    }

    private void registrarEquipo() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingresa el nombre del equipo (texto)");
        String nombre = sc.nextLine();
        System.out.println("Ingresa el estadio del equipo (texto)");
        String estadio = sc.nextLine();
        System.out.println("Ingresa los titulos del equipo (número)");
        int titulos = sc.nextInt();

        Equipo equipo = new Equipo(nombre,estadio,titulos);
        equipos.add(equipo);
    }
}
