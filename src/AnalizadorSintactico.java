
package Laboratorio1.src;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * AnalizadorSintactico
 */
public class AnalizadorSintactico {
    public static boolean ExpresionRegular(String cadena){
        Pattern pattern = Pattern.compile("", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(cadena);
        return matcher.find();
    }
}