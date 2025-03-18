package personnages;

import objets.Equipement;

public class Romain {
	private String nom;
	private int force;
	private Equipement[] equipements = new Equipement[2];
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
	
	public int getForce() {
		return force;
	}

//	public void recevoirCoup(int forceCoup) {
//		assert forceCoup > 0;
//		int oldforce = force;
//		force -= forceCoup;
//		if (force < 1) {
//			force = 0;
//			parler("J'abandonne !");
//		} else {
//			parler("Aie !");
//		}
//		assert isInvariantVerified();
//		assert oldforce > force;
//	}
	
	private int calculResistanceEquipement(int forceCoup) {
		String texte;
		texte = "Ma force est de " + this.force + ", et la force du coup est de" + forceCoup;
		int resistanceEquipement = 0;
		if ((nbEquipement != 0)) {
			texte += "\nMais heureusement, grace à mon équipement sa force est diminué de ";
			for (int i = 0; i < nbEquipement;) {
				if ((equipements[i] != null &&
						equipements[i].equals(Equipement.BOUCLIER)) == true) {
					resistanceEquipement += 8;
				} else {
					System.out.println("Equipement casque");
					resistanceEquipement += 5;
				}
			}
			texte += resistanceEquipement + "!";
		}
		parler(texte);
		forceCoup -= resistanceEquipement;
		return forceCoup;
	}
	
	private Equipement[] ejecterEquipement() {
		System.out.println("L'équipement de " + nom.toString() + " s'envole sous la force du coup.");
		Equipement[] equipementEjecte = new Equipement[nbEquipement];
		int nbEquipementEjecte = 0;
		for (int i = 0; i < nbEquipement; i++) {
			if (equipements[i] != null) {
				equipementEjecte[nbEquipementEjecte] = equipements[i];
				nbEquipementEjecte++;
				equipements[i] = null;
			}
		}
		return equipementEjecte;
	}

	public Equipement[] recevoirCoup(int forceCoup) {
		Equipement[] equipementEjecte = null;
		
		forceCoup = calculResistanceEquipement(forceCoup);
		
		force -= forceCoup;
		if (force == 0) {
			parler("Aïe");
		}
		equipementEjecte = ejecterEquipement();
		parler("J'abandonne...");
		return equipementEjecte;
	}
	
	private boolean isInvariantVerified() {
		return this.force >= 0;
	}
	
	private void temp_sEquiper(Equipement equipement, int slot) {
		this.equipements[slot] = equipement;
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
			if (this.equipements[0] == equipement) {
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
