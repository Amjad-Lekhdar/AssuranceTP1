package tp1Partie3.test;



import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Test;

import tp1Partie3.main.Commande;

public class Cas1 {
	
	@Test
	public void calculerPrix() throws FileNotFoundException, IOException {
		
		Commande total = new Commande("b", 1, 2, 3);
		
		total.calculerPrix();
	}
}
