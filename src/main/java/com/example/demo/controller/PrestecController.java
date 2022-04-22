package com.example.demo.controller;

import java.math.BigDecimal;

import javax.persistence.Column;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.model.Prestec;
import com.example.demo.repository.PrestecRepository;

@Controller
@RequestMapping( {"/prestec"} )
public class PrestecController {
	
	@Autowired
	private PrestecRepository prestecrepo;
	
	@PostMapping(path = "/add") // localhost:8080/vol/add?codi=1....
	public String addNewPrestec (Prestec prestec, Model model) {
		model.addAttribute("prestec", prestec);
		prestecrepo.save(prestec);
		return "saved";
		
	}
	
	@GetMapping
    public String main(Model model) {
        model.addAttribute("prestec", new Prestec());
        return "index";
    }
	
	@GetMapping(path="/all")
	  public @ResponseBody Iterable<Prestec> getAllPrestecs() {
	    // This returns a JSON or XML with the users
	    return prestecrepo.findAll();
	  }
	

}

