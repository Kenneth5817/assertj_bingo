package org.iesvdm;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class TestBingo{
@Test
public void testLimpiar() {
    int[] resultado = UtilesArrays.limpiar();
    assertEquals(0, resultado.length);
}

@Test
public void testRellenar() {
    int[] array = {1, 2, 3};
    int numeroElementos = 5;
    int[] resultado = UtilesArrays.rellenar(array, numeroElementos);
    assertEquals(numeroElementos, resultado.length);
    for (int valor : resultado) {
        assertEquals(0, valor);
    }
}

@Test
public void testRellenarConValor() {
    int[] array = {1, 2, 3};
    int numeroElementos = 5;
    int valor = 10;
    int[] resultado = UtilesArrays.rellenar(array, numeroElementos, valor);
    assertEquals(numeroElementos, resultado.length);
    for (int valorElemento : resultado) {
        assertEquals(valor, valorElemento);
    }
}

@Test
public void testInsertarAlFinal() {
    int[] array = {1, 2, 3};
    int elemento = 4;
    int[] resultado = UtilesArrays.insertarAlFinal(array, elemento);
    assertEquals(array.length + 1, resultado.length);
    assertEquals(elemento, resultado[resultado.length - 1]);
}

@Test
public void testInsertarAlPrincipio() {
    int[] array = {1, 2, 3};
    int elemento = 0;
    int[] resultado = UtilesArrays.insertarAlPrincipio(array, elemento);
    assertEquals(array.length + 1, resultado.length);
    assertEquals(elemento, resultado[0]);
}

@Test
public void testInsertarEnPosicion() {
    int[] array = {1, 2, 3};
    int elemento = 10;
    int posicion = 1;
    int[] resultado = UtilesArrays.insertarEnPosicion(array, elemento, posicion);
    assertEquals(array.length + 1, resultado.length);
    assertEquals(elemento, resultado[posicion]);
}

@Test
public void testInsertarOrdenado() {
    int[] array = {1, 3, 5};
    int elemento = 4;
    int[] resultado = UtilesArrays.insertarOrdenado(array, elemento);
    int[] esperado = {1, 3, 4, 5};
    assertArrayEquals(esperado, resultado);
}

@Test
public void testEliminarUltimo() {
    int[] array = {1, 2, 3};
    int[] resultado = UtilesArrays.eliminarUltimo(array);
    int[] esperado = {1, 2};
    assertArrayEquals(esperado, resultado);
}


@Test
public void testEliminarPrimero() {
    int[] array = {1, 2, 3};
    int[] resultado = UtilesArrays.eliminarPrimero(array);
    int[] esperado = {2, 3};
    assertArrayEquals(esperado, resultado);
}

@Test
public void testEliminarPosicion() {
    int[] array = {1, 2, 3, 4, 5};
    int posicion = 2; // Eliminar el elemento en la posición 2 (índice 2)
    int[] resultado = UtilesArrays.eliminarPosicion(array, posicion);
    int[] esperado = {1, 2, 4, 5}; // El resultado esperado es {1, 2, 4, 5} después de eliminar el elemento en la posición 2
    assertArrayEquals(esperado, resultado);
}

@Test
public void testEliminar() {
    int[] array = {1, 2, 3, 2, 4, 2};
    int elemento = 2; // Eliminar el elemento 2 del array
    int[] resultado = UtilesArrays.eliminar(array, elemento);
    int[] esperado = {1, 3, 4}; // El resultado esperado es {1, 3, 4} después de eliminar todas las ocurrencias del elemento 2
    assertArrayEquals(esperado, resultado);
}

@Test
public void testOrdenar() {
    int[] array = {5, 3, 8, 1, 4};
    int[] resultado = UtilesArrays.ordenar(array);
    int[] esperado = {1, 3, 4, 5, 8};
    assertArrayEquals(esperado, resultado);
}

    @Test
    public void testDesordenar() {
        int[] array = {1, 2, 3, 4, 5};
        int[] arrayOrdenado = Arrays.copyOf(array, array.length);
        Arrays.sort(arrayOrdenado);
        UtilesArrays.desordenar(array);
        assertFalse(Arrays.equals(array, arrayOrdenado));
    }

@Test
public void testInvertir() {
    int[] array = {1, 2, 3, 4, 5};
    int[] resultado = UtilesArrays.invertir(array);
    int[] esperado = {5, 4, 3, 2, 1};
    assertArrayEquals(esperado, resultado);
}

@Test
public void testEstaOrdenado() {
    int[] arrayOrdenado = {1, 2, 3, 4, 5};
    int[] arrayDesordenado = {5, 4, 3, 2, 1};
    assertTrue(UtilesArrays.estaOrdenado(arrayOrdenado));
    assertFalse(UtilesArrays.estaOrdenado(arrayDesordenado));
}

@Test
public void testBuscar() {
    int[] array = {1, 2, 3, 4, 5};
    int elemento = 3;
    int posicion = UtilesArrays.buscar(array, elemento);
    assertEquals(2, posicion); // El elemento 3 está en la posición 2 (índice 2)
}

@Test
public void testPartirPor() {
    int[] array = {1, 2, 3, 4, 5};
    int[] resultado = UtilesArrays.partirPor(array, 1, 4);
    int[] esperado = {2, 3, 4};
    assertArrayEquals(esperado, resultado);
}

@Test
public void testPartirPor_PosicionesIncorrectas() {
    int[] array = {1, 2, 3, 4, 5};
    int[] resultado = UtilesArrays.partirPor(array, 3, 1);
    assertArrayEquals(array, resultado);
}

@Test
public void testPartirPor_PosicionesFueraDeRango() {
    int[] array = {1, 2, 3, 4, 5};
    int[] resultado = UtilesArrays.partirPor(array, 6, 8);
    assertArrayEquals(array, resultado);
}

@Test
public void testSonIguales() {
    int[] array1 = {1, 2, 3, 4, 5};
    int[] array2 = {1, 2, 3, 4, 5};
    assertTrue(UtilesArrays.sonIguales(array1, array2)); // Comparación de arrays completos
}

@Test
public void testSonIguales_DiferentesLongitudes() {
    int[] array1 = {1, 2, 3, 4, 5};
    int[] array2 = {1, 2, 3};
    assertFalse(UtilesArrays.sonIguales(array1, array2));
}

@Test
public void testSonIguales_DiferentesElementos() {
    int[] array1 = {1, 2, 3, 4, 5};
    int[] array2 = {1, 2, 7, 4, 5};
    assertFalse(UtilesArrays.sonIguales(array1, array2));
}

@Test
public void testElementosIguales() {
    int[] array1 = {1, 2, 3, 4, 5};
    int[] array2 = {1, 2, 3, 4, 5};
    assertTrue(UtilesArrays.elementosIguales(array1, array2, 2)); // Elementos en la posición 2 son iguales
}

@Test
public void testElementosIguales_DiferentesElementos() {
    int[] array1 = {1, 2, 3, 4, 5};
    int[] array2 = {1, 2, 7, 4, 5};
    assertFalse(UtilesArrays.elementosIguales(array1, array2, 2)); // Elementos en la posición 2 son diferentes
}

@Test
public void testConcatenarArrays() {
    int[] array1 = {1, 2, 3};
    int[] array2 = {4, 5, 6};
    int[] resultado = UtilesArrays.concatenarArrays(array1, array2);
    int[] esperado = {1, 2, 3, 4, 5, 6};
    assertArrayEquals(esperado, resultado);
}

@Test
public void testConcatenarArrays_Array1Vacio() {
    int[] array1 = {};
    int[] array2 = {4, 5, 6};
    int[] resultado = UtilesArrays.concatenarArrays(array1, array2);
    assertArrayEquals(array2, resultado);
}

@Test
public void testConcatenarArrays_Array2Vacio() {
    int[] array1 = {1, 2, 3};
    int[] array2 = {};
    int[] resultado = UtilesArrays.concatenarArrays(array1, array2);
    assertArrayEquals(array1, resultado);
}

@Test
public void testConcatenarArrays_AmbosArraysVacios() {
    int[] array1 = {};
    int[] array2 = {};
    int[] resultado = UtilesArrays.concatenarArrays(array1, array2);
    assertEquals(0, resultado.length);
}
}

