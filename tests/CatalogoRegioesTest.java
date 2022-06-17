import app.domain.CatalogoRegioes;
import app.domain.Regioes;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CatalogoRegioesTest {
    static CatalogoRegioes catReg;

    @BeforeAll
    public static void setUp() {
        catReg = CatalogoRegioes.getInstance();
    }


    @Test
    public void runGetById() {
        assertEquals(catReg.getByID(0).getNome(), Regioes.AVEIRO.name());
        assertEquals(catReg.getByID(11).getNome(), Regioes.PORTALEGRE.name());
        assertEquals(catReg.getByID(14).getNome(), Regioes.SETUBAL.name());
        assertEquals(catReg.getByID(17).getNome(), Regioes.VISEU.name());
        assertEquals(catReg.getByID(7).getNome(), Regioes.FARO.name());
        assertNotEquals(catReg.getByID(0).getNome(), Regioes.BEJA.name());
        assertNotEquals(catReg.getByID(17).getNome(), Regioes.LEIRIA.name());
    }

    @Test
    public void runIsRegiao() {
        assertTrue(catReg.isRegiao(3));
        assertTrue(catReg.isRegiao(15));
        assertFalse(catReg.isRegiao(20));
        assertFalse(catReg.isRegiao(87));
        assertFalse(catReg.isRegiao(-1));
    }
}
