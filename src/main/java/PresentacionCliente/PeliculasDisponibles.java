package PresentacionCliente;

import Negocio.IPeliculasNegocio;
import Negocio.NegocioException;
import dtoCinepolis.PeliculasFiltroTablaDTO;
import dtoCinepolis.PeliculasTablaDTO;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
/**
 *
 * @author aleja
 */
public class PeliculasDisponibles extends javax.swing.JFrame {

    private IPeliculasNegocio peliculasNegocio;
    private int idPeliculasSeleccionada = -1;
    private int pagina = 0;

    /**
     * Creates new form PeliculasDisponibles
     */
    public PeliculasDisponibles(){
        initComponents();
    }
     public PeliculasDisponibles(IPeliculasNegocio peliculasNegocio) {
        this.peliculasNegocio = peliculasNegocio;
        initComponents();
        cargarTablaPeliculasDisponibles();

        // Agregar listener para la selección de la tabla
        jTable1.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 1) {
                    int row = jTable1.getSelectedRow();
                    if (row != -1) {
                        idPeliculasSeleccionada = (int) jTable1.getValueAt(row, 0);
                        System.out.println("ID Película seleccionada: " + idPeliculasSeleccionada);
                    }
                }
            }
        });
    }

     private void agregarRegistroTablaPeliculas(List<PeliculasTablaDTO> peliculasTablaDTOs) {
        if (peliculasTablaDTOs == null) {
            return;
        }
        DefaultTableModel modeloTabla = (DefaultTableModel) this.jTable1.getModel();
       peliculasTablaDTOs.forEach(row -> {
            Object[] fila = new Object[2]; 
            fila[0] = row.getTitulo(); 
            fila[1] = row.getGenero(); 
            modeloTabla.addRow(fila);
        });
    }

    private void cargarTablaPeliculasDisponibles() {
        try {
            PeliculasFiltroTablaDTO peliculasFiltroTablaDTO = obtenerFiltrosTablas();
            List<PeliculasTablaDTO> peliculaLista = peliculasNegocio.buscarPeliculasTabla(peliculasFiltroTablaDTO);
            agregarRegistroTablaPeliculas(peliculaLista);
        } catch (NegocioException e) {
            BorrarRegistroTablaSalas();
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

     private void BorrarRegistroTablaSalas() {
        DefaultTableModel modeloTabla = (DefaultTableModel) this.jTable1.getModel();
        modeloTabla.setRowCount(0);
    }

    private PeliculasFiltroTablaDTO obtenerFiltrosTablas() {
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnAnterior = new javax.swing.JButton();
        Siguiente = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnRegresar = new javax.swing.JButton();
        jTextField1 = new javax.swing.JLabel();
        btnContinuar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Pelicula", "Genero"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        btnAnterior.setText("Anterior");
        btnAnterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnteriorActionPerformed(evt);
            }
        });

        Siguiente.setText("Siguiente");
        Siguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SiguienteActionPerformed(evt);
            }
        });

        jLabel1.setText("Peliculas Disponible en taquilla");

        jLabel2.setText("Cinepolis");

        btnRegresar.setText("Regresar");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        jTextField1.setText("        ");

        btnContinuar.setText("Continuar");
        btnContinuar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnContinuarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(btnAnterior)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jTextField1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(114, 114, 114)
                                        .addComponent(jLabel1))
                                    .addGroup(layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addComponent(btnRegresar)
                                        .addGap(93, 93, 93)
                                        .addComponent(jLabel2)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)))
                        .addComponent(Siguiente))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnContinuar, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(21, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(20, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(btnRegresar))
                .addGap(28, 28, 28)
                .addComponent(jLabel1)
                .addGap(17, 17, 17)
                .addComponent(btnContinuar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 158, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAnterior)
                    .addComponent(Siguiente)
                    .addComponent(jTextField1))
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(130, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(41, Short.MAX_VALUE)))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
       SucursalesDisponibles regresar = new SucursalesDisponibles();
       regresar.setVisible(true);
       this.dispose();
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void btnContinuarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnContinuarActionPerformed
         PeliculaDetalles continuar = new PeliculaDetalles();
        continuar.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnContinuarActionPerformed

    private void SiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SiguienteActionPerformed
        this.pagina++;
        int impresion = pagina + 1;
         jTextField1.setText("Página " + impresion);
        this.cargarTablaPeliculasDisponibles();
    }//GEN-LAST:event_SiguienteActionPerformed

    private void btnAnteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnteriorActionPerformed
        if (pagina == 0) {
            JOptionPane.showMessageDialog(null, "inicio de la lista");
        } else {
            this.pagina--;

            int impresion = pagina + 1;
            jTextField1.setText("Página " + impresion);
            this.cargarTablaPeliculasDisponibles();
        }
    }//GEN-LAST:event_btnAnteriorActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Siguiente;
    private javax.swing.JButton btnAnterior;
    private javax.swing.JButton btnContinuar;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel jTextField1;
    // End of variables declaration//GEN-END:variables
}
