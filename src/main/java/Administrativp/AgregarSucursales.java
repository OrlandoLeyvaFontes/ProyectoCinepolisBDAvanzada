/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Administrativp;

import Entidad.Ciudad;
import Entidad.Sucursales;
import Negocio.CiudadesNegocio;
import Negocio.ICiudadesNegocio;
import Negocio.ISucursalesNegocio;
import Negocio.NegocioException;
import Negocio.SucursalesNegocio;
import Persistencia.CiudadesDAO;
import Persistencia.ConexionBD;
import Persistencia.IConexionBD;
import Persistencia.ISucursalDAO;
import Persistencia.PersistenciaException;
import Persistencia.SucursalDAO;
import dtoCinepolis.CiudadesDTO;
import dtoCinepolis.SucursalesDTO;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Oley
 */
public class AgregarSucursales extends javax.swing.JFrame {

    private ICiudadesNegocio ciudadesNegocio;
    private ISucursalesNegocio sucursalesNegocio;

    /**
     * Creates new form AñadirSucursales
     */
    public AgregarSucursales(ICiudadesNegocio ciudadesNegocio, ISucursalesNegocio sucursalesNegocio) {
        this.sucursalesNegocio = sucursalesNegocio;
        this.ciudadesNegocio = ciudadesNegocio;
        initComponents();

    }

    private void agregarSucursal() throws PersistenciaException {
        String nombreSucursal = jTextField1.getText();
    String nombreCiudad = jTextField2.getText();

    try {
        CiudadesDTO ciudad = ciudadesNegocio.buscarCiudadPorNombre(nombreCiudad);

        if (ciudad != null) {
            SucursalesDTO sucursalesDTO = new SucursalesDTO(nombreSucursal, ciudad);
            sucursalesNegocio.guardarSucursalConCiudadPorNombre(sucursalesDTO, nombreCiudad);
        } else {
            JOptionPane.showMessageDialog(this, "La ciudad no existe.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    } catch (NegocioException e) {
        JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Añadir Sucursales");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 20, -1, -1));

        jLabel2.setText("Nombre de la sucursal:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, -1, -1));

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 52, 180, 30));

        jLabel3.setText("Cuidad:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 110, -1, -1));
        getContentPane().add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 102, 190, 30));

        jButton1.setText("Regresar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 200, -1, -1));

        jButton2.setText("Continuar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 200, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
  try {
        agregarSucursal();  
    } catch (PersistenciaException ex) {
        Logger.getLogger(AgregarSucursales.class.getName()).log(Level.SEVERE, null, ex);
    }


    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}
