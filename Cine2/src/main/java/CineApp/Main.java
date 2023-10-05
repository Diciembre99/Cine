package CineApp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    public static void main(String[] args) {
        
        String titulo=" ";
        String texto=" ";
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        try {
            System.out.println("Titulo");
            titulo=br.readLine();
            System.out.println("Texto");
            texto=br.readLine();
            EscribirSecuencial.escribirSecuencial(titulo, texto,true);
            System.out.println("Texto");
            texto=br.readLine();
            EscribirSecuencial.escribirSecuencial(titulo, texto,true);
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println("");
        System.out.println("Funcion leer:");
        LeerSecuencial.leerSecuencial(titulo);
        
        
        
    }
}