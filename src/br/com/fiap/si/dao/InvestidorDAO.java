package br.com.fiap.si.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
			i.setCreatedAt(rs.getDate("created_at"));
			investidores.add(i);
		}
		
		conn.close();
		
		return investidores;
	}
	
	public List<Investidor> listar(String nome, String dataDe, String dataAte)  throws SQLException, ParseException{
		
		Connection conn = ConnectionFactory.getConnection();
		
		String sql = "select * from investidor where 1=1 ";

		if(nome != null && !nome.equals(""))
			sql += " and nome like ? ";
		
		if(dataDe != null && !dataDe.equals("") && dataAte != null && !dataAte.equals(""))
			sql += " and created_at > ? and created_at < ? ";
		
		sql += "order by nome";
		
		PreparedStatement stmt = conn.prepareStatement(sql);
		
		int cont = 0;
		
		if(nome != null && !nome.equals(""))
			stmt.setString(++cont, nome+"%");
		
		if(dataDe != null && !dataDe.equals("") && dataAte != null && !dataAte.equals("")){
			
			DateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");  
			java.sql.Date de = new java.sql.Date(fmt.parse(dataDe).getTime());
			java.sql.Date ate = new java.sql.Date(fmt.parse(dataAte).getTime());
			
			stmt.setDate(++cont, new java.sql.Date(de.getTime()));
			
			stmt.setDate(++cont, new java.sql.Date(ate.getTime()));
		}
		
		ResultSet rs = stmt.executeQuery();
		ArrayList<Investidor> investidores = new ArrayList<Investidor>();
		
		while(rs.next()){
			Investidor i = new Investidor();
			i.setNome(rs.getString("nome"));
			i.setEmpresa(rs.getString("empresa"));
			i.setEmail(rs.getString("email"));
			i.setTelefone(rs.getString("telefone"));
			i.setProposta(rs.getFloat("proposta"));
			i.setCreatedAt(rs.getDate("created_at"));
			investidores.add(i);
		}
		
		conn.close();
		
		return investidores;
	}
	
	public Integer getQuantidade()  throws SQLException{
		
		Connection conn = ConnectionFactory.getConnection();
		
		String sql = "select count(id) as qtd from investidor";
		
		PreparedStatement stmt = conn.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();
		
		Integer qtd = 0;
		
		while(rs.next()){
			qtd = rs.getInt("qtd");
		}
		
		conn.close();
		
		return qtd;
	}
	
public Float getMediaPropostas()  throws SQLException{
		
		Connection conn = ConnectionFactory.getConnection();
		
		String sql = "select SUM(proposta)/count(id) as media from investidor";
		
		PreparedStatement stmt = conn.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();
		
		Float media = (float) 0;
		
		while(rs.next()){
			media = rs.getFloat("media");
		}
		
		conn.close();
		
		return media;
	}
}
