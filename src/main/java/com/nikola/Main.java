package com.nikola;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication //oznacuvame deka ova e spring boot aplikacija
@RestController //za da rabotat rest endpoints morame da koristime RestController
public class Main {
	
	private final CostumerRepository costumerRepository;
	
	public Main(CostumerRepository costumerRepository) {
		this.costumerRepository=costumerRepository;
	}
	
public static void main(String [] args) {
	SpringApplication.run(Main.class, args);
}

@GetMapping("/")//ova e rest endpoint i e root na nasata web aplikacija i e HTTP Get
public String greet() {
	return "hello";
}

@GetMapping("/costumers")
public List<Costumer> getCostumers(){
	return costumerRepository.findAll();
	
	}


@PostMapping("/costumers") //POST method
public void addCostumer(@RequestBody NewCostumerRequest request) {//Requestot koj ide od POST methodot, treba da go fatime od body-to
	Costumer costumer =new Costumer();//kreirame nov costumer
	costumer.setName(request.getName());//setirame ime
	costumer.setEmail(request.getEmail());//email
	costumer.setAge(request.getAge());//age
	costumerRepository.save(costumer);//go zacuvuvame vo bazata
}

@DeleteMapping("/costumers/{costumerId}") //DELETE method
public void deleteCostumer(@PathVariable("costumerId") Integer id) {//dobivame id od klientot
	//treba da proverime dali costumer so toa id, ako postoi togas da go izbriseme, ako ne da vratime error, no vo ovoj slucaj
	//zaradi tutorijalot toa e ednostavno i samo go briseme
	costumerRepository.deleteById(id);
	
	
	
}

}
