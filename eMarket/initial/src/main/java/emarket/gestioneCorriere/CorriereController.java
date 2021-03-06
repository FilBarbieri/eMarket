package emarket.gestioneCorriere;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@Controller
public class CorriereController implements WebMvcConfigurer, GestioneCorriereIF{

  @Autowired // This means to get the bean called userRepository
  // Which is auto-generated by Spring, we will use it to handle the data
  private CorriereRepository corriereRepository;

  public void addViewControllers(ViewControllerRegistry registry) {
    registry.addViewController("/index").setViewName("index");
    registry.addViewController("/").setViewName("index");
    registry.addViewController("/visualizzaCorriere").setViewName("corriere");
  }

  //HTML
  @GetMapping ("/visualizzaCorriere")
  public String visualizzaCorriere(Corriere corriere, Model model) {
    model.addAttribute("dati", getAllC());
    return "corriere";
  }


  @PostMapping("/inserimentoCorriere")
  public String inserimentoCorriere(Corriere corriere) {
    insertC(corriere);
    return "redirect:/visualizzaCorriere";
  }
  
  @PostMapping("/modificaCorriere")
  public String modificaCorriere(@RequestParam (value ="idCo")Long id,
      @RequestParam (value ="nome")String nome,
      @RequestParam (value ="cognome")String cognome,
      @RequestParam (value ="dob") String dob,
      @RequestParam (value ="stipendio") Integer stipendio,
      @RequestParam (value ="cf") String cf,
      @RequestParam (value ="patente") String patente){

    Corriere corriere = new Corriere(nome, cognome, dob, stipendio, cf, patente);
    modifyC(id, corriere);
    return "redirect:/visualizzaCorriere";
  }
  
  @PostMapping("/cancellaCorriere")
  public String cancellazioneCorriere(@RequestParam (value ="idCo")Long id) {
    //corriereRepository.deleteById(id);
    deleteC(id);
    return "redirect:/visualizzaCorriere";
  }
  
  
  //REST API
  @GetMapping ("/visualizza_Corriere")
  public @ResponseBody Iterable<Corriere> getAllC() {
    return corriereRepository.findAll();
  }
  
  @PostMapping ("/inserimento_Corriere")
  public @ResponseBody Corriere insertC(Corriere corriere) {
    return corriereRepository.save(corriere);
  }
  
  @PostMapping ("/trova_Corriere")
  public @ResponseBody Corriere getC(Long id) {
    return corriereRepository.findById(id).orElseThrow(null);
  }
  
  
  
  @PostMapping ("/modifica_Corriere")
  public @ResponseBody Corriere modifyC(@RequestParam (value ="idCo")Long id, Corriere corriere) {
    
    Corriere corriereToUpdate = getC(id);
    corriereToUpdate.setCognome(corriere.getCognome());
    corriereToUpdate.setNome(corriere.getNome());
    corriereToUpdate.setDob(corriere.getDob());
    corriereToUpdate.setStipendio(corriere.getStipendio());
    corriereToUpdate.setCf(corriere.getCf());
    corriereToUpdate.setPatente(corriere.getPatente());
    return corriereRepository.save(corriereToUpdate);
  }
  
  
  @PostMapping ("/cancella_Corriere")
  public @ResponseBody String deleteC(@RequestParam (value ="idCo")Long id) {
    corriereRepository.deleteById(id);
    return "Corriere eliminato";
  }
  
}