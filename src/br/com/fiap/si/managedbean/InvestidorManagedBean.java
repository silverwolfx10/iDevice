package br.com.fiap.si.managedbean;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import br.com.fiap.si.bean.Investidor;
import br.com.fiap.si.dao.InvestidorDAO;

@ManagedBean
@SessionScoped
public class InvestidorManagedBean extends Investidor{
	private Investidor investidor = new Investidor();
	private List<Investidor> listaInvestidores;
	
	private Integer pk;
	private String dhCadastroDe ="";
	private String dhCadastroAte ="";
	private String mensagem = "";

	public String getmensagem() {
		return mensagem;
	}
	
	public String getDhCadastroDe() {
		return dhCadastroDe;
	}

	public void setDhCadastroDe(String dhCadastroDe) {
		this.dhCadastroDe = dhCadastroDe;
	}

	public String getDhCadastroAte() {
		return dhCadastroAte;
	}

	public void setDhCadastroAte(String dhCadastroAte) {
		this.dhCadastroAte = dhCadastroAte;
	}

	public void setPk(Integer pk) {
		this.pk = pk;
	}

	public List<Investidor> getlistaInvestidores() {
		this.listar();
		return listaInvestidores;
	}

	public Investidor getInvestidor() {
		return investidor;
	}

	public void setInvestidor(Investidor Investidor) {
		this.investidor = Investidor;
	}

	
	/*
	public String incluirInvestidor(){
		
		String resultado = "";
		
		InvestidorDAO dao = new InvestidorDAO();
		
		try{
			dao.incluir(investidor);
			
			resultado = "sucesso";
			
			this.teste = "atualizado";
			
		}catch(SQLException e){
			System.out.print(e.getMessage());
			resultado = "erro";
		}
		
		return resultado;
	}
	*/
	
	public void incluirInvestidor(){
		
		String resultado = "";
		
		InvestidorDAO dao = new InvestidorDAO();
		
		try{
			dao.incluir(investidor);
			
			resultado = "sucesso";
			
			this.mensagem = "Sua proposta foi enviada com sucesso !";
			
		}catch(SQLException e){
			System.out.print(e.getMessage());
			resultado = "erro";
		}
		
		//return resultado;
	}
	
	public String listar(){
		
		String resultado = "mostrar";
		
		InvestidorDAO dao = new InvestidorDAO();
		
		try{
			listaInvestidores = dao.listar(nome,dhCadastroDe,dhCadastroAte);
			
			
		}catch(Exception e){
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
	
	public String atualizar(){
		
		FacesContext context = FacesContext.getCurrentInstance();
		
		if((!dhCadastroDe.equals("") && dhCadastroAte.equals("")) || (!dhCadastroAte.equals("") && dhCadastroDe.equals("")) ){
			context.addMessage(null,new FacesMessage("Para realizar uma busca por periodo, � necessario preencher as duas datas!"));
			return null;
		}else if(!dhCadastroDe.equals("") && !dhCadastroAte.equals("")){
			Date de = new Date(dhCadastroDe);
			Date ate = new Date(dhCadastroAte);
			
			if(de.getTime() <= ate.getTime())
				this.dhCadastroDe = dhCadastroDe;
			else{
				context.addMessage(null,new FacesMessage("A data do campo 'At�:' n�o pode ser menor que a data do campo 'De:'"));
				return null;
			}
		}
		
		return "entrada";
	}
}
