package cat.itacademy.barcelonactiva.gimeno.carlos.s04.t02.n02.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cat.itacademy.barcelonactiva.gimeno.carlos.s04.t02.n02.Repository.FruitaRepository;
import cat.itacademy.barcelonactiva.gimeno.carlos.s04.t02.n02.model.Fruita;
import cat.itacademy.barcelonactiva.gimeno.carlos.s04.t02.n02.service.ServiceFruita;

@RestController
@RequestMapping("/fruita")

public class FruitaControllers {
	
	private final ServiceFruita servicefruita;
	
	public FruitaControllers(ServiceFruita servicefruita){
		this.servicefruita = servicefruita;		
	}
	@PostMapping("/add")
	public ResponseEntity<Fruita> addFruita(@RequestBody Fruita fruita) {
		return new ResponseEntity<Fruita>(servicefruita.addfruita(fruita), HttpStatus.CREATED);
	}

	@GetMapping("/getOne/{id}")
	public ResponseEntity<Fruita> getOne(@PathVariable("id") long id) {
		return new ResponseEntity<Fruita>(servicefruita.getOne(id), HttpStatus.OK);
	}
	

	@PutMapping("/update/{id}")
	public ResponseEntity<Fruita> update(@PathVariable("id") long id, @RequestBody Fruita fruita) {
		return new ResponseEntity<Fruita>(servicefruita.update(id, fruita), HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity delete(@PathVariable("id") long id) {
		boolean resposta = servicefruita.delete(id);
		if(resposta == true) {
			return new ResponseEntity(HttpStatus.OK);
		}
		else {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
	}
}
