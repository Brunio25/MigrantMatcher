package app.domain;

import java.util.List;
import java.util.ArrayList;
/**
 * Migrante
 */
public class Migrante {
    protected String contacto;
    protected List<Ajuda> ajudas = new ArrayList<>();
    
    public void setAjudasMigrante(Ajuda ajuda) {
        ajudas.add(ajuda);
    }

    public List<Ajuda> getAjudas() {
        return ajudas;
    }
}

