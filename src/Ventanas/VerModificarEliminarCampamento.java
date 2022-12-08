package Ventanas;

import Clases.Campamento;
import Clases.Response;
import diputacionAlava.Main;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class VerModificarEliminarCampamento extends javax.swing.JFrame {
    private Campamento camp;
    private List<Campamento> listaCamp;
    private int opcion;
    public VerModificarEliminarCampamento() {
        initComponents();
        setLocationRelativeTo(null);
        tLugar.setEditable(false);
        tCapacidad.setEditable(false);
        tFechaI.setEditable(false);
        tFechaF.setEditable(false);
        this.listaCamp = new ArrayList<>();
        bEliminarModificar.setEnabled(false);
    }
    
    public VerModificarEliminarCampamento(int opcion, List<Campamento> listaCamp) {
        initComponents();
        setLocationRelativeTo(null);
        tLugar.setEditable(false);
        tCapacidad.setEditable(false);
        tFechaI.setEditable(false);
        tFechaF.setEditable(false);
        this.opcion = opcion;
        this.listaCamp = listaCamp;
        AjustarVentanaOpcion();
        rellenarComboCampamentos();
        bEliminarModificar.setEnabled(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cbNombre = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        tLugar = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        tCapacidad = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        tFechaI = new javax.swing.JTextField();
        tFechaF = new javax.swing.JTextField();
        bEliminarModificar = new javax.swing.JButton();
        bCancelarCerrar = new javax.swing.JButton();
        eTitulo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        cbNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbNombreActionPerformed(evt);
            }
        });

        jLabel2.setText("Nombre");

        jLabel3.setText("Lugar");

        jLabel4.setText("Capacidad");

        jLabel5.setText("Fecha Inicio");

        jLabel6.setText("Fecha fin");

        bEliminarModificar.setText("Eliminar");
        bEliminarModificar.setPreferredSize(new java.awt.Dimension(109, 23));
        bEliminarModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bEliminarModificarActionPerformed(evt);
            }
        });

        bCancelarCerrar.setText("Cancelar");
        bCancelarCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCancelarCerrarActionPerformed(evt);
            }
        });

        eTitulo.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        eTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        eTitulo.setText("Info. campamentos registrados");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(eTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, 397, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(bEliminarModificar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bCancelarCerrar)
                .addGap(55, 55, 55))
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tFechaF)
                    .addComponent(cbNombre, 0, 242, Short.MAX_VALUE)
                    .addComponent(tLugar)
                    .addComponent(tFechaI)
                    .addComponent(tCapacidad))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(eTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cbNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tLugar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(tFechaI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tFechaF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tCapacidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bCancelarCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bEliminarModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bCancelarCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCancelarCerrarActionPerformed
        Main.cerrarVerModificarEliminarCamp();
    }//GEN-LAST:event_bCancelarCerrarActionPerformed

    private void bEliminarModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bEliminarModificarActionPerformed
        if(this.opcion==0){
            if(JOptionPane.showConfirmDialog(null, "¿Estás seguro de que deseas eliminar el campamento?", "", JOptionPane.WARNING_MESSAGE) == 0){
                Response respuesta = Main.EliminarCampamento(camp); 
                if(!respuesta.isCorrecto()){
                    JOptionPane.showMessageDialog(null, respuesta.getMensajeError(),"", JOptionPane.ERROR_MESSAGE);
                }else{
                    JOptionPane.showMessageDialog(null, "Se ha eliminado el campamento correctamente.");
                    Main.cerrarVerModificarEliminarCamp();
                }
            }
        }else if(opcion==1){
            Main.entrarAModificacionDeCampamento(camp);
        }
    }//GEN-LAST:event_bEliminarModificarActionPerformed

    private void cbNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbNombreActionPerformed
        int index = cbNombre.getSelectedIndex()-1;
        Campamento camp = null;
        if(index > -1){
            camp = this.listaCamp.get(index);
        }
        if(camp == null){
            LimpiarCampos();
            bEliminarModificar.setEnabled(false);
        }else{
            this.camp = camp;
            AutocompletarDatos();
            bEliminarModificar.setEnabled(true);
        }
    }//GEN-LAST:event_cbNombreActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VerModificarEliminarCampamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VerModificarEliminarCampamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VerModificarEliminarCampamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VerModificarEliminarCampamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VerModificarEliminarCampamento().setVisible(true);
            }
        });
    }
    
    public void AjustarVentanaOpcion(){
        if(this.opcion == 0){
            eTitulo.setText("Eliminar campamento");
        }else if(this.opcion == 1){
            eTitulo.setText("Modificar campamento");
            bEliminarModificar.setText("Modificar");
        }else{
            bEliminarModificar.setVisible(false);
            bCancelarCerrar.setText("Cerrar");
            eTitulo.setText("Info. campamentos registrados");
        }
    }
    
    public void rellenarComboCampamentos(){
        if(this.listaCamp != null && !this.listaCamp.isEmpty()){
             cbNombre.addItem("-----Elegir campamento-----");
            try{
                for(Campamento camp : this.listaCamp){
                    String nombre = camp.getNombre();
                    String nombreOriginal = nombre;
                    int countRepetido = 0;
                    for(int x = 0;x<cbNombre.getItemCount();x++){
                        String item = cbNombre.getItemAt(x);
                        if(item.equalsIgnoreCase(nombre)){
                            nombre = nombreOriginal+" ("+countRepetido+")";
                            countRepetido++;
                        }
                    }
                    cbNombre.addItem(nombre);
                }
            }catch(Exception e){
                System.out.println("ha ocurrido un error "+ e.getMessage());
            } 
        }
    }
    
    public void LimpiarCampos(){
        tLugar.setText("");
        tCapacidad.setText("");
        tFechaI.setText("");
        tFechaF.setText("");
    }
    
    public void AutocompletarDatos(){
        DateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        tLugar.setText(camp.getLugar());
        tCapacidad.setText(String.valueOf(camp.getCapacidad()));
        tFechaI.setText(formato.format(camp.getFechaI()));
        tFechaF.setText(formato.format(camp.getFechaF()));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bCancelarCerrar;
    private javax.swing.JButton bEliminarModificar;
    private javax.swing.JComboBox<String> cbNombre;
    private javax.swing.JLabel eTitulo;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField tCapacidad;
    private javax.swing.JTextField tFechaF;
    private javax.swing.JTextField tFechaI;
    private javax.swing.JTextField tLugar;
    // End of variables declaration//GEN-END:variables

}
