/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */

package pe.gob.sunat.jmarket.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import pe.gob.sunat.jmarket.App;
import pe.gob.sunat.jmarket.dao.UsuarioDao;
import pe.gob.sunat.jmarket.idao.IUsuarioDao;

/**
 * FXML Controller class
 *
 * @author Anthony Ponte
 */
public class LoginController implements Initializable {

  @FXML private TextField txtUsuario;
  @FXML private PasswordField txtContrasena;
  @FXML private Button btnEntrar;
  private UsuarioDao dao;

  public LoginController() {
    dao = new IUsuarioDao();
  }

  /** Initializes the controller class. */
  @Override
  public void initialize(URL url, ResourceBundle rb) {
    btnEntrar.setOnAction(
        (ActionEvent t) -> {
          try {
            Stage stage = (Stage) btnEntrar.getScene().getWindow();
            stage.close();

            App.setScene(stage, "MainView", "JMarket", true);
          } catch (IOException ex) {
          }
        });
  }
}