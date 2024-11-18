package personnages;

import java.util.Random;

public class Traitre extends Samourai{
	private int niveauTraitrise=0;
	
	public Traitre(String seigneur, String nom, String boissonFavorite, int argent) {
		super(seigneur,nom,boissonFavorite,argent);
	}
	
	@Override
	public void direBonjour() {
		super.direBonjour();
		parler( "Mais je suis un traître et mon niveau de traîtrise est : "+niveauTraitrise+". Chut !");
	}
	
	public void ranconner(Commercant victime) {
		if (niveauTraitrise<3) {
			int argentRanconner=victime.getArgent()/5;
			victime.perdreArgent(argentRanconner);
			gagnerArgent(argentRanconner);
			parler("Si tu veux ma protection contre les Yakuzas, il va falloir payer ! Donne-moi "+argentRanconner+" sous ou gare à toi !");
			victime.parler("Tout de suite grand "+getNom()+".");
			niveauTraitrise++;
		}
		else {
			parler("Mince je ne peux plus rançonner personne sinon un samouraï risque de me démasquer !");
		}
	}
	
	public void faireLeGentil() {
		if (nbConnaissance<1) {
			parler("Je ne peux faire ami ami avec personne car je ne connais personne ! Snif.");
		}
		else {
			Random random= new Random();
			Humain ami=memoire[random.nextInt(nbConnaissance)];
			String nomAmi=ami.getNom();
			int don=argent/20;
			parler("Il faut absolument remonter ma cote de confiance. Je vais faire ami ami avec "+nomAmi+".");
			parler(" Bonjour l'ami ! Je voudrais vous aider en vous donnant "+don+" sous.");
			perdreArgent(don);
			ami.gagnerArgent(don);
			ami.parler(" Merci "+getNom()+". Vous êtes quelqu'un de bien.");
			if (niveauTraitrise>1) {
				niveauTraitrise-=1;
			}
		}
	}
}
