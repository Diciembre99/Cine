package com.plaga.cine.FilesManage;

import com.plaga.cine.Modules.Client;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class RandomFilesFunction {

    private static int MAXBYTES = 74;
    private static int MAXNAME = 50;
    private static int MAXDNI = 20;

    private static final Logger logger = LogManager.getRootLogger();

    /**
     * Escribe datos en el fichero apartir de una ruta
     *
     * @param client objeto que se almacenara en la lista
     * @param nombreArchivo Nobre del fichero que se va a guardar
     * @throws IOException
     */
    public static void WriteFile(Client client, File nombreArchivo) {
        try (RandomAccessFile archivo = new RandomAccessFile(nombreArchivo, "rw")) {
            archivo.seek(archivo.length()); // Se posiciona al final del archivo
            //Escritura del nombre
            String nombre = client.getNombre();
            byte[] textoBytesName = new byte[MAXNAME]; //una lista bytes con el ancho predefinido
            byte[] textoOriginalBytes = nombre.getBytes(); //Obtenemos los bytes del String nombre y los asignamos a la lista
            System.arraycopy(textoOriginalBytes, 0, textoBytesName, 0, textoOriginalBytes.length); //Asignamos el nombre convertido a bytes a la lista de ancho predefinido
            archivo.write(textoBytesName); //Escribimos el fichero

            //Escritura del DNI
            String DNI = client.getDni();
            textoBytesName = new byte[MAXDNI];
            textoOriginalBytes = DNI.getBytes();
            System.arraycopy(textoOriginalBytes, 0, textoBytesName, 0, textoOriginalBytes.length);
            archivo.write(textoBytesName);
            archivo.writeInt(client.getEdad());

        } catch (IOException io) {
            logger.error("Error al escribir el archivo " + io);
        }
    }

    /**
     * Funcion que lee el fichero de forma de acceso aleatorio
     *
     * @param nameFile Ruta donde esta guardado el fichero
     * @return lista de clientes leidos apartir del fichero dado
     */
    public static List<Client> ReadFile(File nameFile) {
        List<Client> list = new ArrayList<Client>();

        try {
            // Abre el archivo en modo solo lectura
            RandomAccessFile file = new RandomAccessFile(nameFile, "r");

            // Calcula el número total de registros en el archivo
            long totalRegister = file.length() / MAXBYTES;
            // Lee cada registro del archivo
            for (long i = 0; i < totalRegister; i++) {
                // Lee el nombre del registro actual
                byte[] nombreBytes = new byte[MAXNAME];
                file.read(nombreBytes);
                String name = new String(nombreBytes, StandardCharsets.UTF_8).trim(); // Convierte bytes a String y elimina espacios en blanco

                // Lee el DNI del registro actual
                byte[] dniBytes = new byte[MAXDNI];
                file.read(dniBytes);
                String dni = new String(dniBytes, StandardCharsets.UTF_8).trim(); // Convierte bytes a String y elimina espacios en blanco

                // Lee la edad del registro actual (suponiendo un entero de 4 bytes)
                int age = file.readInt();
                Client client = new Client(name, dni, age);
                list.add(client);
            }
        } catch (IOException e) {
            logger.error("Error al leer el archivo");
        }
        return list;
    }

    /**
     * Borarr un usuario especifico de un fichero
     *
     * @param fileName Nombre del fichero donde se eliminara el usuario
     * @param numberUserDelete Numero de id del usuario a eliminar
     * @throws IOException
     */
    public static void DeleteUser(File fileName, int numberUserDelete) throws IOException {
        try {
            // Abre el archivo en modo lectura/escritura
            RandomAccessFile RandomFile = new RandomAccessFile(fileName, "rw");

            // Calcula la posición en el archivo donde comienza el registro que deseas eliminar
            long positionRegisterDelete = (numberUserDelete) * MAXBYTES;

            // Mueve el puntero de lectura/escritura al inicio del registro que deseas eliminar
            RandomFile.seek(positionRegisterDelete);

            // Mueve el contenido del archivo a partir del registro siguiente para sobrescribir el registro que deseas eliminar
            byte[] buffer = new byte[(int) (RandomFile.length() - positionRegisterDelete - MAXBYTES)];
            RandomFile.read(buffer);
            RandomFile.seek(positionRegisterDelete);
            RandomFile.write(buffer);

            // Trunca el archivo para eliminar los bytes finales (el último registro duplicado)
            RandomFile.setLength(RandomFile.length() - MAXBYTES);

            // Cierra el archivo después de editar
            RandomFile.close();

            logger.trace("El fichero fue eliminado " + numberUserDelete);
        } catch (IOException e) {
            logger.error("Error al eliminar el archivo");
        }
    }

    public static void EdirUserVip(Client client, File fileName, int numberUserEdit) {
        try {
            RandomAccessFile randomFile = new RandomAccessFile(fileName, "rw");
            long positionRegisterDelete = (numberUserEdit) * MAXBYTES;
            randomFile.seek(positionRegisterDelete);

            String nombre = client.getNombre();
            byte[] textoBytesName = new byte[MAXNAME]; //una lista bytes con el ancho predefinido
            byte[] textoOriginalBytes = nombre.getBytes(); //Obtenemos los bytes del String nombre y los asignamos a la lista
            System.arraycopy(textoOriginalBytes, 0, textoBytesName, 0, textoOriginalBytes.length); //Asignamos el nombre convertido a bytes a la lista de ancho predefinido
            randomFile.write(textoBytesName); //Escribimos el fichero

            //Escritura del DNI
            String DNI = client.getDni();
            textoBytesName = new byte[MAXDNI];
            textoOriginalBytes = DNI.getBytes();
            System.arraycopy(textoOriginalBytes, 0, textoBytesName, 0, textoOriginalBytes.length);
            randomFile.write(textoBytesName);
            randomFile.writeInt(client.getEdad());
        } catch (IOException io) {

        }
    }
}
