package modelo;

import java.io.Serializable;

public class Clientes implements Serializable {
	
	private static final long serialVersionUID = 1L;
	String nomeCliente;
	int cpf;
	
	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nome) {
		this.nomeCliente = nome;
	}

	public int getCpf() {
		return cpf;
	}

	public void setCpf(int cpf) {
		this.cpf = cpf;
	}
	
}
