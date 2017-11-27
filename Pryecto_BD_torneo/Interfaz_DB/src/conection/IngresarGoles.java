/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conection;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author hassler-pc
 */
public class IngresarGoles {
    
    public IngresarGoles(){}
    
    public void ingGoles(String nombre, int numGoles){
         int goles = 0;
         try {
            MySQL db = new MySQL();
            db.MySQLConnect();
            //UPDATE Jugador SET num_goles = 3 WHERE nombre = 'Ronaldo';
            //UPDATE Jugador SET num_goles = 7 WHERE nombre = 'Ronaldo';
            MySQL db_2 = new MySQL();
            db_2.MySQLConnect();
            
            String Query2 = "select num_goles from Jugador WHERE nombre = " + "'" + nombre + "'" + ";";
            db_2.comando = db_2.conexion.createStatement();
            db_2.registro = db_2.comando.executeQuery(Query2);
            
            while (db_2.registro.next()) {
               
                goles = Integer.parseInt(db_2.registro.getString(1));
                        
            }
            goles+=numGoles;
            
            String Query = "UPDATE Jugador SET num_goles = " + goles + " WHERE nombre = " + "'" + nombre + "'" + ";";
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
