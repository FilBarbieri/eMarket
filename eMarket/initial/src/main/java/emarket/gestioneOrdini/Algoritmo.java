package emarket.gestioneOrdini;

import java.util.ArrayList;
import java.util.Map;
import java.util.function.Function;
import org.jgrapht.Graph;
import org.jgrapht.alg.flow.mincost.CapacityScalingMinimumCostFlow;
import org.jgrapht.alg.flow.mincost.MinimumCostFlowProblem;
import org.jgrapht.alg.flow.mincost.MinimumCostFlowProblem.MinimumCostFlowProblemImpl;
import org.jgrapht.alg.interfaces.MinimumCostFlowAlgorithm.MinimumCostFlow;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleDirectedWeightedGraph;


public class Algoritmo {

	private Graph<Vertice, DefaultWeightedEdge> grafo;
	private ArrayList<Flusso> flussi;
	private MinimumCostFlow<DefaultWeightedEdge> result;
	private ArrayList<Camion> lista_camion;
	private int km_max = 15;

	public Algoritmo() {
		grafo = new SimpleDirectedWeightedGraph<Vertice, DefaultWeightedEdge>(DefaultWeightedEdge.class);
		flussi = new ArrayList<Flusso>();
		costruzioneGrafo();
	}


	/**
	 * Ritorna il grafo.
	 *
	 * @return Grafo creato in precedenza
	 */
	public Graph<Vertice, DefaultWeightedEdge> getGrafo() {
		return grafo;
	}


	/**
	 * Ritorna i percorsi
	 *
	 * @return Percorsi calcolati dall'algoritmo
	 */
	public ArrayList<Camion> getListacamion() {
		return lista_camion;
	}


	/**
	 * Costruisce il grafo
	 */
	public void costruzioneGrafo() {

		// Creo i vertici 
		Vertice v1 = new Vertice("24100", 0); //sorgente
		Vertice v2 = new Vertice("24128", 0);
		Vertice v3 = new Vertice("24030", 0);
		Vertice v4 = new Vertice("24160", 0);
		Vertice v5 = new Vertice("24123", 0);
		Vertice v6 = new Vertice("24068", 0);
		Vertice v7 = new Vertice("24168", 0);
		Vertice v8 = new Vertice("24010", 0);
		Vertice v9 = new Vertice("24090", 0);
		Vertice v10 = new Vertice("24200", 0);
		grafo.addVertex(v1); 
		grafo.addVertex(v2); 
		grafo.addVertex(v3); 
		grafo.addVertex(v4);
		grafo.addVertex(v5);
		grafo.addVertex(v6);
		grafo.addVertex(v7);
		grafo.addVertex(v8);
		grafo.addVertex(v9);
		grafo.addVertex(v10);

		// Connetto i vertici con gli archi 
		DefaultWeightedEdge e;
		e = grafo.addEdge(v1, v2); grafo.setEdgeWeight(e, 10);
		e = grafo.addEdge(v1, v6); grafo.setEdgeWeight(e, 2);
		e = grafo.addEdge(v1, v5); grafo.setEdgeWeight(e, 7);
		e = grafo.addEdge(v1, v3); grafo.setEdgeWeight(e, 5);
		e = grafo.addEdge(v1, v7); grafo.setEdgeWeight(e, 12);
		e = grafo.addEdge(v2, v4); grafo.setEdgeWeight(e, 8);
		e = grafo.addEdge(v2, v7); grafo.setEdgeWeight(e, 5);
		e = grafo.addEdge(v5, v4); grafo.setEdgeWeight(e, 1);
		e = grafo.addEdge(v6, v3); grafo.setEdgeWeight(e, 2);
		e = grafo.addEdge(v3, v8); grafo.setEdgeWeight(e, 1);
		e = grafo.addEdge(v6, v8); grafo.setEdgeWeight(e, 8);
		e = grafo.addEdge(v6, v9); grafo.setEdgeWeight(e, 5);
		e = grafo.addEdge(v8, v9); grafo.setEdgeWeight(e, 7);
		e = grafo.addEdge(v9, v5); grafo.setEdgeWeight(e, 2);
		e = grafo.addEdge(v4, v10); grafo.setEdgeWeight(e, 10);
		e = grafo.addEdge(v2, v10); grafo.setEdgeWeight(e, 4);
		e = grafo.addEdge(v7, v10); grafo.setEdgeWeight(e, 4);

		//Inverso
		e = grafo.addEdge(v2, v1); grafo.setEdgeWeight(e, 10);
		e = grafo.addEdge(v6, v1); grafo.setEdgeWeight(e, 2);
		e = grafo.addEdge(v5, v1); grafo.setEdgeWeight(e, 7);
		e = grafo.addEdge(v3, v1); grafo.setEdgeWeight(e, 5);
		e = grafo.addEdge(v7, v1); grafo.setEdgeWeight(e, 12);
		e = grafo.addEdge(v4, v2); grafo.setEdgeWeight(e, 8);
		e = grafo.addEdge(v7, v2); grafo.setEdgeWeight(e, 5);
		e = grafo.addEdge(v4, v5); grafo.setEdgeWeight(e, 1); 
		e = grafo.addEdge(v3, v6); grafo.setEdgeWeight(e, 2); 
		e = grafo.addEdge(v8, v3); grafo.setEdgeWeight(e, 1);
		e = grafo.addEdge(v8, v6); grafo.setEdgeWeight(e, 8);
		e = grafo.addEdge(v9, v6); grafo.setEdgeWeight(e, 5);
		e = grafo.addEdge(v9, v8); grafo.setEdgeWeight(e, 7);
		e = grafo.addEdge(v5, v9); grafo.setEdgeWeight(e, 2);
		e = grafo.addEdge(v10, v4); grafo.setEdgeWeight(e, 10);
		e = grafo.addEdge(v10, v2); grafo.setEdgeWeight(e, 4);
		e = grafo.addEdge(v10, v7); grafo.setEdgeWeight(e, 4);

	}


