package net.javiro.empleos.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import net.javiro.empleos.model.Vacante;

@Controller
public class HomeController {

	/*Especificamos que éste es el método que respondrá a nuestro directorio raíz de la aplicación, cuando hagamos un GET*/
	@GetMapping("/")
	public String mostrarHome(Model model) {

		String nombre = "Auxiliar de contabilidad";
		Date fechaPub= new Date();
		double salario = 900;
		boolean vigente = true;
		
		model.addAttribute("nombre",nombre);
		model.addAttribute("fecha",fechaPub);
		model.addAttribute("salario",salario);
		model.addAttribute("vigente",vigente);
		
		
		//No es necesario agregar la extensión .html porque tenemos thymeleaf
		return "home";
	}
	
	@GetMapping("/listado")
	public String mostrarListado(Model model) {
		List<String> lista = new LinkedList<>();
		
		lista.add("Ingeniero");
		lista.add("Arquitecto");
		lista.add("Vendedor");
		lista.add("Albañil");
		
		model.addAttribute("empleos", lista);
		return "listado";
	}
	
	@GetMapping("/detalle")
	public String mostrarDetalle(Model model) {
		Vacante vacante = new Vacante();
		
		vacante.setNombre("Ingeniero");
		vacante.setDescripcion("Solicitamos ingeniero de soporte");
		vacante.setFecha(new Date());
		vacante.setSalario(9300);
		
		model.addAttribute("vacante",vacante);
		
		//Retornamos el nombre de una vista
		return "detalle";
	}
	
	@GetMapping("/tabla")
	public String mostrarTabla(Model model) {
		
		List<Vacante> jobs = getVacantes();
		model.addAttribute("jobs", jobs);
		
		return "tabla";
	}
	
	
	private List<Vacante> getVacantes(){
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd-mm-yy");
		List<Vacante> jobs = new LinkedList<Vacante>();
		
		try {
			
			Vacante vc1= new Vacante();
			vc1.setId(1);
			vc1.setNombre("Ingeniero civil");
			vc1.setDescripcion("Oferta para multinacional");
			vc1.setFecha(sdf.parse("12-04-2022"));
			vc1.setSalario(14000);
			vc1.setDestacado(1);
			vc1.setImagen("empresa1.png");
			
			Vacante vc2= new Vacante();
			vc2.setId(2);
			vc2.setNombre("Arquitecto");
			vc2.setDescripcion("Oferta para multinacional");
			vc2.setFecha(sdf.parse("22-04-2022"));
			vc2.setSalario(40000);
			vc2.setDestacado(0);
			vc2.setImagen("empresa2.png");
			
			Vacante vc3= new Vacante();
			vc3.setId(3);
			vc3.setNombre("Ingeniero Naval");
			vc3.setDescripcion("Oferta para multinacional");
			vc3.setFecha(sdf.parse("04-04-2022"));
			vc3.setSalario(35000);
			vc3.setDestacado(0);
			
			
			Vacante vc4= new Vacante();
			vc4.setId(4);
			vc4.setNombre("Medico");
			vc4.setDescripcion("Oferta para multinacional");
			vc4.setFecha(sdf.parse("17-04-2022"));
			vc4.setSalario(78000);
			vc4.setDestacado(1);
			vc4.setImagen("empresa4.png");
			
			Vacante vc5= new Vacante();
			vc5.setId(5);
			vc5.setNombre("Profesor");
			vc5.setDescripcion("Oferta para multinacional");
			vc5.setFecha(sdf.parse("01-04-2022"));
			vc5.setSalario(12000);
			vc5.setDestacado(1);
			
			
			jobs.add(vc1);
			jobs.add(vc2);
			jobs.add(vc3);
			jobs.add(vc4);
			jobs.add(vc5);
			
		}catch(ParseException e) {
			System.out.println("Error: " + e.getMessage());
		}
		
		return jobs;
	}
	
}
