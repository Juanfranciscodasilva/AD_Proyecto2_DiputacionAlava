package Ventanas;

import Clases.Persona;
import Clases.Response;
import diputacionAlava.Main;
import javax.swing.JOptionPane;

public class CrearPersona extends javax.swing.JFrame {
    
    private final String dniChars="TRWAGMYFPDXBNJZSQVHLCKE";   
    
    public CrearPersona() {
        initComponents();
        setLocationRelativeTo(null);
        NoDni.setVisible(false);
        NoNombre.setVisible(false);
        NoApellido1.setVisible(false);
        NoApellido2.setVisible(false);
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jCalendar1 = new com.toedter.calendar.JCalendar();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        tTitulo = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        eNombre = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        tDni = new javax.swing.JTextField();
        tNombre = new javax.swing.JTextField();
        AceptarModificar = new javax.swing.JButton();
        bCancelar = new javax.swing.JButton();
        NoApellido1 = new javax.swing.JLabel();
        NoDni = new javax.swing.JLabel();
        NoApellido2 = new javax.swing.JLabel();
        NoNombre = new javax.swing.JLabel();
        tApellido1 = new javax.swing.JTextField();
        tApellido2 = new javax.swing.JTextField();

        jScrollPane1.setViewportView(jTextPane1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tTitulo.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        tTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tTitulo.setText("Crear Persona");

        jLabel2.setText("DNI:");

        jLabel3.setText("Apellido 2:");

        eNombre.setText("Nombre:");

        jLabel6.setText("Apellido 1:");

        AceptarModificar.setText("Aceptar y crear");
        AceptarModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AceptarModificarActionPerformed(evt);
            }
        });

        bCancelar.setText("Cancelar");
        bCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCancelarActionPerformed(evt);
            }
        });

        NoApellido1.setFont(new java.awt.Font("Dialog", 2, 12)); // NOI18N
        NoApellido1.setForeground(new java.awt.Color(255, 0, 0));
        NoApellido1.setText("*Apellido no válido");

        NoDni.setFont(new java.awt.Font("Dialog", 2, 12)); // NOI18N
        NoDni.setForeground(new java.awt.Color(255, 0, 0));
        NoDni.setText("*DNI no válido");

        NoApellido2.setFont(new java.awt.Font("Dialog", 2, 12)); // NOI18N
        NoApellido2.setForeground(new java.awt.Color(255, 0, 0));
        NoApellido2.setText("*Apellido no válido");

        NoNombre.setFont(new java.awt.Font("Dialog", 2, 12)); // NOI18N
        NoNombre.setForeground(new java.awt.Color(255, 0, 0));
        NoNombre.setText("*Nombre no válido");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(43, 43, 43)
                                .addComponent(AceptarModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(50, 50, 50)
                                .addComponent(bCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(9, 9, 9)
                                                .addComponent(eNombre))
                                            .addComponent(jLabel3))
                                        .addComponent(jLabel6))
                                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(NoApellido1)
                                    .addComponent(NoApellido2)
                                    .addComponent(tNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tDni, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(NoDni)
                                    .addComponent(NoNombre)
                                    .addComponent(tApellido1, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tApellido2, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 17, Short.MAX_VALUE))
                    .addComponent(tTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(tTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tDni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(NoDni)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(eNombre))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(NoNombre)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(tApellido1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(NoApellido1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tApellido2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(NoApellido2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AceptarModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCancelarActionPerformed
        Main.cerrarCrearPersona();
    }//GEN-LAST:event_bCancelarActionPerformed

    private void AceptarModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AceptarModificarActionPerformed
        if(validarDatos()){
            String dni = tDni.getText();
            String nombre = tNombre.getText();
            String apellido1 = tApellido1.getText();
            String apellido2 = tApellido2.getText();
            
            Persona p = new Persona();
            p.setDni(dni.toUpperCase());
            p.setNombre(nombre);
            p.setApellido1(apellido1);
            p.setApellido2(apellido2);
            
            Response respuesta = null;
            respuesta = Main.insertarPersona(p);
            if(respuesta != null){
                if(respuesta.isCorrecto()){
                    JOptionPane.showMessageDialog(null, "Se ha insertado la persona correctamente.");
                    Main.cerrarCrearPersona();
                }else{
                    JOptionPane.showMessageDialog(null,respuesta.getMensajeError(),"", JOptionPane.ERROR_MESSAGE);
                }
            }else{
                JOptionPane.showMessageDialog(null,"Ha ocurrido un error insesperado. Vuelve a intentarlo.","", JOptionPane.ERROR_MESSAGE);
            }
            
        }
    }//GEN-LAST:event_AceptarModificarActionPerformed

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
            java.util.logging.Logger.getLogger(CrearPersona.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CrearPersona.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CrearPersona.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CrearPersona.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CrearPersona().setVisible(true);
            }
        });
    }
    
    public boolean validarDatos(){
        NoDni.setVisible(false);
        NoNombre.setVisible(false);
        NoApellido1.setVisible(false);
        NoApellido2.setVisible(false);
        boolean valido = true;
        String dni = tDni.getText();
        String nombre = tNombre.getText();
        String apellido1 = tApellido1.getText();
        String apellido2 = tApellido2.getText();
        if(dni == null || dni.isBlank()){
            NoDni.setText("*El DNI es obligatorio.");
            NoDni.setVisible(true);
            valido = false;
        }else if(!validarDNI(dni)){
            NoDni.setText("*El DNI no es correcto.");
            NoDni.setVisible(true);
            valido = false;
        }
        if(nombre == null || nombre.isBlank()){
            NoNombre.setText("*El nombre es obligatorio.");
            NoNombre.setVisible(true);
            valido = false;
        }
        if(apellido1 == null || apellido1.isBlank()){
            NoApellido1.setText("*Los apellidos son obligatorios.");
            NoApellido1.setVisible(true);
            valido = false;
        }
        if(apellido2 == null || apellido2.isBlank()){
            NoApellido2.setText("*Los apellidos son obligatorios.");
            NoApellido2.setVisible(true);
            valido = false;
        }
        return valido;
    }
    
     private boolean validarDNI(String dni) {
        dni = dni.toUpperCase();
        String intPartDNI = dni.trim().replaceAll(" ", "").substring(0, 8);
        if(dni.length() == 9){
            char ltrDNI = dni.charAt(8);
            if(isNumeric(intPartDNI)){
                int valNumDni = Integer.parseInt(intPartDNI) % 23;
                if(dniChars.charAt(valNumDni)== ltrDNI){
                    return true;
                }
            }
        }
        return false;
    }
     
     private boolean isNumeric(String numeroString){
         try{
             int numeroConvertido = Integer.parseInt(numeroString);
             return true;
         }catch(Exception ex){
             return false;
         }
     }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AceptarModificar;
    private javax.swing.JLabel NoApellido1;
    private javax.swing.JLabel NoApellido2;
    private javax.swing.JLabel NoDni;
    private javax.swing.JLabel NoNombre;
    private javax.swing.JButton bCancelar;
    private javax.swing.JLabel eNombre;
    private com.toedter.calendar.JCalendar jCalendar1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JTextField tApellido1;
    private javax.swing.JTextField tApellido2;
    private javax.swing.JTextField tDni;
    private javax.swing.JTextField tNombre;
    private javax.swing.JLabel tTitulo;
    // End of variables declaration//GEN-END:variables
}
