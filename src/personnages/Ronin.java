package personnages;

public class Ronin extends Humain {
	private int honneur = 1;
	
	public Ronin(String nom, String boissonFavorite, int argent) {
		super(nom, boissonFavorite, argent);
	}
	
	public void donner(Commercant beneficiaire) {
		int argentDonne=argent/10;
		perdreArgent(argentDonne);
		parler(beneficiaire.getNom()+" prend ces "+ argentDonne +" sous");
		beneficiaire.recevoir(argentDonne);
	}
}
