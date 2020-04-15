package tp1Partie3.test;

import java.io.FileNotFoundException;
import java.io.IOException;
import org.junit.Test;
import tp1Partie3.main.Commande;

public class Cas3 {

	@Test
	public void lireFichier() throws FileNotFoundException, IOException {

		String path = "src/tp1Partie3/main/facture.txt";
		
		Commande.lireFichier(path);
	}
}
