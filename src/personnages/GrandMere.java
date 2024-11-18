package personnages;

import java.util.Random;

public class GrandMere extends Humain{
	private TypeHumain[] types = TypeHumain.values();
	
	private enum TypeHumain {
		COMMERCANT("un commer�ant"), RONIN("un ronin"), YAKUZA("un yakuza"), SAMOURAI("un samourai"), GRANDMERE("une grand-m�re");
		
		private String nom;
		
		private TypeHumain(String nom) {
			this.nom=nom;
		}
		
		public String toString() {
			return nom;
		}
	}


	public GrandMere(String nom, int argent) {
		super(nom, "tisane", argent);
	}
	
	@Override
	protected void memoriser(Humain autreHumain) {
		if (nbConnaissance<5) {
			super.memoriser(autreHumain);
		}
		else {
			parler("Oh ma t�te ! Je ne peux plus retenir le nom d'une personne suppl�mentaire !");
		}
	}
	
	private String humainHasard() {
		Random random =new Random();
		return types[random.nextInt(5)].toString();
	}
	
	public void ragoter() {
		for(int i=0;i<nbConnaissance;i++) {
			if (memoire[i] instanceof Traitre){
				parler(" Je sais que "+memoire[i].getNom()+" est un tra�tre. Petit chenapan !");
			}
			else {
				parler("Je crois que "+memoire[i].getNom()+" est "+humainHasard());
			}
		}
	}
}
