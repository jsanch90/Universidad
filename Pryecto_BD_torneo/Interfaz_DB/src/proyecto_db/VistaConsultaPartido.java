/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_db;

import conection.MySQL;
import static java.lang.Integer.parseInt;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author usuario
 */
public class VistaConsultaPartido extends javax.swing.JFrame {

    /**
     * Creates new form VistaConsultaPartido
     */
    public VistaConsultaPartido() {
        initComponents();
        MostrarMarcador("","");
        MostrarCancha("", "");
        MostrarArbitroC("", "");
        MostrarArbitroL("","");
        MostrarArbitroCu("","");
        MostrarTiempo("","");
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
    
    
    public int idPartido_nom(int l,int v){
        int ide=0;
        try {
            MySQL db = new MySQL();
            db.MySQLConnect();
            
            db.comando = db.conexion.createStatement();
            db.registro = db.comando.executeQuery("SELECT idPartido FROM Partido where idEquipo_L = "+l+" AND idEquipo_V = "+v+";");
            
            while (db.registro.next()) {
                
                ide=parseInt((db.registro.getString(db.registro.findColumn("idPartido"))));
                                
            }
            db.close();
        } catch (SQLException ex) {
            Logger.getLogger(VistaConsultaEquipo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ide;
    }
    
    
    public void LlenarMarcador(int idPar){
        MySQL db = new MySQL();
        db.MySQLConnect();
        
        DefaultTableModel mod = new DefaultTableModel();
        mod.addColumn("Marcador");
        TablaMarcador.setModel(mod);
        
        try{
        db.comando = db.conexion.createStatement();
        db.registro = db.comando.executeQuery("SELECT marcador FROM Informe where idPartido = "+idPar+";");
        String [] datos = new String [1];
        while(db.registro.next()){
            datos[0]=db.registro.getString(1);
            mod.addRow(datos);
        }
        TablaMarcador.setModel(mod);
        db.close();
        }catch(Exception e){
            System.out.println(e);
        }
        db.close();
    }
    
    public int idCancha_par(int l, int v){
        int ide=0;
        try {
            MySQL db = new MySQL();
            db.MySQLConnect();
            
            db.comando = db.conexion.createStatement();
            db.registro = db.comando.executeQuery("SELECT idCancha FROM Partido where idEquipo_L = "+l+" AND idEquipo_V = "+v+";");
            
            while (db.registro.next()) {
                
                ide=parseInt((db.registro.getString(db.registro.findColumn("idCancha"))));
                                
            }
            db.close();
        } catch (SQLException ex) {
            Logger.getLogger(VistaConsultaEquipo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ide;
    }
    
    public void LlenarCancha(int idC){
        MySQL db = new MySQL();
        db.MySQLConnect();
        
        DefaultTableModel mod = new DefaultTableModel();
        mod.addColumn("Cancha");
        TablaCancha.setModel(mod);
        
        try{
        db.comando = db.conexion.createStatement();
        db.registro = db.comando.executeQuery("SELECT nombre FROM Cancha where idCancha = "+idC+";");
        System.out.println("SELECT nombre FROM Cancha where idCancha = "+idC+";");
        String [] datos = new String [1];
        while(db.registro.next()){
            datos[0]=db.registro.getString(1);
            mod.addRow(datos);
        }
        TablaCancha.setModel(mod);
        db.close();
        }catch(Exception e){
            System.out.println(e);
        }
        db.close();
    }
    
    
    public void LlenarArbitro_C(int idPar){
        MySQL db = new MySQL();
        db.MySQLConnect();
        
        DefaultTableModel mod = new DefaultTableModel();
        mod.addColumn("Nombre");
        mod.addColumn("Apellido 1");
        mod.addColumn("Apellido 2");
        TablaArbitroC.setModel(mod);
        
        try{
        db.comando = db.conexion.createStatement();
        db.registro = db.comando.executeQuery("SELECT Arbitro.nombre,Arbitro.apellido1,Arbitro.apellido2 "
                + "FROM Partido_Arbitro INNER JOIN Arbitro ON "
                + "Partido_Arbitro.idArbitro_C = Arbitro.idArbitro "
                + "AND Partido_Arbitro.idPartido="+idPar+";");
            System.out.println("SELECT Arbitro.nombre,Arbitro.apellido1,Arbitro.apellido2 "
                + "FROM Partido_Arbitro INNER JOIN Arbitro ON "
                + "Partido_Arbitro.idArbitro_C = Arbitro.idArbitro "
                + "AND Partido_Arbitro.idPartido="+idPar+";");
        String [] datos = new String [3];
        while(db.registro.next()){
            datos[0]=db.registro.getString(1);
            datos[1]=db.registro.getString(2);
            datos[2]=db.registro.getString(3);
            mod.addRow(datos);
        }
        TablaArbitroC.setModel(mod);
        db.close();
        }catch(Exception e){
            System.out.println(e);
        }
        db.close();
    }
    
    
    public void LlenarArbitro_L(int idPar){
        MySQL db = new MySQL();
        db.MySQLConnect();
        
        DefaultTableModel mod = new DefaultTableModel();
        mod.addColumn("Nombre");
        mod.addColumn("Apellido 1");
        mod.addColumn("Apellido 2");
        TablaArbitrosL.setModel(mod);
        
        try{
        db.comando = db.conexion.createStatement();
        db.registro = db.comando.executeQuery("SELECT Arbitro.nombre,Arbitro.apellido1,Arbitro.apellido2 "
                + "FROM Partido_Arbitro INNER JOIN Arbitro ON "
                + "Partido_Arbitro.idArbitro_L1 = Arbitro.idArbitro "
                + "AND Partido_Arbitro.idPartido="+idPar+";");
            System.out.println("SELECT Arbitro.nombre,Arbitro.apellido1,Arbitro.apellido2 "
                + "FROM Partido_Arbitro INNER JOIN Arbitro ON "
                + "Partido_Arbitro.idArbitro_C = Arbitro.idArbitro "
                + "AND Partido_Arbitro.idPartido="+idPar+";");
        String [] datos = new String [3];
        while(db.registro.next()){
            datos[0]=db.registro.getString(1);
            datos[1]=db.registro.getString(2);
            datos[2]=db.registro.getString(3);
            mod.addRow(datos);
        }
        TablaArbitrosL.setModel(mod);
        }catch(Exception e){
            System.out.println(e);
        }
        
        try{
        db.comando = db.conexion.createStatement();
        db.registro = db.comando.executeQuery("SELECT Arbitro.nombre,Arbitro.apellido1,Arbitro.apellido2 "
                + "FROM Partido_Arbitro INNER JOIN Arbitro ON "
                + "Partido_Arbitro.idArbitro_L2 = Arbitro.idArbitro "
                + "AND Partido_Arbitro.idPartido="+idPar+";");
            System.out.println("SELECT Arbitro.nombre,Arbitro.apellido1,Arbitro.apellido2 "
                + "FROM Partido_Arbitro INNER JOIN Arbitro ON "
                + "Partido_Arbitro.idArbitro_C = Arbitro.idArbitro "
                + "AND Partido_Arbitro.idPartido="+idPar+";");
        String [] datos = new String [3];
        while(db.registro.next()){
            datos[0]=db.registro.getString(1);
            datos[1]=db.registro.getString(2);
            datos[2]=db.registro.getString(3);
            mod.addRow(datos);
        }
        TablaArbitrosL.setModel(mod);
        }catch(Exception e){
            System.out.println(e);
        }
        db.close();
    }
    
    public void LlenarArbitro_Cu(int idPar){
        MySQL db = new MySQL();
        db.MySQLConnect();
        
        DefaultTableModel mod = new DefaultTableModel();
        mod.addColumn("Nombre");
        mod.addColumn("Apellido 1");
        mod.addColumn("Apellido 2");
        TablaArbitroCu.setModel(mod);
        
        try{
        db.comando = db.conexion.createStatement();
        db.registro = db.comando.executeQuery("SELECT Arbitro.nombre,Arbitro.apellido1,Arbitro.apellido2 "
                + "FROM Partido_Arbitro INNER JOIN Arbitro ON "
                + "Partido_Arbitro.idArbitro_Cuarto = Arbitro.idArbitro "
                + "AND Partido_Arbitro.idPartido="+idPar+";");
            System.out.println("SELECT Arbitro.nombre,Arbitro.apellido1,Arbitro.apellido2 "
                + "FROM Partido_Arbitro INNER JOIN Arbitro ON "
                + "Partido_Arbitro.idArbitro_C = Arbitro.idArbitro "
                + "AND Partido_Arbitro.idPartido="+idPar+";");
        String [] datos = new String [3];
        while(db.registro.next()){
            datos[0]=db.registro.getString(1);
            datos[1]=db.registro.getString(2);
            datos[2]=db.registro.getString(3);
            mod.addRow(datos);
        }
        TablaArbitroCu.setModel(mod);
        db.close();
        }catch(Exception e){
            System.out.println(e);
        }
        db.close();
    }
    
    
    public void LlenarTiempo(int idPar){
        MySQL db = new MySQL();
        db.MySQLConnect();
        
        DefaultTableModel mod = new DefaultTableModel();
        mod.addColumn("Tiempo");
        TablaTiempo.setModel(mod);
        
        try{
        db.comando = db.conexion.createStatement();
        db.registro = db.comando.executeQuery("SELECT tiempo FROM Partido where idPartido = "+idPar+";");
        String [] datos = new String [1];
        while(db.registro.next()){
            datos[0]=db.registro.getString(1);
            mod.addRow(datos);
        }
        TablaTiempo.setModel(mod);
        db.close();
        }catch(Exception e){
            System.out.println(e);
        }
        db.close();
    }
    
    public void MostrarTiempo(String eq1, String eq2){
        int l=idEquip_nom(eq1);
        int v=idEquip_nom(eq2);
        int idP = idPartido_nom(l, v);
        LlenarTiempo(idP);
    }
    
    public void MostrarArbitroCu(String eq1, String eq2){
        int l=idEquip_nom(eq1);
        int v=idEquip_nom(eq2);
        int idP = idPartido_nom(l, v);
        LlenarArbitro_Cu(idP);
    }

    
    public void MostrarArbitroC(String eq1, String eq2){
        int l=idEquip_nom(eq1);
        int v=idEquip_nom(eq2);
        int idP = idPartido_nom(l, v);
        LlenarArbitro_C(idP);
    }
    
    public void MostrarArbitroL(String eq1, String eq2){
        int l=idEquip_nom(eq1);
        int v=idEquip_nom(eq2);
        int idP = idPartido_nom(l, v);
        LlenarArbitro_L(idP);
    }
    
    public void MostrarMarcador(String eq1, String eq2){
        int l=idEquip_nom(eq1);
        int v=idEquip_nom(eq2);
        int idP = idPartido_nom(l, v);
        LlenarMarcador(idP);
        
    }
    
    public void MostrarCancha(String eq1, String eq2){
        int l=idEquip_nom(eq1);
        int v=idEquip_nom(eq2);
        int idCan = idCancha_par(l, v);
        LlenarCancha(idCan);
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
        EquipoVisitante = new javax.swing.JLabel();
        EquipoLocal = new javax.swing.JLabel();
        EquipoLocalConsulta = new javax.swing.JTextField();
        EquipoVisitaConsulta = new javax.swing.JTextField();
        Marcador = new javax.swing.JCheckBox();
        TCancha = new javax.swing.JCheckBox();
        Consultar = new javax.swing.JButton();
        ArbitroCentral = new javax.swing.JCheckBox();
        Tiempo = new javax.swing.JCheckBox();
        ArbitroLateral = new javax.swing.JCheckBox();
        CuartoArbitro = new javax.swing.JCheckBox();
        Atras = new javax.swing.JButton();
        SiguienteConsulta = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaMarcador = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        TablaCancha = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        TablaArbitroC = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        TablaArbitrosL = new javax.swing.JTable();
        jScrollPane5 = new javax.swing.JScrollPane();
        TablaArbitroCu = new javax.swing.JTable();
        jScrollPane6 = new javax.swing.JScrollPane();
        TablaTiempo = new javax.swing.JTable();
        Limpiar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Titulo.setFont(new java.awt.Font("Maiandra GD", 1, 36)); // NOI18N
        Titulo.setForeground(new java.awt.Color(255, 255, 255));
        Titulo.setText("Consultas de Partido");
        getContentPane().add(Titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 20, 440, 40));

        EquipoVisitante.setFont(new java.awt.Font("Maiandra GD", 1, 18)); // NOI18N
        EquipoVisitante.setForeground(new java.awt.Color(255, 255, 255));
        EquipoVisitante.setText("Equipo Visitante:");
        getContentPane().add(EquipoVisitante, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 60, 180, 30));

        EquipoLocal.setFont(new java.awt.Font("Maiandra GD", 1, 18)); // NOI18N
        EquipoLocal.setForeground(new java.awt.Color(255, 255, 255));
        EquipoLocal.setText("Equipo Local:");
        getContentPane().add(EquipoLocal, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 70, 160, 30));

        EquipoLocalConsulta.setFont(new java.awt.Font("Maiandra GD", 1, 18)); // NOI18N
        getContentPane().add(EquipoLocalConsulta, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 110, 200, 30));

        EquipoVisitaConsulta.setFont(new java.awt.Font("Maiandra GD", 1, 18)); // NOI18N
        getContentPane().add(EquipoVisitaConsulta, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 100, 200, 30));

        Marcador.setFont(new java.awt.Font("Maiandra GD", 1, 18)); // NOI18N
        Marcador.setForeground(new java.awt.Color(255, 255, 255));
        Marcador.setText("Marcador");
        getContentPane().add(Marcador, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 210, 190, 30));

