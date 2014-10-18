package br.com.fiap.si.managedbean;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.fiap.si.bean.Investidor;
import br.com.fiap.si.dao.ClienteDAO;
import br.com.fiap.si.dao.InvestidorDAO;

@ManagedBean
@SessionScoped
public class ResumoManagedBean {
	private Integer qtdClientes;
	private Integer qtdItens;
	private Integer qtdInvestidores;
	private Float 	mediaPropostas;
	
	public ResumoManagedBean() {
		loadResumo();
	}
	public Integer getQtdClientes() {
		return qtdClientes;
	}

	public void setQtdClientes(Integer qtdClientes) {
		this.qtdClientes = qtdClientes;
	}

	public Integer getQtdItens() {
		return qtdItens;
	}

	public void setQtdItens(Integer qtdItens) {
		this.qtdItens = qtdItens;
	}

	public Integer getQtdInvestidores() {
		return qtdInvestidores;
	}

	public void setQtdInvestidores(Integer qtdInvestidores) {
		this.qtdInvestidores = qtdInvestidores;
	}

	public Float getMediaPropostas() {
		return mediaPropostas;
	}

	public void setMediaPropostas(Float mediaPropostas) {
		this.mediaPropostas = mediaPropostas;
	}



	public String loadResumo(){
		
		String resultado = "";
		
		InvestidorDAO daoInv = new InvestidorDAO();
		ClienteDAO daoCli = new ClienteDAO();
		
		try{
			setQtdInvestidores(daoInv.getQuantidade());
			setMediaPropostas(daoInv.getMediaPropostas());
			setQtdClientes(daoCli.getQuantidade());
			setQtdItens(daoCli.getQuantidadeItens());
			
			resultado = "resumo";
			
		}catch(SQLException e){
			System.out.print(e.getMessage());
			resultado = "erro";
		}
		
		return resultado;
	}
	
	
}
