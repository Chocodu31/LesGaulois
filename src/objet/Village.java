package objet;

import personnages.Gaulois;

public class Village {
	private String nom;
	private int nbVillageois = 0;
	private Gaulois chef;
	private Gaulois[] villageois;

	public Village(String nom, Gaulois chef, int nbmaximum) {
		this.nom = nom;
		this.chef = chef;
		villageois = new Gaulois[nbmaximum];
		chef.setVillage(this);
	}

	public String getNom() {
		return nom;
	}

	public Gaulois getChef() {
		return chef;
	}

	public void ajouterVillageois(Gaulois gaulois) {
		villageois[nbVillageois] = gaulois;
		nbVillageois++;
		gaulois.setVillage(this);
	}
	
	public Gaulois trouverVillageois(int numvillageois) {
		numvillageois--;
		if (numvillageois < nbVillageois) {
			return villageois[numvillageois];
		}
		System.out.println("Il n'y a pas autant d'habitants dans notre village !");
		return null;
	}
	
	public void afficherVillageois() {
		System.out.println("Dans le village \"" + this.nom + "\" du chef " + this.chef + " vivent les légendaires gaulois :");
		for (int i = 0; i < nbVillageois; i++) {
			Gaulois gaulois = villageois[i];
			System.out.println(" - " + gaulois);
		}
	}
	
	public static void main(String[] args) {
		Gaulois abraracourcix = new Gaulois("Abraracourcix", 6);
		Village village = new Village("Village des Irréductibles", abraracourcix, 30);		
		Gaulois asterix = new Gaulois("Astérix", 8);
		village.ajouterVillageois(asterix);
		Gaulois gaulois = village.trouverVillageois(1);
		System.out.println(gaulois);
		gaulois = village.trouverVillageois(2);
		System.out.println(gaulois);
		Gaulois obelix = new Gaulois("Obélix", 25);
		village.ajouterVillageois(obelix);
		village.afficherVillageois();
		Gaulois doublepolemix = new Gaulois("DoublePolémix", 4);
		abraracourcix.sePresenter();
		asterix.sePresenter();
		obelix.sePresenter();
		doublepolemix.sePresenter();
		
		
	}
	
}