	/**
	 * Metodo che risolve il problema del MinCostFlow a partire dal grafo costruito
	 */
	public void minCostFlow() {

		//Rimuove flussi dall'ArrayList
		flussi.removeAll(flussi);

		//Funzioni per MinCostFlow
		Function<Vertice, Integer> functionV = x -> x.getB();
		Function<DefaultWeightedEdge, Integer> functionE = x -> 100;

		//Definisco problema e risolvo
		MinimumCostFlowProblem<Vertice, DefaultWeightedEdge> mcf = new MinimumCostFlowProblemImpl<Vertice, DefaultWeightedEdge>(grafo, functionV, functionE);
		CapacityScalingMinimumCostFlow<Vertice, DefaultWeightedEdge> cmcf = new CapacityScalingMinimumCostFlow<Vertice, DefaultWeightedEdge>();
		result = cmcf.getMinimumCostFlow(mcf);

		
		//Riempio vettore dei flussi
		aggiungiFlusso(); 
		
	}


	/**
	 * Metodo che restituisce l'arco con il flusso maggiore a partire dal nodo fornito rispettando il vincolo sui km massimi
	 * percorribili da ogni camion
	 * @param Posizione di partenza
	 * @param Km percorsi dal camion fino a quel momento
	 * @return Arco con flusso massimo
	 */
	public DefaultWeightedEdge trovaFlussoMassimo(Vertice posizione, double km) {
		int start = -1;
		int index = 0;
		double flusso = 0;

		for(Flusso e: flussi) {
			if ( (grafo.getEdgeSource(e.getE()).getNome() == posizione.getNome() )  && (e.getf() > flusso) && ( (km + grafo.getEdgeWeight(e.getE())) <= km_max) ) {
				start = index;
				flusso = e.getf();
			}
			index++;
		}

		if(start != -1)
			return flussi.get(start).getE();
		else {
			DefaultWeightedEdge e = null;
			return e;
		}
	}


