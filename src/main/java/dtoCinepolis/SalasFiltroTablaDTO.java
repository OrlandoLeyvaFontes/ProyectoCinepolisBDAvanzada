/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dtoCinepolis;

/**
 *
 * @author Oley
 */
public class SalasFiltroTablaDTO {
      private int limit;
    private int offset;
    private String filtro;

    public SalasFiltroTablaDTO() {
    }

    public SalasFiltroTablaDTO(int limit, int offset, String filtro) {
        this.limit = limit;
        this.offset = offset;
        this.filtro = filtro;
    }

    public SalasFiltroTablaDTO(int limit) {
        this.limit = limit;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public String getFiltro() {
        return filtro;
    }

    public void setFiltro(String filtro) {
        this.filtro = filtro;
    }
}
