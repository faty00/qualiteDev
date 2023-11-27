import fr.einfolearning.tp2.metiers.EmacsKillRing;
import fr.einfolearning.tp2.metiers.TextBuffer;
import fr.einfolearning.tp2.metiers.exceptions.EmacsKillRingOverflowException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class EmacsKillRingTest {

    private TextBuffer textBuffer;

    /*
    *Vérifie si une exception EmacsKillRingOverflowException est levée lorsque
    * le buffer est plein. Le test remplit le buffer avec le nombre maximum
    * d'éléments autorisés (EmacsKillRing.MAX) et essaie d'ajouter un élément
    * supplémentaire pour vérifier que l'exception est bien déclenchée.
     */
    @Test
    public void should_throw_emacskillringoverflowexception_when_buffer_full(){

        //Arrange
        EmacsKillRing emacsKillRing = new EmacsKillRing();


        //Act
        try {
            for (int i = 0; i< EmacsKillRing.MAX; i++) {
                emacsKillRing.add("test");
            }

        }
        catch(EmacsKillRingOverflowException e){
            Assertions.fail();
        }

        //Assert
        Assertions.assertThrows(EmacsKillRingOverflowException.class, ()->{ emacsKillRing.add("test") ;}) ;
        System.out.println(emacsKillRing.toString());

    }

    /*Vérifie si la méthode isEmpty() fonctionne correctement en vérifiant si un EmacsKillRing
    *nouvellement créé est vide et si un autre objet EmacsKillRing avec un élément ajouté
    * n'est pas vide.
     */
    @Test
    public void test_empty(){

        //Arrange
        EmacsKillRing emacsKillRing = new EmacsKillRing();
        EmacsKillRing emacsKillRing1 = new EmacsKillRing();


        //Act
        try {
            for (int i = 0; i< 0; i++) {
                emacsKillRing.add("");

            }
            emacsKillRing1.add("test");

        }
        catch(EmacsKillRingOverflowException e){
            Assertions.fail();
        }

        //Assert
        boolean empty = emacsKillRing.isEmpty();
        boolean notEmpty = emacsKillRing1.isEmpty();
        assertThat(empty, is(true));
        assertThat(notEmpty, is(false));

    }

    /*
    Teste la méthode rotateFwd() pour s'assurer qu'elle ne provoque pas d'erreur
    lorsqu'elle est appelée après avoir ajouté des éléments dans le EmacsKillRing.
     */
    @Test
    public void test_rotatefwd(){

        //Arrange
        EmacsKillRing emacsKillRing = new EmacsKillRing();


        //Act
        try {
            for (int i = 0; i< 2; i++) {
                emacsKillRing.add("test");
            }

        }
        catch(EmacsKillRingOverflowException e){
            Assertions.fail();
        }

        //Assert
        emacsKillRing.rotateFwd();

    }

    /*
    * test_current: Vérifie si la méthode currentElt() retourne correctement
    * le dernier élément ajouté dans le EmacsKillRing
    * */
    @Test
    public void test_current(){

        //Arrange
        EmacsKillRing emacsKillRing = new EmacsKillRing();


        //Act
        try {
            for (int i = 0; i< 2; i++) {
                emacsKillRing.add("test");
            }

        }
        catch(EmacsKillRingOverflowException e){
            Assertions.fail();
        }

        //Assert
        assertThat(emacsKillRing.currentElt(), is("test"));

    }
    /*/**
     * Teste le comportement de la classe EmacsKillRing lorsqu'un dépassement de la limite maximale
     * du nombre d'éléments est tenté.
     * Vérifie que la classe gère correctement cette situation en ne déclenchant pas l'exception
     * EmacsKillRingOverflowException et en permettant l'exécution de la méthode rotateFwd() après
     * avoir atteint la limite.
     */
    @Test
    public void test_entry() {
        // Arrange
        EmacsKillRing emacsKillRing = new EmacsKillRing();

        // Act
        try {
            for (int i = 0; i < EmacsKillRing.MAX + 1; i++) {
                emacsKillRing.add("test");
            }
        } catch (EmacsKillRingOverflowException e) {
            Assertions.fail("Unexpected EmacsKillRingOverflowException");
        }

        // Assert
        emacsKillRing.rotateFwd();
    }

}
