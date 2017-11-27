/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conection;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


/**
 *
 * @author josh
 */
public class Equipo {
    private final String tabla;
    public Equipo(){
        tabla="Equipo";
    }
    
    
    public String[] Equipos_Finalistas(){
         String [] arr = new String[2];
         int i=0;
        try { MySQL db = new MySQL();
                db.MySQLConnect();
                String Query = "select nombre from Equipo group by idEquipo order by puntos DESC limit 2;";              
                db.comando = db.conexion.createStatement();
                db.registro = db.comando.executeQuery(Query);
                while (db.registro.next()) {               
                arr[i] = db.registro.getString(db.registro.findColumn("nombre")) ;
                i++;     
                db.close();
            }      
                return arr;
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error en los datos ingresados ", ex.getMessage(), JOptionPane.ERROR_MESSAGE);
                Logger.getLogger(MySQL_Test.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arr;
    }
    
    
    
    public void AgregarEquipo(int id, String nombre, String eslogan){
        try {
            MySQL db = new MySQL();
            db.MySQLConnect();
             
            int puntos=0;
            String Query = "INSERT INTO  "+ tabla+ "(idEquipo,nombre,eslogan,puntos) VALUES("+id+","+"'"+nombre+"'"+","+"'"+eslogan+"'"+","+puntos+");";
            //System.out.println(Query);  
            db.comando = db.conexion.createStatement();
            db.comando.executeUpdate(Query);
            JOptionPane.showMessageDialog(null, "Registo Exitoso");
            db.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en los datos ingresados ", ex.getMessage(), JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(MySQL_Test.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        
    public void ActulizarEquipo_Puntos_id(int id,int punt){
        try {
            MySQL db = new MySQL();
            db.MySQLConnect();
            String Query = "UPDATE Equipo set puntos = "+punt+ " WHERE idEquipo = "+id+";";
            //System.out.println(Query);  
            db.comando = db.conexion.createStatement();
            db.comando.executeUpdate(Query);
            JOptionPane.showMessageDialog(null, "Registo Exitoso");
            db.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en los datos ingresados ", ex.getMessage(), JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(MySQL_Test.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void ActualizarEquipo_Puntos_nombre(String nom, int punt){
        try {
            MySQL db = new MySQL();
            db.MySQLConnect();
            String Query = "UPDATE Equipo set puntos = "+punt+ " WHERE nombre = "+"'"+nom+"'"+";";
            //System.out.println(Query);  
            db.comando = db.conexion.createStatement();
            db.comando.executeUpdate(Query);
            JOptionPane.showMessageDialog(null, "Registo Exitoso");
            db.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en los datos ingresados ", ex.getMessage(), JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(MySQL_Test.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        
}
