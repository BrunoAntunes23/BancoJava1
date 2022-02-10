package Model;

import java.util.Date;

import Helper.Util;

public class Cliente {

	private static int contador=101;
	private int codigo;
	private String nome;
	private String email;
	private String cpf;
	private Date datanasc;
	private Date datacadastro;
	public Cliente(String nome, String email, String cpf, Date datanasc) {
		this.codigo=Cliente.contador;
		this.nome = nome;
		this.email = email;
		this.cpf = cpf;
		this.datanasc = datanasc;
		this.datacadastro=new Date();
		Cliente.contador+=1;
		
	}
	public int getCodigo() {
		return this.codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public Date getDatanasc() {
		return datanasc;
	}
	public void setDatanasc(Date datanasc) {
		this.datanasc = datanasc;
	}
	public Date getdatacadastro() {
		return this.datacadastro;
	}
	@Override
	public String toString() {
		return "Cliente [codigo=" + codigo + ", \n nome=" + nome + ",\n email=" + email + "\n cpf=" + cpf + "\n datanasc="
				+ Util.dateParaString(this.datanasc) + "\n datacadastro=" + Util.dateParaString(this.datacadastro) + "]";
	}
	
}
	
	
	
	


