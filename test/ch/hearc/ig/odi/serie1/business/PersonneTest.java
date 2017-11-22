package ch.hearc.ig.odi.serie1.business;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Tests pour la classe Personne
 *
 * @author ulysse.rosselet
 */
public class PersonneTest {

    private final SimpleDateFormat sdf;

    /**
     * Constructeur du test 
     * Initialise l'attribut 'sdf' pour le parsing des dates dans les tests
     */
    public PersonneTest() {
        sdf = new SimpleDateFormat("dd.MM.yyyy");
    }
	
	/**
     * Test basique qui crée un objet Personne et vérifie les accesseurs
     */
    @Test
    public void testAttributs() throws ParseException{
        Personne maPersonne = new Personne();
		maPersonne.setPrenom("Alice");
		
		assertEquals("Alice", maPersonne.getPrenom());
		
		maPersonne.setNom("Cooper");
		assertEquals("Cooper", maPersonne.getNom());
		
		maPersonne.setDateDeNaissance(sdf.parse("04.02.1948"));
		assertEquals(sdf.parse("04.02.1948"), maPersonne.getDateDeNaissance());
    }

    /**
     * Test basique de la méthode sePresenter() 
     * Vérifie que la méthode sePresenter() retourne la bonne chaîne de caractères
     */
    @Test
    public void testSePresenter() throws ParseException {
        Personne alice = new Personne("Alice", "Cooper", sdf.parse("04.02.1948"));
        String result = "Bonjour, je m'appelle Alice Cooper";
        assertEquals(result, alice.sePresenter());
    }

    /**
     * Test basique de la méthode monAge() 
     * Vérifie que la méthode monAge() retourne l'âge correct de la personne 
     */
    @Test
    public void testMonAge() throws ParseException {
        Personne alice = new Personne("Alice", "Cooper", sdf.parse("04.02.1948"));
        
        LocalDate bd = LocalDate.of(1948, 2, 4);
        LocalDate current = LocalDate.now();
        
        long age = ChronoUnit.YEARS.between(bd, current);
        
        assertEquals(age, alice.monAge());
    }

}
