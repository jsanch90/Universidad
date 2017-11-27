/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools,Templates
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
public class VariadosPartido {
    public boolean check = false;
    /*
        Equipo Local , Equipo Visitante, identificacion , tiempo , pertenecen a Partido
        Marcador , identificacion , --diferente--idInforme  pertenecen a Informe
        Los 4 arbitros e Identificacion pertenecen a Partido_Arbitro  
        Sancionados 
    */
    
    public VariadosPartido(){}
    
    public void agregarPartido(String EqLocal, String EqVisitante, String cancha, int identificacion, int tiempo){

        int [] arr = new int[2];
        int i = 0;
        int idCancha = 0;
        try {
            MySQL db = new MySQL();
            db.MySQLConnect();
            MySQL db_2 = new MySQL();
            db_2.MySQLConnect();
            MySQL db_3 = new MySQL();
            db_3.MySQLConnect();
            
            String Query2 = "select idEquipo from Equipo where nombre = "+ "'" + EqLocal + "'" + "or nombre=" +"'"+ EqVisitante +"'"+";"; 
            db_2.comando = db_2.conexion.createStatement();
            db_2.registro = db_2.comando.executeQuery(Query2);
            
            String Query3 = "select idCancha from Cancha where nombre = " + "'" + cancha +"'" + ";";
            db_3.comando = db_3.conexion.createStatement();
            db_3.registro = db_3.comando.executeQuery(Query3);
            
            
                  
            while (db_2.registro.next()) {
               
                arr[i] = Integer.parseInt(db_2.registro.getString(1));
                i++;         
            }
            
         
    
            while (db_3.registro.next()){
                idCancha = Integer.parseInt(db_3.registro.getString(1));
            }
            
            String Query = "INSERT INTO  Partido( idPartido,idEquipo_L,idEquipo_V,tiempo,idCancha ) "
                 + "VALUES("+identificacion+","+ arr[0] +"," + arr[1] + "," + tiempo + "," + idCancha + ")";
            
            db.comando = db.conexion.createStatement();
            db.comando.executeUpdate(Query); 
            
            //db.comando = db.conexion.createStatement();
            //db.comando.executeUpdate(Query);
            //JOptionPane.showMessageDialog(null, "Registo Exitoso");
            db.close();
            db.close();
            db.close();
        } catch (SQLException ex) {
            check = true;
            JOptionPane.showMessageDialog(null, "Error en los datos ingresados ", ex.getMessage(), JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(MySQL_Test.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void agregarPartidoArbitro(int idPartido, int idArbitroC, int idArbitroL1, int idArbitroL2, int idArbitroCuarto){
        try {
            MySQL db = new MySQL();
            db.MySQLConnect();
            
            String Query = "INSERT INTO  Partido_Arbitro(idPartido , idArbitro_C , idArbitro_L1 , idArbitro_L2 , idArbitro_Cuarto) "
                    + "VALUES("+idPartido+","+idArbitroC+","+idArbitroL1+","+idArbitroL2+","+idArbitroCuarto+");";
            //System.out.println(Query);  
            db.comando = db.conexion.createStatement();
            db.comando.executeUpdate(Query);
           // JOptionPane.showMessageDialog(null, "Registo Exitoso");
           db.close();
        } catch (SQLException ex) {
            check = true;
            JOptionPane.showMessageDialog(null, "Error en los datos ingresados ", ex.getMessage(), JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(MySQL_Test.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void agregarInforme(int id, String marcador){
        try {
            MySQL db = new MySQL();
            db.MySQLConnect();
            
            String Query = "INSERT INTO  Informe( idInforme , idPartido , marcador) "
                    + "VALUES("+id+","+id+ ","+"'"+marcador+ "'" +   ");";
            //System.out.println(Query);  
            db.comando = db.conexion.createStatement();
            db.comando.executeUpdate(Query);
            if (check == false) JOptionPane.showMessageDialog(null, "Registo Exitoso");
            
          db.close();
        } catch (SQLException ex) {
            
            JOptionPane.showMessageDialog(null, "Error en los datos ingresados ", ex.getMessage(), JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(MySQL_Test.class.getName()).log(Level.SEVERE, null, ex);
        }  
    }
    
    public void SumarPuntos(String EquipoLocal,String EquipoVisitante,String Marcador){
        System.out.println(Marcador);
        System.out.println(Marcador.length());
        try {
            MySQL db = new MySQL();
            db.MySQLConnect();
            char [] marcadorPartido = Marcador.toCharArray();
            int EquipoLocalGoles = marcadorPartido[0];
            int EquipoVisitanteGoles = marcadorPartido[2];
        
            if(EquipoLocalGoles>EquipoVisitanteGoles){
                String Query = "Update Equipo set puntos = puntos+3  where Nombre=" + "'" + EquipoLocal + "' ;" ;
                db.comando = db.conexion.createStatement();
                db.comando.executeUpdate(Query);
            }
            else if(EquipoLocalGoles<EquipoVisitanteGoles){
                String Query2 = "update Equipo set puntos = puntos+3  where Nombre=" + "'" + EquipoVisitante + "' ;" ;
                db.comando = db.conexion.createStatement();
                db.comando.executeUpdate(Query2);
            }
            else{
                String Query3 = "update Equipo set puntos = puntos+1  where Nombre=" + "'" + EquipoLocal + "' or Nombre='" + EquipoVisitante + "';";
                db.comando = db.conexion.createStatement();
                db.comando.executeUpdate(Query3);
            }db.close();
                    } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en los datos ingresados ", ex.getMessage(), JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(MySQL_Test.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}