package br.com.fiap.si.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

import br.com.fiap.si.bean.Investidor;
import br.com.fiap.si.factory.ConnectionFactory;

public class InvestidorDAO {
	
	public void incluir(Investidor i) throws SQLException{
		
		Connection conn = ConnectionFactory.getConnection();
		
		String sql = "insert into investidor (id, nome, email, empresa, telefone, proposta, created_at) values(NULL, ?,?,?,?,?, now())";

		
		try{
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, i.getNome());
			stmt.setString(2, i.getEmpresa());
			stmt.setString(3, i.getEmail());
			stmt.setString(4, i.getTelefone());
			stmt.setFloat(5, i.getProposta());
			
			
			stmt.executeUpdate();
		}catch(SQLException ex){
			ex.printStackTrace();
		}finally{
			conn.close();
		}

	}
	
	public void excluir(Integer pk) throws SQLException{
		
			Connection conn = ConnectionFactory.getConnection();
			
			String sql = "delete from investidor where id = ?";
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
	
	public List<Investidor> listar()  throws SQLException{
		
		Connection conn = ConnectionFactory.getConnection();
		
		String sql = "select * from investidor order by nome";
		
		PreparedStatement stmt = conn.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();
		
		ArrayList<Investidor> investidores = new ArrayList<Investidor>();
		
		while(rs.next()){
			Investidor i = new Investidor();
			i.setNome(rs.getString("nome"));
			i.setEmpresa(rs.getString("empresa"));
			i.setEmail(rs.getString("email"));
			i.setTelefone(rs.getString("telefone"));
			i.setProposta(rs.getFloat("proposta"));
			investidores.add(i);
		}
		
		conn.close();
		
		return investidores;
	}
}
