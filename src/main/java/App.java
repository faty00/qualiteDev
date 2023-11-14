//
// Utilisation nominale des classes td3.Buffer, Killring et td3.Editor
//
////////////////////////////////////////////////////////////////

import fr.einfolearning.tp2.metiers.EmacsKillRing;
import fr.einfolearning.tp2.metiers.TextBuffer;
import fr.einfolearning.tp2.metiers.TextEditor;
import fr.einfolearning.tp2.metiers.exceptions.EmacsKillRingOverflowException;

public class App {

    public static void main(String[] args) {
        // A completer
        // A completer
        TextBuffer b = new TextBuffer("cours qualite logiciel");
        EmacsKillRing kc = new EmacsKillRing();
        TextEditor ed = new TextEditor("Je suis un editeur");

        try {
            System.out.println(ed.getBuffer());

            ed.setCursor(3);
            ed.setMark(7);
            ed.killRingBackup();
            System.out.println(ed.getBuffer());

            ed.setCursor(11);
            ed.setMark(16);
            ed.killSection();
            System.out.println(ed.getBuffer());

            ed.setCursor(8);
            ed.yank();
        } catch (EmacsKillRingOverflowException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    /*
        "Je suis un editeur"[]"
    "Je suis un editeur"[suis]"
    "Je suis un ur"[edite, suis]"
     */
}
