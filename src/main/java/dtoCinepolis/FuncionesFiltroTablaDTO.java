/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dtoCinepolis;

/**
 *
 * @author aleja
 */
public class FuncionesFiltroTablaDTO {
    
     private int limit; // Máximo número de resultados a devolver
    private int offset; // Número de resultados a omitir
    private String filtro; // Filtro para la búsqueda

    public FuncionesFiltroTablaDTO(int limit, int offset, String filtro) {
        setLimit(limit); // Usar el setter para validación
        setOffset(offset); // Usar el setter para validación
        this.filtro = filtro;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        if (limit < 0) {
            throw new IllegalArgumentException("Limit cannot be negative");
        }
        this.limit = limit;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        if (offset < 0) {
            throw new IllegalArgumentException("Offset cannot be negative");
        }
        this.offset = offset;
    }

    public String getFiltro() {
        return filtro;
    }

    public void setFiltro(String filtro) {
        this.filtro = filtro;
    }
    
    
}
