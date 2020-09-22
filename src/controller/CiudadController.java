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
import model.Ciudad;

/**
 *
 * @author jodarove
 */
public class CiudadController {
    // Traemos todas las ciudades y lo asignamos a un arraylist como objetos.
    public static ArrayList<Ciudad> getAll() throws Exception{
        String query = "SELECT * FROM ciudads ORDER by id";
        ArrayList<Ciudad> ciudades = new ArrayList<>();
        Connection connection = DBUtil.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery()){
            while (rs.next()) {
                Ciudad ciudad = new Ciudad();
                ciudad.setId(rs.getInt("id"));
                ciudad.setNombre(rs.getString("nombre"));
                ciudad.setDepartamentoId(rs.getInt("departamento_id"));
            }
            return ciudades;
        } catch (Exception e) {
            System.err.println("Algo paso al querer traer todos las ciudades: " + e);
            throw e;
        } finally{
            DBUtil.closeConnection();
        }
    }
    
    public static Ciudad get(int id) throws Exception{
        String query = "SELECT * FROM ciudads WHERE id = ?";
        Connection connection = DBUtil.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(query)){
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Ciudad ciudad = new Ciudad();
                ciudad.setId(rs.getInt("id"));
                ciudad.setNombre(rs.getString("nombre"));
                ciudad.setDepartamentoId(rs.getInt("departamento_id"));
                return ciudad;
            }else{
                rs.close();
                return null;
            }
        } catch (Exception e) {
            System.err.println("Algo paso al hacer el get Ciudad: " + e);
            throw e;
        } finally{
            DBUtil.closeConnection();
        }
    }
    
    public static Ciudad getByName(String nombre) throws Exception{
        String query = "SELECT * FROM ciudads WHERE nombre = ?";
        Connection connection = DBUtil.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(query)){
            ps.setString(1, nombre);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Ciudad ciudad = new Ciudad();
                ciudad.setId(rs.getInt("id"));
                ciudad.setNombre(rs.getString("nombre"));
                ciudad.setDepartamentoId(rs.getInt("departamento_id"));
                return ciudad;
            } else{
                rs.close();
                return null;
            }
        } catch (Exception e) {
            System.err.println("Algo paso al hacer get Ciudad by name: " + e);
            throw e;
        } finally{
            DBUtil.closeConnection();
        }
    }
    
    public static void add(Ciudad ciudad) throws Exception {
        String query = "INSERT INTO ciudads (nombre, departamento_id, created_at, updated_at) "
                + "VALUES (?, ?, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP)";
        Connection connection = DBUtil.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(query)){
            ps.setString(1, ciudad.getNombre());
            ps.setInt(2, ciudad.getDepartamentoId());
            ps.executeUpdate();
        } catch (Exception e) {
            System.err.println("CiudadController problema al hacer add(): " + e);
            throw e;
        } finally{
            DBUtil.closeConnection();
        }
    }
    
    public static void update(Ciudad ciudad) throws Exception {
        String query = "UPDATE ciudads SET "
                + "nombre = ?, "
                + "departamento_id = ?, "
                + "updated_at = CURRENT_TIMESTAMP "
                + "WHERE id = ?";
        Connection connection = DBUtil.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(query)){
            ps.setString(1, ciudad.getNombre());
            ps.setLong(2, ciudad.getDepartamentoId());
            ps.setLong(3, ciudad.getId());
            ps.executeUpdate();
        } catch (Exception e) {
            System.err.println("problema al hacer update en CiudadController: " + e);
            throw e;
        } finally {
            DBUtil.closeConnection();
        }
    }
    public static void delete(Ciudad ciudad) throws Exception{
        String query = "DELETE FROM ciudads WHERE id = ?";
        Connection connection = DBUtil.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(query)){
            ps.setLong(1, ciudad.getId());
            ps.executeUpdate();
        } catch (Exception e) {
            System.err.println("Algo paso en el delete de la ciudad: " + e);
        } finally{
            DBUtil.closeConnection();
        }
    }
}
