package arbolpreguntasyrespuestas;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class ArbolPreguntasYRespuestas {

    public static int gen(ArrayList<Integer> numeros, Random ra) {
        // crea un valor ramdon y busca si ya esta en la lista, si es verdadero vuelve a ejecutar la misma funcion gen 
        int numero = ra.nextInt(100);
        if (!numeros.contains(numero)) {
            return numero;
        } else {
            return gen(numeros, new Random());
        }
    }

    public static ArrayList<Integer> generarArbol(int cantidad) {
        // creo una lista vacio para luego llenarla con un valor ramdon no repetido que proviene de la funcion gen
        ArrayList<Integer> numeros = new ArrayList<>();
        for (int i = 0; i < cantidad; i++) numeros.add(gen(numeros, new Random()));
        return numeros;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random generador = new Random();
        
        Arbol arbol = new Arbol(); // creacion de la instancia del arbol
        int cantidad = 12; // cantidad de nodos

        int estados = 1;
        while (estados == 1) {
            int intentos = 4;
            System.out.println("bienvenido a la Adivinanza Numerica");

            // generacion del arbol y el nuemero a buscar
            ArrayList<Integer> valores = generarArbol(cantidad);
            int numAdivinar = valores.get(generador.nextInt(cantidad));
            for (Integer valore : valores) arbol.agregar(valore);
            System.out.println("este es el valor a buscar " + numAdivinar);

            // escribo el arbol
            arbol.TreePrinter();

            // todo el sistema de adivinanza
            while (intentos > 0) {
                System.out.println("intentos: " + intentos);
                System.out.print("digita el numero a adivinar: ");
                int valorUsuario = input.nextInt();

                // se compara el dato del usuario y el numero a adivinar
                if (valorUsuario == numAdivinar) {
                    System.out.println("ganaste");
                    System.out.println("el recorrido realizado fue :" + arbol.buscar(arbol.raiz, valorUsuario, "", 0, true));
                    break;
                } else {
                    intentos--;
                    System.out.println("el recorrido realizado fue :" + arbol.buscar(arbol.raiz, valorUsuario, "", 0, false));
                }
            }
            if (intentos == 0) System.out.println("perdiste");
            System.out.println("deseas otra partida 1. si 2. no");
            estados = input.nextInt();
        }
    }
}


