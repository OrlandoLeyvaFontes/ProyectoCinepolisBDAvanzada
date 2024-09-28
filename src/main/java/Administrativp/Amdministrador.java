/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Administrativp;

import Negocio.ICiudadesNegocio;
import Negocio.IClientesNegocios;
import Negocio.IPeliculasNegocio;
import Negocio.ISalasNegocios;
import Negocio.ISucursalesNegocio;
import Negocio.IFuncionesNegocio;

/**
 *
 * @author Oley
 */
public class Amdministrador extends javax.swing.JFrame {

    private ICiudadesNegocio ciudadesNegocios;
    private ISucursalesNegocio sucursalesNegocio;
    private ISalasNegocios salasNegocios;
    private IPeliculasNegocio peliculasNegocio;
    private IFuncionesNegocio funcionesNegocio;
     private IClientesNegocios clientesNegocios;

    /**
     * Creates new form Amdministrador
     */
    public Amdministrador(ICiudadesNegocio ciudadesNegocio, ISucursalesNegocio sucursalesNegocio, ISalasNegocios salasNegocios, IPeliculasNegocio peliculasNegocio, IFuncionesNegocio funcionesNegocio,IClientesNegocios clientesNegocios) {
        this.ciudadesNegocios = ciudadesNegocio;
        this.sucursalesNegocio = sucursalesNegocio;
        this.salasNegocios = salasNegocios;
        this.peliculasNegocio = peliculasNegocio;
        this.funcionesNegocio = funcionesNegocio;
        this.clientesNegocios=clientesNegocios;
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        btnCatalogoFuncion = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setText("Agregar Ciudades");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, -1, -1));

        jButton2.setText("Agregar Sucursal");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 90, -1, -1));

        jButton3.setText("Catalogo Salas");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 90, -1, -1));

        jButton4.setText("Catalogo Peliculas");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, -1, -1));

        btnCatalogoFuncion.setText("Catalogo Funcion");
        btnCatalogoFuncion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCatalogoFuncionActionPerformed(evt);
            }
        });
        getContentPane().add(btnCatalogoFuncion, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 190, -1, 30));

        jButton5.setText("Administrar Clientes");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 190, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        this.setVisible(false);
        CatalogoPeliculas catalogoPeliculas = new CatalogoPeliculas(peliculasNegocio);
        catalogoPeliculas.setVisible(true);

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.setVisible(false);
        AgregarCiudades añadirCiudades = new AgregarCiudades(ciudadesNegocios);
        añadirCiudades.setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        this.setVisible(false);
        AgregarSucursales agregarSucursales = new AgregarSucursales(ciudadesNegocios, sucursalesNegocio);
        agregarSucursales.setVisible(true);

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        this.setVisible(false);
    CatalogoSalas catalogoSalas = new CatalogoSalas(salasNegocios, sucursalesNegocio);
    catalogoSalas.setVisible(true);

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void btnCatalogoFuncionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCatalogoFuncionActionPerformed
       this.setVisible(false);
        CatalogoFunciones continuar = new CatalogoFunciones(funcionesNegocio);
        continuar.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnCatalogoFuncionActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
this.setVisible(false);
CatalogoClientes catalogoClientes=new CatalogoClientes(clientesNegocios);
catalogoClientes.setVisible(true);


        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCatalogoFuncion;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    // End of variables declaration//GEN-END:variables
}
