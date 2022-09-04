package com.quipux.test.hora;

import com.quipux.test.IOpcionMenu;

import java.util.HashMap;
import java.util.Scanner;

public class Hora implements IOpcionMenu {
    boolean continuar = true;
    @Override
    public void mostrarOpciones() {
        System.out.println("Bienvenido a la prueba de hora en palabras \n" +
                "\t Ingrese la opción \n" +
                "\t \t 1. Ingresar hora \n" +
                "\t \t 2. Salir de la prueba \n"
        );
    }

    @Override
    public void procesarOpcion(int opcion) {
        switch (opcion){
            case 1:
                convertirHora();
                break;
            case 2:
                continuar = false;
                break;
        }
    }

    private void convertirHora() {
        Scanner sc = new Scanner(System.in);
        int horasNum;
        int minutosNum;
        HashMap<Integer, String> horas = new HashMap<>();
        horas.put(1, "una ");
        horas.put(2, "dos ");
        horas.put(3, "tres ");
        horas.put(4, "cuatro ");
        horas.put(5, "cinco ");
        horas.put(6, "seis ");
        horas.put(7, "siete ");
        horas.put(8, "ocho ");
        horas.put(9, "nueve ");
        horas.put(10, "diez ");
        horas.put(11, "once ");
        horas.put(12, "doce ");

        HashMap<Integer, String> minutos = new HashMap<>();
        minutos.put(0, " minutos");
        minutos.put(1, " y un minuto");
        minutos.put(2, " y dos minutos");
        minutos.put(3, " y tres minutos");
        minutos.put(4, " y cuatro minutos");
        minutos.put(5, " y cinco minutos");
        minutos.put(6, " y seis minutos");
        minutos.put(7, " y siete minutos");
        minutos.put(8, " y ocho minutos");
        minutos.put(9, " y nueve minutos");
        minutos.put(10, " y diez minutos");
        minutos.put(11, " y once minutos");
        minutos.put(12, " y doce minutos");
        minutos.put(13, " y trece minutos");

        HashMap<Integer, String> decimas = new HashMap<>();
        decimas.put(1, "y diez");
        decimas.put(2, "y veinte");
        decimas.put(3, "y treinta");
        decimas.put(4, "y cuarenta");
        decimas.put(5, "y cincuenta");

        HashMap<Integer, String> especiales = new HashMap<>();
        especiales.put(0, "en punto");
        especiales.put(15, "y cuarto");
        especiales.put(30, "y media");

        System.out.println("Ingrese las horas (entre 1 y 12)");
        horasNum = sc.nextInt();
        System.out.println("Ingrese los minutos (entre 0 y 60)");
        minutosNum = sc.nextInt();

        boolean isEspecial = especiales.keySet().stream().anyMatch(k -> k == minutosNum);
        boolean isSinDecimas = minutos.keySet().stream().anyMatch(k -> k == minutosNum);
        String horaTxt = "";
        horaTxt += horas.get(horasNum);

        if(isEspecial){
            horaTxt += especiales.get(minutosNum);
        }else if(isSinDecimas){
            horaTxt += minutos.get(minutosNum);
        }else{
            horaTxt += decimas.get(minutosNum/10) + minutos.get(minutosNum%10);
        }
        System.out.println("La hora en texto es: " + horaTxt);
    }

    @Override
    public boolean continuar() {
        return continuar;
    }
}
