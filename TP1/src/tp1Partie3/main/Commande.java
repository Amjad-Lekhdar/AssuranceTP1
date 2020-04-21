package tp1Partie3.main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Commande {
	
	
	
	static String nom;
	
	public static int nbPoutine;
	public static int nbFrites;
	public static int nbPoulet;
	

	private static double prixPoulet;

	private static double PrixPoutine;

	private static double PrixFrite;
	
	
	
	public Commande(String pNom,  int pNbPoutine,int pNbFrites,int pNbPoulet) throws FileNotFoundException, IOException {
		String[] commande = {""};
		
		for (int i = 0; i < commande.length; i++) {
			
			nom=pNom;
			
			nbPoutine=pNbPoutine;
			nbFrites=pNbFrites;
			nbPoulet=pNbPoulet;
			
			
			String[] tab=lireFichier(new File("src/tp1Partie3/main/facture.txt").getAbsolutePath());
			
			PrixPoutine = Double.parseDouble(tab[6]);
			PrixFrite = Double.parseDouble(tab[8]);
			prixPoulet=Double.parseDouble(tab[10]);
		}
		
	}
	
	
	public double calculerPrix() {
		
		double total = 0;
		

		total=(nbFrites*PrixFrite)+(nbPoutine*PrixPoutine)+(nbPoulet*prixPoulet);

		DecimalFormat df = new DecimalFormat();
        df.setMaximumFractionDigits(2); // arrondi à 2 chiffres apres la virgules
        df.setMinimumFractionDigits(2);
        df.setDecimalSeparatorAlwaysShown(true);
		
		
		total=((nbFrites*PrixFrite)+(nbPoutine*PrixPoutine)+(nbPoulet*prixPoulet))*1.14975;
		
		df.format(total);
		

		return total;
	}
	
	public String toString() { 
		
		DecimalFormat df = new DecimalFormat();
        df.setMaximumFractionDigits(2); 
        df.setMinimumFractionDigits(2);
        df.setDecimalSeparatorAlwaysShown(true);
		
		
        return "\nNom : " + nom +"\n" +
        		"Total : " +df.format(calculerPrix()) +"$" +"\n" ; 
    } 
	
	
	public void afficheTotal() {
		
		DecimalFormat df = new DecimalFormat();
        df.setMaximumFractionDigits(2); 
        df.setMinimumFractionDigits(2);
        df.setDecimalSeparatorAlwaysShown(true);
		
		
		System.out.println("\nNom : " + nom);
		System.out.println("Total : " + df.format(calculerPrix())+"$");
		
	}
	
	public static String[] lireFichier( String chemin ) throws FileNotFoundException, IOException {

		String[] chaqueLigne = null;

		try (BufferedReader br = new BufferedReader( new FileReader( chemin ) )) {
			String ligne;

			 	ligne = br.readLine();
				chaqueLigne=ligne.split(";");
			
		} 
		return chaqueLigne;
	}
	
	public static void commandeIncorrecte(Commande com) {
		
		try {
			if (com.calculerPrix() == 0 || Commande.nbFrites < 0 || Commande.nbPoulet < 0 || Commande.nbPoutine < 0 ) {
				
				System.out.println("\nVoici les commandes incorrectes : ");
				
				if (com.calculerPrix() == 0) {
					System.out.println("\nLa valeur totale de la commande de " + Commande.nom + " est à 0$." );
				}
				if (Commande.nbFrites < 0 || Commande.nbPoulet < 0 || Commande.nbPoutine < 0) {
					System.out.println("\nLe nombre de frites ou de poulets ou de poutines de la commande à " + 
						Commande.nom + " est une valeur erronée.");
				}
				com.toString();
			}
			
		} catch (Exception e) {
			e.getMessage();
		}
	}
}
