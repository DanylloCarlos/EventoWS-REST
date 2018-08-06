package modelo;

import java.io.Serializable;

public class Clientes implements Serializable {
	
	private static final long serialVersionUID = 1L;
	String nomeCliente;
	String cpf;
	
	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nome) {
		this.nomeCliente = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
}
