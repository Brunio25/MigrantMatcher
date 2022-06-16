package app.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * CatalogoRegioes
 */
public class CatalogoRegioes {
    private final List<Regiao> regioes;
    private static CatalogoRegioes instance;

    public static CatalogoRegioes getInstance() {
            if (instance == null) {
                instance = new CatalogoRegioes();
            }

            return instance;
    }
    
    private CatalogoRegioes() {
        this.regioes = new ArrayList<>();

        for (Regioes nomeRegiao : Regioes.values()) {
            this.regioes.add(new Regiao(nomeRegiao.toString()));
          }
    }

    public List<Regiao> getRegioes() {
        return regioes;
    }

    public Regiao getByID(int id) {
        return this.regioes.get(id);
    }

    public boolean isRegiao(int id) {
        return id >= 0 && id < regioes.size();
    }
}