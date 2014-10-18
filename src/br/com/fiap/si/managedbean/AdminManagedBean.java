package br.com.fiap.si.managedbean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import com.sun.org.apache.xpath.internal.operations.Bool;

import br.com.fiap.si.bean.Admin;
import br.com.fiap.si.dao.AdminDao;

@ManagedBean
@SessionScoped
public class AdminManagedBean extends Admin{
	
	private String erro = "";
	
	public String autenticar(){
		
		String 	pagRet = "login";
		boolean	verify;
		verify  = new AdminDao().autenticar(login,senha);
		((HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest()).getSession().setAttribute("usuario",verify);

		if(verify)pagRet = "clientes";
		else erro = "Usuario ou senha invalidos";
		return pagRet;
	}
	
	public String logout(){
		((HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest()).getSession().setAttribute("usuario",null);

		return "login";
	}
	
	//getters and setters
	public String getErro() {
		return erro;
	}

	public void setErro(String erro) {
		this.erro = erro;
	}

}
