package controller;

import database.DBUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.Departamento;

/**
 *
 * @author jodarove
 */
public class DepartamentoController {
    // Treamos todos los departamentos y los guardamos en un arraylist
    // como objetos.
    public static ArrayList<Departamento> getAll() throws Exception{
        String query = "SELECT * FROM departamentos ORDER BY id";
        ArrayList<Departamento> departamentos = new ArrayList<>();
        Connection connection = DBUtil.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery()){
            while (rs.next()) {                
                Departamento departamento = new Departamento();
                departamento.setId(rs.getInt("id"));
                departamento.setNombre(rs.getString("nombre"));
                departamentos.add(departamento);
            }
            return departamentos;
        } catch (Exception e) {
            System.err.println("getAll() Problema al hacer el mapping en DepartamentoController: " + e);
            throw e;
        } finally{
            DBUtil.closeConnection();
        }
    }
    
    public static Departamento get(int id) throws Exception{
        String query = "SELECT * FROM departamentos WHERE id = ?";
        Connection connection = DBUtil.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(query)){
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Departamento departamento = new Departamento();
                departamento.setId(rs.getInt("id"));
                departamento.setNombre(rs.getString("nombre"));
                return departamento;   
            } else {
                rs.close();
                return null;
            }
        } catch (Exception e) {
            System.err.println("get() Problema al hacer mapping en DepartamentoController: " + e);
            throw e;
        } finally{
            DBUtil.closeConnection();
        }
    }
    
    public static Departamento getByName(String nombre) throws Exception{
        String query = "SELECT * FROM departamentos WHERE nombre = ?";
        Connection connection = DBUtil.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(query)){
            ps.setString(1, nombre);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Departamento departamento = new Departamento();
                departamento.setId(rs.getInt("id"));
                departamento.setNombre(rs.getString("nombre"));
                return departamento;   
            } else {
                rs.close();
                return null;
            }
        } catch (Exception e) {
            System.err.println("get() Problema al hacer mapping en DepartamentoController: " + e);
            throw e;
        } finally{
            DBUtil.closeConnection();
        }
    }
    
    public static void add(Departamento departamento) throws Exception{
        String query = "INSERT INTO departamentos (nombre, created_at, updated_at) "
                + "VALUES (?, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP)";
        Connection connection = DBUtil.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(query)){
            ps.setString(1, departamento.getNombre());
            ps.executeUpdate();
        } catch (Exception e) {
            System.err.println("DepartamentoController problema al hacer el add(): " + e);
            throw e;
        } finally{
            DBUtil.closeConnection();
        }
    }
    
    public static void update(Departamento departamento) throws Exception{
        String query = "UPDATE departamentos SET "
                + "nombre = ?,"
                + "updated_at = CURRENT_TIMESTAMP "
                + "WHERE id = ?";
        Connection connection = DBUtil.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(query)){
            ps.setString(1, departamento.getNombre());
            ps.setLong(2, departamento.getId());
            ps.executeUpdate();
        } catch (Exception e) {
            System.err.println("problema al hacer update en DepartamentoController: " + e);
            throw e;
        } finally{
            DBUtil.closeConnection();
        }
    }
    
    public static void delete(Departamento departamento) throws Exception{
        String query = "DELETE FROM departamentos WHERE id = ?";
        Connection connection = DBUtil.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(query)){
            ps.setLong(1, departamento.getId());
            ps.executeUpdate();
        } catch (Exception e) {
            System.err.println("Algo paso en el delete del departamento: " +  e);
        } finally{
            DBUtil.closeConnection();
        }
        
    }
}
