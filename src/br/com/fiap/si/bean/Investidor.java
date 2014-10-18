package br.com.fiap.si.bean;

import java.util.Date;

public class Investidor {
	private String 	nome;
	private String 	empresa;
	private String 	email;
	private String 	telefone;
	private Float 	proposta;
	private Date 	created_at;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmpresa() {
		return empresa;
	}
	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public Float getProposta() {
		return proposta;
	}
	public void setProposta(Float proposta) {
		this.proposta = proposta;
	}
	public Date getCreatedAt() {
		return created_at;
	}
	public void setCreatedAt(Date created_at) {
		this.created_at = created_at;
	}
}
