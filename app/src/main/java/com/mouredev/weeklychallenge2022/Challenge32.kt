package com.mouredev.weeklychallenge2022

/*
 * Reto #32
 * EL SEGUNDO
 * Fecha publicación enunciado: 08/08/22
 * Fecha publicación resolución: 15/08/22
 * Dificultad: FÁCIL
 *
 * Enunciado: Dado un listado de números, encuentra el SEGUNDO más grande.
 *
 * Información adicional:
 * - Usa el canal de nuestro Discord (https://mouredev.com/discord) "🔁reto-semanal" para preguntas, dudas o prestar ayuda a la comunidad.
 * - Tienes toda la información sobre los retos semanales en https://retosdeprogramacion.com/semanales2022.
 *
 */
import java.util.*;
public class lista
{
    public static final int CANTIDAD_NUMEROS_LISTA = 10;
    public static final int NUMERO_MAXIMO_LISTA = 100;
    public static final int NUMERO_MINIMO_LISTA = 0;
    public static void main(String[] args) {
		System.out.println("Programa para encontrar el segundo número más grande de un listado");
        List<Integer> lista = rellenarLista();
        imprimir(lista);
        int segundo = segundoMasGrande(lista);
        System.out.println("EL SEGUNDO NUMERO MAS GRANDE ES: " + segundo);
	}

    private static void imprimir(List<Integer> lista) {
        System.out.println(lista.toString());
    }

    public static List<Integer> rellenarLista(){
        Random rand = new Random();
        List<Integer> l = new LinkedList<Integer>();

        for(int i=0;i<CANTIDAD_NUMEROS_LISTA;i++){
            int numero = NUMERO_MINIMO_LISTA + rand.nextInt((NUMERO_MAXIMO_LISTA - NUMERO_MINIMO_LISTA) + 1);
            
            while(estaNumeroLista(l,numero)){
                numero = NUMERO_MINIMO_LISTA + rand.nextInt((NUMERO_MAXIMO_LISTA - NUMERO_MINIMO_LISTA) + 1);
            }
            l.add(numero);
        }
        return l;
    }
    
    private static boolean estaNumeroLista(List<Integer> l, int numero) {
        if(l.equals(null)){
            return false;
        }
        for(int i = 0; i < l.size(); i++){
            if(l.get(i).equals(numero)){
                return true;
            }
        }
        return false;
    }
    private static int segundoMasGrande(List<Integer> l) {
        seleccion(l);
        System.out.println("LISTA ORDENADA:");
        System.out.println(l.toString());
        return l.get(l.size()-2);
    }
    
    public static void seleccion(List<Integer> A) {
        int i, j, menor, pos, tmp;
        for (i = 0; i < A.size() - 1; i++) {      // tomamos como menor el primero
              menor = A.get(i);                   // de los elementos que quedan por ordenar                    
              pos = i;                            // y guardamos su posición
              for (j = i + 1; j < A.size(); j++){ // buscamos en el resto
                    if (A.get(j) < menor) {           // del array algún elemento
                        menor = A.get(j);             // menor que el actual
                        pos = j;
                    }
              }
              if (pos != i){                      // si hay alguno menor se intercambia                         
                  tmp = A.get(i);
                  A.set(i, A.get(pos));
                  A.set(pos, tmp);
              }
        }
    }
}
