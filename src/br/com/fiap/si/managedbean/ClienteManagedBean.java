package br.com.fiap.si.managedbean;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import br.com.fiap.si.bean.Cliente;
import br.com.fiap.si.dao.ClienteDAO;

@ManagedBean
@SessionScoped
public class ClienteManagedBean extends Cliente{
	private Cliente cliente = new Cliente();
	private List<Cliente> listaClientes;
	
	private Integer pk;
	private String dhCadastroDe ="";
	private String dhCadastroAte ="";

	

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

	public List<Cliente> getListaClientes() {
		
		this.listar();
		return listaClientes;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public String incluirCliente(){
		
		String resultado = "sucesso";
		
		ClienteDAO dao = new ClienteDAO();
		
		try{
			dao.incluir(cliente);
			
			resultado = "index.jsf#adquirir";
			
		}catch(SQLException e){
			resultado = "erro";
		}
		
		return null;
	}
	
	public String listar(){
		
		String resultado = "mostrar";
		
		ClienteDAO dao = new ClienteDAO();
		
		try{
			listaClientes = dao.listar(nome,dhCadastroDe,dhCadastroAte);
			
		}catch(Exception e){
			resultado = "erro";
		}
		
		return resultado;
		
	}
	
	
	public String excluir(){
		
		String resultado = "entrada";
		
		ClienteDAO dao = new ClienteDAO();
		
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
			context.addMessage(null,new FacesMessage("Para realizar uma busca por periodo, é necessario preencher as duas datas!"));
			return null;
		}else if(!dhCadastroDe.equals("") && !dhCadastroAte.equals("")){
			Date de = new Date(dhCadastroDe);
			Date ate = new Date(dhCadastroAte);
			
			if(de.getTime() < ate.getTime())
				this.dhCadastroDe = dhCadastroDe;
			else{
				context.addMessage(null,new FacesMessage("A data do campo 'Até:' não pode ser menor que a data do campo 'De:'"));
				return null;
			}
		}
		
		return "entrada";
	}
}
