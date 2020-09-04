/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package database;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author jodarove
 */
public class Conexion {
    String db_user = "jromero";
    String db_pass = "978admin123";
    String db_name = "facturacion_development";
    String db_url = "jdbc:mysql://localhost:3306/" + db_name;
    
    public Connection conectar(){
        Connection link = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            link = DriverManager.getConnection(this.db_url, this.db_user, this.db_pass);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "La conexion a la base de datos no esta disponible. " + e);
        }
        return link;
    }    
}