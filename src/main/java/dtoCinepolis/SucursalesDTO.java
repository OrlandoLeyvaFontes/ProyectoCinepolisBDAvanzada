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
    String ciudad;

    public SucursalesDTO() {
    }

    public SucursalesDTO(String nombre, String ciudad) {
        this.nombre = nombre;
        this.ciudad = ciudad;
    }

   

public SucursalesDTO(int id, String nombre, String ciudad) {
    this.id = id;
    this.nombre = nombre; 
    this.ciudad = ciudad; 
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

  

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad; 
    }
   

    
}
