package cat.itacademy.barcelonactiva.gimeno.carlos.s04.t02.n01.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import cat.itacademy.barcelonactiva.gimeno.carlos.s04.t02.n01.Repository.FruitaRepository;
import cat.itacademy.barcelonactiva.gimeno.carlos.s04.t02.n01.model.Fruita;

@Service
public class ServiceImpl implements ServiceFruita {
	FruitaRepository fruitaRepository;
	
	@Override
	public ResponseEntity<List<Fruita>> getAllFruita(@RequestParam(required = false) String nom) {
		try {
			List<Fruita> Llistafruita = new ArrayList<Fruita>();

			if (nom == null)
				fruitaRepository.findAll().forEach(Llistafruita::add);
			else
				fruitaRepository.findByTitleContaining(nom).forEach(Llistafruita::add);

			if (Llistafruita.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(Llistafruita, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@Override
	public ResponseEntity<Fruita> getFruitaById(@PathVariable("id") long id) {
		Optional<Fruita> fruitaid = fruitaRepository.findById(id);

		if (fruitaid.isPresent()) {
			return new ResponseEntity<>(fruitaid.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	@Override
	public ResponseEntity<Fruita> addFruita(@RequestBody Fruita fruita) {
		try {
			Fruita _fruita = fruitaRepository.save(new Fruita(fruita.getNom(), fruita.getQuantitatKG(), false));
			return new ResponseEntity<>(_fruita, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@Override
	public ResponseEntity<Fruita> updateFruites(@PathVariable("id") long id,@RequestBody Fruita fruita) {
		Optional<Fruita> fruitaid = fruitaRepository.findById(id);

		if (fruitaid.isPresent()) {
			Fruita _fruita = fruitaid.get();
			_fruita.setNom(fruita.getNom());
			_fruita.setQuantitatKG(fruita.getQuantitatKG());
			return new ResponseEntity<>(fruitaRepository.save(_fruita), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	@Override
	public ResponseEntity<Fruita> updateFruita(@PathVariable("id") long id, @RequestBody Fruita fruita) {
		Optional<Fruita> fruitaid = fruitaRepository.findById(id);

		if (fruitaid.isPresent()) {
			Fruita _fruita = fruitaid.get();
			_fruita.setNom(fruita.getNom());
			_fruita.setQuantitatKG(fruita.getQuantitatKG());
			return new ResponseEntity<>(fruitaRepository.save(_fruita), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	@Override
	public ResponseEntity<HttpStatus> deleteFruita(@PathVariable("id") long id) {
		try {
			fruitaRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@Override
	public ResponseEntity<HttpStatus> deleteAllFruites() {
		try {
			fruitaRepository.deleteAll();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

}
