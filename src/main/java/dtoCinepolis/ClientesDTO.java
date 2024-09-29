/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dtoCinepolis;

import java.time.LocalDate;

/**
 *
 * @author Oley
 */
public class ClientesDTO {

    int id;
    String nombre;
    String apellidoPaterno;
    String apellidoMaterno;
    LocalDate fechaNacimiento;
    String correo;
    String contraseña;
    String ciudad;
int estaEliminado;
    public ClientesDTO() {
    }

    public ClientesDTO(int id) {
        this.id = id;
    }

    public ClientesDTO(String correo, String contraseña) {
        this.correo = correo;
        this.contraseña = contraseña;
    }    

    public ClientesDTO(String nombre, String apellidoPaterno, String apellidoMaterno, LocalDate fechaNacimiento, String correo, String contraseña, String ciudad) {
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.fechaNacimiento = fechaNacimiento;
        this.correo = correo;
        this.contraseña = contraseña;
        this.ciudad = ciudad;
    }

    public ClientesDTO(int id, String nombre, String apellidoPaterno, String apellidoMaterno, LocalDate fechaNacimiento, String correo, String contraseña, String ciudad) {
        this.id = id;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.fechaNacimiento = fechaNacimiento;
        this.correo = correo;
        this.contraseña = contraseña;
        this.ciudad = ciudad;
    }

//    public CiudadesDTO getCiudad() {
//        return ciudad;
//    }
//
//    public void setCiudad(CiudadesDTO ciudad) {
//        this.ciudad = ciudad;
//    }

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

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getCiudad() {
        return ciudad;
    }

    
    public void setCiudad(String ciudad) {
         this.ciudad=ciudad;
    }

    public int getEstaEliminado() {
        return estaEliminado;
    }

    public void setEstaEliminado(int estaEliminado) {
        this.estaEliminado = estaEliminado;
    }
    
}
