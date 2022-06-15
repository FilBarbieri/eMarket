package emarket.gestioneOrdini;

import java.util.ArrayList;

import emarket.gestioneCorriere.Corriere;

public class Camion {
	
	private Corriere corriere;
	private ArrayList<String> percorso;
	private ArrayList<Long> clienti;
	
	public Camion() {
		percorso = new ArrayList<String>();
		clienti = new ArrayList<Long>();
	}
	
	void aggiungiVertice(Vertice v) {
		percorso.add(v.getNome());
	}
	
	void aggiungiCliente(Long id) {
		clienti.add(id);
	}
	
	void setCorriere(Corriere corriere) {
		this.corriere = corriere;
	}
	
	public void aggiungiClienti(ArrayList<Long> clienti) {
		for(Long c: clienti) {
			aggiungiCliente(c);
		}
	}
	
	@Override
	public String toString() {
		return "[" + corriere.getNome() + " "+ corriere.getCognome()+ "], " + percorso.toString() + ", " + clienti.toString();
	}

	public ArrayList<String> getPercorso() {
		return percorso;
	}

	public void setPercorso(ArrayList<String> percorso) {
		this.percorso = percorso;
	}

	public ArrayList<Long> getClienti() {
		return clienti;
	}

	public void setClienti(ArrayList<Long> clienti) {
		this.clienti = clienti;
	}

	public Corriere getCorriere() {
		return corriere;
	}

}
