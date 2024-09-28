/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Administrativp;

import Negocio.IPeliculasNegocio;
import Negocio.NegocioException;
import dtoCinepolis.PeliculasFiltroTablaDTO;
import dtoCinepolis.PeliculasTablaDTO;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Oley
 */
public class CatalogoPeliculas extends javax.swing.JFrame {
    private IPeliculasNegocio peliculasNegocio;
    private int idPeliculasSeleccionada = -1;

    /**
     * Creates new form CatalogoPeliculas
     */
    public CatalogoPeliculas(IPeliculasNegocio peliculasNegocio) {
        this.peliculasNegocio=peliculasNegocio;
        initComponents();
         cargarTablaPeliculas();
  jTable1.addMouseListener(new MouseAdapter() {
    public void mouseClicked(MouseEvent e) {
        if (e.getClickCount() == 1) { 
            int row = jTable1.getSelectedRow();
            if (row != -1) {
                idPeliculasSeleccionada = (int) jTable1.getValueAt(row, 0); 
                System.out.println("ID Ciudad seleccionada: " + idPeliculasSeleccionada);
          
    }
        }
    }
   });
          }
    private void AgregarRegistroTablaPeliculas(List<PeliculasTablaDTO> peliculasTablaDTOs){
        if(peliculasTablaDTOs==null){
            return;
        }
          DefaultTableModel modeloTabla = (DefaultTableModel) this.jTable1.getModel();
          peliculasTablaDTOs.forEach(row ->{
              Object[] fila=new Object[3];
              fila[0]=row.getId();
              fila[1]=row.getTitulo();
              fila[2]=row.getSinopsis();
                 modeloTabla.addRow(fila);
          });
    }
    
    
    
    
     private void cargarTablaPeliculas(){
       try {
        PeliculasFiltroTablaDTO peliculasFiltroTablaDTO = ObtenerFiltrosTablas();
        List<PeliculasTablaDTO> peliculaLista = peliculasNegocio.buscarPeliculasTabla(peliculasFiltroTablaDTO);
        System.out.println("Cantidad de películas encontradas: " + peliculaLista.size()); // Debug

        if (!peliculaLista.isEmpty()) {
            AgregarRegistroTablaPeliculas(peliculaLista); // Llamada para agregar registros a la tabla
        } else {
            BorrarRegistroTablaSalas();
            JOptionPane.showMessageDialog(this, "No se encontraron películas.", "Información", JOptionPane.INFORMATION_MESSAGE);
        }
    } catch (NegocioException e) {
        BorrarRegistroTablaSalas();
        JOptionPane.showMessageDialog(this, e.getMessage(), "Información", JOptionPane.ERROR_MESSAGE);
    }
     }
     private void BorrarRegistroTablaSalas() {
        DefaultTableModel modeloTabla = (DefaultTableModel) this.jTable1.getModel();
        modeloTabla.setRowCount(0);
    }
     private PeliculasFiltroTablaDTO ObtenerFiltrosTablas(){
          return new PeliculasFiltroTablaDTO(10, 0, jTextField1.getText());
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
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Catalgo de Peliculas");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 260, -1));

        jButton1.setText("Buscar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 30, -1, -1));

        jButton2.setText("Nuevo");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, -1));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "id", "titulo", "sinopsis"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 360, 160));

        jButton3.setText("Regresar");
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 300, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.setVisible(false);
        AgregarPeliculas agregarPeliculas = new AgregarPeliculas(peliculasNegocio);
        agregarPeliculas.setVisible(true);
        
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    
        cargarTablaPeliculas();


// TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
