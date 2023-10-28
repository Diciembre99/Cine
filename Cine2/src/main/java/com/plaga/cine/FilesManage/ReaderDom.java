package com.plaga.cine.FilesManage;

// Importaciones

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import com.plaga.cine.Modules.AgeCategory;
import com.plaga.cine.Modules.Billboard;
import com.plaga.cine.Modules.Gender;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * Clase DOM encargada de leer,escribir y modificar archivos XML
 * incluido el agregar nodo, eliminar nodo y tambien modificalo
 * mediante uso de DOM y en lectura tambien uso de la herramienta SAX
 * 
 * @author Alex Pineño Sanchez
 */
public class ReaderDom {

    private static final Logger logger = LogManager.getRootLogger(); // Objeto logger a utilizar
    private static final String ruta = "DOM\\Billboard.xml"; // Ruta relativa al directorio
    private static final DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd"); // Formato de las fechas

    /**
     *
     * Funcion que borra y escribe de cero una lista de Billboard
     *
     * @param lista Lista a de tipo billboard a escirbir en tipo xml
     * @author Alex Pineño Sanchez
     * @param ruta
     */
    public static void escribirBillboard(LinkedList<Billboard> lista, File ruta) {
        try {
            File archivo = new File(ruta+"\\ListadoPeliculas"+LocalDate.now().toString()+"_"+LocalTime.now().getHour()+"_"+LocalTime.now().getMinute()+"_"+LocalTime.now().getSecond()+".xml");

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

                nombre.appendChild(archivoXML.createTextNode(pelicula.getMovie()));
                inicio.appendChild(archivoXML.createTextNode(pelicula.getStart().format(formato)));
                fin.appendChild(archivoXML.createTextNode(pelicula.getEnd().format(formato)));
                genero.appendChild(archivoXML.createTextNode(pelicula.getGender().toString()));
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
     * @param b Billboard a agrregar
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

            nombre.appendChild(archivoXML.createTextNode(b.getMovie()));
            inicio.appendChild(archivoXML.createTextNode(b.getStart().format(formato)));
            fin.appendChild(archivoXML.createTextNode(b.getEnd().format(formato)));
            genero.appendChild(archivoXML.createTextNode(b.getGender().toString()));
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
     * @param ruta
     * @return LinkedList de peliculas
     * @author Alex Pineño Sanchez
     */
    public static LinkedList<Billboard> leerBillboard(File ruta) {
        LinkedList<Billboard> billboards = new LinkedList<>();
        try {

            // Crear un objeto DocumentBuilderFactory
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Parsear el archivo XML
            Document doc = builder.parse(ruta);

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

    /**
     *
     * Funcion que devuelve un LinkedList de peliculas que contiene el xml con
     * SAX
     *
     * @param ruta Ruta del archivo XML a leer
     * @return LinkedList de Billboard
     * @author Alex Pineño Sanchez
     */
    public static LinkedList<Billboard> leerBillboardSAX(File ruta) {
        LinkedList<Billboard> billboards = new LinkedList<>();
        
        try {
            SAXParserFactory spFactory = SAXParserFactory.newInstance();
            SAXParser saxParser = spFactory.newSAXParser(); // Se crea un objeto SAXParser para interpretar el documento XML.

            // Se crea un manejador, que recorre el archivo SAX secuencialmente
            HadlerSAX manejador = new HadlerSAX();
            saxParser.parse(ruta, manejador);

            billboards = manejador.getBillboards();

        } catch (SAXException | ParserConfigurationException | IOException e) {
            System.out.println(e.getMessage());
        }
        return billboards;
    }

    /**
     *
     * Funcion que modifica un nodo dado el nombre del billboard,nombre del nodo
     * y su nuevo valor
     *
     * @param valorNombreBillboard Nombre de la pelicula
     * @param nombreNodo Nodo a modificar
     * @param nuevoValor Nuevo valor del nodo
     * @author Alex Pineño Sanchez
     */
    public static void modificarNodoEnBillboard(String valorNombreBillboard, String nombreNodo, String nuevoValor) {
        try {
            // Carga el documento XML
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document doc = docBuilder.parse(ruta);

            // Buscar el nodo <Billboard> con el nombre especificado
            NodeList billboards = doc.getElementsByTagName("Billboard");
            for (int i = 0; i < billboards.getLength(); i++) {
                Element billboard = (Element) billboards.item(i);
                Element nombre = (Element) billboard.getElementsByTagName("Nombre").item(0);

                if (nombre.getTextContent().equals(valorNombreBillboard)) {
                    // Modificar el contenido del nodo especificado
                    Element nodoAModificar = (Element) billboard.getElementsByTagName(nombreNodo).item(0);
                    nodoAModificar.setTextContent(nuevoValor);
                    break; // Terminar el bucle después de encontrar el nodo deseado
                }
            }

            // Guardar los cambios en el archivo XML
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(ruta));
            transformer.transform(source, result);

            logger.info("Nodo '" + nombreNodo + "' modificado en el archivo XML para el billboard con Nombre: " + valorNombreBillboard);
        } catch (ParserConfigurationException | IOException | SAXException | TransformerException e) {
        }
    }

    /**
     *
     * Funcion que crea un nuevo nodo en XML
     *
     * @param nuevoValor Nodo a introducir
     * @author Alex Pineño Sanchez
     */
    public static void insertarNodo(String nuevoValor) {
        try {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document doc = docBuilder.parse(ruta);

            // Crea un nuevo nodo
            Element nuevoNodo = doc.createElement("dato");
            nuevoNodo.appendChild(doc.createTextNode(nuevoValor));

            // Encuentra el nodo donde deseas insertar el nuevo nodo
            Node elemento = doc.getElementsByTagName("elemento").item(0);
            elemento.appendChild(nuevoNodo);

            // Guarda los cambios en el archivo XML
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(ruta));
            transformer.transform(source, result);
        } catch (IOException | ParserConfigurationException | TransformerException | DOMException | SAXException e) {
        }
    }

    /**
     * 
     * Funcion que agrega un nodo dado el nombre del billboard
     * 
     * @param valorNombreBillboard Nombre del billboard
     * @param nombreNodo Nombre del nuevo nodo
     * @param nuevoValor Valor del nuevo nodo
     * @author Alex Pineño Sanchez
     */
    public static void agregarNodo(String valorNombreBillboard, String nombreNodo, String nuevoValor) {
        try {
            // Carga el documento XML
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document doc = docBuilder.parse(ruta);

            // Encuentra el nodo <Billboard> con el nombre especificado
            NodeList billboards = doc.getElementsByTagName("Billboard");
            for (int i = 0; i < billboards.getLength(); i++) {
                Element billboard = (Element) billboards.item(i);
                Element nombre = (Element) billboard.getElementsByTagName("Nombre").item(0);

                if (nombre.getTextContent().equals(valorNombreBillboard)) {
                    // Crea un nuevo nodo
                    Element nuevoNodo = doc.createElement(nombreNodo);
                    nuevoNodo.appendChild(doc.createTextNode(nuevoValor));

                    // Agrega el nuevo nodo al elemento <Billboard>
                    billboard.appendChild(nuevoNodo);
                    break; // Terminar el bucle después de encontrar el nodo deseado
                }
            }

            // Guarda los cambios en el archivo XML
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(ruta));
            transformer.transform(source, result);

            logger.info("Nodo '" + nombreNodo + "' agregado en el archivo XML para el billboard con Nombre: " + valorNombreBillboard);
        } catch (ParserConfigurationException | IOException | SAXException | TransformerException e) {
        }
    }

    /**
     *
     * Funcion que borra un billboard dado su nombre
     * 
     * @param valorNombreBillboard Nombre del billboard a borrar
     * @author Alex Pineño Sanchez
     */
    public static void borrarBillboard(String valorNombreBillboard) {
        try {
            // Carga el documento XML
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document doc = docBuilder.parse(ruta);

            // Encuentra el nodo <Billboard> con el nombre especificado
            NodeList billboards = doc.getElementsByTagName("Billboard");
            for (int i = 0; i < billboards.getLength(); i++) {
                Element billboard = (Element) billboards.item(i);
                Element nombre = (Element) billboard.getElementsByTagName("Nombre").item(0);

                if (nombre.getTextContent().equals(valorNombreBillboard)) {
                    // Elimina el nodo completo (el elemento <Billboard>)
                    billboard.getParentNode().removeChild(billboard);
                    break; // Terminar el bucle después de encontrar el nodo deseado
                }
            }

            // Guarda los cambios en el archivo XML
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(ruta));
            transformer.transform(source, result);

            logger.info("Billboard con Nombre: " + valorNombreBillboard + " eliminado del archivo XML.");
        } catch (ParserConfigurationException | IOException | SAXException | TransformerException e) {
        }
    }

