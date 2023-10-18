package CineApp;

import java.time.LocalDate;
import java.util.LinkedList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * El manejador recorre los objetos del xml, almacenandolos en un LinkedList tipo billboard
 *
 * @author Alex Pineño Sanchez
 */
public class ManejadorSAX extends DefaultHandler {

    private final LinkedList<Billboard> lista;
    private Billboard billboardAuxiliar;
    private StringBuilder sb;

    public ManejadorSAX() {
        lista = new LinkedList<>();
    }

    public LinkedList<Billboard> getBillboards() {
        return lista;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        sb = new StringBuilder();

        if (qName.equalsIgnoreCase("Billboard")) {
            billboardAuxiliar = new Billboard("", LocalDate.now(), LocalDate.now(), Gender.ACTION, AgeCategory.C_12);
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        sb.append(new String(ch, start, length));
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
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
            lista.add(billboardAuxiliar);
        }
    }
}
