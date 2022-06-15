package emarket.gestioneCorriere;

import org.springframework.web.bind.annotation.RequestParam;

public interface GestioneCorriereIF{

  public Iterable<Corriere> getAllC();
  public Corriere getC(Long id);
  public Corriere insertC(Corriere corriere);
  public Corriere modifyC(@RequestParam (value ="idCo")Long id, Corriere corriere);
  public String deleteC(@RequestParam (value ="idCo")Long id);
  
}