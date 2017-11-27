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
public class IngresarSancionados {
    public IngresarSancionados(){}
    
    public void ingSancionados(String nombre,int tipo,int partido){
    // EL id del informe es igual 
    try {
            int id = 0;
            int idSancion = 0;
            MySQL db = new MySQL();
            db.MySQLConnect();
            
            MySQL db_2 = new MySQL();
            db_2.MySQLConnect();
            
            MySQL db_3 = new MySQL();
            db_3.MySQLConnect();
            
            String Query3 = "select max(idSancionados) from Sancionados;";
            
            db_3.comando = db_3.conexion.createStatement();
            db_3.registro = db_3.comando.executeQuery(Query3);
            
               while(db_3.registro.next()){
                idSancion = Integer.parseInt(db_3.registro.getString(1));   
                
            }
               System.out.println(idSancion);
               idSancion++;
            
            //select idJugador from Jugador where nombre = 'Ronaldo';
            String Query2 = "SELECT idJugador from Jugador where nombre =" + "'" + nombre + "'"+";";
                    
            db_2.comando = db_2.conexion.createStatement();
            db_2.registro = db_2.comando.executeQuery(Query2);
            
            while(db_2.registro.next()){
                id = Integer.parseInt(db_2.registro.getString(1));      
            }
            System.out.println(id);
            //idSancionados | tipo_sancion | idJugador | idInforme
            System.out.println("lasdasnfkajbfjabfjhasdbfksbdf");
            //String Query = "INSERT INTO  Cancha(idCancha,capacidad,medida,Nombre) VALUES("+id+","+cap+","+medida+","+"'"+nom+"'"+");";
            String Query = "INSERT INTO Sancionados (idSancionados,tipo_sancion,idJugador,idInforme) "
                    + "VALUES (" +idSancion +"," + tipo +"," +id+ "," +partido +");";
            //System.out.println(Query);  
            db.comando = db.conexion.createStatement();
            db.comando.executeUpdate(Query);
            JOptionPane.showMessageDialog(null, "Registo Exitoso");
            db.close();
            db.close();
            db.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en los datos ingresados ", ex.getMessage(), JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(MySQL_Test.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

   
}
