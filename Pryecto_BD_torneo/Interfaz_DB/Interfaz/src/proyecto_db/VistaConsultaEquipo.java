/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_db;

import conection.MySQL;
import javax.swing.table.DefaultTableModel;
import conection.*;
import static java.lang.Integer.parseInt;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author usuario
 */
public class VistaConsultaEquipo extends javax.swing.JFrame {

    /**
     * Creates new form VistaConsultaEquipo
     */
    public VistaConsultaEquipo() {
        initComponents();
        MostrarJugadores("");
        MostrarPuntos("");
        MostrarSlogan("");
        MostarGoleadores("");
        this.setLocationRelativeTo(null);
    }
    
    public int idEquip_nom(String nom){
        int ide=0;
        try {
            MySQL db = new MySQL();
            db.MySQLConnect();
            
            db.comando = db.conexion.createStatement();
            db.registro = db.comando.executeQuery("SELECT idEquipo FROM Equipo where nombre = "+"'"+nom+"'"+";");
            
            while (db.registro.next()) {
                
                ide=parseInt((db.registro.getString(db.registro.findColumn("idEquipo"))));
                                
            }
            db.close();
        } catch (SQLException ex) {
            Logger.getLogger(VistaConsultaEquipo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ide;
    }
    
    public void LlenarJugadores(int idEquip){
        
        MySQL db = new MySQL();
        db.MySQLConnect();
        
        DefaultTableModel mod = new DefaultTableModel();
        mod.addColumn("Id Jugador");
        mod.addColumn("Nombre");
        mod.addColumn("Apellido 1");
        mod.addColumn("Apellido 2");
        mod.addColumn("Numero");
        TablaJugador.setModel(mod);
        
        try{
        db.comando = db.conexion.createStatement();
        db.registro = db.comando.executeQuery("SELECT idJugador,nombre,apellido1,apellido2,numero,num_goles FROM Jugador where idEquipo = "+idEquip+";");
        String [] datos = new String [6];
        while(db.registro.next()){
            datos[0]=db.registro.getString(1);
            datos[1]=db.registro.getString(2);
            datos[2]=db.registro.getString(3);
            datos[3]=db.registro.getString(4);
            datos[4]=db.registro.getString(5);
            mod.addRow(datos);
        }
        TablaJugador.setModel(mod);
        db.close();
        }catch(Exception e){
            System.out.println(e);
        }
        db.close();
    
    }
    
    public void LlenarPuntos(int idEq){
        MySQL db = new MySQL();
        db.MySQLConnect();
        
        DefaultTableModel mod = new DefaultTableModel();
        mod.addColumn("Puntos");
        TablaPuntos.setModel(mod);
        
        try{
        db.comando = db.conexion.createStatement();
        db.registro = db.comando.executeQuery("SELECT puntos FROM Equipo where idEquipo = "+idEq+";");
        String [] datos = new String [1];
        while(db.registro.next()){
            datos[0]=db.registro.getString(1);
            mod.addRow(datos);
        }
        TablaPuntos.setModel(mod);
        db.close();
        }catch(Exception e){
            System.out.println(e);
        }
        db.close();
    }
    
    public void LlenarSlogan(int idEq){
        MySQL db = new MySQL();
        db.MySQLConnect();
        
        DefaultTableModel mod = new DefaultTableModel();
        mod.addColumn("Eslogan");
        TablaSlogan.setModel(mod);
        
        try{
        db.comando = db.conexion.createStatement();
        db.registro = db.comando.executeQuery("SELECT eslogan FROM Equipo where idEquipo = "+idEq+";");
        String [] datos = new String [1];
        while(db.registro.next()){
            datos[0]=db.registro.getString(1);
            mod.addRow(datos);
        }
        TablaSlogan.setModel(mod);
        db.close();
        }catch(Exception e){
            System.out.println(e);
        }
        db.close();
    }
    
    public void LlenarGoleadores(int idEq){
        MySQL db = new MySQL();
        db.MySQLConnect();
        
        DefaultTableModel mod = new DefaultTableModel();
        mod.addColumn("Nombre");
        mod.addColumn("Apellido");
        mod.addColumn("Goles");
        TablaGoleador.setModel(mod);
        
        try{
        db.comando = db.conexion.createStatement();
        db.registro = db.comando.executeQuery("SELECT nombre,apellido1,num_goles FROM Jugador where idEquipo = "+idEq+" ORDER BY (num_goles) DESC;");
        String [] datos = new String [3];
        while(db.registro.next()){
            datos[0]=db.registro.getString(1);
            datos[1]=db.registro.getString(2);
            datos[2]=db.registro.getString(3);
            mod.addRow(datos);
        }
        TablaGoleador.setModel(mod);
        db.close();
        }catch(Exception e){
            System.out.println(e);
        }
        db.close();
    }
    
    public void MostrarJugadores(String nomb){
        LlenarJugadores(idEquip_nom(nomb));
    }
    
    public void MostrarPuntos(String nomb){
        LlenarPuntos(idEquip_nom(nomb));
    }
    
    public void MostrarSlogan(String nom){
        LlenarSlogan(idEquip_nom(nom));
    }
    
    public void MostarGoleadores(String nom){
        LlenarGoleadores(idEquip_nom(nom));
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
        JugadorGoleador = new javax.swing.JCheckBox();
        Puntos = new javax.swing.JCheckBox();
        NombreEquipo = new javax.swing.JLabel();
        NombreEquipoConsultas = new javax.swing.JTextField();
        Eslogan = new javax.swing.JCheckBox();
        Consultar = new javax.swing.JButton();
        Jugadores = new javax.swing.JCheckBox();
        SiguienteConsulta = new javax.swing.JButton();
        Atras = new javax.swing.JButton();
        AnteriorConsulta = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaJugador = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        TablaPuntos = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        TablaSlogan = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        TablaGoleador = new javax.swing.JTable();
        Limpiar = new javax.swing.JButton();
        Fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Titulo.setFont(new java.awt.Font("Maiandra GD", 1, 36)); // NOI18N
        Titulo.setForeground(new java.awt.Color(255, 255, 255));
        Titulo.setText("Consultas de Equipo");
        getContentPane().add(Titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 10, 420, 40));

        JugadorGoleador.setFont(new java.awt.Font("Maiandra GD", 1, 18)); // NOI18N
        JugadorGoleador.setForeground(new java.awt.Color(255, 255, 255));
        JugadorGoleador.setText("Goles");
        getContentPane().add(JugadorGoleador, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 150, 210, 30));

        Puntos.setFont(new java.awt.Font("Maiandra GD", 1, 18)); // NOI18N
        Puntos.setForeground(new java.awt.Color(255, 255, 255));
        Puntos.setText("Puntos");
        getContentPane().add(Puntos, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 250, 210, 30));

