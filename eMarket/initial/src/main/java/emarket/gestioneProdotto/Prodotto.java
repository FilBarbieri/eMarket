package emarket.gestioneProdotto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Prodotto {

	
	@Id
	@GeneratedValue()
	private Long idP;
	private String nome;
	private Float prezzo;
	private Integer qt;
	private Integer qm;
	
	public Prodotto() {
	}
	
	public Prodotto(String nome, Float prezzo, Integer qt, Integer qm) {
		super();
		this.nome = nome;
		this.prezzo = prezzo;
		this.qt = qt;
		this.qm = qm;
	}
	
	public Long getIdP() {
		return idP;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Float getPrezzo() {
		return prezzo;
	}
	public void setPrezzo(Float prezzo) {
		this.prezzo = prezzo;
	}
	public Integer getQt() {
		return qt;
	}
	public void setQt(Integer qt) {
		this.qt = qt;
	}
	public Integer getQm() {
		return qm;
	}
	public void setQm(Integer qm) {
		this.qm = qm;
	}
	
}
