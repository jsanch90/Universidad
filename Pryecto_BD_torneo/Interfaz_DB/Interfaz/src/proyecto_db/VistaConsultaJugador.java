/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_db;

import conection.MySQL;
import static java.lang.Integer.parseInt;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author usuario
 */
public class VistaConsultaJugador extends javax.swing.JFrame {

    /**
     * Creates new form VistaConsultaJugador
     */
    public VistaConsultaJugador() {
        initComponents();
        
        DefaultTableModel mod1 = new DefaultTableModel();
        mod1.addColumn("Nombre");
        mod1.addColumn("Apellido 1");
        mod1.addColumn("Apellido 2");
        TablaNombre.setModel(mod1);
        
        DefaultTableModel mod2 = new DefaultTableModel();
        mod2.addColumn("Goles");
        TablaGoles.setModel(mod2);
        
        DefaultTableModel mod3 = new DefaultTableModel();
        mod3.addColumn("Equipo");
        mod3.addColumn("Eslogan");
        mod3.addColumn("Identificacion");
        TablaEquipo.setModel(mod3);
        
        DefaultTableModel mod4 = new DefaultTableModel();
        mod4.addColumn("Numero");
        TablaNumero.setModel(mod4);
        
        DefaultTableModel mod5 = new DefaultTableModel();
        mod5.addColumn("Estado");
        TablaEstado.setModel(mod5);
        
        this.setLocationRelativeTo(null);
    }

    
        public void LlenarNombre(int idJug){
        MySQL db = new MySQL();
        db.MySQLConnect();
        
        DefaultTableModel mod = new DefaultTableModel();
        mod.addColumn("Nombre");
        mod.addColumn("Apellido 1");
        mod.addColumn("Apellido 2");
        TablaNombre.setModel(mod);
        try{
            db.comando = db.conexion.createStatement();
            db.registro = db.comando.executeQuery("select nombre,apellido1,apellido2 from Jugador where idJugador = "+idJug+";");
            System.out.println("select nombre,apellido1,apellido2 from Jugador where idJugador = "+idJug+";");
            String [] datos = new String [3];
            while(db.registro.next()){
                datos[0]=db.registro.getString(1);
                datos[1]=db.registro.getString(2);
                datos[2]=db.registro.getString(3);
                mod.addRow(datos);
            }
            TablaNombre.setModel(mod);
            db.close();
        }catch(Exception e){
            System.out.println(e);
        }
        db.close();
    }
        
        
        public void LlenarGoles(int idJug){
            MySQL db = new MySQL();
            db.MySQLConnect();
            
            DefaultTableModel mod = new DefaultTableModel();
            mod.addColumn("Goles");
            TablaGoles.setModel(mod);
            try{
                db.comando = db.conexion.createStatement();
                db.registro = db.comando.executeQuery("select num_goles from Jugador where idJugador = "+idJug+";");
                System.out.println("select nombre,apellido1,apellido2 from Jugador where idJugador = "+idJug+";");
                String [] datos = new String [1];
                while(db.registro.next()){
                    datos[0]=db.registro.getString(1);
                    mod.addRow(datos);
                }
                TablaGoles.setModel(mod);
                db.close();
            }catch(Exception e){
                System.out.println(e);
            }
            db.close();
        }
        
