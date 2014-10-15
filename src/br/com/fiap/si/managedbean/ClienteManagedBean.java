package br.com.fiap.si.managedbean;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.fiap.si.bean.Cliente;
import br.com.fiap.si.dao.ClienteDAO;

@ManagedBean
@SessionScoped
public class ClienteManagedBean {
	private Cliente cliente = new Cliente();
	private List<Cliente> listaClientes;
	
	private Integer pk;
	
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
			
			resultado = "sucesso";
			
		}catch(SQLException e){
			resultado = "erro";
		}
		
		return resultado;
	}
	
	public String listar(){
		
		String resultado = "mostrar";
		
		ClienteDAO dao = new ClienteDAO();
		
		try{
			listaClientes = dao.listar();
			
		}catch(SQLException e){
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
}
