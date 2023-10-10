package CineApp;

import java.io.File;
import java.time.LocalDate;
import java.util.Scanner;

public class Pruebas {
    public static void main(String[] args){
        LocalDate date = LocalDate.now();
        Scanner read = new Scanner(System.in);
        File file = new File(date+".data");
        System.out.println("Lista de recursos ");
        System.out.println("================================================");
        FilesFunction.ReadShowList(file);
        System.out.println("Escribe el nombre de la película a buscar");
        String buscar = read.nextLine();
        FilesFunction.ReadShows(file, buscar);
    }
}