    /**
     *
     * Funcion que borra un nodo dado el nombre de un billboard
     * 
     * @param valorNombreBillboard Nombre del billboard
     * @param nombreNodo Nombre del nodo a borrar
     * @author Alex Pineño Sanchez
     */
    public static void borrarNodoEnBillboard(String valorNombreBillboard, String nombreNodo) {
        try {
            // Carga el documento XML
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document doc = docBuilder.parse(ruta);

            // Encuentra el nodo <Billboard> con el nombre especificado
            NodeList billboards = doc.getElementsByTagName("Billboard");
            for (int i = 0; i < billboards.getLength(); i++) {
                Element billboard = (Element) billboards.item(i);
                Element nombre = (Element) billboard.getElementsByTagName("Nombre").item(0);

                if (nombre.getTextContent().equals(valorNombreBillboard)) {
                    // Busca y elimina el nodo especificado
                    Element nodoAEliminar = (Element) billboard.getElementsByTagName(nombreNodo).item(0);
                    billboard.removeChild(nodoAEliminar);
                    break; // Terminar el bucle después de encontrar el nodo deseado
                }
            }

            // Guarda los cambios en el archivo XML
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(ruta));
            transformer.transform(source, result);

            logger.info("Nodo '" + nombreNodo + "' eliminado del billboard con Nombre: " + valorNombreBillboard);
        } catch (ParserConfigurationException | IOException | SAXException | TransformerException e) {
        }
    }
}
