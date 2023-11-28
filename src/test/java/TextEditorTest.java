import fr.einfolearning.tp2.metiers.EmacsKillRing;
import fr.einfolearning.tp2.metiers.TextBuffer;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.doThrow;

public class TextEditorTest {

    TextBuffer mockBuffer;
    EmacsKillRing mockEmacs;
    Boolean yankMod;
    @BeforeEach
    public void init(){

        TextBuffer mockBuffer = mock(TextBuffer.class);
        EmacsKillRing mockEmacs = mock(EmacsKillRing.class);

    }

    @Test
    public void testYankPop(){

        mockBuffer = mock(TextBuffer.class);
        mockEmacs = mock(EmacsKillRing.class);

        when(mockEmacs.isEmpty()).thenReturn(false);
        doThrow(new IllegalAccessException("Yankpop without yank not allowed")).when(!yankMod);
    }
}
