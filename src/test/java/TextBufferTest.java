import fr.einfolearning.tp2.metiers.TextBuffer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class TextBufferTest {

    /*
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


    }*/
    /**
     * Vérifie le comportement des opérations sur un TextBuffer incluant des actions comme l'insertion, la suppression,
     * et l'extraction du texte.
     */

    @Test
    public void should_extract_qualite_when_substring_from_text_buffer() {
        // Arrange
        TextBuffer tb = new TextBuffer("qualite logiciel");
        String expectedText = "qualite";

        // Act
        String extractedText = tb.substr(0, 7);

        // Assert
        Assertions.assertEquals(expectedText, extractedText);

        // Additional Assertions and Actions for illustration (can be refactored or removed)
        System.out.println(tb.toString());

        System.out.println(tb.maxP());
        tb.ins("cours ", 0);
        System.out.println(tb.toString());
        System.out.println(tb.maxP());

        tb.del(0, 6);
        System.out.println(tb.toString());
        tb.del(0, 30);

        tb.ins("cours de java ", 0);

        TextBuffer tbs = new TextBuffer("cours qualite logiciel");
        String expectedTxt = "cours qualite logiciel";

        String text = tbs.substr(0, 30);
        Assertions.assertEquals(expectedTxt, text);

        System.out.println(tb.toString());
    }


    private TextBuffer textBuffer;

    @BeforeEach
    public void init() {
        textBuffer = new TextBuffer("Ceci est un test de la methode toString");
    }

    /**
     * Vérifie si la méthode toString() retourne le contenu initial du TextBuffer après son initialisation.
     */
    @Test
    public void should_run_string_when_create_textbuffer_whith_string_content(){

        //Arrange
        String expectedString = "Ceci est un test de la methode toString";

        //Act
        String string = textBuffer.toString();

        //Assert
        Assertions.assertEquals(expectedString, string);
    }
    // A completer
    /**
     * Vérifie si la méthode del() supprime une plage de texte définie par les paramètres from et to.
     */
    @Test
    public void test_del(){

        //Arrange
        int from = -1;
        int to = -10;
        String expectedString = "Ceci est un test de la methode toString";

        //Act
        textBuffer.del(from, to);

        //Assert
        assertThat(textBuffer.toString(), is(expectedString));
    }

    /**
     * Vérifie le comportement de la méthode ins() en insérant du texte dans le TextBuffer avec une position négative.
     */
    @Test
    public void test_ins(){

        //Arrange
        int position = -1;

        String expectedString = "Ceci est un test de la methode toString";

        //Act
        textBuffer.ins("ce", position);

        //Assert
        assertThat(textBuffer.toString(), is(expectedString));
    }

    /*Teste la méthode substr() avec des valeurs négatives
    pour from et to, ce qui pourrait ne pas correspondre à une utilisation normale de cette méthode.
     */
    @Test
    public void test_subs(){



        //Arrange
        int from = -1;
        int to = -10;
        String expectedString = "Ceci est un test de la methode toString";

        //Act
        textBuffer.substr(from, to);

        //Assert
        assertThat(textBuffer.toString(), is(expectedString));
    }
    //
    /*Vérifie si la méthode maxP() retourne correctement la longueur du texte initial du TextBuffer.
     */
    @Test
    public void should_return_correct_max_when_create_textbuffer_whith_string_content(){

        //Arrange
        int expectedMax = "Ceci est un test de la methode toString".length();

        //Act
        int max = textBuffer.maxP();

        //Assert
       assertThat(max, is(expectedMax));
    }

    /*
    Vérifie si l'insertion d'une chaîne de caractères dans le
    TextBuffer fonctionne correctement en vérifiant la sous-chaîne insérée.
     */
    @Test
    public void should_return_same_inserted_string_when_insert_string(){

        //Arrange
        String expectedString = "test";
        int from = 4;
        int to = from + "test".length();


        //Act
        textBuffer.ins("test", 4);

        //Assert
        String stringInserted = textBuffer.substr(from, to);
        assertThat(stringInserted, is(expectedString));
    }

    /*Vérifie si la méthode substr() retourne
    correctement une sous-chaîne définie par les valeurs de from et to
     */

    @Test
    public void should_return_correct_string_when_correct_to_from_paramater(){

        //Arrange
        int from = 12;
        int to = 16;
        String expectedString = "test";


        //Act
        String subStringRes = textBuffer.substr(from, to);

        //Assert
        assertThat(subStringRes, is(expectedString));
    }

    /*
    Teste si la méthode substr() retourne une
    sous-chaîne tronquée lorsque to est en dehors des limites du texte
     */
    @Test
    public void should_return_trunced_string_when_to_out_of_limit(){

        //Arrange
        int from = "Ceci est un test de la methode toString".length() - 6;
        int to = 200;
        String expectedString = "String";


        //Act
        String subStringRes = textBuffer.substr(from, to);

        //Assert
        assertThat(subStringRes, is(expectedString));
    }

    /*
    Vérifie si substr() retourne une chaîne vide lorsque from et to
    sont en dehors des limites du texte.
     */
    @Test
    public void should_return_nothing_where_when_from_and_to_out_of_limit(){

        //Arrange
        int from = 200;
        int to = 200;
        String expectedString = "String";


        //Act
        String subStringRes = textBuffer.substr(from, to);

        //Assert
        assertThat(subStringRes, is(""));
    }

    /*
     Teste la méthode del() pour supprimer une sous-chaîne définie par les valeurs de from et to.
     */
    @Test
    public void should_delete_substring_where_when_from_and_correct(){

        //Arrange
        int from = 12;
        int to = 16;
        String expectedString = "Ceci est un  de la methode toString";

        //Act
        textBuffer.del(from, to);

        //Assert
        assertThat(textBuffer.toString(), is(expectedString));
    }

    /*
    Vérifie si del() supprime correctement une sous-chaîne lorsque to est en dehors des limites du texte.
     */
    @Test
    public void should_delete_trunced_substring_where_to_out_of_limit(){

        //Arrange
        int from = "Ceci est un test de la methode toString".length() - 6;
        int to = 200;
        String expectedString = "Ceci est un test de la methode to";


        //Act
        textBuffer.del(from, to);

        //Assert
        assertThat(textBuffer.toString(), is(expectedString));
    }

    /*
    Vérifie si del() ne modifie pas le texte lorsque from et to sont en dehors des limites du texte.
     */

    @Test
    public void should_del_nothing_where_from_and_to_out_of_limit(){

        //Arrange
        int from = 200;
        int to = 200;
        String expectedString = "Ceci est un test de la methode toString";


        //Act
        textBuffer.del(from, to);

        //Assert
        assertThat(textBuffer.toString(), is(expectedString));
    }




}
