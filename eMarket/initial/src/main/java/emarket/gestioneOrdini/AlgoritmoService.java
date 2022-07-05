package emarket.gestioneOrdini;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import org.springframework.stereotype.Service;

import emarket.gestioneCorriere.Corriere;


// TODO: Auto-generated Javadoc
/**
 * The Class AlgoritmoService.
 */
@Service
public class AlgoritmoService {


	/** The algoritmo. */
	private Algoritmo algoritmo;

	/**
	 * Instantiates a new algoritmo service.
	 */
	public AlgoritmoService() {
		algoritmo = new Algoritmo();
		esecuzioneAlgoritmo();
	}

	/**
	 * Funzione che dopo aver effettuato la connessione al DB salva i dati relativi agli ordini come pesi dei nodi del grafo e successivamente richiama l'algoritmo 
	 * per il calcolo dei percorsi.
	 */
	public void esecuzioneAlgoritmo() {
		int n_ordini = 0;

		try {
			
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/emarketdb", "root", "");
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT cliente.id_cl, cliente.nome, cliente.cognome, cliente.indirizzo, cliente.citta, cliente.cap "
					+ "FROM `cliente` JOIN `ordine` WHERE ordine.id_cl=cliente.id_cl GROUP BY cliente.id_cl"); 
			
			while(resultSet.next()) {
				for(Vertice v : algoritmo.getGrafo().vertexSet()) {
					if (v.getNome().equals(Integer.toString(resultSet.getInt("cap")))) {
						n_ordini++;
						v.decrement();
					}
				}
				
				//Lista clienti
				for(Vertice v : algoritmo.getGrafo().vertexSet()) {
					if (v.getNome().equals(Long.toString(resultSet.getLong("cap")))) {
							v.aggiungiCliente(resultSet.getLong("id_cl"));
					}
				}
			}

			for(Vertice v : algoritmo.getGrafo().vertexSet()) {
				if (v.getNome().equals("24100")) {
					v.setB(n_ordini);
				}
			}
			

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		algoritmo.assegnamentoOrdini();
	}
	
	
	
	/**
	 * Assegna i corrieri ai camion e restituisce la lista con corriere, percorso e clienti della consegna
	 *
	 * @return the lista camion
	 */
	public ArrayList<Camion> getLista_Camion(){
		
		ArrayList<Camion> camcor = algoritmo.getLista_Camion();
		ArrayList<Corriere> corrieri = new ArrayList<Corriere>();
		
		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/emarketdb", "root", "");
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT id_co,cf,cognome,nome,dob,patente,stipendio"
					+ " FROM `corriere`"); 

			while(resultSet.next()) {
				corrieri.add(new Corriere(resultSet.getLong("id_co"),
													resultSet.getString("nome"),
													resultSet.getString("cognome"),
													resultSet.getString("dob"),
													resultSet.getInt("stipendio"),
													resultSet.getString("cf"),
													resultSet.getString("patente")
							));
			}
			
			int i = 0;
			for(Camion c: camcor) {
				c.setCorriere(corrieri.get(i));
				i++;
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//System.out.println(camcor.toString());
		return camcor;
	}


}