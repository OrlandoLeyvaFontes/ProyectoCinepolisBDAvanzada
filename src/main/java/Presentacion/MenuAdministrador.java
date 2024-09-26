/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Presentacion;

import Negocio.PeliculasNegocio;
import Negocio.SucursalesNegocio;
import Persistencia.ClientesDAO;
import Persistencia.ConexionBD;
import Persistencia.IPeliculasDAO;
import Persistencia.PeliculasDAO;
import Persistencia.SucursalDAO;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Oley
 */
public class MenuAdministrador extends javax.swing.JFrame {

    private PeliculasNegocio peliculasNegocio;
    private ConexionBD conexionBD;
    private SucursalesNegocio sucursalesNegocios;

    /**
     * Creates new form MenuAdministrador
     */
    public MenuAdministrador() {
        try {
            conexionBD = new ConexionBD();
            IPeliculasDAO peliculasDAO = new PeliculasDAO(conexionBD);
            this.peliculasNegocio = new PeliculasNegocio(conexionBD, peliculasDAO);
            initComponents();
        } catch (SQLException ex) {
            ex.printStackTrace(); // Imprime el error en la consola
            JOptionPane.showMessageDialog(this, "Error al conectar con la base de datos: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
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

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setText("Añadir peliculas");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, -1, -1));

        jButton2.setText("Catalogo Sucursales");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 130, -1, -1));

        jButton3.setText("Catalogo Ciudades");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 130, -1, -1));

        jButton4.setText("Catalogo Clientes");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 180, -1, -1));

        jButton5.setText("Catalogo Salas");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 180, -1, -1));

        jButton6.setText("Editar Peliculas");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, -1, -1));

        jButton7.setText("Eliminar Pelicula");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.setVisible(false);
        AgregarPeliculas añadir = new AgregarPeliculas(peliculasNegocio);
        añadir.setVisible(true);

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.setVisible(false);
        CatalogoSucursales catalogoSucursales = new CatalogoSucursales();
        catalogoSucursales.setVisible(true);

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        this.setVisible(false);
        CatalogoCiudades catalogo = new CatalogoCiudades();
        catalogo.setVisible(true);

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        this.setVisible(false);
        CatalogoClientes catalogoClientes = new CatalogoClientes();
        catalogoClientes.setVisible(true);

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        this.setVisible(false);
        CatalogoSalas catalogoSalas = new CatalogoSalas();
        catalogoSalas.setVisible(true);

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        this.setVisible(false);
        modificarPelicula mp = new modificarPelicula(peliculasNegocio);
        mp.setVisible(true);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        this.setVisible(false);
        eliminarPelicula ep = new eliminarPelicula(peliculasNegocio);
        ep.setVisible(true);
    }//GEN-LAST:event_jButton7ActionPerformed

    public static void main(String[] args) {
        // Ejecutar el formulario del menú administrador en el hilo de la interfaz gráfica (Event Dispatch Thread)
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                // Crear y mostrar el formulario del menú administrador
                MenuAdministrador menu = new MenuAdministrador();
                menu.setVisible(true);  // Hacer visible el JFrame
                menu.setLocationRelativeTo(null);  // Centrar la ventana
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    // End of variables declaration//GEN-END:variables
}
