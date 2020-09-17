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
}
