/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conection;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;

/**
 *
 * @author josh
 */
public class MySQL_Test extends JTable {

    /**
     * @param args the command line arguments
     */
  
    public static void correr() {
        try {
            MySQL db = new MySQL();
            db.MySQLConnect();

            /* Se establece el nombre de la base de datos que contiene 
             la información que se quiere consultar
             */
            String Tabla;
            Tabla= "Jugador";
            
             /* Se establece la consulta que se desea hacer.
            Select se encargará de seleccionar todos los datos
            (representado por *) desde (FROM) la base de datos
            llamada "Registro"
             */
            
            String Query = "SELECT * FROM " + Tabla;
            
            
            /* Se crea una declaración y se establece el Query que se
            desea ejecutar
             */
            
            db.comando = db.conexion.createStatement();
            db.registro = db.comando.executeQuery(Query);

            /* Se imprimen los registros que estén guardados en 
            la base de datos
             */
            while (db.registro.next()) {
                
                System.out.println(db.registro.getString(db.registro.findColumn("nombre")));
                
                System.out.println("------------------------------------------");
            }
            db.close();
        } catch (SQLException ex) {
            Logger.getLogger(MySQL_Test.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
