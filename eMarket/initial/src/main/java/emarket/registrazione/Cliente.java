package emarket.registrazione;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCl;
	private String nome;
	private String cognome;
	private String citta;
	private String indirizzo;
	private Integer cap;
	private String pagamento;
	private String email;
	private String password; 
	
	public Cliente() {
	}
	
	public Cliente(String nome, String cognome, String pagamento, String email, String password, String citta, String indirizzo, Integer cap) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.citta = citta;
		this.indirizzo = indirizzo;
		this.cap = cap;
		this.pagamento = pagamento;
		this.email = email;
		this.password = password;
	}

	public Long getIdCl() {
		return idCl;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getCognome() {
		return cognome;
	}


	public void setCognome(String cognome) {
		this.cognome = cognome;
	}


	public String getCitta() {
		return citta;
	}


	public void setCitta(String citta) {
		this.citta = citta;
	}


	public String getIndirizzo() {
		return indirizzo;
	}


	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}


	public Integer getCap() {
		return cap;
	}


	public void setCap(Integer cap) {
		this.cap = cap;
	}


	public String getPagamento() {
		return pagamento;
	}


	public void setPagamento(String pagamento) {
		this.pagamento = pagamento;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
