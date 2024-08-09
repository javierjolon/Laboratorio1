package Laboratorio1.test;

import static org.junit.Assume.assumeTrue;

import java.util.ArrayList;

import org.junit.Test;

import Laboratorio1.src.AnalizadorLexico;

public class AnalizadorLexicoTest {

    @Test
    public void test1() throws Exception {
        ArrayList<String> listado = new ArrayList<String>();
        listado.add("(");
        listado.add("VALUE_BIN");
        listado.add("+");
        listado.add("VALUE_BIN");
        listado.add(")");
        listado.add("-");
        listado.add("VALUE_BIN");
        
        Boolean respuesta = AnalizadorLexico.AutomataPila(listado);
        assumeTrue(respuesta);
    }

    @Test
    public void test2() throws Exception {
        ArrayList<String> listado = new ArrayList<String>();
        listado.add("(");
        listado.add("VALUE_BIN");
        listado.add("-");
        listado.add("VALUE_OCT");
        listado.add(")");
        listado.add("+");
        listado.add("VALUE_HEX");
        
        Boolean respuesta = AnalizadorLexico.AutomataPila(listado);
        assumeTrue(respuesta);
    }

    @Test
    public void test3() throws Exception {
        ArrayList<String> listado = new ArrayList<String>();
        listado.add("VALUE_BIN");
        
        Boolean respuesta = AnalizadorLexico.AutomataPila(listado);
        assumeTrue(respuesta);
    }

    @Test
    public void test4() throws Exception {
        ArrayList<String> listado = new ArrayList<String>();
        listado.add("VALUE_BIN");
        listado.add("+");
        listado.add("VALUE_BIN");
        
        Boolean respuesta = AnalizadorLexico.AutomataPila(listado);
        assumeTrue(respuesta);
    }
}
