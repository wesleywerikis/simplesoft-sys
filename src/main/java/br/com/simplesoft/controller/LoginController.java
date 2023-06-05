package br.com.simplesoft.controller;

import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import br.com.simplesoft.dal.ModelConnection;
import br.com.simplesoft.entity.User;
import br.com.simplesoft.repository.UserRepository;
import br.com.simplesoft.view.Login;
import br.com.simplesoft.view.Menu;

public class LoginController {
    private Connection connection;

    private Login loginView;

    public LoginController(Login loginView) {
        this.loginView = loginView;
        this.connection = ModelConnection.getConnection();
    }

    public void logar() {
        String username = loginView.getUsername();
        String password = new String(loginView.getPassword());
        try {
        	UserRepository userRepository = new UserRepository();
        	User user1 = userRepository.buscarPorLoginESenha(username, password);
            if (user1 != null) {
            	Menu.main(null);
                loginView.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Usuário e/ou senha inválido", password, JOptionPane.WARNING_MESSAGE, null);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao realizar login: ", password, JOptionPane.ERROR_MESSAGE, null);
        } finally {
            ModelConnection.closeConnection();
        }
    }


    public void closeConnection() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
