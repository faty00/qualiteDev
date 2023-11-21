import fr.einfolearning.tp2.metiers.EmacsKillRing;
import fr.einfolearning.tp2.metiers.TextBuffer;
import fr.einfolearning.tp2.metiers.exceptions.EmacsKillRingOverflowException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class EmacsKillRingTest {

    private TextBuffer textBuffer;

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

    @Test
    public void test_entry(){

        //Arrange
        EmacsKillRing emacsKillRing = new EmacsKillRing();


        //Act
        try {
            for (int i = 0; i< 30; i++) {
                emacsKillRing.add("test");
            }

        }
        catch(EmacsKillRingOverflowException e){
            Assertions.fail();
        }

        //Assert
        emacsKillRing.rotateFwd();

    }

}
