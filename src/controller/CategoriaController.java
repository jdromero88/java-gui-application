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
import java.util.ArrayList;
import model.Categoria;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author jodarove
 */
public class CategoriaController {
    public static ArrayList<Categoria> getAll() throws Exception{
        // nuevo codigo
        String query = "SELECT * FROM categoria ORDER BY id";
        ArrayList<Categoria> categorias = new ArrayList<>();
        Connection connection = DBUtil.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery(query)){
            while (rs.next()) {                
                Categoria categoria = new Categoria();
                categoria.setId(rs.getInt("id"));
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
    
    public static Categoria get(int id) throws Exception{
        String query = "SELECT * FROM categoria WHERE id = ?";
        Connection connection = DBUtil.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(query)){
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Categoria categoria = new Categoria();
                categoria.setId(rs.getInt("id"));
                categoria.setNombre(rs.getString("nombre"));
                return categoria;
            } else{
                rs.close();
                return null;
            }
        } catch (Exception e) {
            throw e;
        } finally{
            DBUtil.closeConnection();
        }
    }
    
    public static Categoria getByName(String nombre) throws Exception{
        String query = "SELECT * FROM categoria WHERE nombre = ?";
        Connection connection = DBUtil.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(query)){
            ps.setString(1, nombre);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Categoria categoria = new Categoria();
                categoria.setId(rs.getInt("id"));
                categoria.setNombre(rs.getString("nombre"));
                return categoria;
            } else{
                rs.close();
                return null;
            }
        } catch (Exception e) {
            throw e;
        } finally{
            DBUtil.closeConnection();
        }
    }    
    
    public static void add(Categoria categoria) throws Exception{
        String query = "INSERT INTO categoria (nombre, created_at, updated_at) VALUES (?, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP)";
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
    
    public static void update(Categoria categoria) throws Exception{
        String query = "UPDATE categoria SET "
                + "nombre = ?, "
                + "updated_at = CURRENT_TIMESTAMP "
                + "WHERE id = ?";
        Connection connection = DBUtil.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(query)){
            ps.setString(1, categoria.getNombre());
            ps.setLong(2, categoria.getId());
            ps.executeUpdate();
        } catch (Exception e) {
            System.err.println("Algo paso en el update: " + e);
        } finally{
            DBUtil.closeConnection();
        }
    }
    
    public static void delete(Categoria categoria) throws Exception{
        String query = "DELETE FROM categoria WHERE id = ?";
        Connection connection = DBUtil.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(query)){
            ps.setLong(1, categoria.getId());
            ps.executeUpdate();
        } catch (Exception e) {
            System.err.println("Algo paso en el delete: " + e);
        } finally{
            DBUtil.closeConnection();
        }
    }
}
