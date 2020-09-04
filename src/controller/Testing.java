/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import database.Conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author jodarove
 */
public class Testing {
    
    public double getKilo(String codigo){
        double kilo = 0; //declaramos kilo y le asignamos el valor 0
//      Declaramos nueva variable para dividir el codigo
//      codigo barra ej: 0203000001354
//      objetivo es agarrar este: 00135
//      excluimos los 7 primeros caracteres
//      y el ultimo (el ultimo caracter estaria en la posicion 12
        String str = codigo.substring(7,12);        
        kilo = Double.parseDouble(str) / 1000; // El peso en gramos ahora lo dividimos con 1000 para convertir a kg
        return kilo;
    }
    
    public void getUsuarios() throws SQLException{
        String query = "SELECT * FROM usuarios";
        Conexion mysql = new Conexion(); 
        Connection cn = mysql.conectar();
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                System.out.println("Usuario: " + rs.getString("nombre"));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Problema en getUsuarios() " + e);
        } finally{
            if (cn != null) cn.close();
        }
    }
}
