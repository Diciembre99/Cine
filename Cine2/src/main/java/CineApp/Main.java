package CineApp;

import static CineApp.LeerSecuencial.nombreArchivo;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    public static void main(String[] args) {

        Date begin = null;
        Date end = null;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //Functions pelicula=new Functions("batman",begin,end,AgeCategory.C_18,Gender.ACTION);
        //Functions pelicula2=new Functions("barbie",begin,end,AgeCategory.C_A,Gender.ADVENTURE);
        //EscribirSecuencial.escribirSecuencial(pelicula);
        //EscribirSecuencial.escribirSecuencial(pelicula2);
        System.out.println("Funcion leer:");
        LeerSecuencial.leerSecuencial();

    }
}
