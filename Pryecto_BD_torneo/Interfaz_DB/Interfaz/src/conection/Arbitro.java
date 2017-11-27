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
 * @author hassler-pc
 */
public class Arbitro {
    public Arbitro(){}
    public void AgregarArbitro(int id_arbitro, String nombre ,  String Apellido1 , String Apellido2, int tipo_de_arbitro){
        try {
            MySQL db = new MySQL();
            db.MySQLConnect();
            //Ejemplo de insert en esta tabla
            //INSERT INTO Arbitro(idArbitro,nombre,apellido1,apellido2,tipo_de_arbitro) VALUES(101,'Jose','Arboleda','Camacho',1);
            
            String Query = "INSERT INTO  Arbitro(idArbitro,nombre,apellido1,apellido2,tipo_de_arbitro) "
                    + "VALUES("+id_arbitro+","+"'"+nombre+"'"+","+"'"+Apellido1+"'"+","+"'"+Apellido2+"'"+","+tipo_de_arbitro+");";
            
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
    
    
    

