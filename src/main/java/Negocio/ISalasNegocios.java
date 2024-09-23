/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

import dtoCinepolis.SalasDTO;
import dtoCinepolis.SucursalesDTO;

/**
 *
 * @author Oley
 */
public interface ISalasNegocios {
    void guardarSucursalesConSalas(SalasDTO salasDTO , String nombre ) throws NegocioException;
}
