package personnages;

import objet.Equipement;

public class Romain {
	private String nom;
	private int force;
	private Equipement[] equipement = new Equipement[2];
	private int nbEquipement = 0;

	public Romain(String nom, int force) {
		this.nom = nom;
		this.force = force;
		assert isInvariantVerified();
	}

	public String getNom() {
		return nom;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "\"" + texte + "\"");
	}

	private String prendreParole() {
		return "Le romain " + nom + " : ";
	}

	public void recevoirCoup(int forceCoup) {
		assert forceCoup > 0;
		int oldforce = force;
		force -= forceCoup;
		if (force < 1) {
			force = 0;
			parler("J'abandonne !");
		} else {
			parler("Aie !");
		}
		assert isInvariantVerified();
		assert oldforce > force;
	}

	private boolean isInvariantVerified() {
		return this.force >= 0;
	}
	
	private void temp_sEquiper(Equipement equipement, int slot) {
		this.equipement[slot] = equipement;
		nbEquipement++;
		System.out.println("Le soldat " + this.nom + " s'équipe avec un " + 
				equipement.toString() + ".");
	}

	public void sEquiper(Equipement equipement) {
		int slot = 0;
		switch (nbEquipement) {
		case 2:
			System.out.println("Le soldat " + this.nom + " est déjà bien protégé !");
			break;
		case 1:
			if (this.equipement[0] == equipement) {
				System.out.println("Le soldat " + this.nom + 
						" possède déjà un " + equipement.toString() + " !");
				break;
			} else {
				slot = 1;
			}
		default:
			temp_sEquiper(equipement, slot);
		}
	}
	
	public static void main(String[] args) {
		Romain minus = new Romain("Minus", 6);
		Equipement casque = Equipement.CASQUE;
		Equipement bouclier = Equipement.BOUCLIER;
		System.out.println(casque.toString() + bouclier.toString());
		
		minus.sEquiper(casque);
		minus.sEquiper(casque);
		minus.sEquiper(bouclier);
		minus.sEquiper(casque);
	}
}
