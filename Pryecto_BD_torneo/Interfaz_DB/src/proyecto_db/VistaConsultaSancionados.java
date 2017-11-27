/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_db;

import conection.MySQL;
import javax.swing.table.DefaultTableModel;
import static java.lang.Integer.parseInt;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author usuario
 */
public class VistaConsultaSancionados extends javax.swing.JFrame {

    /**
     * Creates new form VistaConsultaSancionados
     */
    public VistaConsultaSancionados() {
        initComponents();
         MostrarSancionados1("","");
         MostrarSancionados2("","");
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
     
   
        public void LlenarSancionados_1(int id1, int id2){
        MySQL db = new MySQL();
        db.MySQLConnect();
        
        DefaultTableModel mod = new DefaultTableModel();
        mod.addColumn("Nombre");
        mod.addColumn("Apellido");
        mod.addColumn("Tipo de sanción");
        
        tblSancionados.setModel(mod);
        try{
        db.comando = db.conexion.createStatement();
        db.registro = db.comando.executeQuery("SELECT Jugador.nombre,Jugador.apellido1,Sancionados.tipo_sancion FROM Jugador,Sancionados,Equipo WHERE Sancionados.tipo_sancion= 1 AND Jugador.idEquipo=Equipo.idEquipo AND Sancionados.idJugador=Jugador.idJugador AND Jugador.idEquipo="+id1+";");
            System.out.println("SELECT Jugador.nombre,Sancionados.tipo_sancion FROM Jugador,Sancionados,Equipo WHERE Sancionados.tipo_sancion= 1 AND Jugador.idEquipo=Equipo.idEquipo AND Sancionados.idJugador=Jugador.idJugador AND Jugador.idEquipo="+id1+";");
        String [] datos = new String [3];
        while(db.registro.next()){
            datos[0]=db.registro.getString(1);
            datos[1]=db.registro.getString(2);
            datos[2]=db.registro.getString(3);
            mod.addRow(datos);
        }
        tblSancionados.setModel(mod);
        }catch(Exception e){
            System.out.println(e);
        }
        
        tblSancionados.setModel(mod);
        try{
        db.comando = db.conexion.createStatement();
        db.registro = db.comando.executeQuery("SELECT Jugador.nombre,Jugador.apellido1,Sancionados.tipo_sancion FROM Jugador,Sancionados,Equipo WHERE Sancionados.tipo_sancion= 1 AND Jugador.idEquipo=Equipo.idEquipo AND Sancionados.idJugador=Jugador.idJugador AND Jugador.idEquipo="+id2+";");
            System.out.println("SELECT Jugador.nombre,Sancionados.tipo_sancion FROM Jugador,Sancionados,Equipo WHERE Sancionados.tipo_sancion= 1 AND Jugador.idEquipo=Equipo.idEquipo AND Sancionados.idJugador=Jugador.idJugador AND Jugador.idEquipo="+id1+";");
        String [] datos = new String [3];
        while(db.registro.next()){
            datos[0]=db.registro.getString(1);
            datos[1]=db.registro.getString(2);
            datos[2]=db.registro.getString(3);
            mod.addRow(datos);
        }
        tblSancionados.setModel(mod);
        }catch(Exception e){
            System.out.println(e);
        }
        db.close();
    
    }

        
          public void LlenarSancionados_2(int id1,int id2){
        MySQL db = new MySQL();
        db.MySQLConnect();
        
        DefaultTableModel mod = new DefaultTableModel();
        mod.addColumn("Nombre");
        mod.addColumn("Apellido");
        mod.addColumn("Tipo de sanción");
      
        tblSancionados2.setModel(mod);
        try{
        db.comando = db.conexion.createStatement();
        db.registro = db.comando.executeQuery("SELECT Jugador.nombre,Jugador.apellido1,Sancionados.tipo_sancion FROM Jugador,Sancionados,Equipo WHERE Sancionados.tipo_sancion= 2 AND Jugador.idEquipo=Equipo.idEquipo AND Sancionados.idJugador=Jugador.idJugador AND Jugador.idEquipo="+id1+";");
            System.out.println("SELECT Jugador.nombre,Sancionados.tipo_sancion FROM Jugador,Sancionados,Equipo WHERE Sancionados.tipo_sancion= 2 AND Jugador.idEquipo=Equipo.idEquipo AND Sancionados.idJugador=Jugador.idJugador AND Jugador.idEquipo="+id2+";");
        String [] datos = new String [3];
        while(db.registro.next()){
            datos[0]=db.registro.getString(1);
            datos[1]=db.registro.getString(2);
            datos[2]=db.registro.getString(3);
            mod.addRow(datos);
        }
        tblSancionados2.setModel(mod);
        }catch(Exception e){
            System.out.println(e);
        }
        
        try{
        db.comando = db.conexion.createStatement();
        db.registro = db.comando.executeQuery("SELECT Jugador.nombre,Jugador.apellido1,Sancionados.tipo_sancion FROM Jugador,Sancionados,Equipo WHERE Sancionados.tipo_sancion= 2 AND Jugador.idEquipo=Equipo.idEquipo AND Sancionados.idJugador=Jugador.idJugador AND Jugador.idEquipo="+id2+";");
            System.out.println("SELECT Jugador.nombre,Sancionados.tipo_sancion FROM Jugador,Sancionados,Equipo WHERE Sancionados.tipo_sancion= 2 AND Jugador.idEquipo=Equipo.idEquipo AND Sancionados.idJugador=Jugador.idJugador AND Jugador.idEquipo="+id2+";");
        String [] datos = new String [3];
        while(db.registro.next()){
            datos[0]=db.registro.getString(1);
            datos[1]=db.registro.getString(2);
            datos[2]=db.registro.getString(3);
            mod.addRow(datos);
        }
        tblSancionados2.setModel(mod);
        }catch(Exception e){
            System.out.println(e);
        }
        
        db.close();
    }
          
     public void MostrarSancionados1(String nom1,String nom2){
        LlenarSancionados_1(idEquip_nom(nom1),idEquip_nom(nom2));
    }
    
    public void MostrarSancionados2(String nom1,String nom2){
        LlenarSancionados_2(idEquip_nom(nom1),idEquip_nom(nom2));
    }
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Titulo = new javax.swing.JLabel();
        NombreEquipoLocal = new javax.swing.JLabel();
        NombreEquipoVisitante = new javax.swing.JLabel();
        EquipoLocalSancionados = new javax.swing.JTextField();
        EquipoVisitaSancionados = new javax.swing.JTextField();
        Amarillas = new javax.swing.JCheckBox();
        Rojas = new javax.swing.JCheckBox();
        Consultar = new javax.swing.JButton();
        SiguienteConsulta = new javax.swing.JButton();
        TablaSancionados = new javax.swing.JScrollPane();
        tblSancionados = new javax.swing.JTable();
        AnteriorConsulta = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblSancionados2 = new javax.swing.JTable();
        Atras = new javax.swing.JButton();
        Limpiar = new javax.swing.JButton();
        Fondo = new javax.swing.JLabel();
        NombreEquipoConsultas = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Titulo.setFont(new java.awt.Font("Maiandra GD", 1, 36)); // NOI18N
        Titulo.setForeground(new java.awt.Color(255, 255, 255));
        Titulo.setText("Consultas de Sancionados");
        getContentPane().add(Titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 30, 630, 40));

