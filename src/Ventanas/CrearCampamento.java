package Ventanas;

import Clases.Campamento;
import Clases.Response;
import diputacionAlava.Main;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import javax.swing.JOptionPane;

public class CrearCampamento extends javax.swing.JFrame {

    private int opcion;
    private Campamento c;
    
    public CrearCampamento() {
        initComponents();
        setLocationRelativeTo(null);
        NoNombre.setVisible(false);
        NoLugar.setVisible(false);
        NoFechaI.setVisible(false);
        NoFechaF.setVisible(false);
        NoCapacidad.setVisible(false);
        this.opcion = 0;
        c = new Campamento();
    }
    
    public CrearCampamento(int opcion, Campamento camp) {
        initComponents();
        setLocationRelativeTo(null);
        NoNombre.setVisible(false);
        NoLugar.setVisible(false);
        NoFechaI.setVisible(false);
        NoFechaF.setVisible(false);
        NoCapacidad.setVisible(false);
        this.opcion = opcion;
        this.c = camp;
        AjustarVentanaOpcion();
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
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        tNombre = new javax.swing.JTextField();
        tLugar = new javax.swing.JTextField();
        tCapacidad = new javax.swing.JTextField();
        AceptarModificar = new javax.swing.JButton();
        bCancelar = new javax.swing.JButton();
        NoFechaI = new javax.swing.JLabel();
        NoNombre = new javax.swing.JLabel();
        NoFechaF = new javax.swing.JLabel();
        NoCapacidad = new javax.swing.JLabel();
        NoLugar = new javax.swing.JLabel();
        tFechaInicio = new com.toedter.calendar.JDateChooser();
        tFechaFin = new com.toedter.calendar.JDateChooser();

        jScrollPane1.setViewportView(jTextPane1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tTitulo.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        tTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tTitulo.setText("Modificar Campamento");

        jLabel2.setText("Nombre:");

        jLabel3.setText("Fecha fin:");

        jLabel5.setText("Lugar:");

        jLabel6.setText("Fecha inicio:");

        jLabel8.setText("Capacidad:");

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

        NoFechaI.setFont(new java.awt.Font("Dialog", 2, 12)); // NOI18N
        NoFechaI.setForeground(new java.awt.Color(255, 0, 0));
        NoFechaI.setText("*Fecha no válida (dd/mm/aaaa)");

        NoNombre.setFont(new java.awt.Font("Dialog", 2, 12)); // NOI18N
        NoNombre.setForeground(new java.awt.Color(255, 0, 0));
        NoNombre.setText("*Nombre no válido");

        NoFechaF.setFont(new java.awt.Font("Dialog", 2, 12)); // NOI18N
        NoFechaF.setForeground(new java.awt.Color(255, 0, 0));
        NoFechaF.setText("*Fecha no válida (dd/mm/aaaa)");

        NoCapacidad.setFont(new java.awt.Font("Dialog", 2, 12)); // NOI18N
        NoCapacidad.setForeground(new java.awt.Color(255, 0, 0));
        NoCapacidad.setText("*Capacidad no válida");

        NoLugar.setFont(new java.awt.Font("Dialog", 2, 12)); // NOI18N
        NoLugar.setForeground(new java.awt.Color(255, 0, 0));
        NoLugar.setText("*Lugar no válido");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(84, 84, 84)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(NoNombre)
                    .addComponent(NoLugar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(NoCapacidad)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(tCapacidad)
                                        .addComponent(tFechaFin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(NoFechaI)
                                        .addComponent(NoFechaF)
                                        .addComponent(tFechaInicio, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(tLugar, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(tTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(tTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(NoNombre)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tLugar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(NoLugar)
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tFechaInicio, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(NoFechaI)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(tFechaFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(NoFechaF)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tCapacidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(NoCapacidad)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AceptarModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCancelarActionPerformed
        Main.cerrarCrearModificarCampamento(this.opcion);
    }//GEN-LAST:event_bCancelarActionPerformed

    private void AceptarModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AceptarModificarActionPerformed
        if(validarDatos()){
            String nombre = tNombre.getText();
            String lugar = tLugar.getText();
            Date fechaInicio = tFechaInicio.getDate();
            Date fechaFin = tFechaFin.getDate();
            int capacidad = Integer.parseInt(tCapacidad.getText());
            
            this.c.setNombre(nombre);
            this.c.setLugar(lugar);
            this.c.setFechaI(fechaInicio);
            this.c.setFechaF(fechaFin);
            this.c.setCapacidad(capacidad);
            
            Response respuesta = null;
            if(this.opcion == 1){
                respuesta = Main.ModificarCampamento(c);
                if(respuesta.isCorrecto()){
                    JOptionPane.showMessageDialog(null, "Se ha modificado el campamento correctamente.");
                }
            }else{
                respuesta = Main.insertarCampamento(c);
                if(respuesta.isCorrecto()){
                    JOptionPane.showMessageDialog(null, "Se ha insertado el campamento correctamente.");
                }
            }
            if(respuesta != null){
                if(!respuesta.isCorrecto()){
                    JOptionPane.showMessageDialog(null,respuesta.getMensajeError(),"", JOptionPane.ERROR_MESSAGE);
                }else{
                    Main.cerrarCrearModificarCampamento(this.opcion);
                }
            }else{
                JOptionPane.showMessageDialog(null, "Ha ocurrido un error inesperado. Vuelve a intentarlo.","", JOptionPane.ERROR_MESSAGE);
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
            java.util.logging.Logger.getLogger(CrearCampamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CrearCampamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CrearCampamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CrearCampamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CrearCampamento().setVisible(true);
            }
        });
    }
    
    public boolean validarDatos(){
        NoNombre.setVisible(false);
        NoLugar.setVisible(false);
        NoFechaI.setVisible(false);
        NoFechaF.setVisible(false);
        NoCapacidad.setVisible(false);
        boolean valido = true;
        String nombre = tNombre.getText();
        String lugar = tLugar.getText();
        Date fechaInicio = tFechaInicio.getDate();
        Date fechaFin = tFechaFin.getDate();
        String capacidadString = tCapacidad.getText();
        if(nombre == null || nombre.isEmpty()){
            NoNombre.setText("*El nombre es obligatorio.");
            NoNombre.setVisible(true);
            valido = false;
        }
        if(lugar == null || lugar.isEmpty()){
            NoLugar.setText("*El lugar es obligatorio.");
            NoLugar.setVisible(true);
            valido = false;
        }
        if(fechaInicio == null){
            NoFechaI.setText("*La fecha de inicio es obligatoria.");
            NoFechaI.setVisible(true);
            valido = false;
        }
        if(fechaFin == null){
            NoFechaF.setText("*La fecha de fin es obligatoria.");
            NoFechaF.setVisible(true);
            valido = false;
        }else if(fechaFin.compareTo(fechaInicio) <= 0){
            NoFechaF.setText("*La fecha de fin tiene que ser posterior a la de inicio.");
            NoFechaF.setVisible(true);
            valido = false;
        }
        if(capacidadString == null || capacidadString.isEmpty()){
            NoCapacidad.setText("*La capacidad es obligatoria.");
            NoCapacidad.setVisible(true);
            valido = false;
        }else if(!validarCapacidad()){
            NoCapacidad.setText("*La capacidad tiene que ser un número mayor a 0.");
            NoCapacidad.setVisible(true);
            valido = false;
        }
        return valido;
    }
    
    public void Modificar(Campamento c){
        opcion=1;
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        AceptarModificar.setText("Aceptar y modificar");
        tNombre.setText(c.getNombre());
        tNombre.setEnabled(false);
        tLugar.setText(c.getLugar());
        tCapacidad.setText(String.valueOf(c.getCapacidad()));
    }
    
    public boolean validarCapacidad(){
       try{
           int capacidad = Integer.parseInt(tCapacidad.getText());
           if(capacidad<=0){
               return false;
           }
           return true;
       }catch(Exception e){
           return false;
       }
    }
    
    public void AjustarVentanaOpcion(){
        if(opcion == 1){
            tTitulo.setText("Modificar Campamento");
            RellenarDatosDelCampamento();
        }else{
            tTitulo.setText("Crear Campamento");
        }
    }
    
    public void RellenarDatosDelCampamento(){
        if(c != null){
            tNombre.setText(c.getNombre());
            tLugar.setText(c.getLugar());
            tFechaInicio.setDate(c.getFechaI());
            tFechaFin.setDate(c.getFechaF());
            tCapacidad.setText(String.valueOf(c.getCapacidad()));
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AceptarModificar;
    private javax.swing.JLabel NoCapacidad;
    private javax.swing.JLabel NoFechaF;
    private javax.swing.JLabel NoFechaI;
    private javax.swing.JLabel NoLugar;
    private javax.swing.JLabel NoNombre;
    private javax.swing.JButton bCancelar;
    private com.toedter.calendar.JCalendar jCalendar1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JTextField tCapacidad;
    private com.toedter.calendar.JDateChooser tFechaFin;
    private com.toedter.calendar.JDateChooser tFechaInicio;
    private javax.swing.JTextField tLugar;
    private javax.swing.JTextField tNombre;
    private javax.swing.JLabel tTitulo;
    // End of variables declaration//GEN-END:variables
}
