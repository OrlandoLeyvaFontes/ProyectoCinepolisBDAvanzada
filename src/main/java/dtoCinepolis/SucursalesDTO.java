/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dtoCinepolis;

import Entidad.Ciudad;

/**
 *
 * @author Oley
 */
public class SucursalesDTO {

    int id;
    String nombreCiudad;

    public SucursalesDTO(int id, String nombreCiudad) {
        this.id = id;
        this.nombreCiudad = nombreCiudad;
    }

    public SucursalesDTO() {
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreCiudad() {
        return nombreCiudad;
    }

    public void setNombreCiudad(String nombreCiudad) {
        this.nombreCiudad = nombreCiudad;
    }
    
    

}
