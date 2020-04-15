package tp1Partie3.main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import tp1Partie3.main.Commande;

public class Principal {
	
	private static String[] tabClient = new String[3];
	private static String[] tabPlats = new String[3];
	private static Commande[] tabCommande = new Commande[3];
	
	private static ArrayList<Commande> listeCommande = new ArrayList<Commande>(3);
	
	
	
	
	public static void main(String[] args) throws IOException {
		
		String[] tab=lireFichier(new File("src/tp1Partie3/main/facture.txt").getAbsolutePath());
		
		
		
		tabClient[0]=tab[1];
		
		
		
		tabClient[1]=tab[2];
		tabClient[2]=tab[3];
		
		tabPlats[0]=tab[5];
		tabPlats[1]=tab[7];
		tabPlats[2]=tab[9];
		
		
		
		System.out.println("Bienvenue chez Barette");
		
		
		/*cela affiche le total de chaque clients
		 * 
		 * Affichage:
		 * 
		 * 
		 * Bienvenue chez Barette

			Nom : Roger
			Total : 10.5$
			
			Nom : C�line
			Total : 20.75$
			
			Nom : Steeve
			Total : 0.0$

		
		 */
		
		Commande com1 = new Commande(tabClient[0],1,0,0);
		
		com1.afficheTotal();
		
		listeCommande.add(com1);
		
		
		
		Commande com2 = new Commande(tabClient[1],0,2,1 );
		
		com2.afficheTotal();
		
		listeCommande.add(com2);
		
		

		
		Commande com3 = new Commande(tabClient[2], 0, 0, 0);
			
		com3.afficheTotal();
		
		listeCommande.add(com3);
		
		
		

		
		
		
		
		
		EcrireFichier();
		
		 
		
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
	
	public static void EcrireFichier() throws FileNotFoundException, IOException {

		
		
		 DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd-HH:mm");
		 LocalDateTime now = LocalDateTime.now();
		 //String monFichier="Facture-du-"+dtf.format(now).toString()+".txt";
		 String monFichier="Facture-du-.txt";

		 
		 try {
			
			 
			 PrintWriter  fichier = new PrintWriter(monFichier);
		 
			 //PrintWriter  fichier = new PrintWriter(new File("Facture.txt"));

		 
	       
		for (Commande com : listeCommande) {
			
			fichier.write(com.toString());
			
		}
		
		
		 
		 
	
	       
		 fichier.close();
		 
		 }
		 catch (IOException e)
		 {
		 e.printStackTrace();
		 }
		
	}

}
