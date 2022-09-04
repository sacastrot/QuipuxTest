package com.quipux.test.entero;

import com.quipux.test.IOpcionMenu;

import java.util.Scanner;

public class Entero implements IOpcionMenu {
    boolean continuar = true;
    @Override
    public void mostrarOpciones() {
        System.out.println("Bienvenido a la prueba del número entero \n" +
                "\t Ingrese la opción \n" +
                "\t \t 1. Ingresar número \n" +
                "\t \t 2. Salir de la prueba \n"
        );
    }

    @Override
    public void procesarOpcion(int opcion) {
        switch (opcion){
            case 1:
                evaluarNumero();
                break;
            case 2:
                continuar = false;
                break;
        }

    }

    private void evaluarNumero() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el número entero a evaluar");
        int numero = sc.nextInt();
        if(numero%2 == 0){
            if (numero>=2 && numero<=5){
                System.out.println("No Quipux");
            } else if (numero>=6 && numero<=20) {
                System.out.println("Quipux");

            } else if(numero>20){
                System.out.println("Quipux");
            }
        }else {
            System.out.println("Quipux");
        }
    }

    @Override
    public boolean continuar() {
        return continuar;
    }
}
