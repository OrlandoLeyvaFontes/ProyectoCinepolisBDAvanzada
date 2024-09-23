/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dtoCinepolis;

/**
 *
 * @author Oley
 */
public class SucursalesDTO {
    int id;
    String nombre;
     CiudadesDTO ciudad;
         private boolean estaEliminado;

    public SucursalesDTO() {
    }

    public SucursalesDTO(String nombre, CiudadesDTO ciudad) {
        this.nombre = nombre;
        this.ciudad = ciudad;
    }

    public SucursalesDTO(int id, String nombre, CiudadesDTO ciudad, boolean estaEliminado) {
        this.id = id;
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.estaEliminado = estaEliminado;
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
