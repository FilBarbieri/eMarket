package emarket.registrazione;

public interface GestioneClienteIF {

	  public Iterable<Cliente> getAllCl();
	  public Cliente getCl(Long id);
	  public Cliente insertCl(Cliente cliente);
}
