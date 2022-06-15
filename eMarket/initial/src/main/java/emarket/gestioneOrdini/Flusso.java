package emarket.gestioneOrdini;

import org.jgrapht.graph.DefaultWeightedEdge;

public class Flusso {
	
	private DefaultWeightedEdge e;
	private Double f;
	
	public Flusso(DefaultWeightedEdge e, Double f) {
		super();
		this.e = e;
		this.f = f;
	}
	
	public DefaultWeightedEdge getE() {
		return e;
	}
	public void setE(DefaultWeightedEdge e) {
		this.e = e;
	}
	public Double getf() {
		return f;
	}
	public void setf(Double f) {
		this.f = f;
	}
	
	@Override
	public String toString() {
		return e.toString() + ", " + this.f;
	}

}