        NombreEquipo.setFont(new java.awt.Font("Maiandra GD", 1, 18)); // NOI18N
        NombreEquipo.setForeground(new java.awt.Color(255, 255, 255));
        NombreEquipo.setText("Nombre Equipo:");
        getContentPane().add(NombreEquipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 70, -1, -1));

        NombreEquipoConsultas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NombreEquipoConsultasActionPerformed(evt);
            }
        });
        getContentPane().add(NombreEquipoConsultas, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 100, 210, 30));

        Eslogan.setFont(new java.awt.Font("Maiandra GD", 1, 18)); // NOI18N
        Eslogan.setForeground(new java.awt.Color(255, 255, 255));
        Eslogan.setText("Eslogan");
        getContentPane().add(Eslogan, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 200, 210, 30));

        Consultar.setBackground(new java.awt.Color(0, 0, 0));
        Consultar.setFont(new java.awt.Font("Maiandra GD", 1, 14)); // NOI18N
        Consultar.setForeground(new java.awt.Color(255, 255, 255));
        Consultar.setText("Consultar");
        Consultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConsultarActionPerformed(evt);
            }
        });
        getContentPane().add(Consultar, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 360, 150, 60));

        Jugadores.setFont(new java.awt.Font("Maiandra GD", 1, 18)); // NOI18N
        Jugadores.setForeground(new java.awt.Color(255, 255, 255));
        Jugadores.setText("Jugadores");
        getContentPane().add(Jugadores, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 300, 210, 30));

        SiguienteConsulta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/siguiente.jpg"))); // NOI18N
        SiguienteConsulta.setText(">>");
        SiguienteConsulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SiguienteConsultaActionPerformed(evt);
            }
        });
        getContentPane().add(SiguienteConsulta, new org.netbeans.lib.awtextra.AbsoluteConstraints(1300, 250, 60, 100));

        Atras.setBackground(new java.awt.Color(0, 0, 0));
        Atras.setFont(new java.awt.Font("Maiandra GD", 1, 14)); // NOI18N
        Atras.setForeground(new java.awt.Color(255, 255, 255));
        Atras.setText("Atrás");
        Atras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AtrasActionPerformed(evt);
            }
        });
        getContentPane().add(Atras, new org.netbeans.lib.awtextra.AbsoluteConstraints(1240, 40, 110, 30));

        AnteriorConsulta.setFont(new java.awt.Font("Maiandra GD", 1, 18)); // NOI18N
        AnteriorConsulta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/anterior.jpg"))); // NOI18N
        AnteriorConsulta.setText(">>");
        AnteriorConsulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AnteriorConsultaActionPerformed(evt);
            }
        });
        getContentPane().add(AnteriorConsulta, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 250, 70, 80));

        TablaJugador.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(TablaJugador);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 70, 460, 370));

        TablaPuntos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(TablaPuntos);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 70, 310, 50));

        TablaSlogan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane3.setViewportView(TablaSlogan);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 140, 310, 50));

        TablaGoleador.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane4.setViewportView(TablaGoleador);

        getContentPane().add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 210, 310, 230));

        Limpiar.setBackground(new java.awt.Color(0, 0, 0));
        Limpiar.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        Limpiar.setForeground(new java.awt.Color(255, 255, 255));
        Limpiar.setText("Limpiar");
        Limpiar.setToolTipText("");
        Limpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LimpiarActionPerformed(evt);
            }
        });
        getContentPane().add(Limpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 440, -1, -1));

        Fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Fondo.jpg"))); // NOI18N
        Fondo.setText("jLabel1");
        getContentPane().add(Fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -20, 1530, 940));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConsultarActionPerformed
        MostrarJugadores("");
        MostrarPuntos("");
        MostrarSlogan("");
        MostarGoleadores("");
         
        if(Jugadores.isSelected()){
            MostrarJugadores(NombreEquipoConsultas.getText());
        }
         
         if(Puntos.isSelected()){
             MostrarPuntos(NombreEquipoConsultas.getText());
         }
         
         if(Eslogan.isSelected()){
             MostrarSlogan(NombreEquipoConsultas.getText());
         }
         
         if(JugadorGoleador.isSelected()){
             MostarGoleadores(NombreEquipoConsultas.getText());
         }
        
    }//GEN-LAST:event_ConsultarActionPerformed

    private void SiguienteConsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SiguienteConsultaActionPerformed
        VistaConsultaJugador vistaConsultaJ = new VistaConsultaJugador();
        vistaConsultaJ.run();
        this.setVisible(false);
    }//GEN-LAST:event_SiguienteConsultaActionPerformed

    private void AnteriorConsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AnteriorConsultaActionPerformed
        VistaConsultaPartido vistaConsultaP = new VistaConsultaPartido();
        vistaConsultaP.run();
        this.setVisible(false);
    }//GEN-LAST:event_AnteriorConsultaActionPerformed

    private void AtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AtrasActionPerformed
        this.setVisible(false);
        Main main = new Main();
        main.setVisible(true);
    }//GEN-LAST:event_AtrasActionPerformed

    private void NombreEquipoConsultasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NombreEquipoConsultasActionPerformed

    }//GEN-LAST:event_NombreEquipoConsultasActionPerformed

    private void LimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LimpiarActionPerformed
        MostrarJugadores("");
        MostrarPuntos("");
        MostrarSlogan("");
        MostarGoleadores("");
        Jugadores.setSelected(false);
        Puntos.setSelected(false);
        Eslogan.setSelected(false);
        JugadorGoleador.setSelected(false);
        NombreEquipoConsultas.setText("");
    }//GEN-LAST:event_LimpiarActionPerformed

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
            java.util.logging.Logger.getLogger(VistaConsultaEquipo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaConsultaEquipo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaConsultaEquipo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaConsultaEquipo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VistaConsultaEquipo().setVisible(true);
            }
        });
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AnteriorConsulta;
    private javax.swing.JButton Atras;
    private javax.swing.JButton Consultar;
    private javax.swing.JCheckBox Eslogan;
    private javax.swing.JLabel Fondo;
    private javax.swing.JCheckBox JugadorGoleador;
    private javax.swing.JCheckBox Jugadores;
    private javax.swing.JButton Limpiar;
    private javax.swing.JLabel NombreEquipo;
    private javax.swing.JTextField NombreEquipoConsultas;
    private javax.swing.JCheckBox Puntos;
    private javax.swing.JButton SiguienteConsulta;
    private javax.swing.JTable TablaGoleador;
    private javax.swing.JTable TablaJugador;
    private javax.swing.JTable TablaPuntos;
    private javax.swing.JTable TablaSlogan;
    private javax.swing.JLabel Titulo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    // End of variables declaration//GEN-END:variables
}
