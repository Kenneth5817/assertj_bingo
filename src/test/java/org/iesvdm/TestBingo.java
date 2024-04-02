package org.iesvdm;
import org.junit.Test;

import java.util.Arrays;

import static org.iesvdm.Bingo.*;
import static org.junit.Assert.*;

public class TestBingo{
    @Test
    public void testRellenarNumerosCarton() {
        int[][] arrayBidimensional = new int[5][8];
        rellenarNumerosCarton(arrayBidimensional);

        // Comprobamos que todas las columnas están ordenadas
        for (int i = 0; i < arrayBidimensional.length; i++) {
            boolean sorted = true;
            for (int z = 0; z < arrayBidimensional[i].length - 1; z++) {
                if (arrayBidimensional[i][z] > arrayBidimensional[i][z + 1]) {
                    sorted = false;
                    break;
                }
            }
            assertTrue("La columna " + i + " no está ordenada", sorted);
        }
    }


    @Test
    public void testBuscarFila() {
        int[][] arrayBi = {
                {4, 42, 52},
                {2, -1, 14},
                {7, 2, 12}
        };
        assertTrue(buscarFila(arrayBi, 1, 1));
        assertFalse(buscarFila(arrayBi, 1, 0));
    }

    @Test
    public void testPonerBlancos() {
        int[][] arrayBi = new int[28][2];

        ponerBlancos(arrayBi);

        // Comprobamos que no haya más de dos blancos en ninguna columna
        for (int i = 0; i < arrayBi[0].length; i++) {
            int contadorBlancos = 0;
            for (int z = 0; z < arrayBi.length; z++) {
                if (arrayBi[z][i] == -1) {
                    contadorBlancos++;
                    if (contadorBlancos > 2) {
                        throw new AssertionError("Hay más de dos blancos en la columna " + i);
                    }
                }
            }
        }
    }

    @Test
    public void testBuscarColumna() {
        int[][] arrayBi = new int[1][3];

        arrayBi[0][0] = -1;
        arrayBi[0][1] = -1;

        assertTrue(buscarColumna(arrayBi, 0));
    }

    @Test
    public void testBuscarValorRepetido() {
        int[] array = {1, 2, 3, 4, 5, 3};

        // Buscamos un elemento que está en el array
        assertTrue(buscarValorRepetido(array, 3));

        // Buscamos un elemento que no está en el array
        assertFalse(buscarValorRepetido(array, 29));
    }

    @Test
    public void testPintarCarton() {
        int[][] carton = {
                {5, 4, 9, 2, 7},
                {6, 3, 8, 1, 10},
                {17, 34, 13, 11, 15}
        };
        int[] bolas = {3, 7, 10};

        // Llamamos al método y guardamos el resultado en una variable
        int aciertos = pintarCarton(carton, bolas);

        assertEquals(3, aciertos);
    }

    @Test
    public void testInsertarAlFinal() {
        int[] array = {4,2,3,1};
        int elemento = 5;

        // Llamamos al método y guardamos el resultado en una variable
        int[] resultado = insertarAlFinal(array, elemento);

        // ARRAY ESPERADO
        int[] esperado = {4,2,3,1,5};

        assertArrayEquals(esperado, resultado);
    }
    @Test
    public void testOrdenar() {
        int[] array = {3, 1, 4, 2};

        // Llamamos al método y guardamos el resultado en una variable
        int[] resultado = ordenar(array);

        //ARRAY ESPERADO
        int[] esperado = {1, 2, 3, 4};

        assertArrayEquals(esperado, resultado);
    }



}

