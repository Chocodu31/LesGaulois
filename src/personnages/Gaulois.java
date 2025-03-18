package personnages;

import objets.Equipement;
import objets.Village;

public class Gaulois {
	private String nom;
//	private int force;
	private int force;
	private int nbTrophees;
	private Equipement[] trophees = new Equipement[100];
	private int effetPotion = 1;
	private Village village;
	
	public Gaulois(String nom, int force) {
		this.nom = nom;
		this.force = force;
	}

	public String getNom() {
		return nom;
	}
	
	public void setVillage(Village village) {
		this.village = village;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "\"" + texte + "\"");
	}

//	private String prendreParole() {
//		return "Le Gaulois " + nom + " : ";
//	}
	
	private String prendreParole() {
		return "Le gaulois " + nom + " : ";
	}

	public void sePresenter() {
		if (village != null) {
			if (village.getChef() == this) {
				System.out.println("Le Gaulois " + this.getNom() + " : \"Bonjour, je m'appelle " + this.getNom()
				+ ". Je suis le chef du village '" + village.getNom() + "'.\"");
			} else {
				System.out.println("Le Gaulois " + this.getNom() + " : \"Bonjour, je m'appelle " + this.getNom()
				+ ". J'habite le village '" + village.getNom() + "'.\"");
			}
		} else {
			System.out.println("Le Gaulois " + this.getNom() + " : \"Bonjour, je m'appelle " + this.getNom()
			+ ". Je voyage de villages en villages.\"");
		}
	}

//	public void frapper(Romain romain) {
//		System.out.println(nom + " envoie un grand coup dans la mâchoire de " + romain.getNom());
//		romain.recevoirCoup((force*effetPotion) /3);
//		if (effetPotion > 1) {
//			effetPotion--;
//		}
//	}
	
	public void frapper(Romain romain) {
		System.out.println(nom + " envoie un grand coup dans la mâchoire de " + romain.getNom());
		Equipement[] tempTrophees = romain.recevoirCoup((force / 3) * effetPotion);
		for (int i = 0; tempTrophees != null && i < tempTrophees.length; i++, nbTrophees++) {
		this.trophees[nbTrophees] = trophees[i];
		}
	}
	
	public void boirePotion(int forcePotion) {
		effetPotion = forcePotion;
	}
	
	@Override
	public String toString() {
		return nom;
	}

	public static void main(String[] args) {
		Gaulois asterix = new Gaulois("Astérix", 8);
		System.out.println(asterix);
	}
	
}
