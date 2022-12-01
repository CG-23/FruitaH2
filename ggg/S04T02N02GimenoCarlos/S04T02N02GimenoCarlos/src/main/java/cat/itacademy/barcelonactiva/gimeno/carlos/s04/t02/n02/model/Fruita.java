package cat.itacademy.barcelonactiva.gimeno.carlos.s04.t02.n02.model;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
@jakarta.persistence.Table(name = "Fruites")
public class Fruita {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "nom")
	private String nom;

	@Column(name = "quantitatKG")
	private int quantitatKG;

	public Fruita() {
	}

	public Fruita(String nom, int quantitatKG) {
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

	public long getId() {
		return id;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id, nom, quantitatKG);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Fruita other = (Fruita) obj;
		return id == other.id && Objects.equals(nom, other.nom) && quantitatKG == other.quantitatKG;
	}

	@Override
	public String toString() {
		return "Fruita [id=" + id + ", nom=" + nom + ", quantitatKG=" + quantitatKG + "]";
	}
	

	
	
}
