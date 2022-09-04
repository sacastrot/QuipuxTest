package com.quipux.test;

import com.quipux.test.entero.Entero;
import com.quipux.test.futbol.Futbol;
import com.quipux.test.hora.Hora;

import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        IOpcionMenu opcionMenu = null;
        Futbol futbol = new Futbol();
        Entero entero = new Entero();
        Hora hora = new Hora();
        boolean continuar = true;
        Scanner sc = new Scanner(System.in);
        int opcion=0;
        while (continuar){
            System.out.println("\nBienvenido a la prueba técnica de Quipux \n " +
                    "\t Santiago Castro Tabares \n" +
                    "\t \t 1. Numero entero \n" +
                    "\t \t 2. Hora en numeros \n" +
                    "\t \t 3. Futbol \n" +
                    "\t \t 4. Salir \n"
            );

            try{
                opcion = sc.nextInt();
                switch (opcion) {
                    case 1:
                        opcionMenu = entero;
                        break;
                    case 2:
                        opcionMenu = hora;
                        break;
                    case 3:
                        opcionMenu = futbol;
                        break;
                    case 4:
                           continuar = false;
                           break;
                    default:
                        throw new Exception("Opción inválida");

                }
            } catch (Exception e){
                System.out.println("Revise la opción ingresada");
            }
            if(continuar){
                do {
                    opcionMenu.mostrarOpciones();
                    opcion = sc.nextInt();
                    opcionMenu.procesarOpcion(opcion);
                }while (opcionMenu.continuar());
            }

        }


    }
}
