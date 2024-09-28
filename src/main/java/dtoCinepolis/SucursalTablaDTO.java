/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dtoCinepolis;

/**
 *
 * @author aleja
 */
public class SucursalTablaDTO {
    
    int id;
    String nombre;
    CiudadesDTO ciudad;
    private boolean estaEliminado;

    public SucursalTablaDTO(int id, String nombre, CiudadesDTO ciudad, boolean estaEliminado) {
        this.id = id;
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.estaEliminado = estaEliminado;
    }

    public SucursalTablaDTO() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public CiudadesDTO getCiudad() {
        return ciudad;
    }

    public void setCiudad(CiudadesDTO ciudad) {
        this.ciudad = ciudad;
    }

    public boolean isEstaEliminado() {
        return estaEliminado;
    }

    public void setEstaEliminado(boolean estaEliminado) {
        this.estaEliminado = estaEliminado;
    }
    
    
}
