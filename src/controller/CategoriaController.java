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
import java.util.ArrayList;
import model.Categoria;

/**
 *
 * @author jodarove
 */
public class CategoriaController {
    private Connection cn = null;
    private Conexion mysql = new Conexion();
    
    public ArrayList<Categoria> index() throws SQLException{
        ArrayList<Categoria> categorias = new ArrayList<>();
        try {
            cn = mysql.conectar();
            Statement statement = cn.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM categoria");
            while (resultSet.next()) {                
                Categoria categoria = new Categoria();
                categoria.setNombre(resultSet.getString(2));
                categorias.add(categoria);
                System.out.println(categoria.getNombre());
            }
        } catch (Exception e) {
            System.err.println("Error in ArrayList<Categoria> Categoria controller: " + e);
        } finally{
            if(cn != null) cn.close();
        }
        return categorias;
    }
}
