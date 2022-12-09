package Ventanas;

import Clases.Campamento;
import Clases.Persona;
import diputacionAlava.Main;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class RetirarPersona extends javax.swing.JFrame {
    Persona peSeleccionada = null;
    Campamento campSeleccionado = null;
    List<Campamento> campamentos = new ArrayList<>();
    List<Persona> personas;
    
    public RetirarPersona() {
        initComponents();
        setLocationRelativeTo(null);
        cbNombre.setEnabled(false);
        cbDni.setEnabled(false);
        Retirar.setVisible(false);
    }
    
    public RetirarPersona(List<Persona> personas, int opcion) {
        initComponents();
        setLocationRelativeTo(null);
        this.personas = personas;
        if(opcion == 0){
            Retirar.setVisible(false);
            Cancelar.setText("Volver");
            titulo.setText("Ver Inscripciones");
        }
        rellenarComboPersonas();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        titulo = new javax.swing.JLabel();
        Cancelar = new javax.swing.JButton();
        Retirar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        cbDni = new javax.swing.JComboBox<>();
        tNombre = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        tApellido1 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        eApellido2 = new javax.swing.JLabel();
        tApellido2 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        cbNombre = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        tFechaI = new javax.swing.JTextField();
        eLugar = new javax.swing.JLabel();
        tLugar = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        tFechaF = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        titulo.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titulo.setText("Retirar Persona");

        Cancelar.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        Cancelar.setText("Cancelar");
        Cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelarActionPerformed(evt);
            }
        });

        Retirar.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        Retirar.setText("Retirar");
        Retirar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RetirarActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Persona", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 18))); // NOI18N

        jLabel8.setText("DNI:");

        cbDni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbDniActionPerformed(evt);
            }
        });

        tNombre.setEditable(false);
        tNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tNombreActionPerformed(evt);
            }
        });

        jLabel6.setText("Nombre:");

        tApellido1.setEditable(false);

        jLabel7.setText("Primer apellido:");

        eApellido2.setText("Segundo apellido:");

        tApellido2.setEditable(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tNombre)
                            .addComponent(cbDni, 0, 326, Short.MAX_VALUE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(eApellido2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tApellido2, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tApellido1, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 36, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(cbDni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(tNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tApellido1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(eApellido2)
                    .addComponent(tApellido2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Campamentos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 18))); // NOI18N

        jLabel2.setText("Nombre:");

        cbNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbNombreActionPerformed(evt);
            }
        });

        jLabel3.setText("Fecha Inicio:");

        tFechaI.setEditable(false);

        eLugar.setText("Lugar:");

        tLugar.setEditable(false);

        jLabel4.setText("Fecha Fin:");

        tFechaF.setEditable(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(eLugar)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel3)
                        .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbNombre, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tFechaI)
                    .addComponent(tFechaF)
                    .addComponent(tLugar))
                .addGap(23, 23, 23))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cbNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tFechaI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(tFechaF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(eLugar)
                    .addComponent(tLugar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(Retirar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Cancelar)
                .addGap(59, 59, 59))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addComponent(titulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(titulo)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Retirar)
                    .addComponent(Cancelar))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelarActionPerformed
       Main.CerrarRetirarPersona();
    }//GEN-LAST:event_CancelarActionPerformed

    private void RetirarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RetirarActionPerformed
        if(this.campSeleccionado != null && this.peSeleccionada != null){
            if(JOptionPane.showConfirmDialog(this, "¿Estás seguro de querer retirar a esta persona de este campamento?")==0){
                try{
                    Main.eliminarInscripcion(this.peSeleccionada, this.campSeleccionado);
                    LimpiarCamposCampamento();
                    this.campamentos = Main.obtenerCampamentosByIdPersona(this.peSeleccionada.getDni());
                    rellenarComboCampamentos();
                }catch(Exception e){
                    JOptionPane.showMessageDialog(null, "Ha ocurrido un error inesperado. Vuelve a intentarlo","",JOptionPane.ERROR_MESSAGE);
                }
            }
        }else{
            JOptionPane.showMessageDialog(null, "Tanto la persona como el campamento son obligatorios.");
        }
        
    }//GEN-LAST:event_RetirarActionPerformed

    private void cbDniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbDniActionPerformed
        int index = cbDni.getSelectedIndex()-1;
        Persona pers = null;
        LimpiarCamposCampamento();
        cbNombre.removeAllItems();
        if(index > -1){
            pers = this.personas.get(index);
        }
        if(pers == null){
            LimpiarCamposPersona();
            this.peSeleccionada = null;
        }else{
            this.peSeleccionada = pers;
            AutocompletarDatosPersona();
            this.campamentos = Main.obtenerCampamentosByIdPersona(pers.getDni());
            rellenarComboCampamentos();
        }
    }//GEN-LAST:event_cbDniActionPerformed

    private void tNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tNombreActionPerformed

    private void cbNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbNombreActionPerformed
        int index = cbNombre.getSelectedIndex()-1;
        Campamento camp = null;
        if(index > -1){
            camp = this.campamentos.get(index);
        }
        if(camp == null){
            LimpiarCamposCampamento();
            this.campSeleccionado = null;
        }else{
            this.campSeleccionado = camp;
            AutocompletarDatosCampamento();
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
            java.util.logging.Logger.getLogger(RetirarPersona.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RetirarPersona.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RetirarPersona.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RetirarPersona.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RetirarPersona().setVisible(true);
            }
        });
    }
    
    public void LimpiarCamposCampamento(){
        tFechaI.setText("");
        tLugar.setText("");
        tFechaF.setText("");
    }
    
    public void LimpiarCamposPersona(){
        tNombre.setText("");
        tApellido1.setText("");
        tApellido2.setText("");
    }
    
    public void AutocompletarDatosCampamento(){
        DateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        tLugar.setText(campSeleccionado.getLugar());
        tFechaI.setText(formato.format(campSeleccionado.getFechaI()));
        tFechaF.setText(formato.format(campSeleccionado.getFechaF()));
    }
    
    public void AutocompletarDatosPersona(){
        tNombre.setText(peSeleccionada.getNombre());
        tApellido1.setText(peSeleccionada.getApellido1());
        tApellido2.setText(peSeleccionada.getApellido2());
    }
    
    public void rellenarComboCampamentos(){
        cbNombre.removeAllItems();
        if(this.campamentos != null && !this.campamentos.isEmpty()){
            cbNombre.addItem("-----Elegir campamento-----");
            try{
                for(Campamento camp : this.campamentos){
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
    
    public void rellenarComboPersonas(){
        if(this.personas != null && !this.personas.isEmpty()){
            try{
                cbDni.addItem("-----Elegir persona-----");
                for(Persona pers : this.personas){
                    cbDni.addItem(pers.getDni());
                }
            }catch(Exception e){
                System.out.println("ha ocurrido un error "+ e.getMessage());
            } 
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Cancelar;
    private javax.swing.JButton Retirar;
    private javax.swing.JComboBox<String> cbDni;
    private javax.swing.JComboBox<String> cbNombre;
    private javax.swing.JLabel eApellido2;
    private javax.swing.JLabel eLugar;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField tApellido1;
    private javax.swing.JTextField tApellido2;
    private javax.swing.JTextField tFechaF;
    private javax.swing.JTextField tFechaI;
    private javax.swing.JTextField tLugar;
    private javax.swing.JTextField tNombre;
    private javax.swing.JLabel titulo;
    // End of variables declaration//GEN-END:variables
}
