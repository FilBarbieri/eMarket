package emarket.gestioneOrdini;

import java.util.*;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@Controller
public class AlgoritmoController implements WebMvcConfigurer,gestioneOrdiniIF{

	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/index").setViewName("index");
		registry.addViewController("/").setViewName("index");
		registry.addViewController("/visualizzaPercorsi").setViewName("algoritmo");
	}


	private AlgoritmoService algoritmoService = new AlgoritmoService();

	//HTML
	@GetMapping ("/visualizzaPercorsi")
	public String visualizzaCorriere(Model model) {
		model.addAttribute("dati", getPercorsi());
		return "algoritmo";
	}


	//REST API
	@GetMapping ("/visualizza_Percorsi")
	public @ResponseBody ArrayList<Camion> getPercorsi() {
		return algoritmoService.getLista_Camion();
	}
		


}
