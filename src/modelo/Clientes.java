package modelo;

import java.io.Serializable;
import java.math.BigDecimal;

public class Clientes implements Serializable {
	
	private static final long serialVersionUID = 1L;
	String nomeCliente;
	BigDecimal cpf;
	
	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nome) {
		this.nomeCliente = nome;
	}

	public BigDecimal getCpf() {
		return cpf;
	}

	public void setCpf(BigDecimal cpf) {
		this.cpf = cpf;
	}
	
}
