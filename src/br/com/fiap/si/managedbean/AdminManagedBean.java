package br.com.fiap.si.managedbean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.fiap.si.bean.Admin;
import br.com.fiap.si.dao.AdminDao;

@ManagedBean
@SessionScoped
public class AdminManagedBean extends Admin{
	
	private String erro = "";
	
	public String autenticar(){
		
		String pagRet = "login";
		if(new AdminDao().autenticar(login,senha))pagRet = "menu";
		else erro = "Usuario ou senha inválidos";
		return pagRet;
	}
	
	//getters and setters
	public String getErro() {
		return erro;
	}

	public void setErro(String erro) {
		this.erro = erro;
	}

}
