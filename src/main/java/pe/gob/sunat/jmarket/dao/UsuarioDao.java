/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

package pe.gob.sunat.jmarket.dao;

import pe.gob.sunat.jmarket.model.Usuario;

/**
 * @author Anthony Ponte
 */
public interface UsuarioDao extends ObjectDao<Usuario> {
  Long validate(String nombreUsuario, String contrasena);
}
