package emarket.test;

import static org.junit.Assert.*;

import org.junit.Test;

import emarket.gestioneCorriere.Corriere;
import emarket.gestioneProdotto.Prodotto;
import emarket.registrazione.Cliente;

public class TestSetandGet{
	
	
	//Prodotto
	Float f = (float) 2.5;
	Integer qt = 500;
	Integer qm = 2;
	Prodotto p1 = new Prodotto("Pasta", f , qt, qm);


	@Test
	public void getNomeTest() {
		assertEquals("Pasta", p1.getNome());
	}

	@Test
	public void setNomeTest() {
		p1.setNome("Pasta integrale");
		assertEquals("Pasta integrale", p1.getNome());
	}

	@Test
	public void getPrezzoTest() {
		assertEquals(f, p1.getPrezzo());
	}

	@Test
	public void setPrezzoTest() {
		Float fnew = (float) 3.5;
		p1.setPrezzo(fnew);
		assertEquals(fnew, p1.getPrezzo());
	}


	@Test
	public void getQtTest() {
		assertEquals(qt, p1.getQt());
	}

	@Test
	public void setQtTest() {
		Integer qtnew = 550;
		p1.setQt(qtnew);
		assertEquals(qtnew, p1.getQt());
	}

	@Test
	public void getQmTest() {
		assertEquals(qm, p1.getQm());
	}

	@Test
	public void setQmTest() {
		Integer qmnew = 4;
		p1.setQm(qmnew);
		assertEquals(qmnew, p1.getQm());
	}


	//Corriere
	Integer stipendio = 20000;
	Corriere c1 = new Corriere("Acram", "Bousaid", "07/09/1997", stipendio, "CodiceFiscale", "AB");

	@Test
	public void getNomeTestC() {
		assertEquals("Acram", c1.getNome());
	}

	@Test
	public void setNomeTestC() {
		c1.setNome("Filippo");
		assertEquals("Filippo", c1.getNome());
	}

	@Test
	public void getCognomeTest() {
		assertEquals("Bousaid", c1.getCognome());
	}

	@Test
	public void setCognomeTest() {
		c1.setCognome("Barbieri");
		assertEquals("Barbieri", c1.getCognome());
	}

	@Test
	public void getDobTest() {
		assertEquals("07/09/1997", c1.getDob());
	}

	@Test
	public void setDobTest() {
		c1.setDob("19/03/1998");
		assertEquals("19/03/1998", c1.getDob());
	}

	@Test
	public void getStipendioTest() {
		assertEquals(stipendio , c1.getStipendio());
	}

	@Test
	public void setStipendioTest() {
		Integer stipendionew = 25000;
		c1.setStipendio(stipendionew);
		assertEquals(stipendionew,c1.getStipendio());
	}


	@Test
	public void getCfTest() {
		assertEquals("CodiceFiscale", c1.getCf());
	}

	@Test
	public void setCfTest() {
		c1.setCf("CodiceFiscale2");
		assertEquals("CodiceFiscale2", c1.getCf());
	}

	@Test
	public void getPatenteTest() {
		assertEquals("AB", c1.getPatente());
	}

	@Test
	public void setPatenteTest() {
		c1.setPatente("ABCE");
		assertEquals("ABCE", c1.getPatente());
	}
	
	
	//Cliente
	Cliente cl1 = new Cliente("Mario", "Rossi", "AMEX", "prova@gmail.com", "abcde", "Bergamo", "Via Bergamo", 24100);
	
	@Test
	public void getNomeTestCl() {
		assertEquals("Mario", cl1.getNome());
	}

	@Test
	public void setNomeTestCl() {
		cl1.setNome("Filippo");
		assertEquals("Filippo", cl1.getNome());
	}
	

	@Test
	public void getCognomeTestCl() {
		assertEquals("Rossi", cl1.getCognome());
	}

	@Test
	public void setCognomeTestCl() {
		cl1.setCognome("Barbieri");
		assertEquals("Barbieri", cl1.getCognome());
	}
	
	@Test
	public void getPagamentoTestCl() {
		assertEquals("AMEX", cl1.getPagamento());
	}

	@Test
	public void setPagamentoTestCl() {
		cl1.setPagamento("VISA");
		assertEquals("VISA", cl1.getPagamento());
	}
	

	@Test
	public void getEmailTestCl() {
		assertEquals("prova@gmail.com", cl1.getEmail());
	}

	@Test
	public void setEmailTestCl() {
		cl1.setEmail("prova");
		assertEquals("prova", cl1.getEmail());
	}
	
	@Test
	public void getPasswordTestCl() {
		assertEquals("abcde", cl1.getPassword());
	}

	@Test
	public void setPasswordTestCl() {
		cl1.setPassword("password");
		assertEquals("password", cl1.getPassword());
	}
	
	@Test
	public void getCittaTestCl() {
		assertEquals("Bergamo", cl1.getCitta());
	}

	@Test
	public void setCittaTestCl() {
		cl1.setCitta("Milano");
		assertEquals("Milano", cl1.getCitta());
	}
	
	@Test
	public void getIndirizzoTestCl() {
		assertEquals("Via Bergamo", cl1.getIndirizzo());
	}

	@Test
	public void setIndirizzoTestCl() {
		cl1.setIndirizzo("Via Milano");
		assertEquals("Via Milano", cl1.getIndirizzo());
	}
	
	@Test
	public void getCapTestCl() {
		Integer cap = 24100;
		assertEquals(cap, cl1.getCap());
	}

	@Test
	public void setCapTestCl() {
		cl1.setCap(24030);
		Integer cap = 24030;
		assertEquals(cap, cl1.getCap());
	}

}