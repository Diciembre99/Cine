package CineApp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        
        Date begin = null;
        Date end = null;
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        Functions pelicula=new Functions("batman",begin,end,AgeCategory.C_18,Gender.ACTION);
        Functions pelicula2=new Functions("barbie",begin,end,AgeCategory.C_A,Gender.ADVENTURE);
        
        //EscribirSecuencial.escribirSecuencial(pelicula);
        //EscribirSecuencial.escribirSecuencial(pelicula2);
        
        System.out.println("Funcion leer:");
        LeerSecuencial.leerSecuencial();
        
        
        
    }
}