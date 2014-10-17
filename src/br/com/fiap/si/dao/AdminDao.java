package br.com.fiap.si.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.fiap.si.factory.ConnectionFactory;

public class AdminDao {

	public boolean autenticar(String login, String senha){
		
		boolean isAtenticado = false;
		
		Connection conn = null;
		try {
			conn = ConnectionFactory.getConnection();
			
			String sql = "select * from usuarios where login = ? and senha = ?";
			
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, login);
			stmt.setString(2, senha);
			
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()){
				isAtenticado = true;
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally{
			try {
				conn.close();
			} catch (Exception e2) {
				System.out.println(e2.getMessage());
			}
		}
		
		return isAtenticado;
	}
	
}
