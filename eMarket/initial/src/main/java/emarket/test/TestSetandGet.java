package emarket.test;

import static org.junit.Assert.*;
import emarket.gestioneCorriere.Corriere;
import emarket.gestioneProdotto.Prodotto;

public class TestSetandGet{

	//Prodotto
	Float f = (float) 2.5;
	Integer qt = (int) 500;
	Integer qm = (int) 2;
	Prodotto p1 = new Prodotto("Pasta", f , qt, qm);


	@org.junit.Test
	public void getNomeTest() {
		assertEquals("Pasta", p1.getNome());
	}

	@org.junit.Test
	public void setNomeTest() {
		p1.setNome("Pasta integrale");
		assertEquals("Pasta integrale", p1.getNome());
	}

	@org.junit.Test
	public void getPrezzoTest() {
		assertEquals(f, p1.getPrezzo());
	}

	@org.junit.Test
	public void setPrezzoTest() {
		Float fnew = (float) 3.5;
		p1.setPrezzo(fnew);
		assertEquals(fnew, p1.getPrezzo());
	}


	@org.junit.Test
	public void getQtTest() {
		assertEquals(qt, p1.getQt());
	}

	@org.junit.Test
	public void setQtTest() {
		Integer qtnew = (int) 550;
		p1.setQt(qtnew);
		assertEquals(qtnew, p1.getQt());
	}

	@org.junit.Test
	public void getQmTest() {
		assertEquals(qm, p1.getQm());
	}

	@org.junit.Test
	public void setQmTest() {
		Integer qmnew = (int) 4;
		p1.setQm(qmnew);
		assertEquals(qmnew, p1.getQm());
	}


	//Corriere
	Integer stipendio = (int) 20000;
	Corriere c1 = new Corriere("Acram", "Bousaid", "07/09/1997", stipendio, "CodiceFiscale", "AB");

	@org.junit.Test
	public void getNomeTestC() {
		assertEquals("Acram", c1.getNome());
	}

	@org.junit.Test
	public void setNomeTestC() {
		c1.setNome("Filippo");
		assertEquals("Filippo", c1.getNome());
	}

	@org.junit.Test
	public void getCognomeTest() {
		assertEquals("Bousaid", c1.getCognome());
	}

	@org.junit.Test
	public void setCognomeTest() {
		c1.setCognome("Barbieri");
		assertEquals("Barbieri", c1.getCognome());
	}

	@org.junit.Test
	public void getDobTest() {
		assertEquals("07/09/1997", c1.getDob());
	}

	@org.junit.Test
	public void setDobTest() {
		c1.setDob("19/03/1998");
		assertEquals("19/03/1998", c1.getDob());
	}

	@org.junit.Test
	public void getStipendioTest() {
		assertEquals(stipendio , c1.getStipendio());
	}

	@org.junit.Test
	public void setStipendioTest() {
		Integer stipendionew = (int) 25000;
		c1.setStipendio(stipendionew);
		assertEquals(stipendionew,c1.getStipendio());
	}


	@org.junit.Test
	public void getCfTest() {
		assertEquals("CodiceFiscale", c1.getCf());
	}

	@org.junit.Test
	public void setCfTest() {
		c1.setCf("CodiceFiscale2");
		assertEquals("CodiceFiscale2", c1.getCf());
	}

	@org.junit.Test
	public void getPatenteTest() {
		assertEquals("AB", c1.getPatente());
	}

	@org.junit.Test
	public void setPatenteTest() {
		c1.setPatente("ABCE");
		assertEquals("ABCE", c1.getPatente());
	}


}