package personnages;

public class Yakuza extends Humain {
	private String clan;
	private int reputation = 0;

	public Yakuza(String nom, String boissonFavorite, int argent, String clan) {
		super(nom, boissonFavorite, argent);
		this.clan = clan;
	}

	public int getReputation() {
		return reputation;
	}

	public void extorquer(Commercant victime) {
		parler("Tiens, tiens, ne serait-ce pas un faible marchand qui passe par l� ?");
		parler(victime.getNom() + " , si tu tiens � la vie donne moi ta bourse !");
		int argentGagne = victime.seFaireExtorquer();
		gagnerArgent(argentGagne);
		reputation += 1;
		parler("J�ai piqu� les " + argentGagne + " sous de " + victime.getNom() + ", ce qui me fait " + argent
				+ " sous dans ma poche. Hi ! Hi !");
	}

	public int perdre() {
		int argentPerdu = argent;
		perdreArgent(argentPerdu);
		reputation -= 1;
		parler("J�ai perdu mon duel et mes " + argentPerdu + " sous, snif... J'ai d�shonor� le clan de " + clan);
		return argentPerdu;
	}

	public void gagner(int gain) {
		gagnerArgent(gain);
		reputation += 1;
		parler("Ce ronin pensait vraiment battre " + getNom() + " du clan de " + clan + " ? Je l'ai d�pouill� de ses "
				+ gain + " sous");
	}
	
	@Override
	public void direBonjour() {
		super.direBonjour();
		parler("Mon clan est celui de "+clan+".");
	}
}
