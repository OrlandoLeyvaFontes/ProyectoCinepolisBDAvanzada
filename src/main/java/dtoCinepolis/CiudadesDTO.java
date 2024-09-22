/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dtoCinepolis;

/**
 *
 * @author Oley
 */
public class CiudadesDTO {

    int id;
    String nombre;
    private boolean estaEliminado;

    public CiudadesDTO() {
    }

    public CiudadesDTO(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public CiudadesDTO(int id, String nombre, boolean estaEliminado) {
        this.id = id;
        this.nombre = nombre;
        this.estaEliminado = estaEliminado;
    }

   

    public CiudadesDTO(String nombre) {
        this.nombre = nombre;
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

    public boolean isEstaEliminado() {
        return estaEliminado;
    }

    public void setEstaEliminado(boolean estaEliminado) {
        this.estaEliminado = estaEliminado;
    }
    
}
