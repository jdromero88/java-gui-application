/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import database.DBUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.util.ArrayList;
import model.Categoria;

/**
 *
 * @author jodarove
 */
public class CategoriaController {
    private static LocalDateTime createAt;
    private static LocalDateTime updateAt;
    public ArrayList<Categoria> index() throws Exception{
        // nuevo codigo
        String query = "SELECT * FROM categoria";
        ArrayList<Categoria> categorias = new ArrayList<>();
        Connection connection = DBUtil.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery(query)){
            while (rs.next()) {                
                Categoria categoria = new Categoria();
                categoria.setNombre(rs.getString("nombre"));
                categorias.add(categoria);
            }
            return categorias;
        } catch (Exception e) {
            throw e;
        } finally{
            DBUtil.closeConnection();
        }
    }
    
    public static void add(Categoria categoria) throws Exception{
        //Seteamos la fecha hora local
        createAt = LocalDateTime.now();
        String query = "INSERT INTO categoria (nombre, created_at, updated_at) VALUES (?, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP())";
        Connection connection = DBUtil.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(query)){
            ps.setString(1, categoria.getNombre());
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally{
            DBUtil.closeConnection();
        }
    }
}
