package app.domain;

import java.util.ArrayList;
import java.util.List;

public class CatalogoMigrantes {
    private static List<Migrante> migrantesCatalogo;
    private static CatalogoMigrantes instance;

    public static CatalogoMigrantes getInstance() {
        if (instance == null) {
            instance = new CatalogoMigrantes();
        }

        return instance;
    }

    private CatalogoMigrantes() {
        migrantesCatalogo = new ArrayList<>();
    }

    public void addMigrante(Migrante migrante) {
        migrantesCatalogo.add(migrante);
    }

    public int nrMigrantes() {
        return migrantesCatalogo.size();
    }
}
