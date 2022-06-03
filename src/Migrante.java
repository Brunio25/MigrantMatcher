package src;

import java.util.List;
import java.util.ArrayList;
/**
 * Migrante
 */
public class Migrante {
    protected int id;
    protected List<Ajuda> ajudas = new ArrayList<>();
    
    public void setAjudas(Ajuda ajuda) {
        ajudas.add(ajuda);
    }

    public List<Ajuda> getAjudas() {
        return ajudas;
    }
}

