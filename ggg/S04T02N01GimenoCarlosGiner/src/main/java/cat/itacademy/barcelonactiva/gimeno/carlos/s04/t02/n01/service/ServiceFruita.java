package cat.itacademy.barcelonactiva.gimeno.carlos.s04.t02.n01.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import cat.itacademy.barcelonactiva.gimeno.carlos.s04.t02.n01.model.Fruita;

public interface ServiceFruita {
	

	ResponseEntity<List<Fruita>> getAllFruita(String nom);

	ResponseEntity<Fruita> getFruitaById(long id);

	ResponseEntity<Fruita> addFruita(Fruita fruita);

	ResponseEntity<Fruita> updateFruites(long id, Fruita fruita);

	ResponseEntity<Fruita> updateFruita(long id, Fruita fruita);

	ResponseEntity<HttpStatus> deleteFruita(long id);

	ResponseEntity<HttpStatus> deleteAllFruites();
	
}