        NombreEquipoLocal.setFont(new java.awt.Font("Maiandra GD", 1, 18)); // NOI18N
        NombreEquipoLocal.setForeground(new java.awt.Color(255, 255, 255));
        NombreEquipoLocal.setText("Equipo Local:");
        getContentPane().add(NombreEquipoLocal, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 120, 140, 30));

        NombreEquipoVisitante.setFont(new java.awt.Font("Maiandra GD", 1, 18)); // NOI18N
        NombreEquipoVisitante.setForeground(new java.awt.Color(255, 255, 255));
        NombreEquipoVisitante.setText("Equipo Visitante:");
        getContentPane().add(NombreEquipoVisitante, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 120, 190, 30));

        EquipoLocalSancionados.setFont(new java.awt.Font("Maiandra GD", 1, 18)); // NOI18N
        getContentPane().add(EquipoLocalSancionados, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 160, 220, 30));

        EquipoVisitaSancionados.setFont(new java.awt.Font("Maiandra GD", 1, 18)); // NOI18N
        getContentPane().add(EquipoVisitaSancionados, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 160, 220, 30));

        Amarillas.setFont(new java.awt.Font("Maiandra GD", 1, 18)); // NOI18N
        Amarillas.setForeground(new java.awt.Color(255, 255, 255));
        Amarillas.setText("Amarillas");
        getContentPane().add(Amarillas, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 210, 220, 30));

        Rojas.setFont(new java.awt.Font("Maiandra GD", 1, 18)); // NOI18N
        Rojas.setForeground(new java.awt.Color(255, 255, 255));
        Rojas.setText("Rojas");
        getContentPane().add(Rojas, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 210, 220, 30));

        Consultar.setBackground(new java.awt.Color(0, 0, 0));
        Consultar.setFont(new java.awt.Font("Maiandra GD", 1, 18)); // NOI18N
        Consultar.setForeground(new java.awt.Color(255, 255, 255));
        Consultar.setText("Consultar");
        Consultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConsultarActionPerformed(evt);
            }
        });
        getContentPane().add(Consultar, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 340, 150, 60));

        SiguienteConsulta.setBackground(new java.awt.Color(0, 0, 0));
        SiguienteConsulta.setFont(new java.awt.Font("Maiandra GD", 1, 14)); // NOI18N
        SiguienteConsulta.setForeground(new java.awt.Color(255, 255, 255));
        SiguienteConsulta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/siguiente.jpg"))); // NOI18N
        SiguienteConsulta.setText(">>");
        SiguienteConsulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SiguienteConsultaActionPerformed(evt);
            }
        });
        getContentPane().add(SiguienteConsulta, new org.netbeans.lib.awtextra.AbsoluteConstraints(1250, 250, 60, 100));

        tblSancionados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        TablaSancionados.setViewportView(tblSancionados);

        getContentPane().add(TablaSancionados, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 110, 420, 140));

        AnteriorConsulta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/anterior.jpg"))); // NOI18N
        AnteriorConsulta.setText(">>");
        AnteriorConsulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AnteriorConsultaActionPerformed(evt);
            }
        });
        getContentPane().add(AnteriorConsulta, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 250, 70, 80));

        tblSancionados2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tblSancionados2);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 280, 420, 170));

        Atras.setBackground(new java.awt.Color(0, 0, 0));
        Atras.setFont(new java.awt.Font("Maiandra GD", 1, 14)); // NOI18N
        Atras.setForeground(new java.awt.Color(255, 255, 255));
        Atras.setText("Atrás");
        Atras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AtrasActionPerformed(evt);
            }
        });
        getContentPane().add(Atras, new org.netbeans.lib.awtextra.AbsoluteConstraints(1210, 40, 110, 30));

        Limpiar.setBackground(new java.awt.Color(0, 0, 0));
        Limpiar.setFont(new java.awt.Font("Maiandra GD", 1, 14)); // NOI18N
        Limpiar.setForeground(new java.awt.Color(255, 255, 255));
        Limpiar.setText("Limpiar");
        Limpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LimpiarActionPerformed(evt);
            }
        });
        getContentPane().add(Limpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 450, 110, 30));

        Fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Fondo.jpg"))); // NOI18N
        getContentPane().add(Fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, 1680, 810));
        getContentPane().add(NombreEquipoConsultas, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 120, 210, 30));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SiguienteConsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SiguienteConsultaActionPerformed
        VistaConsultaPremiacion vistaConsultaP = new VistaConsultaPremiacion();
        vistaConsultaP.run();
        this.setVisible(false);
    }//GEN-LAST:event_SiguienteConsultaActionPerformed

    private void AnteriorConsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AnteriorConsultaActionPerformed
        VistaConsultaJugador vistaConsultaJ = new VistaConsultaJugador();
        
        vistaConsultaJ.run();
        this.setVisible(false);
    }//GEN-LAST:event_AnteriorConsultaActionPerformed

    private void AtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AtrasActionPerformed
        this.setVisible(false);
        Main main = new Main();
        main.setVisible(true);
    }//GEN-LAST:event_AtrasActionPerformed

    private void ConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConsultarActionPerformed

        if(Amarillas.isSelected())
        {
            MostrarSancionados1(EquipoLocalSancionados.getText(),EquipoVisitaSancionados.getText());
        }
        
        if(Rojas.isSelected())
        {
            MostrarSancionados2(EquipoLocalSancionados.getText(),EquipoVisitaSancionados.getText());
        }
    }//GEN-LAST:event_ConsultarActionPerformed

    private void LimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LimpiarActionPerformed
        MostrarSancionados1("","");
        MostrarSancionados2("","");
        Amarillas.setSelected(false);
        Rojas.setSelected(false);
        EquipoLocalSancionados.setText("");
        EquipoVisitaSancionados.setText("");
    }//GEN-LAST:event_LimpiarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void run() {///cambiar a run
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
            java.util.logging.Logger.getLogger(VistaConsultaSancionados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaConsultaSancionados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaConsultaSancionados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaConsultaSancionados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VistaConsultaSancionados().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox Amarillas;
    private javax.swing.JButton AnteriorConsulta;
    private javax.swing.JButton Atras;
    private javax.swing.JButton Consultar;
    private javax.swing.JTextField EquipoLocalSancionados;
    private javax.swing.JTextField EquipoVisitaSancionados;
    private javax.swing.JLabel Fondo;
    private javax.swing.JButton Limpiar;
    private javax.swing.JTextField NombreEquipoConsultas;
    private javax.swing.JLabel NombreEquipoLocal;
    private javax.swing.JLabel NombreEquipoVisitante;
    private javax.swing.JCheckBox Rojas;
    private javax.swing.JButton SiguienteConsulta;
    private javax.swing.JScrollPane TablaSancionados;
    private javax.swing.JLabel Titulo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblSancionados;
    private javax.swing.JTable tblSancionados2;
    // End of variables declaration//GEN-END:variables
}
