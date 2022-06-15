package emarket.gestioneOrdini;

import java.util.ArrayList;

public class Vertice {

	private String nome;
	private Integer b;
	private ArrayList<Long> clienti;
	
	
	public Vertice(String nome, Integer b) {
		super();
		this.nome = nome;
		this.b = b;
		clienti = new ArrayList<Long>();
	}
	
	public void decrement() {
		this.b--;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Integer getB() {
		return b;
	}
	public void setB(Integer b) {
		this.b = b;
	}
	
	public ArrayList<Long> getClienti() {
		return clienti;
	}
	public void setClienti() {
		this.clienti = null;
	}
	
	
	public void aggiungiCliente(Long id) {
		this.clienti.add(id);
	}
	
	@Override
	public String toString() {
		if(clienti != null) {
			return "Nome: " + this.nome + ", valore: " + this.b + ", " + clienti.toString();
		}
		else {
			return "Nome: " + this.nome + ", valore: " + this.b + ", clienti: null";
		}
	}
	
	
}
