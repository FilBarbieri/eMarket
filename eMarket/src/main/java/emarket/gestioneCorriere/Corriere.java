package emarket.gestioneCorriere;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

// TODO: Auto-generated Javadoc
/**
 * The Class Corriere.
 */
@Entity
public class Corriere {

	/** The id. */
	@Id
	@GeneratedValue()
	private Long idCo;
	
	/** The nome. */
	private String nome;
	
	/** The cognome. */
	private String cognome;
	
	/** The dob. */
	private String dob;
	
	/** The stipendio. */
	private Integer stipendio;
	
	/** The cf. */
	private String cf;
	
	/** The patente. */
	private String patente;
	
	/**
	 * Instantiates a new corriere.
	 */
	public Corriere() {
	}
	
	
	/**
	 * Instantiates a new corriere.
	 *
	 * @param id the id
	 * @param nome the nome
	 * @param cognome the cognome
	 * @param dob the dob
	 * @param stipendio the stipendio
	 * @param cf the cf
	 * @param patente the patente
	 */
	public Corriere(Long idCo, String nome, String cognome, String dob, Integer stipendio, String cf, String patente) {
		super();
		this.idCo = idCo;
		this.nome = nome;
		this.cognome = cognome;
		this.dob = dob;
		this.stipendio = stipendio;
		this.cf = cf;
		this.patente = patente;
	}
	
	public Corriere(String nome, String cognome, String dob, Integer stipendio, String cf, String patente) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.dob = dob;
		this.stipendio = stipendio;
		this.cf = cf;
		this.patente = patente;
	}
	
	
	
	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public Long getIdCo() {
		return this.idCo;
	}

	/**
	 * Gets the nome.
	 *
	 * @return the nome
	 */
	public String getNome() {
		return this.nome;
	}

	/**
	 * Sets the nome.
	 *
	 * @param nome the new nome
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * Gets the cognome.
	 *
	 * @return the cognome
	 */
	public String getCognome() {
		return this.cognome;
	}

	/**
	 * Sets the cognome.
	 *
	 * @param cognome the new cognome
	 */
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	
	/**
	 * Gets the cf.
	 *
	 * @return the cf
	 */
	public String getCf() {
		return cf;
	}
	
	/**
	 * Sets the cf.
	 *
	 * @param cf the new cf
	 */
	public void setCf(String cf) {
		this.cf = cf;
	}
	
	/**
	 * Gets the dob.
	 *
	 * @return the dob
	 */
	public String getDob() {
		return dob;
	}
	
	/**
	 * Sets the dob.
	 *
	 * @param dob the new dob
	 */
	public void setDob(String dob) {
		this.dob = dob;
	}
	
	/**
	 * Gets the stipendio.
	 *
	 * @return the stipendio
	 */
	public Integer getStipendio() {
		return stipendio;
	}
	
	/**
	 * Sets the stipendio.
	 *
	 * @param stipendio the new stipendio
	 */
	public void setStipendio(Integer stipendio) {
		this.stipendio = stipendio;
	}
	
	
	/**
	 * Gets the patente.
	 *
	 * @return the patente
	 */
	public String getPatente() {
		return patente;
	}
	
	/**
	 * Sets the patente.
	 *
	 * @param patente the new patente
	 */
	public void setPatente(String patente) {
		this.patente = patente;
	}
	
	

}
