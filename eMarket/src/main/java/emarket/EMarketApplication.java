package emarket;

import org.jgrapht.graph.DefaultWeightedEdge;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import emarket.gestioneOrdini.AlgoritmoService;
import emarket.gestioneOrdini.Vertice;

@SpringBootApplication
public class EMarketApplication{

	public static void main(String[] args) throws Throwable {
		SpringApplication.run(EMarketApplication.class, args);
		
	}
}
