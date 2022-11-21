package cat.itacademy.barcelonactiva.gimeno.carlos.s04.t02.n01.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cat.itacademy.barcelonactiva.gimeno.carlos.s04.t02.n01.Repository.FruitaRepository;
import cat.itacademy.barcelonactiva.gimeno.carlos.s04.t02.n01.model.Fruita;
import cat.itacademy.barcelonactiva.gimeno.carlos.s04.t02.n01.service.ServiceImpl;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/fruita")
public class FruitaControllers {
	
	@Autowired
	FruitaRepository fruitaRepository;
	ServiceImpl serviceImpl;

	@GetMapping("/getAll")
	public ResponseEntity<List<Fruita>> getAllFruita(@RequestParam(required = false) String nom) {
		return serviceImpl.getAllFruita(nom);
	}

	@GetMapping("/getOne/{id}")
	public ResponseEntity<Fruita> getFruitaById(@PathVariable("id") long id) {
		return serviceImpl.getFruitaById(id);
	}

	@PostMapping("/add")
	public ResponseEntity<Fruita> addFruita(@RequestBody Fruita fruita) {
		return serviceImpl.addFruita(fruita);
	}

	@PutMapping("/fruites/{id}")
	public ResponseEntity<Fruita> updateFruites(@PathVariable("id") long id,@RequestBody Fruita fruita) {
		return serviceImpl.updateFruita(id, fruita);
	}
	
	@PutMapping("/fruites/{id}")
	public ResponseEntity<Fruita> updateFruita(@PathVariable("id") long id, @RequestBody Fruita fruita) {
		return serviceImpl.updateFruita(id, fruita);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<HttpStatus> deleteFruita(@PathVariable("id") long id) {
		return serviceImpl.deleteFruita(id);
	}

	@DeleteMapping("/delete")
	public ResponseEntity<HttpStatus> deleteAllFruites() {
		return serviceImpl.deleteAllFruites();

	}

}
