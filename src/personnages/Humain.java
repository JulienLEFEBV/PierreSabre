package personnages;

public class Humain {
	private static final int TAILLE_MEMOIRE=30;
	private String nom;
	private String boissonFavorite;
	protected int argent;
	protected int nbConnaissance=0;
	protected Humain[] memoire=new Humain[TAILLE_MEMOIRE];

	public Humain(String nom, String boissonFavorite, int argent) {
		this.nom = nom;
		this.boissonFavorite = boissonFavorite;
		this.argent = argent;
	}

	public String getNom() {
		return nom;
	}

	public int getArgent() {
		return argent;
	}

	protected void parler(String texte) {
		System.out.println("(" + nom + ") - " + texte);
	}

	public void direBonjour() {
		parler("Bonjour ! Je m’appelle " + nom + " et j’aime boire du " + boissonFavorite+".");
	}

	public void boire() {
		parler("Mmmm, un bon verre de " + boissonFavorite + " ! GLOUPS !");
	}

	protected void perdreArgent(int argentPerdu) {
		argent -= argentPerdu;
	}

	protected void gagnerArgent(int argentGagne) {
		argent += argentGagne;
	}
	
	public void faireConnaissanceAvec(Humain autreHumain) {
		direBonjour();
		autreHumain.repondre(this);
		memoriser(autreHumain);
	}
	
	public void repondre(Humain autreHumain) {
		direBonjour();
		memoriser(autreHumain);
	}

	protected void memoriser(Humain autreHumain) {
		if(nbConnaissance<TAILLE_MEMOIRE) {
			memoire[nbConnaissance]=autreHumain;
			nbConnaissance++;
		}
		else {
			for(int i=1;i<TAILLE_MEMOIRE;i++) memoire[i-1]=memoire[i];
			memoire[TAILLE_MEMOIRE-1]=autreHumain;
		}
	}
	
	public void listerConnaissance() {
		String texte="Je connais beaucoup de monde dont : ";
		if (nbConnaissance>0) {
			for (int i=0;i<nbConnaissance-1;i++) texte+=memoire[i].getNom()+", ";
			texte+=memoire[nbConnaissance-1].getNom();
			parler(texte);
		}
	}
	
	public void acheter(String bien, int prix) {
		if (prix <= argent) {
			parler("J'ai " + argent + " sous en poche. Je vais pouvoir m'offrir " + bien + " à " + prix + " sous");
			perdreArgent(prix);
		} else {
			parler("Je n'ai plus que  " + argent + " sous en poche. Je ne peux même pas m'offrir " + bien + " à " + prix
					+ " sous");
		}
	}
}
