package br.com.simplesoft.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.simplesoft.dal.ModelConnection;
import br.com.simplesoft.entity.User;


public class UserRepository {
	
	public User buscarPorLoginESenha(String username, String password) throws SQLException {
		String sql = "SELECT id, user, password FROM tbuser WHERE user=? AND password=?";
		try (Connection connection = ModelConnection.getConnection();
				PreparedStatement pst = connection.prepareStatement(sql)) {
			pst.setString(1, username);
			pst.setString(2, password);
			
			try (ResultSet rs = pst.executeQuery()) {
				if (rs.next()) {
					User user1 = new User();
					user1.setId(rs.getLong("id"));
					user1.setUser(rs.getString("user"));
					user1.setPassword(rs.getString("password"));
					return user1;
				} else {
					return null;
				}
			}
		}
	}

}
