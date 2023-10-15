package CineApp;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author Alex Pineño Sanchez
 */
public class DOM {

    private static final Logger logger = LogManager.getRootLogger();
    private static final String ruta = "DOM\\Billboard.xml"; // Ruta relativa al directorio
    private static final DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    /**
     *
     * Funcion que borra y escribe de cero una lista de Billboard
     * 
     * @param lista
     * @author Alex Pineño Sanchez
     */
    public static void escribirBillboard(LinkedList<Billboard> lista) {
        try {
            File archivo = new File(ruta);

            // Crear un nuevo documento XML
            DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();
            Document archivoXML = documentBuilder.newDocument();

            Element root = archivoXML.createElement("Billboards");
            archivoXML.appendChild(root);

            for (Billboard pelicula : lista) {
                Element billboard1 = archivoXML.createElement("Billboard");
                Element nombre = archivoXML.createElement("Nombre");
                Element inicio = archivoXML.createElement("Inicio");
                Element fin = archivoXML.createElement("Final");
                Element genero = archivoXML.createElement("Genero");
                Element categoriaEdad = archivoXML.createElement("CategoriaEdad");

                nombre.appendChild(archivoXML.createTextNode(pelicula.getPelicula()));
                inicio.appendChild(archivoXML.createTextNode(pelicula.getInicio().format(formato)));
                fin.appendChild(archivoXML.createTextNode(pelicula.getFinalizacion().format(formato)));
                genero.appendChild(archivoXML.createTextNode(pelicula.getGenero().toString()));
                categoriaEdad.appendChild(archivoXML.createTextNode(pelicula.getPegi().toString()));

                billboard1.appendChild(nombre);
                billboard1.appendChild(inicio);
                billboard1.appendChild(fin);
                billboard1.appendChild(genero);
                billboard1.appendChild(categoriaEdad);

                root.appendChild(billboard1);
            }

            // Crear un objeto Transformer para escribir el documento a un archivo
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource domSource = new DOMSource(archivoXML);
            StreamResult streamResult = new StreamResult(archivo);

            // Escribir el contenido del documento a un archivo XML
            transformer.transform(domSource, streamResult);
        } catch (ParserConfigurationException | TransformerException | DOMException e) {
            logger.error("hubo un errro ren la escritura del DOM");
        }
    }

    /**
     *
     * Funcion que agrea un Billboard conservando los anteriores
     * 
     * @param b
     * @author Alex Pineño Sanchez
     */
    public static void agregar(Billboard b) {
        try {
            File archivo = new File(ruta);

            // Crear un nuevo documento XML
            DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();
            Document archivoXML = documentBuilder.parse(archivo);

            Element root = archivoXML.getDocumentElement();

            Element billboard1 = archivoXML.createElement("Billboard");
            Element nombre = archivoXML.createElement("Nombre");
            Element inicio = archivoXML.createElement("Inicio");
            Element fin = archivoXML.createElement("Final");
            Element genero = archivoXML.createElement("Genero");
            Element categoriaEdad = archivoXML.createElement("CategoriaEdad");

            nombre.appendChild(archivoXML.createTextNode(b.getPelicula()));
            inicio.appendChild(archivoXML.createTextNode(b.getInicio().format(formato)));
            fin.appendChild(archivoXML.createTextNode(b.getFinalizacion().format(formato)));
            genero.appendChild(archivoXML.createTextNode(b.getGenero().toString()));
            categoriaEdad.appendChild(archivoXML.createTextNode(b.getPegi().toString()));

            billboard1.appendChild(nombre);
            billboard1.appendChild(inicio);
            billboard1.appendChild(fin);
            billboard1.appendChild(genero);
            billboard1.appendChild(categoriaEdad);

            root.appendChild(billboard1);

            // Crear un objeto Transformer para escribir el documento a un archivo
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource domSource = new DOMSource(archivoXML);
            StreamResult streamResult = new StreamResult(archivo);

            // Escribir el contenido del documento a un archivo XML
            transformer.transform(domSource, streamResult);

            logger.info("Nuevo Billboard agregado al archivo XML.");

        } catch (IOException | ParserConfigurationException | TransformerException | DOMException | SAXException e) {
            logger.error("Hubo un error en la escritura del DOM");
        }
    }

    /**
     *
     * Funcion que devuelve un LinkedList de peliculas que contiene el xml
     * 
     * @return
     * @author Alex Pineño Sanchez
     */
    public static LinkedList<Billboard> leerBillboard() {
        LinkedList<Billboard> billboards = new LinkedList<>();
        try {
            File archivoXML = new File(ruta);

            // Crear un objeto DocumentBuilderFactory
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Parsear el archivo XML
            Document doc = builder.parse(archivoXML);

            // Obtener la lista de nodos "Billboard"
            NodeList billboardNodes = doc.getElementsByTagName("Billboard");

            for (int i = 0; i < billboardNodes.getLength(); i++) {
                Element billboardElement = (Element) billboardNodes.item(i);
                String nombre = billboardElement.getElementsByTagName("Nombre").item(0).getTextContent();
                LocalDate inicio = LocalDate.parse(billboardElement.getElementsByTagName("Inicio").item(0).getTextContent());
                LocalDate finalizacion = LocalDate.parse(billboardElement.getElementsByTagName("Final").item(0).getTextContent());
                String genero = billboardElement.getElementsByTagName("Genero").item(0).getTextContent();
                String categoriaEdad = billboardElement.getElementsByTagName("CategoriaEdad").item(0).getTextContent();

                Billboard billboard = new Billboard(nombre, inicio, finalizacion, Gender.valueOf(genero), AgeCategory.valueOf(categoriaEdad));
                billboards.add(billboard);
            }
        } catch (ParserConfigurationException | SAXException | IOException e) {
            logger.error("hubo un error en la rectura del DOM");
        }
        return billboards;
    }
}