          public void LlenarEstado(int idJug){
            MySQL db = new MySQL();
            db.MySQLConnect();
            String aux=null;
            DefaultTableModel mod = new DefaultTableModel();
            mod.addColumn("Estado");
            TablaEstado.setModel(mod);
            try{
                db.comando = db.conexion.createStatement();
                db.registro = db.comando.executeQuery("select estado from Jugador where idJugador = "+idJug+";");
                String [] datos = new String [1];
                while(db.registro.next()){
                    aux=db.registro.getString(1);
                    if(aux.equals("1")){
                        datos[0]="Disponible";
                    }else{
                        datos[0]="Sancionado o lesionado";
                    }
                    mod.addRow(datos);
                }
                TablaEstado.setModel(mod);
                db.close();
            }catch(Exception e){
                System.out.println(e);
            }
            db.close();
        }
        
        
        public void LlenarEquipo(int idJug){
            MySQL db = new MySQL();
            db.MySQLConnect();
            
            DefaultTableModel mod = new DefaultTableModel();
            mod.addColumn("Equipo");
            mod.addColumn("Eslogan");
            mod.addColumn("Identificacion");
            TablaEquipo.setModel(mod);
            try{
                db.comando = db.conexion.createStatement();
                db.registro = db.comando.executeQuery("select Equipo.nombre,Equipo.eslogan,Equipo.idEquipo from Equipo inner join Jugador on Jugador.idEquipo=Equipo.idEquipo and Jugador.idJugador="+idJug+";");
           
                String [] datos = new String [3];
                while(db.registro.next()){
                    datos[0]=db.registro.getString(1);
                    datos[1]=db.registro.getString(2);
                    datos[2]=db.registro.getString(3);
                    mod.addRow(datos);
                }
                TablaEquipo.setModel(mod);
                db.close();
            }catch(Exception e){
                System.out.println(e);
            }
            db.close();
        }
        
        
        public void LlenarNumero(int idJug){
            MySQL db = new MySQL();
            db.MySQLConnect();
            
            DefaultTableModel mod = new DefaultTableModel();
            mod.addColumn("Numero");
            TablaNumero.setModel(mod);
            try{
                db.comando = db.conexion.createStatement();
                db.registro = db.comando.executeQuery("select numero from Jugador where idJugador = "+idJug+";");
                String [] datos = new String [1];
                while(db.registro.next()){
                    datos[0]=db.registro.getString(1);
                    mod.addRow(datos);
                }
                TablaNumero.setModel(mod);
                db.close();
            }catch(Exception e){
                System.out.println(e);
            }
            db.close();
        }
        
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Titulo = new javax.swing.JLabel();
        IdentificaciónJugador = new javax.swing.JLabel();
        IdentificacionJugadorConsultas = new javax.swing.JTextField();
        Nombre = new javax.swing.JCheckBox();
        Goles = new javax.swing.JCheckBox();
        Equipo = new javax.swing.JCheckBox();
        Estado = new javax.swing.JCheckBox();
        Numero = new javax.swing.JCheckBox();
        Consultar = new javax.swing.JButton();
        SiguienteConsulta = new javax.swing.JButton();
        Atras = new javax.swing.JButton();
        AnteriorConsulta = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaNombre = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        TablaGoles = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        TablaEquipo = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        TablaNumero = new javax.swing.JTable();
        jScrollPane5 = new javax.swing.JScrollPane();
        TablaEstado = new javax.swing.JTable();
        BtnLimpiar = new javax.swing.JButton();
        Fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Titulo.setFont(new java.awt.Font("Maiandra GD", 1, 36)); // NOI18N
        Titulo.setForeground(new java.awt.Color(255, 255, 255));
        Titulo.setText("Consultas de Jugador");
        getContentPane().add(Titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 30, 450, 40));

        IdentificaciónJugador.setFont(new java.awt.Font("Maiandra GD", 1, 18)); // NOI18N
        IdentificaciónJugador.setForeground(java.awt.Color.white);
        IdentificaciónJugador.setText("Identificación Jugador:");
        getContentPane().add(IdentificaciónJugador, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 100, 250, 40));

        IdentificacionJugadorConsultas.setFont(new java.awt.Font("Maiandra GD", 1, 14)); // NOI18N
        getContentPane().add(IdentificacionJugadorConsultas, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 150, 210, 30));

        Nombre.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Nombre.setForeground(new java.awt.Color(255, 255, 255));
        Nombre.setText("Nombre");
        getContentPane().add(Nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 210, 200, 30));

        Goles.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Goles.setForeground(new java.awt.Color(255, 255, 255));
        Goles.setText("Goles");
        getContentPane().add(Goles, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 260, 200, 30));

        Equipo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Equipo.setForeground(new java.awt.Color(255, 255, 255));
        Equipo.setText("Equipo");
        getContentPane().add(Equipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 310, 200, 30));

        Estado.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Estado.setForeground(new java.awt.Color(255, 255, 255));
        Estado.setText("Estado");
        getContentPane().add(Estado, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 410, 200, 30));

        Numero.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Numero.setForeground(new java.awt.Color(255, 255, 255));
        Numero.setText("Numero");
        getContentPane().add(Numero, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 360, 200, 30));

        Consultar.setBackground(new java.awt.Color(0, 0, 0));
        Consultar.setFont(new java.awt.Font("Maiandra GD", 1, 14)); // NOI18N
        Consultar.setForeground(new java.awt.Color(255, 255, 255));
        Consultar.setText("Consultar");
        Consultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConsultarActionPerformed(evt);
            }
        });
        getContentPane().add(Consultar, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 490, 150, 60));

        SiguienteConsulta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/siguiente.jpg"))); // NOI18N
        SiguienteConsulta.setText(">>");
        SiguienteConsulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SiguienteConsultaActionPerformed(evt);
            }
        });
        getContentPane().add(SiguienteConsulta, new org.netbeans.lib.awtextra.AbsoluteConstraints(1250, 250, 60, 100));

        Atras.setBackground(new java.awt.Color(0, 0, 0));
        Atras.setFont(new java.awt.Font("Maiandra GD", 1, 14)); // NOI18N
        Atras.setForeground(new java.awt.Color(255, 255, 255));
        Atras.setText("Atrás");
        Atras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AtrasActionPerformed(evt);
            }
        });
        getContentPane().add(Atras, new org.netbeans.lib.awtextra.AbsoluteConstraints(1230, 40, 110, 30));

        AnteriorConsulta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/anterior.jpg"))); // NOI18N
        AnteriorConsulta.setText(">>");
        AnteriorConsulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AnteriorConsultaActionPerformed(evt);
            }
        });
        getContentPane().add(AnteriorConsulta, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 250, 70, 80));

        TablaNombre.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(TablaNombre);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 120, -1, 50));

        TablaGoles.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(TablaGoles);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 190, -1, 50));

        TablaEquipo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane3.setViewportView(TablaEquipo);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 260, -1, 50));

        TablaNumero.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane4.setViewportView(TablaNumero);

        getContentPane().add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 330, -1, 50));

        TablaEstado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane5.setViewportView(TablaEstado);

        getContentPane().add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 400, -1, 50));

        BtnLimpiar.setBackground(new java.awt.Color(0, 0, 0));
        BtnLimpiar.setFont(new java.awt.Font("Maiandra GD", 1, 14)); // NOI18N
        BtnLimpiar.setForeground(new java.awt.Color(255, 255, 255));
        BtnLimpiar.setText("Limpiar");
        BtnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnLimpiarActionPerformed(evt);
            }
        });
        getContentPane().add(BtnLimpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 580, 130, 40));

        Fondo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Fondo.jpg"))); // NOI18N
        getContentPane().add(Fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(-40, 0, 1680, 880));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConsultarActionPerformed
        if(Nombre.isSelected()){
            LlenarNombre(parseInt(IdentificacionJugadorConsultas.getText()));
        }
        
        if(Goles.isSelected()){
            LlenarGoles(parseInt(IdentificacionJugadorConsultas.getText()));
        }
        
        if(Equipo.isSelected()){
            LlenarEquipo(parseInt(IdentificacionJugadorConsultas.getText()));
        }
        
        if(Numero.isSelected()){
            LlenarNumero(parseInt(IdentificacionJugadorConsultas.getText()));
        }
        
        if(Estado.isSelected()){
            LlenarEstado(parseInt(IdentificacionJugadorConsultas.getText()));
        }
    }//GEN-LAST:event_ConsultarActionPerformed

    private void SiguienteConsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SiguienteConsultaActionPerformed
        VistaConsultaSancionados vistaConsultaS = new VistaConsultaSancionados();
        vistaConsultaS.run();
        this.setVisible(false);
    }//GEN-LAST:event_SiguienteConsultaActionPerformed

    private void AtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AtrasActionPerformed
        this.setVisible(false);
        Main main = new Main();
        main.setVisible(true);
    }//GEN-LAST:event_AtrasActionPerformed

    private void AnteriorConsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AnteriorConsultaActionPerformed
        VistaConsultaEquipo vistaConsultaE = new VistaConsultaEquipo();
        vistaConsultaE.run();
        this.setVisible(false);
    }//GEN-LAST:event_AnteriorConsultaActionPerformed

    private void BtnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnLimpiarActionPerformed
        DefaultTableModel mod1 = new DefaultTableModel();
        mod1.addColumn("Nombre");
        mod1.addColumn("Apellido 1");
        mod1.addColumn("Apellido 2");
        TablaNombre.setModel(mod1);
        
        DefaultTableModel mod2 = new DefaultTableModel();
        mod2.addColumn("Goles");
        TablaGoles.setModel(mod2);
        
        DefaultTableModel mod3 = new DefaultTableModel();
        mod3.addColumn("Equipo");
        mod3.addColumn("Eslogan");
        mod3.addColumn("Identificacion");
        TablaEquipo.setModel(mod3);
        
        DefaultTableModel mod4 = new DefaultTableModel();
        mod4.addColumn("Numero");
        TablaNumero.setModel(mod4);
        
        DefaultTableModel mod5 = new DefaultTableModel();
        mod5.addColumn("Estado");
        TablaEstado.setModel(mod5);
        Nombre.setSelected(false);
        Goles.setSelected(false);
        Equipo.setSelected(false);
        Numero.setSelected(false);
        Estado.setSelected(false);
        IdentificacionJugadorConsultas.setText("");
    }//GEN-LAST:event_BtnLimpiarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void run() {
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
            java.util.logging.Logger.getLogger(VistaConsultaJugador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaConsultaJugador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaConsultaJugador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaConsultaJugador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VistaConsultaJugador().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AnteriorConsulta;
    private javax.swing.JButton Atras;
    private javax.swing.JButton BtnLimpiar;
    private javax.swing.JButton Consultar;
    private javax.swing.JCheckBox Equipo;
    private javax.swing.JCheckBox Estado;
    private javax.swing.JLabel Fondo;
    private javax.swing.JCheckBox Goles;
    private javax.swing.JTextField IdentificacionJugadorConsultas;
    private javax.swing.JLabel IdentificaciónJugador;
    private javax.swing.JCheckBox Nombre;
    private javax.swing.JCheckBox Numero;
    private javax.swing.JButton SiguienteConsulta;
    private javax.swing.JTable TablaEquipo;
    private javax.swing.JTable TablaEstado;
    private javax.swing.JTable TablaGoles;
    private javax.swing.JTable TablaNombre;
    private javax.swing.JTable TablaNumero;
    private javax.swing.JLabel Titulo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    // End of variables declaration//GEN-END:variables
}
