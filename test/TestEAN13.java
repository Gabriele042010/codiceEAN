import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class TestEAN13 {
    
    private EAN13 codice;

    @Before
    public void init(){
        codice= new EAN13();
    }

    @Test
    public void testEanVerificaCodiceValido(){
        codice.setCodice("3614273613422");
        assertTrue(codice.verificaCodice());
    }

    @Test
    public void testEanVerificaCodiceNonValido(){
        codice.setCodice("3614273613427");
        assertFalse(codice.verificaCodice());
    }

    @Test
    public void testEanVerificaCodiceLunghezzaNonValida(){
        codice.setCodice("36142736134227");
        assertFalse(codice.verificaCodice());
    }

    @Test
    public void testEanVerificaCodiceVuoto(){
        codice.setCodice("");
        assertThrows(NullPointerException.class, () -> {
            codice.verificaCodice();});
       
    }
}
