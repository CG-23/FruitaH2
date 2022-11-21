package cat.itacademy.barcelonactiva.gimeno.carlos.s04.t02.n01.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Fruites")
public class Fruita {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "nom")
	private String nom;

	@Column(name = "quantitatKG")
	private int quantitatKG;

	public Fruita() {

	}

	public Fruita(String nom, int quantitatKG, boolean published) {
		this.nom = nom;
		this.quantitatKG = quantitatKG;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getQuantitatKG() {
		return quantitatKG;
	}

	public void setQuantitatKG(int quantitatKG) {
		this.quantitatKG = quantitatKG;
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Fruita [id=" + id + ", nom=" + nom + ", quantitatKG=" + quantitatKG + "]";
	}
	

	
	
}
