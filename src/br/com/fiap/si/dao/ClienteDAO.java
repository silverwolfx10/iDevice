package br.com.fiap.si.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.si.bean.Cliente;
import br.com.fiap.si.factory.ConnectionFactory;

public class ClienteDAO {
	
	public void incluir(Cliente c) throws SQLException{
		
		Connection conn = ConnectionFactory.getConnection();
		
		String sql = "insert into cliente (id, nome, email, telefone, quantidade) values(NULL,?,?,?,?)";
		try{
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, c.getNome());
			stmt.setString(2, c.getEmail());
			stmt.setString(3, c.getTelefone());
			stmt.setInt(4, c.getQuantidade());
			stmt.executeUpdate();
		
		}catch(SQLException ex){
			ex.printStackTrace();
		}finally{
			conn.close();
		}

	}
	
	public void excluir(Integer pk) throws SQLException{
		
		Connection conn = ConnectionFactory.getConnection();
		
		String sql = "delete from cliente where id = ?";
		try{
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, pk);
					
			stmt.executeUpdate();
		}catch(SQLException ex){
			ex.printStackTrace();
		}finally{
			conn.close();
		}

	}
	
	public List<Cliente> listar()  throws SQLException{
		
		Connection conn = ConnectionFactory.getConnection();
		
		String sql = "select * from cliente order by nome";
		
		PreparedStatement stmt = conn.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();
		
		ArrayList<Cliente> clientes = new ArrayList<Cliente>();
		
		while(rs.next()){
			Cliente c = new Cliente();
			c.setNome(rs.getString("nome"));
			c.setEmail(rs.getString("email"));
			c.setTelefone(rs.getString("telefone"));
			c.setQuantidade(rs.getInt("quantidade"));
			c.setCreatedAt(rs.getDate("created_at"));
			clientes.add(c);
		}
		
		conn.close();
		
		return clientes;
	}
	
	public Integer getQuantidade()  throws SQLException{
		
		Connection conn = ConnectionFactory.getConnection();
		
		String sql = "select count(id) as qtd from cliente";
		
		PreparedStatement stmt = conn.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();
		
		Integer qtd = 0;
		
		while(rs.next()){
			qtd = rs.getInt("qtd");
		}
		
		conn.close();
		
		return qtd;
	}
	
public Integer getQuantidadeItens()  throws SQLException{
		
		Connection conn = ConnectionFactory.getConnection();
		
		String sql = "select SUM(quantidade) as total from cliente";
		
		PreparedStatement stmt = conn.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();
		
		Integer total = 0;
		
		while(rs.next()){
			total = rs.getInt("total");
		}
		
		conn.close();
		
		return total;
	}
}
