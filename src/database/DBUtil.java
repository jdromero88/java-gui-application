/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author jodarove
 */
public class DBUtil {
    private static Connection connection;

    private DBUtil() {
    }
    
    public static synchronized Connection getConnection() throws Exception{
        if (connection != null) {
            return connection;
        }else{
            try {
                String db_user = "jromero";
                String db_pass = "978admin123";
                String db_name = "facturacion_development";
                String db_url = "jdbc:mysql://localhost:3306/" + db_name;
                
                connection = DriverManager.getConnection(db_url, db_user, db_pass);
                return connection;
            } catch (SQLException e) {
                throw e;
            }
        }
    }
    
    public static synchronized void closeConnection() throws Exception{
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                throw e;
            } finally{
                connection = null;
            }
        }
    }
    
}
