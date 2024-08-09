package Laboratorio1.src;

import java.util.ArrayList;
import java.util.Stack;

public class AnalizadorLexico {
    
    public static boolean AutomataPila(ArrayList<String> listadoDeTokens) throws Exception{
        //se agrega el simbolo inicial
        Stack<String> pilaInterna = new Stack<String>();
        pilaInterna.push("I");
        
        while (!pilaInterna.isEmpty()) {
            String lookAhead = "";
            if (listadoDeTokens.size() > 0) {
                lookAhead = listadoDeTokens.get(0);
            }

            String simboloPilaInterna = pilaInterna.peek();
            
            if (lookAhead.equals(simboloPilaInterna)) {
                listadoDeTokens.remove(0);
                pilaInterna.pop();
            }else{
                switch (simboloPilaInterna) {
                    case "I":{
                        pilaInterna.pop();
                        pilaInterna.push("eof");
                        pilaInterna.push("A");
                    } break;
                    case "A":{
                        if (lookAhead.equals("V")) {
                            pilaInterna.pop();
                            pilaInterna.push("V");
                            //pilaInterna.push("S");
                            //pilaInterna.push("A");
                        }else if(lookAhead.equals("(")){
                            pilaInterna.pop();
                            //pilaInterna.push("(");
                            pilaInterna.push("A");
                            pilaInterna.push("V");
                            pilaInterna.push("S");
                            pilaInterna.push(")");
                            pilaInterna.push("V");
                            pilaInterna.push("S");
                            pilaInterna.push("V");
                            listadoDeTokens.remove(0);
                        }else{
                            pilaInterna.pop();
                        }
                    }break;
                    case "S":{
                        if (lookAhead.equals("+") || lookAhead.equals("-")) {
                            listadoDeTokens.remove(0);
                            pilaInterna.pop();
                        }else {
                            pilaInterna.pop();
                        }
                    }break;
                    case "V": {
                        if (lookAhead.equals("VALUE_BIN") || lookAhead.equals("VALUE_OCT") || lookAhead.equals("VALUE_HEX")) {
                            pilaInterna.pop();
                            listadoDeTokens.remove(0);
                        }else {
                            throw new Exception("Se esperaba: " + pilaInterna.peek() + " pero encontró: " + lookAhead);
                        }
                    }break;
                    case "eof": {
                        return true;
                    }
                    default:
                        throw new Exception("Simbolo no encontrado: " + pilaInterna.peek());
                }
    
            }
        }
        
        if (listadoDeTokens.isEmpty()) {
            return true;
        }else{
            return false;
        }
    }
}
