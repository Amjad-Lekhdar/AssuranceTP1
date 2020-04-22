package tp1Partie3.main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import tp1Partie3.main.Commande;
public class Principal {
	
	private static String[] tabClient = new String[3];
	private static String[] tabPlats = new String[3];
	private static Commande com1 ;
	private static Commande com2;
	private static Commande com3;
	private static String monFichier;
	
	
	
	public static void main(String[] args) throws IOException {
		
		String[] tab=lireFichier(new File("src/tp1Partie3/main/facture.txt").getAbsolutePath());
		
		
		
		tabClient[0]=tab[1];
		
		
		
		tabClient[1]=tab[2];
		tabClient[2]=tab[3];
		
		tabPlats[0]=tab[5];
		tabPlats[1]=tab[7];
		tabPlats[2]=tab[9];
		

		
		Date actuelle = new Date();
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd-HH:mm");
        
        String date=dateFormat.format(actuelle);
		
		 DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM\\dd-HH:mm");
		 LocalDateTime now = LocalDateTime.now();
		 monFichier="Facture-du-"+date+".txt";
		 //monFichier="Facture-du-.txt";

		monFichier="Facture-du-.txt";

		
		System.out.println("Bienvenue chez Barette");
		
		System.out.println("Facture  : ");
		
		créerCommande();
	}

	public static void créerCommande() throws FileNotFoundException, IOException {
		
		com1 = new Commande(tabClient[0],1,0,0);
		
		Commande.commandeIncorrecte(com1);
		
		com1.afficheTotal();
		
		EcrireFichier(com1);
		
		com2 = new Commande(tabClient[1],0,2,1 );
		
		Commande.commandeIncorrecte(com2);
		
		com2.afficheTotal();
		
		EcrireFichier(com2);

		com3 = new Commande(tabClient[2], 0, 0, 0);
		
		Commande.commandeIncorrecte(com3);
		
		com3.afficheTotal();
	
		EcrireFichier(com3);
		
		Date actuelle = new Date();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
        
		File out = new File(monFichier);
		
		out.renameTo(new File("Facture-du-"+dateFormat.format(actuelle)));
		
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
	
	public static void EcrireFichier(Commande com) throws FileNotFoundException, IOException {
		
		try {
			 if(com.calculerPrix()!=0) {
			
			 FileWriter fw = new FileWriter(monFichier,true);
			 fw.write(com.toString());
			 fw.close();

			 }
         }catch(FileNotFoundException fx) {
        	System.out.println(fx); 
         }
		
		if(com.calculerPrix()!=0 || Client.nom != null) {
			
		FileWriter fw = new FileWriter(monFichier,true);
		fw.write(com.toString());
		fw.close();
        }
	}
}