/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Presentacion;

import Negocio.CiudadesNegocio;
import Negocio.NegocioException;
import Persistencia.CiudadesDAO;
import Persistencia.ConexionBD;
import dtoCinepolis.CuidadFiltroTablaDTO;
import dtoCinepolis.CuidadTablaDTO;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import enumerador.CiudadCRUDEnumerador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.TableColumnModel;
import utilirias.JButtonCellEditor;
import utilirias.JButtonRenderer;
/**
 *
 * @author Oley
 */
public class CatalogoCiudades extends javax.swing.JFrame {

    private CiudadesNegocio ciudadesNegocio;
    private ConexionBD conexionBD;

    /**
     * Creates new form CatalogoCiudades
     */
    public CatalogoCiudades() {
        conexionBD = new ConexionBD();

        this.ciudadesNegocio = new CiudadesNegocio(new CiudadesDAO(conexionBD));
        initComponents();
                cargarTablaCiudades();


    }

    private void AgregarRegistrosTablaCiudad(List<CuidadTablaDTO> cuidadLista) {
        if (cuidadLista == null) {
            return;
        }
        DefaultTableModel modeloTabla = (DefaultTableModel) this.jTable1.getModel();
        cuidadLista.forEach(row -> {
            Object[] fila = new Object[2];
            fila[0] = row.getId();
            fila[1] = row.getNombre();
            modeloTabla.addRow(fila);
                    });

        }
 private void BorrarRegistrosTablaCuidades() {
        DefaultTableModel modeloTabla = (DefaultTableModel) this.jTable1.getModel();
        modeloTabla.setRowCount(0);
            
        
    }
   private int getIdSeleccionadoTablaClientes() {
        int indiceFilaSeleccionada = this.jTable1.getSelectedRow();
        if (indiceFilaSeleccionada != -1) {
            DefaultTableModel modelo = (DefaultTableModel) this.jTable1.getModel();
            int indiceColumnaId = 0;
            int idSocioSeleccionado = (int) modelo.getValueAt(indiceFilaSeleccionada,
                    indiceColumnaId);
            return idSocioSeleccionado;
        } else {
            return 0;
        }
    }
 private void eliminar() throws NegocioException{
       int id=getIdSeleccionadoTablaCiudades();
       ciudadesNegocio.eliminar(id);
       cargarTablaCiudades();
    
 }
  
   
    private void cargarTablaCiudades() {
        try {
            CuidadFiltroTablaDTO filtro = obtenerFiltrosTabla();
            List<CuidadTablaDTO> cuidadLista = ciudadesNegocio.buscarCuidadTabla(filtro);
            BorrarRegistrosTablaCuidades();
            AgregarRegistrosTablaCiudad(cuidadLista);
        } catch (NegocioException e) {
            this.BorrarRegistrosTablaCuidades();
//            this.HEIGHT--;
//            this.establecerTituloPaginacion();
            JOptionPane.showMessageDialog(this, e.getMessage(), "Información", JOptionPane.ERROR_MESSAGE);

        }
    }
//    private void editar(){
//int id=getIdSeleccionadoTablaCiudades();
//if(id!=0){
//    try{
//        CiudadesDTO ciudadesDTO= ciudadesNegocio.
//    }
//}
//    }
    private void cargarConfiguracionInicialTablaCiudades(){
//        ActionListener onEditarClickListener = new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                editar();
//            }
//        };
        int indiceColumnaEditar = 4;
        TableColumnModel modeloColumnas = this.jTable1.getColumnModel();
//        modeloColumnas.getColumn(indiceColumnaEditar)
//                .setCellRenderer(new JButtonRenderer("Editar"));
//        modeloColumnas.getColumn(indiceColumnaEditar)
//                .setCellEditor(new JButtonCellEditor("Editar", onEditarClickListener));

        ActionListener onEliminarClickListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    eliminar();
                } catch (NegocioException ex) {
                    Logger.getLogger(CatalogoCiudades.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        };
        int indiceColumnaEliminar = 6;
        modeloColumnas = this.jTable1.getColumnModel();
        modeloColumnas.getColumn(indiceColumnaEliminar)
                .setCellRenderer(new JButtonRenderer("Eliminar"));
        modeloColumnas.getColumn(indiceColumnaEliminar)
                .setCellEditor(new JButtonCellEditor("Eliminar", onEliminarClickListener));
    }
    private int getIdSeleccionadoTablaCiudades() {
    int indiceFilaSeleccionada = this.jTable1.getSelectedRow();
    if (indiceFilaSeleccionada != -1) {
        DefaultTableModel modelo = (DefaultTableModel) this.jTable1.getModel();
        int indiceColumnaId = 0;
        return (int) modelo.getValueAt(indiceFilaSeleccionada, indiceColumnaId);
    } else {
        return 0;
    }
}
    private CuidadFiltroTablaDTO obtenerFiltrosTabla() {
 return new CuidadFiltroTablaDTO(10, 0, jTextField1.getText());    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setText("Nuevo");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, -1, -1));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Nombre", "Editar", "Eliminar"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 520, 240));

        jLabel1.setText("Catalogo de Ciudades");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, -1));
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, 400, -1));

        jButton2.setText("Buscar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 40, -1, -1));

        jButton3.setText("Regresar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 440, -1, -1));

        jButton4.setText("<--");
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 380, -1, -1));

        jButton5.setText("-->");
        getContentPane().add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 380, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.setVisible(false);
        AñadirCiudades añadirCiudades = new AñadirCiudades(ciudadesNegocio);
        añadirCiudades.setVisible(true);

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.cargarTablaCiudades();

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
