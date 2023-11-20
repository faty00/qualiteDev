import fr.einfolearning.tp2.metiers.TextBuffer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TextBufferTest {

    @Test
    public void should_get_correct_name_when_instanciate_person_with_name_and_age_() {

        // Arrange
        TextBuffer tb = new TextBuffer("qualite logiciel");;
        String expectedText = "qualite";


        // Act
        String txt = tb.substr(0,7);


        // Assert
        Assertions.assertEquals(expectedText, txt);
        System.out.println(tb.toString());

        System.out.println(tb.maxP());
        tb.ins("cours ", 0 );
        System.out.println(tb.toString());
        System.out.println(tb.maxP());

        tb.del(0, 6);
        System.out.println(tb.toString());
        tb.del(0, 30);

        tb.ins("cours de java ", 0 );

        TextBuffer tbs = new TextBuffer("cours qualite logiciel");;
        String expectedTxt = "cours qualite logiciel";

        String text = tbs.substr(0,30);
        Assertions.assertEquals(expectedTxt, text);


        System.out.println(tb.toString());


    }
















    //mvn clean test
}
