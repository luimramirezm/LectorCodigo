package LectorCodigo;
 
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AnalizadorLinea {
 
    /**
     * Este método lee los archivos de una carpeta
     * @param directorio
     * @return infoArchivoList
     */
    public List leerArchivo(File directorio) {
 
//List of all files and directories
        File filesList[] = directorio.listFiles();
        System.out.println("Lista de carpetas y directorios:");
        Scanner sc = null;
//Lista con info del archivo q vamso a llenar en el for    
        List<InformacionArchivo> infoArchivoList = new ArrayList<InformacionArchivo>();

        for (File file : filesList) {
            InformacionArchivo informacionArchivos = new InformacionArchivo();
            informacionArchivos.setNombreArchivo(file.getName());

            List<String> lineasArchivoList = new ArrayList<String>();

            try {
                //Instantiating the Scanner class
                sc = new Scanner(file);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(AnalizadorLinea.class.getName()).log(Level.SEVERE, null, ex);
            }
            String input;
            Integer contadorMetodos = 0;

            while (sc.hasNextLine()) {

                input = sc.nextLine();
                if (!analizarComentario(input) && !analizarLlave(input) && !analizarImportacion(input) && !analizarPaquete(input) && !analizarLineaVacía(input)) {
                    lineasArchivoList.add(input);

                    if (analizarMetodo(input)) {

                        contadorMetodos += 1;

                    }
                    if (analizarPalabraReservada(input)) {
                        contadorMetodos += 1;
                    }
                }
            }
            informacionArchivos.setListaCadenaList(lineasArchivoList);
            informacionArchivos.setNumeroMetodos(contadorMetodos);
            infoArchivoList.add(informacionArchivos);
        }
        return infoArchivoList;
    }

    /**
     * Este método analiza si una cadena es un comentario
     * @param input
     * @return Boolean
     */
    public static boolean analizarComentario(String input) {
        return (input.trim().startsWith("/*") || input.trim().endsWith("*/") || input.trim().startsWith("//") || input.trim().startsWith("*")) ;
    }

    /**
     * Este método analiza si una cadena es una llave
     * @param input
     * @return Boolean
     */
    public static boolean analizarLlave(String input) {
        return (input.trim().equals("}") || input.trim().equals("{"));
    }

    /**
     * Este método analiza si la cadena hace referencia a una importación
     * @param input
     * @return Boolean
     */
    public static boolean analizarImportacion(String input) {
        String PALABRA_IMPORT = "import";
        return (input.trim().startsWith(PALABRA_IMPORT));
    }

    /**
     * Este método analiza si la cadena hace referencia a un paquete
     * @param input
     * @return Boolean
     */
    public static boolean analizarPaquete(String input) {
        String PALABRA_PACKAGE = "package";
        return (input.trim().startsWith(PALABRA_PACKAGE));
    }

    /**
     * Este método analiza si la cadena esta vacía
     * @param input
     * @return Boolean
     */
    public static boolean analizarLineaVacía(String input) {
        return (input.trim().isEmpty() || input.startsWith("\n"));
    }
    /**
     * Este método analiza si la cadena contiene alguna de las palabras reservadas 
     * @param input
     * @return Boolean
     */
    public static boolean analizarPalabraReservada(String input) {
        String[] tokens = input.trim().split("\\s{1,}");
        String PALABRA_IF = "if";
        String PALABRA_WHILE = "while";
        String PALABRA_FOR = "for";
        String PALABRA_TRY = "try";
        for (String token : tokens) {
            if ((token.equals(PALABRA_IF)) || (token.equals(PALABRA_WHILE)) || (token.equals(PALABRA_FOR)) || (token.equals(PALABRA_TRY))) {
                return true;
            }
        }
        return false;
    }

    /**
     * Este método analiza si la cadena hace referencia a un método
     * @param input
     * @return Boolean
     */
    public static boolean analizarMetodo(String input) {
        String PALABRA_PUBLIC = "public";
        return (input.contains("(") && input.contains(")") && input.contains(PALABRA_PUBLIC));
    }
}
