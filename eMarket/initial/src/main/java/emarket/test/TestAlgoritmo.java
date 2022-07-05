package emarket.test;

import static org.junit.Assert.*;
import org.junit.Test;

import emarket.gestioneOrdini.AlgoritmoController;

public class TestAlgoritmo {
	
	// Test dell'algoritmo
	AlgoritmoController ac = new AlgoritmoController();
	
	@Test
	public void assegnamentoTest() {
		assertNotNull(ac.getPercorsi());
	}


}
