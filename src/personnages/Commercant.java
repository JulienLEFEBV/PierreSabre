package personnages;

public class Commercant extends Humain{

	public Commercant(String nom, int argent) {
		super(nom, "thé", argent);
	}
	
	public int seFaireExtorquer() {
		int sommeExtorque=argent;
		parler("J’ai tout perdu! Le monde est trop injuste...");
		perdreArgent(sommeExtorque);
		return sommeExtorque;
	}
	
	public void recevoir(int argentRecu) {
		parler(argentRecu + "  sous ! Je te remercie généreux donateur!");
		gagnerArgent(argentRecu);
	}
}
