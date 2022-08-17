
package LectorCodigo;
import java.util.ArrayList;
import java.util.List;

public class InformacionArchivo {
    private String nombreArchivo; 
    private Integer numeroMetodos;
    private List<String> listaCadenaList = new ArrayList<String>();

     /**
     * Devuelve el nombre del archivo
     * @return nombreArchivo
     */
    public String getNombreArchivo() {
        return nombreArchivo;
    }

    /**
     * Modifica el nombre del archivo
     * @return void
     */
    public void setNombreArchivo(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }

      /**
     * Devuelve la cantidad de métodos
     * @return numeroMetodos
     */
    public Integer getNumeroMetodos() {
        return numeroMetodos;
    }

    /**
     * Modifica la cantidad de métodos
     * @return void
     */
    public void setNumeroMetodos(Integer numeroMetodos) {
        this.numeroMetodos = numeroMetodos;
    }
    
     /**
     * Devuelve las lineas totales del programa en una lista
     * @return listaCadenaList
     */
    public List<String> getListaCadenaList() {
        return listaCadenaList;
    }

    /**
     * Modifica la cantidad de las lineas totales del programa en una lista
     * @return void
     */
    public void setListaCadenaList(List<String> listaCadenaList) {
        this.listaCadenaList = listaCadenaList;
    }

}