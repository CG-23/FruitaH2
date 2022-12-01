package cat.itacademy.barcelonactiva.gimeno.carlos.s04.t02.n02.service;


import cat.itacademy.barcelonactiva.gimeno.carlos.s04.t02.n02.model.Fruita;

public interface ServiceFruita {
	
	Fruita addfruita(Fruita fruita);
	
	Fruita getOne(long id);
	
	Fruita update(long id, Fruita fruitamodificar);
	
	boolean delete(long id);
		
}
