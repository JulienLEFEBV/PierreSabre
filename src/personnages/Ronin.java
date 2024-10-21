package personnages;

public class Ronin extends Humain {
	private int honneur = 1;

	public Ronin(String nom, String boissonFavorite, int argent) {
		super(nom, boissonFavorite, argent);
	}

	public void donner(Commercant beneficiaire) {
		int argentDonne = argent / 10;
		perdreArgent(argentDonne);
		parler(beneficiaire.getNom() + " prend ces " + argentDonne + " sous");
		beneficiaire.recevoir(argentDonne);
	}

	public void provoquer(Yakuza adversaire) {
		int force=honneur*2;
		if (force>=adversaire.getReputation()) {
			parler("Je t'ai retrouvé vermine, tu vas payer pour ce que tu as fait à ce pauvre marchand!");
			parler("Je t’ai eu petit yakusa!");
			int argentGagne=adversaire.perdre();
			gagnerArgent(argentGagne);
			honneur+=1;
		}
		else {
			parler(" J'ai perdu contre ce yakuza, mon honneur et ma bourse ont en pris un coup");
			int argentPerdu=argent;
			perdreArgent(argentPerdu);
			adversaire.gagner(argentPerdu);
			honneur-=1;
		}
	}
}
