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
 * @author acer
 */
public class Jugador {
   
    public Jugador()
    {}
    
    
    //Funciones de jugador
    
        //Agregar un jugador a la base de datos    
        public void AgregarJugador(int idJugador, String nombre, String apellido1, String apellido2, int numero, int num_goles, int estado, int idEquipo)
        {
        try {
            MySQL db = new MySQL();
            db.MySQLConnect();
            
            String Query = "INSERT INTO  Jugador(idJugador,nombre,apellido1,apellido2,numero,num_goles,estado,idEquipo) VALUES("+idJugador+","+"'"+
                    nombre+"'"+","+"'"+apellido1+"'"+","+"'"+apellido2+"'"+","+numero+","+num_goles+","+estado+","+idEquipo+");";
            System.out.println(Query);

            db.comando = db.conexion.createStatement();
            db.comando.executeUpdate(Query);
            JOptionPane.showMessageDialog(null, "Registo Exitoso");
            db.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en los datos ingresados ", ex.getMessage(), JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(MySQL_Test.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        // Fin de agregar jugador
        
        
        //Buscar jugador por ID 
       public void Buscar_JugadorID(int id)
       {
           try {
            MySQL db = new MySQL();
            db.MySQLConnect();
            
            String Query = "SELECT ";
            
            db.comando = db.conexion.createStatement();
            db.comando.executeUpdate(Query);
            db.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Jugador no encontrado", ex.getMessage(), JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(MySQL_Test.class.getName()).log(Level.SEVERE, null, ex);
        }
       
          
       }
            // Fin buscar jugador por nombre
       
       //Buscar jugador por ID 
       public void Buscar_JugadorNOM(String nom)
       {
           try {
            MySQL db = new MySQL();
            db.MySQLConnect();
            
            String Query = "SELECT ";
            
            db.comando = db.conexion.createStatement();
            db.comando.executeUpdate(Query);
            db.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Jugador no encontrado", ex.getMessage(), JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(MySQL_Test.class.getName()).log(Level.SEVERE, null, ex);
        }
       
          
       }
            // Fin buscar jugador por nombre
           
           // Actualizar Jugador número de goles
           public void ActualizarGoles_id(int id, int num)
           {
                try {
            MySQL db = new MySQL();
            db.MySQLConnect();
            
            String Query = "UPDATE Jugador set num_goles="+num+"WHERE idJugador="+id+";";
            
            db.comando = db.conexion.createStatement();
            db.comando.executeUpdate(Query);
            
            JOptionPane.showMessageDialog(null, "Actualización Exitosa");
            db.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Jugador no encontrado", ex.getMessage(), JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(MySQL_Test.class.getName()).log(Level.SEVERE, null, ex);
        }
               
        }
           
           
            public void ActualizarGoles_Nom(String nom, String ap, int num)
           {
                try {
            MySQL db = new MySQL();
            db.MySQLConnect();
            
            String Query = "UPDATE Jugador set num_goles="+num+"WHERE nombre="+"'"+nom+"'"+" AND apellido1= "+"'"+ap+"'"+";";
            
            db.comando = db.conexion.createStatement();
            db.comando.executeUpdate(Query);
            
            JOptionPane.showMessageDialog(null, "Actualización Exitosa");
            db.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Jugador no encontrado", ex.getMessage(), JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(MySQL_Test.class.getName()).log(Level.SEVERE, null, ex);
        }
               
        }
} //Finale
        
        
    
    
    

