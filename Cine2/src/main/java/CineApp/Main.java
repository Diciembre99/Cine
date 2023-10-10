package CineApp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        
        LocalDate begin = null;
        LocalDate end = null;
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
       Billboard pelicula=new Billboard("batman",begin,end,Gender.ACTION,AgeCategory.C_18);
       Billboard pelicula2=new Billboard("barbie",begin,end,Gender.ADVENTURE,AgeCategory.C_A);
        
        EscribirSecuencial.escribirSecuencialBillboard(pelicula);
        EscribirSecuencial.escribirSecuencialBillboard(pelicula2);
        
        System.out.println("Funcion leer:");
        LeerSecuencial.leerSecuencial();
        
        
        
        
    }
}