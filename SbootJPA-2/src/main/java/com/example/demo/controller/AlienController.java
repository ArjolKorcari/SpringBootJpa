package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dao.AlienRepo;
import com.example.demo.model.Alien;


// @Controller anotation qe na tregon kush eshte kontrolleri
@RestController
public class AlienController {
	
	// ky eshe nje anotation qe ben konfigurimin automatik te nje dependecy
	@Autowired
	AlienRepo repo;// objekt qe e marrim nga interface
	
	@RequestMapping("/")  // kjo sherben kur kerkojm ne console te shfaq faqen home.jsp
	public String home() {
		return "home.jsp";
	}
	
//	@RequestMapping("/addAlien")// kjo eshte kur dergojm nje request per te shtuar nje alien shfaqet kjo metoda
//	public String addAlien(Alien alien) {// metod qe shton nje alien
//		repo.save(alien);// repo.save na ruan te dhenat ne database
//		return "home.jsp";
//	}
	
	@RequestMapping("/getAlien")
	public ModelAndView getAlien(@RequestParam int aid)
	{
		ModelAndView mv=new ModelAndView("showAlien.jsp") ;
		
		//kto jan metoda qe i kemi krijuar te AienRepo(interface) dhe kemi ber shembull
		
//		System.out.println(repo.findByTech("Spring"));
//		System.out.println(repo.findByAidGreaterThan(101));
//		System.out.println(repo.findByTechSorted("Java"));
		
			
		Alien alien=repo.findById(aid).orElse(new Alien());
		mv.addObject(alien);
		return mv;
			
	}
	
	
	
//	@RequestMapping(path="/aliens",produces= {"application/xml"})
//	@ResponseBody   /*kjo tells a controller that the object returned
//	 is automatically serialized into JSON and passed back into the HttpResponse object */
//	public List<Alien> getAliens() {
//		return repo.findAll();
//	}
	
	@RequestMapping("/aliens/{aid}")                       // i gjen nga id qe kan
	public Optional<Alien> getAlienById(@PathVariable("aid") int aid) {
		return repo.findById(aid);
		
	}
	 
	
	@DeleteMapping("/alien/{aid}")                       // metod qe i ben delete te dhenave ne databaz
	public String deleteAlien(@PathVariable int aid) {
		Alien a= repo.getOne(aid);
		repo.delete(a);
		return "deleted";
		
	}
	
	                                                        // metod qe i ben update ose put nje te dhene ne databaz
	@PutMapping(path="/alien",consumes= {"application/json"})// kjo prd te post metoda e http
	public Alien saveOrupdateAlien(@RequestBody Alien alien) {
		repo.save(alien);
		return alien;
	
	}
	
	
	                                                         // metod qe i ben add nje alien 
	@PostMapping(path="/alien",consumes= {"applcation/json"})// kjo prd te post metoda e http
	public Alien addAlien(@RequestBody Alien alien) {
		repo.save(alien);
		return alien;
	}
	
	@GetMapping(path="/aliens")                              // kjo na tregon gjith te dhenat qe kemi te ruajtura
	public List<Alien> getAliens() {
		return repo.findAll();
	}
	
	
	
	
	
	
	
	
	

}
