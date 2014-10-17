package br.com.fiap.si.managedbean;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.ManagedBean;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.fiap.si.bean.Investidor;
import br.com.fiap.si.dao.InvestidorDAO;

@ManagedBean
@SessionScoped
public class InvestidorManagedBean {
	private Investidor investidor = new Investidor();
	private List<Investidor> listaInvestidores;
	
	private Integer pk;
	
	public void setPk(Integer pk) {
		this.pk = pk;
	}

	public List<Investidor> getlistaInvestidores() {
		return listaInvestidores;
	}

	public Investidor getInvestidor() {
		return investidor;
	}

	public void setInvestidor(Investidor Investidor) {
		this.investidor = Investidor;
	}

	public String incluirInvestidor(){
		
		String resultado = "";
		
		InvestidorDAO dao = new InvestidorDAO();
		
		try{
			dao.incluir(investidor);
			
			resultado = "sucesso";
			
		}catch(SQLException e){
			System.out.print(e.getMessage());
			resultado = "erro";
		}
		
		return resultado;
	}
	
	public String listar(){
		
		String resultado = "mostrar";
		
		InvestidorDAO dao = new InvestidorDAO();
		
		try{
			listaInvestidores = dao.listar();
			
		}catch(SQLException e){
			resultado = "erro";
		}
		
		return resultado;
		
	}
	
	
	public String excluir(){
		
		String resultado = "entrada";
		
		InvestidorDAO dao = new InvestidorDAO();
		
		try{
			dao.excluir(pk);
			
		}catch(SQLException e){
			resultado = "erro";
		}
		
		return resultado;
		
	}
}
