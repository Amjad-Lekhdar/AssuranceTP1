package tp1Partie3.main;

import java.io.BufferedReader;
<<<<<<< HEAD
=======
import java.io.BufferedWriter;
import java.io.Console;
>>>>>>> f7b90e37aec29d1454e75e8529fb24f8826531d6
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import tp1Partie3.main.Commande;

public class Principal {
	
	private static String[] tabClient = new String[3];
	private static String[] tabPlats = new String[3];
<<<<<<< HEAD
=======
	private static Commande[] tabCommande = new Commande[3];
	
	private static ArrayList<Commande> listeCommande = new ArrayList<Commande>(3);
	
	private static Commande com1 ;
	private static Commande com2;
	private static Commande com3;
	private static String monFichier;
	
	
	
	public static void main(String[] args) throws IOException {
		
		String[] tab=lireFichier(new File("src/tp1Partie3/main/facture.txt").getAbsolutePath());
>>>>>>> f7b90e37aec29d1454e75e8529fb24f8826531d6
		
	public static void main(String[] args) throws IOException { 
		
		String[] tab=lireFichier(new File("src/tp1Partie3/main/facture.txt").getAbsolutePath());
		
		tabClient[0]=tab[1];
		
		tabClient[1]=tab[2];
		tabClient[2]=tab[3];
		
		tabPlats[0]=tab[5];
		tabPlats[1]=tab[7];
		tabPlats[2]=tab[9];
		
		
		 DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd-HH:mm");
		 LocalDateTime now = LocalDateTime.now();
		 monFichier="Facture-du-"+dtf.format(now).toString()+".txt";
		
		
		System.out.println("Bienvenue chez Barette");
		
		
		
		
		créerCommande();

		
<<<<<<< HEAD
		 */	
		
			Commande com1 = new Commande(tabClient[0],1,0,0);
				
			Commande com2 = new Commande(tabClient[1],0,2,1 );
						
			Commande com3 = new Commande(tabClient[2], 0, 0, 0);
				
			com3.afficheTotal();
				
			//System.out.println(listeCommande.toString());

			EcrireFichier(com1, com2, com3);
			
			
=======
		
		 
		
	}
	
	
	public static void créerCommande() throws FileNotFoundException, IOException {
		
		
		delete();
		
		com1 = new Commande(tabClient[0],1,0,0);
		
		com1.afficheTotal();
		
		EcrireFichier(com1);
		
		
		
		
		com2 = new Commande(tabClient[1],0,2,1 );
		
		com2.afficheTotal();
		
		EcrireFichier(com2);

		
		
		com3 = new Commande(tabClient[2], 0, 0, 0);
		
		com3.afficheTotal();
		
		
		EcrireFichier(com3);

		

		
>>>>>>> f7b90e37aec29d1454e75e8529fb24f8826531d6
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
	
<<<<<<< HEAD
	public static void EcrireFichier(Commande com1, Commande com2, Commande com3) throws FileNotFoundException, IOException {

		try {
            PrintStream myconsole = new PrintStream(new File ("factureCommande.txt"));
            System.setOut(myconsole);
            myconsole.print(com1);
            myconsole.print(com2);
            myconsole.print(com3);
        }catch(FileNotFoundException fx) {
=======
	public static void EcrireFichier(Commande com) throws FileNotFoundException, IOException {
>>>>>>> f7b90e37aec29d1454e75e8529fb24f8826531d6

            System.out.println(fx);
        }
		
		
<<<<<<< HEAD
		
		
		/* DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd-HH:mm");
		 LocalDateTime now = LocalDateTime.now();
		 //String monFichier="Facture-du-"+dtf.format(now).toString()+".txt";
		 String monFichier="Facture-du-.txt";

		 
=======
>>>>>>> f7b90e37aec29d1454e75e8529fb24f8826531d6
		 try {
			 
			
			 
<<<<<<< HEAD
			 PrintWriter  fichier = new PrintWriter(monFichier);
		
	
	       
		 fichier.close();
		 
		 }
		 catch (IOException e)
		 {
		 e.printStackTrace();
		 }*/
=======
			 
			 FileWriter fw = new FileWriter(monFichier,true);
			 fw.write(com.toString());
			 fw.close();

             
         }catch(FileNotFoundException fx) {

             System.out.println(fx);
         }
		 
		
	}
	
	public static void delete() {
		
		
		 File myObj = new File(monFichier); 
		    if (myObj.delete()) { 
		      
		    } else {
		      
		    } 
>>>>>>> f7b90e37aec29d1454e75e8529fb24f8826531d6
		
	}


}