        TCancha.setFont(new java.awt.Font("Maiandra GD", 1, 18)); // NOI18N
        TCancha.setForeground(new java.awt.Color(255, 255, 255));
        TCancha.setText("Cancha");
        getContentPane().add(TCancha, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 210, 200, 30));

        Consultar.setBackground(new java.awt.Color(0, 0, 0));
        Consultar.setFont(new java.awt.Font("Maiandra GD", 1, 18)); // NOI18N
        Consultar.setForeground(new java.awt.Color(255, 255, 255));
        Consultar.setText("Consultar");
        Consultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConsultarActionPerformed(evt);
            }
        });
        getContentPane().add(Consultar, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 80, 150, 60));

        ArbitroCentral.setFont(new java.awt.Font("Maiandra GD", 1, 18)); // NOI18N
        ArbitroCentral.setForeground(new java.awt.Color(255, 255, 255));
        ArbitroCentral.setText("Arbitro Central");
        getContentPane().add(ArbitroCentral, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 210, 210, 30));

        Tiempo.setFont(new java.awt.Font("Maiandra GD", 1, 18)); // NOI18N
        Tiempo.setForeground(new java.awt.Color(255, 255, 255));
        Tiempo.setText("Tiempo");
        getContentPane().add(Tiempo, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 250, 200, -1));

        ArbitroLateral.setFont(new java.awt.Font("Maiandra GD", 1, 18)); // NOI18N
        ArbitroLateral.setForeground(new java.awt.Color(255, 255, 255));
        ArbitroLateral.setText("Arbitros Laterales");
        getContentPane().add(ArbitroLateral, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 250, 210, 30));

        CuartoArbitro.setFont(new java.awt.Font("Maiandra GD", 1, 18)); // NOI18N
        CuartoArbitro.setForeground(new java.awt.Color(255, 255, 255));
        CuartoArbitro.setText("Cuarto Arbitro");
        getContentPane().add(CuartoArbitro, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 210, 200, 30));

        Atras.setBackground(new java.awt.Color(0, 0, 0));
        Atras.setFont(new java.awt.Font("Maiandra GD", 1, 18)); // NOI18N
        Atras.setForeground(new java.awt.Color(255, 255, 255));
        Atras.setText("Atrás");
        Atras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AtrasActionPerformed(evt);
            }
        });
        getContentPane().add(Atras, new org.netbeans.lib.awtextra.AbsoluteConstraints(1170, 20, 110, 30));

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

        TablaMarcador.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(TablaMarcador);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 370, 250, 50));

        TablaCancha.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(TablaCancha);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 370, 320, 50));

        TablaArbitroC.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane3.setViewportView(TablaArbitroC);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 370, 370, 50));

        TablaArbitrosL.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane4.setViewportView(TablaArbitrosL);

        getContentPane().add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 430, 370, 70));

        TablaArbitroCu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane5.setViewportView(TablaArbitroCu);

        getContentPane().add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 430, 320, 50));

        TablaTiempo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane6.setViewportView(TablaTiempo);

        getContentPane().add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 430, 250, 50));

        Limpiar.setBackground(new java.awt.Color(0, 0, 0));
        Limpiar.setFont(new java.awt.Font("Maiandra GD", 1, 18)); // NOI18N
        Limpiar.setForeground(new java.awt.Color(255, 255, 255));
        Limpiar.setText("Limpiar");
        Limpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LimpiarActionPerformed(evt);
            }
        });
        getContentPane().add(Limpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 560, 110, 30));

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Fondo.jpg"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1600, 780));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AtrasActionPerformed
        this.setVisible(false);
        Main main = new Main();
        main.setVisible(true);
    }//GEN-LAST:event_AtrasActionPerformed

    private void SiguienteConsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SiguienteConsultaActionPerformed
        VistaConsultaEquipo vistaConsultaE = new VistaConsultaEquipo();
        vistaConsultaE.run();
        this.setVisible(false);
    }//GEN-LAST:event_SiguienteConsultaActionPerformed

    private void ConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConsultarActionPerformed
        if(Marcador.isSelected()){
            MostrarMarcador(EquipoLocalConsulta.getText(), EquipoVisitaConsulta.getText());
        }
        
        if(TCancha.isSelected()){
            MostrarCancha(EquipoLocalConsulta.getText(), EquipoVisitaConsulta.getText());
        }
        
        if(ArbitroCentral.isSelected()){
            MostrarArbitroC(EquipoLocalConsulta.getText(), EquipoVisitaConsulta.getText());
        }
        
        if(ArbitroLateral.isSelected()){
            MostrarArbitroL(EquipoLocalConsulta.getText(), EquipoVisitaConsulta.getText());
        }
        
        if(CuartoArbitro.isSelected()){
            MostrarArbitroCu(EquipoLocalConsulta.getText(), EquipoVisitaConsulta.getText());
        }
        
        if(Tiempo.isSelected()){
            MostrarTiempo(EquipoLocalConsulta.getText(), EquipoVisitaConsulta.getText());
        }
    }//GEN-LAST:event_ConsultarActionPerformed

    private void LimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LimpiarActionPerformed
        MostrarMarcador("","");
        MostrarCancha("", "");
        MostrarArbitroC("", "");
        MostrarArbitroL("","");
        MostrarArbitroCu("","");
        MostrarTiempo("","");
        
        Marcador.setSelected(false);
        TCancha.setSelected(false);
        ArbitroCentral.setSelected(false);
        CuartoArbitro.setSelected(false);
        Tiempo.setSelected(false);
        ArbitroLateral.setSelected(false);
        
        EquipoLocalConsulta.setText("");
        EquipoVisitaConsulta.setText("");
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
            java.util.logging.Logger.getLogger(VistaConsultaPartido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaConsultaPartido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaConsultaPartido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaConsultaPartido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VistaConsultaPartido().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox ArbitroCentral;
    private javax.swing.JCheckBox ArbitroLateral;
    private javax.swing.JButton Atras;
    private javax.swing.JButton Consultar;
    private javax.swing.JCheckBox CuartoArbitro;
    private javax.swing.JLabel EquipoLocal;
    private javax.swing.JTextField EquipoLocalConsulta;
    private javax.swing.JTextField EquipoVisitaConsulta;
    private javax.swing.JLabel EquipoVisitante;
    private javax.swing.JButton Limpiar;
    private javax.swing.JCheckBox Marcador;
    private javax.swing.JButton SiguienteConsulta;
    private javax.swing.JCheckBox TCancha;
    private javax.swing.JTable TablaArbitroC;
    private javax.swing.JTable TablaArbitroCu;
    private javax.swing.JTable TablaArbitrosL;
    private javax.swing.JTable TablaCancha;
    private javax.swing.JTable TablaMarcador;
    private javax.swing.JTable TablaTiempo;
    private javax.swing.JCheckBox Tiempo;
    private javax.swing.JLabel Titulo;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    // End of variables declaration//GEN-END:variables
}
