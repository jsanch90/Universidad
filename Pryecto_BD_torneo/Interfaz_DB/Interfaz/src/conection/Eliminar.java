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
 * @author usuario
 */
public class Eliminar {
    public Eliminar(){}
    public void EliminarPartido(int Identificacion){
    try {
            MySQL db = new MySQL();
            db.MySQLConnect();
            
            String Query = "DELETE FROM Partido WHERE IdPartido = "+ Identificacion + ";";
            db.comando = db.conexion.createStatement();
            db.comando.executeUpdate(Query);
             System.out.println("Llegoaaa");
            JOptionPane.showMessageDialog(null, "Elimnacion Exitoso");
            db.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en los datos ingresados ", ex.getMessage(), JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(MySQL_Test.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void EliminarJugador(int Identificacion){
    try {
            MySQL db = new MySQL();
            db.MySQLConnect();
            
            String Query = "DELETE FROM Jugador WHERE IdJugador = "+ Identificacion + ";";
            db.comando = db.conexion.createStatement();
            db.comando.executeUpdate(Query);
            JOptionPane.showMessageDialog(null, "Eliminación Exitoso");
            db.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en los datos ingresados ", ex.getMessage(), JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(MySQL_Test.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void EliminarEquipo(int Identificacion){
    try {
            MySQL db = new MySQL();
            db.MySQLConnect();
            
            String Query = "DELETE FROM Equipo WHERE idEquipo="+Identificacion+";";
            System.out.println(Query);
            db.comando = db.conexion.createStatement();
            db.comando.executeUpdate(Query);
            JOptionPane.showMessageDialog(null, "Eliminación Exitosa");
            db.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en los datos ingresados ", ex.getMessage(), JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(MySQL_Test.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void EliminarArbitro(int Identificacion){
    try {
            MySQL db = new MySQL();
            db.MySQLConnect();
            
            String Query = "DELETE FROM Arbitro WHERE IdArbitro = "+ Identificacion + ";";
            db.comando = db.conexion.createStatement();
            db.comando.executeUpdate(Query);
            JOptionPane.showMessageDialog(null, "Eliminación Exitosa");
            db.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en los datos ingresados ", ex.getMessage(), JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(MySQL_Test.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void EliminarCancha(int Identificacion){
    try {
            MySQL db = new MySQL();
            db.MySQLConnect();
            
            String Query = "DELETE FROM Cancha WHERE IdCancha = "+ Identificacion + ";";
            db.comando = db.conexion.createStatement();
            db.comando.executeUpdate(Query);
            JOptionPane.showMessageDialog(null, "Eliminación Exitosa");
            db.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en los datos ingresados ", ex.getMessage(), JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(MySQL_Test.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void EliminarPartidoFinal(int Identificacion){
    try {
            MySQL db = new MySQL();
            db.MySQLConnect();
            
            String Query = "DELETE FROM Partido_Final WHERE IdEquipo_Campeon = "+Identificacion+";";
            db.comando = db.conexion.createStatement();
            db.comando.executeUpdate(Query);
            JOptionPane.showMessageDialog(null, "Eliminación Exitosa");
            db.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en los datos ingresados ", ex.getMessage(), JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(MySQL_Test.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}