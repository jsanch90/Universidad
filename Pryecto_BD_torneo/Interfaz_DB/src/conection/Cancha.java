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
public class Cancha {
    public Cancha(){}
    
    public void AgregarCancha(int id, int cap, int medida, String nom){
        try {
            MySQL db = new MySQL();
            db.MySQLConnect();
            
            String Query = "INSERT INTO  Cancha(idCancha,capacidad,medida,Nombre) VALUES("+id+","+cap+","+medida+","+"'"+nom+"'"+");";
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
    /**
    public static void main(String[] args) {
        Cancha ch=new Cancha();
        int i=4;
        int cap=34567;
        int med=23456;
        String nom="Rengifo";
        ch.AgregarCancha(i, cap, med, nom);
    }
    **/
}
