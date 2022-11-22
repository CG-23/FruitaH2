package cat.itacademy.barcelonactiva.gimeno.carlos.s04.t02.n01.service;

import org.springframework.stereotype.Service;

import cat.itacademy.barcelonactiva.gimeno.carlos.s04.t02.n01.Repository.FruitaRepository;
import cat.itacademy.barcelonactiva.gimeno.carlos.s04.t02.n01.model.Fruita;

@Service
public class ServiceImpl implements ServiceFruita {
	
	private final FruitaRepository fruitaRepository;
	public ServiceImpl(FruitaRepository fruitaRepository){
		this.fruitaRepository = fruitaRepository;		
	}
	
	@Override
	public Fruita addfruita(Fruita fruita) {
		return fruitaRepository.save(fruita);
	}
	@Override
	public Fruita getOne(long id) {
		return fruitaRepository.findById(id).orElseThrow(()-> {throw new RuntimeException();});
	}
	@Override
	public Fruita update(long id, Fruita fruitamodificar) {
		Fruita fruitabuscada = fruitaRepository.findById(id).get();
		fruitabuscada.setNom(fruitamodificar.getNom());
		fruitabuscada.setQuantitatKG(fruitamodificar.getQuantitatKG());
		return fruitaRepository.save(fruitabuscada);
		
	}
	@Override
	public boolean delete(long id) {
		
		try {
			fruitaRepository.deleteById(id);
			return true;
		}catch(Exception e) {
		return false;
		}
	}
}
