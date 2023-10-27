package CineApp;

import java.time.LocalDate;
import java.util.LinkedList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * El manejador recorre los objetos del XML, almacenándolos en un LinkedList
 * tipo billboard.
 *
 * @author Alex Pineño Sanchez
 */
public class ManejadorSAX extends DefaultHandler {

    private final LinkedList<Billboard> lista; // Lista para almacenar objetos de tipo Billboard
    private Billboard billboardAuxiliar; // Objeto auxiliar para construir objetos Billboard
    private StringBuilder sb; // StringBuilder para almacenar el contenido de los elementos XML

    /**
     * Constructor del objeto SAX
     *
     * @author Alex Pineño Sanchez
     */
    public ManejadorSAX() {
        lista = new LinkedList<>();
    }

    /**
     * Funcion que deveuelve un LinkedList de obtejos tipo BillBoard
     *
     * @author Alex Pineño Sanchez
     * @return LinkedList de tipo billboard
     */
    public LinkedList<Billboard> getBillboards() {
        return lista;
    }

    /**
     * Llamado al inicio de un elemento XML durante el análisis SAX.
     *
     * @param uri El URI del espacio de nombres del elemento.
     * @param localName El nombre local del elemento.
     * @param qName El nombre cualificado del elemento.
     * @param attributes Los atributos del elemento.
     * @throws SAXException Si ocurre un error durante el análisis SAX.
     *
     * @author Alex Pineño Sanchez
     */
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        sb = new StringBuilder();

        if (qName.equalsIgnoreCase("Billboard")) {
            // Crear un nuevo objeto Billboard con valores predeterminados
            billboardAuxiliar = new Billboard("", LocalDate.now(), LocalDate.now(), Gender.ACTION, AgeCategory.C_12);
        }
    }

    /**
     * Llamada para procesar el contenido de un elemento XML durante el análisis
     * SAX.
     *
     * @param ch Un arreglo de caracteres que contiene el contenido del
     * elemento.
     * @param start La posición inicial del contenido en el arreglo.
     * @param length La longitud del contenido.
     * @throws SAXException Si ocurre un error durante el análisis SAX.
     *
     * @author Alex Pineño Sanchez
     */
    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        // Almacenar el contenido del elemento XML en el StringBuilder
        sb.append(new String(ch, start, length));
    }

    /**
     * Llamada al finalizar un elemento XML durante el análisis SAX.
     *
     * @param uri El URI del espacio de nombres del elemento.
     * @param localName El nombre local del elemento.
     * @param qName El nombre cualificado del elemento.
     * @throws SAXException Si ocurre un error durante el análisis SAX.
     * @author Alex Pineño Sanchez
     */
    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        // Comprobar el nombre del elemento XML y asignar valores al objeto Billboard
        if (qName.equalsIgnoreCase("Nombre")) {
            billboardAuxiliar.setPelicula(sb.toString());
        } else if (qName.equalsIgnoreCase("Inicio")) {
            billboardAuxiliar.setInicio(LocalDate.parse(sb.toString()));
        } else if (qName.equalsIgnoreCase("Final")) {
            billboardAuxiliar.setFinalizacion(LocalDate.parse(sb.toString()));
        } else if (qName.equalsIgnoreCase("Genero")) {
            billboardAuxiliar.setGenero(Gender.valueOf(sb.toString()));
        } else if (qName.equalsIgnoreCase("CategoriaEdad")) {
            billboardAuxiliar.setPegi(AgeCategory.valueOf(sb.toString()));
        } else if (qName.equalsIgnoreCase("Billboard")) {
            // Agregar el objeto Billboard completo a la lista
            lista.add(billboardAuxiliar);
        }
    }
}
