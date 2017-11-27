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
public class Partido {
    public Partido(){}
    
    public void Crear_Partido(int idP, int eq1, int eq2,int tiempo, int idC ){
        try {
            MySQL db = new MySQL();
            db.MySQLConnect();
            
            String Query = "INSERT INTO  Partido(idPartido,idEquipo_L,idEquipo_V,tiempo,idCancha) VALUES("+idP+","+eq1+","+eq2+","+tiempo+","+idC+");";
            //System.out.println(Query);  
            db.comando = db.conexion.createStatement();
            db.comando.executeUpdate(Query);
        db.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en los datos ingresados ", ex.getMessage(), JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(MySQL_Test.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void  IngresarPartidoFinal(String EquipoLocal,String EquipoVisitante,String Marcador){
        String cadena = "";
        int i=0;
        int [] arr = new int[2];
        try {
            MySQL db = new MySQL();
            db.MySQLConnect();
            
            String Query2 = "select idEquipo from Equipo where nombre = "+ "'" + EquipoLocal + "'" + "or nombre=" +"'"+ EquipoVisitante +"'"+";"; 
            db.comando = db.conexion.createStatement();
            db.registro = db.comando.executeQuery(Query2);
            while (db.registro.next()) {
                cadena += db.registro.getString(1);
                arr[i] = Integer.parseInt(db.registro.getString(1));
                i++;         
            }
            String Query = "INSERT INTO  Partido_Final( idEquipo_Campeon,idEquipo_SubCampeon,idJugador_Goleador,Marcador) "
                 + "VALUES("+arr[0] +","+ arr[1] + "," + 1000 + "," +"'"+Marcador +"'"+ ");";
            System.out.println(Query);
            
            db.comando = db.conexion.createStatement();
            db.comando.executeUpdate(Query); 
        db.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en los datos ingresados ", ex.getMessage(), JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(MySQL_Test.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
