
package CineApp;

import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Alumno
 */
public class Cine_APS {

    public static void main(String[] args) {
        ArrayList<Functions> shows=  new ArrayList<>();
        Scanner read = new Scanner(System.in);
        LocalDate date = LocalDate.now();
        File file = new File(date+".data");
        if (file.exists()) {
            System.out.println("El fichero de hoy ya existe ");
        }else{
            System.out.println("================================================================");
            System.out.println("Escribe el nombre de la película que deseas agregara");
            String nombre = read.nextLine().trim();
            System.out.println("Escribe la fecha de inicio de la function que se va a emitir");
            int diaIni  = Integer.parseInt(read.nextLine().trim());
            int diaFin = Integer.parseInt(read.nextLine().trim());
            LocalDate dateIni = LocalDate.of(date.getYear(), date.getMonth(), diaIni);
            LocalDate dateFin = LocalDate.of(dateIni.getYear(), dateIni.getMonth(),diaFin);
            Functions f = new Functions(nombre, dateIni, dateFin,AgeCategory.C_A,Gender.ACTION);
            shows.add(f);
            Functions f2 = new Functions("Batman", dateIni, dateFin,AgeCategory.C_A,Gender.FANTASY);
            shows.add(f2);
            Functions f3 = new Functions("Superman", dateIni, dateFin,AgeCategory.C_16,Gender.ADVENTURE);
            shows.add(f3);
            FilesFunction.WriteShows(file, shows);
        }
        System.out.println("Lista de recursos ");
        System.out.println("================================================");
        System.out.println("Escribe la fecha que deseas buscar");
        int diaBuscar = Integer.parseInt(read.nextLine());
        String fechaBuscar = String.valueOf(LocalDate.of(date.getYear(), date.getMonth(), diaBuscar));
        File fileBuscar = new File(fechaBuscar);
        FilesFunction.ReadShowList(fileBuscar);
        System.out.println("Escribe el nombre de la película a buscar");
        String buscar = read.nextLine();
        FilesFunction.ReadShows(file, buscar);


    }
}
