/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package pe.gob.sunat.jmarket.idao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import pe.gob.sunat.jmarket.dao.UsuarioDao;
import pe.gob.sunat.jmarket.model.Usuario;
import pe.gob.sunat.jmarket.util.MyHsqldbConnection;

/**
 * @author Anthony Ponte
 */
public class IUsuarioDao implements UsuarioDao {
  private final MyHsqldbConnection database;

  public IUsuarioDao() {
    this.database = new MyHsqldbConnection();
  }

  @Override
  public Long create(Usuario usuario) {
    Long id = 0L;

    database.connect();

    String query =
        "INSERT INTO USUARIO (NOMBRE_USUARIO, CONTRASENA, ESTADO, PERSONA_ID) VALUES (?, ?, ?, ?)";

    try (PreparedStatement ps =
        database.getConnection().prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS)) {

      ps.setString(1, usuario.getNombreUsuario());
      ps.setString(2, usuario.getContrasena());
      ps.setInt(3, usuario.getEstado());
      ps.setLong(4, usuario.getPersona().getId());
      ps.executeUpdate();

      try (ResultSet rs = ps.getGeneratedKeys()) {
        while (rs.next()) {
          id = rs.getLong(1);
        }
      }

    } catch (SQLException ex) {
      Logger.getLogger(IUsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
    }

    database.disconnect();

    return id;
  }

  @Override
  public Usuario read(Long id) {
    throw new UnsupportedOperationException("Not supported yet."); // Generated from
    // nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
  }

  @Override
  public List<Usuario> read() {
    List<Usuario> list = new ArrayList<>();

    database.connect();

    String query = "SELECT ID, NOMBRE_USUARIO, CONTRASENA, ESTADO FROM USUARIO ORDER BY ID DESC";

    try (PreparedStatement ps = database.getConnection().prepareStatement(query)) {
      try (ResultSet rs = ps.executeQuery()) {
        while (rs.next()) {
          Usuario usuario = new Usuario();
          usuario.setId(rs.getLong(1));
          usuario.setNombreUsuario(rs.getString(2));
          usuario.setContrasena(rs.getString(3));
          usuario.setEstado(rs.getInt(4));
          list.add(usuario);
        }
      }
    } catch (SQLException ex) {
      Logger.getLogger(IUsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
    }

    database.disconnect();

    return list;
  }

  @Override
  public void update(Usuario usuario) {
    throw new UnsupportedOperationException("Not supported yet."); // Generated from
    // nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
  }

  @Override
  public void delete(Long id) {
    throw new UnsupportedOperationException("Not supported yet."); // Generated from
    // nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
  }
}
