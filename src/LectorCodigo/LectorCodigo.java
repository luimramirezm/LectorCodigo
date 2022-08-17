
/***********************************************************************
************************************************************************
************************************************************************
*****                                                              *****
*****  Name: LectorCodigo                                          *****
*****  Description: Aplicación para contar la cantidad de lineas   *****
*****  y métodos por clase de una aplicacion.                      *****
*****  Date: 27/06/2022                                            *****
*****  @author Luisa María Ramírez Medina                          *****   
*****  @version 02                                                 *****
*****                                                              *****
************************************************************************
************************************************************************
***********************************************************************/

package LectorCodigo;

import java.io.File;
import java.io.IOException;
import java.util.List;


public class LectorCodigo {
 
   public static void main(String args[]) throws IOException {

      AnalizadorLinea ContadorLinea = new AnalizadorLinea();

      File directorio = new File("D:\\DOCUMENTOS USUARIO\\Desktop\\stadistic\\src");

      List<InformacionArchivo> infoArchivoList = ContadorLinea.leerArchivo(directorio);
      imprimirInformacionLista(infoArchivoList);

   }
    /**
     * Este método imprime el resultado dentro de un item la cantidad de metodos y palabras reservadas por clase, la cantidad de lineas por clase y el total de lineas totales por aplicación
     * @param infoArchivoList
     * @return void
     */
   public static void imprimirInformacionLista(List<InformacionArchivo> infoArchivoList){
        Integer sumaLinea= 0;
        System.out.println("---------------------------------------------------------------");
        System.out.println("| Part Name        | Number of Items | Part Size | Total Size | ");
        System.out.println(" ------------------------------------------------------------- ");
        for (InformacionArchivo impresionInfo: infoArchivoList ){
          String nombreArchivoFormateado = impresionInfo.getNombreArchivo().substring(0,impresionInfo.getNombreArchivo().lastIndexOf("."));
            System.out.println("   " + String.format("%-25s", nombreArchivoFormateado)  + String.format("%-16s", impresionInfo.getNumeroMetodos() ) + String.format("%-9s", impresionInfo.getListaCadenaList().size()));
            sumaLinea = impresionInfo.getListaCadenaList().size() + sumaLinea;
   
        }
        System.out.println("                                                      " +  sumaLinea);
        System.out.println(" ------------------------------------------------------------- ");
    }  
}