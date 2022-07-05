package emarket.gestioneProdotto;

import org.springframework.web.bind.annotation.RequestParam;

public interface GestioneProdottoIF {

  public Iterable<Prodotto> getAllP();
  public Prodotto getP(Long id);
  public Prodotto insertP(Prodotto prodotto);
  public Prodotto modifyP(@RequestParam (value ="idP")Long id, Prodotto prodotto);
  public String deleteP(@RequestParam (value ="idP")Long id);
  
}