	/**
	 * Metodo che divide gli ordini su ogni camion rispettando il vincolo della distanza
	 *
	 * @return ArrayList contenente i percorsi di ogni camion
	 */
	public ArrayList<Camion> assegnamentoOrdini() {

		minCostFlow();
		//aggiungiFlusso();

		//Variabili utilizzate dall'algoritmo
		lista_camion = new ArrayList<Camion>();
		double km = 0;
		Vertice posizione;
		Vertice start = null;

		//Vertice di partenza
		for(Vertice v: grafo.vertexSet()) {
			if(v.getNome() == "24100")
				start = v;
		}

		while(verificaPesoNodi()) { 										//Rifaccio fino a quando non ho finito tutti gli ordini
			posizione = start;
			km = 0;
			Camion camion = new Camion();
			while(km <= km_max) { 											//Hai ancota tempo/km a disposizione (se seguo cammino minimo si)
				camion.aggiungiVertice(posizione);
				if(posizione.getClienti() != null) {
					camion.aggiungiClienti(posizione.getClienti());
					posizione.setClienti();
				}
				DefaultWeightedEdge emax = trovaFlussoMassimo(posizione, km);
				if(emax != null) {
					posizione = grafo.getEdgeTarget(emax); 
					modificaFlusso(emax);									//Elimino flusso da arco
					km = km + grafo.getEdgeWeight(emax);
					azzeraVertice(posizione); 								//Azzero peso nodo e riduco peso sorgente
				}else { 													//Percorso suggerito da mincostflow è terminato
					DefaultWeightedEdge e = trovaVertice(posizione, km);
					if(e != null) {
						posizione = grafo.getEdgeTarget(e);
						km = km + grafo.getEdgeWeight(e);
						azzeraVertice(posizione);
					}else{
						km = km * 2; 										//Torno all'origine
						posizione = start;
					}
				}
			}																//Fine while interno

			lista_camion.add(camion);
			minCostFlow();
		}																	//Fine while esterno

		return lista_camion;
	}


	/**
	 * Metodo che verifica la presenza di nodi con peso != 0 (con ancora ordini da effettuare)
	 *
	 * @return true se la ricerca ha un esito positivo
	 */
	public boolean verificaPesoNodi() {
		for(Vertice v: grafo.vertexSet()) {
			if(v.getB() != 0)
				return true;
		}
		return false;
	}


	/**
	 * Metodo che ricerca il vertice con il peso maggiore direttamente connesso alla posione fornita
	 * che rispetti i vincoli di distanza
	 * @param Posizione corrente
	 * @param Km percorsi dal camion fino a quel momento
	 * @return Arco che collega il nodo fornito a quello con peso maggiore
	 */
	public DefaultWeightedEdge trovaVertice(Vertice posizione, double km) {
		for(Vertice x: grafo.vertexSet()) {
			DefaultWeightedEdge e = grafo.getEdge(posizione, x);
			if(x.getB() < 0 && e != null && (km + grafo.getEdgeWeight(e) <= km_max))
				return e;
		}

		return null;
	}


	/**
	 * Azzera il peso del vertice passato come parametro
	 *
	 * @param Vertice da azzerare
	 */
	public void azzeraVertice(Vertice v) {
		int valore = 0;

		for(Vertice x: grafo.vertexSet()) {
			if(v.getNome() == x.getNome()) {
				valore = x.getB();
				x.setB(0);
			}
		}

		for(Vertice x: grafo.vertexSet()) {
			if("24100" == x.getNome()) {
				int appo = x.getB();
				int t = appo + valore;
				x.setB(t);
			}
		}


	}


	/**
	 * Metodo che inserisce all'interno dell'ArrayList il flusso calcolato in precedenza sul problema 
	 * MinCostFlow
	 */
	public void aggiungiFlusso(){	

		Map<DefaultWeightedEdge, Double> flow = result.getFlowMap();

		for(DefaultWeightedEdge t: flow.keySet()) {
			Flusso f = new Flusso(t, flow.get(t));
			flussi.add(f);
		}

	}


	/**
	 * Metodo che modifica il valore del flusso passato come parametro
	 *
	 * @param Arco da modificare
	 */
	public void modificaFlusso(DefaultWeightedEdge e) {

		for(Flusso x: flussi) {
			if(x.getE().equals(e))
				x.setf(0.0);
		}
	}
	

	public ArrayList<Camion> getLista_Camion(){
		return lista_camion;
	}

}


