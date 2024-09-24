/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Presentacion;

import Negocio.CiudadesNegocio;
import Negocio.ClientesNegocio;
import Negocio.IClientesNegocios;
import Persistencia.IClientesDAO;
import Persistencia.PersistenciaException;
import dtoCinepolis.ClientesDTO;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import Negocio.NegocioException;
import Persistencia.CiudadesDAO;
import Persistencia.ClientesDAO;
import Persistencia.ConexionBD;
import java.time.LocalDate;

/**
 *
 * @author Oley
 */
public class AgregarClientes extends javax.swing.JFrame {

    private IClientesDAO clientesDAO;
    private ConexionBD conexionBD;
    private CiudadesNegocio ciudadesNegocio;
    private ClientesNegocio clientesNegocios;
    private CiudadesDAO ciudadesDAO;

    /**
     * Creates new form AñadirClientes
     */
    public AgregarClientes(IClientesDAO clientesDAO, CiudadesNegocio ciudadesNegocio) {
        conexionBD = new ConexionBD();

        this.clientesNegocios = new ClientesNegocio(clientesDAO, ciudadesNegocio);
      ciudadesNegocio=new CiudadesNegocio(ciudadesDAO);
      
        this.clientesDAO = new ClientesDAO(conexionBD);
        initComponents();
    }

    public AgregarClientes() {
    }

//    private ClientesDTO crearClientesDTO() throws DateTimeParseException {
//        String nombre = jTextField1.getText();
//        String apellidoPaterno = jTextField2.getText();
//        String apellidoMaterno = jTextField3.getText();
//        String fechaNacimientoTexto = jTextField4.getText();
//
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
//        LocalDateTime fechaNacimiento = LocalDateTime.parse(fechaNacimientoTexto, formatter);
//
//        String ciudad = jTextField5.getText();
//        String correo = jTextField6.getText();
//        String contraseña = jTextField7.getText();
//
//        ClientesDTO clientesDTO = new ClientesDTO();
//        clientesDTO.setNombre(nombre);
//        clientesDTO.setApellidoPaterno(apellidoPaterno);
//        clientesDTO.setApellidoMaterno(apellidoMaterno);
//        clientesDTO.setFechaNacimiento(fechaNacimiento);
////        clientesDTO.setCiudad(ciudad);
//        clientesDTO.setCorreo(correo);
//        clientesDTO.setContraseña(contraseña);
//
//        return clientesDTO;
//    }
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
        jLabel4 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Agregar Cliente");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 20, -1, -1));

        jLabel2.setText("Nombre:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, -1, -1));
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 52, 260, 30));

        jLabel3.setText("Apellido Paterno:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, -1));
        getContentPane().add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 102, 240, 30));

        jLabel4.setText("Apellido Materno:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, -1, -1));
        getContentPane().add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 150, 240, 30));

        jLabel5.setText("Fecha Nacimiento:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, -1, -1));
        getContentPane().add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 200, 230, 30));

        jLabel6.setText("Ciudad:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 250, -1, -1));
        getContentPane().add(jTextField5, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 240, 240, 30));

        jLabel7.setText("Correo:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 290, -1, -1));
        getContentPane().add(jTextField6, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 282, 240, 30));

        jLabel8.setText("Contraseña:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 330, -1, -1));
        getContentPane().add(jTextField7, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 322, 240, 30));

        jButton1.setText("Regresar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 360, -1, -1));

        jButton2.setText("Continuar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 360, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       try {
        String nombre = jTextField1.getText();
        String apellidoPaterno = jTextField2.getText();
        String apellidoMaterno = jTextField3.getText();
        String fechaNacimientoTexto = jTextField4.getText();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate fechaNacimiento = LocalDate.parse(fechaNacimientoTexto, formatter);

        LocalDateTime fechaNacimientoCompleta = fechaNacimiento.atStartOfDay();

        String ciudad = jTextField5.getText();
        String correo = jTextField6.getText();
        String contraseña = jTextField7.getText();

        ClientesDTO clientesDTO = new ClientesDTO();
        clientesDTO.setNombre(nombre);
        clientesDTO.setApellidoPaterno(apellidoPaterno);
        clientesDTO.setApellidoMaterno(apellidoMaterno);
        clientesDTO.setFechaNacimiento(fechaNacimientoCompleta); 
        clientesDTO.setCorreo(correo);
        clientesDTO.setContraseña(contraseña);

        clientesNegocios.guardarClientesConCiudad(clientesDTO, ciudad); 

        JOptionPane.showMessageDialog(this, "Cliente guardado exitosamente.");

    } catch (DateTimeParseException e) {
        JOptionPane.showMessageDialog(this, "Error en el formato de la fecha. Debe ser 'dd/MM/yyyy'.", "Error", JOptionPane.ERROR_MESSAGE);
    } catch (NegocioException e) {
        JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Ocurrió un error inesperado: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }

        // TODO add your handling code here:
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
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    // End of variables declaration//GEN-END:variables
}
