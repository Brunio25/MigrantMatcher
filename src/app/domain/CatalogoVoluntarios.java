package app.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * CatalogoVoluntario
 */
public class CatalogoVoluntarios {
    private static List<Voluntario> voluntarios;
    private static CatalogoVoluntarios instance;

    public static CatalogoVoluntarios getInstance() {
            if (instance == null) {
                instance = new CatalogoVoluntarios();
            }

            return instance;
    }
    
    private CatalogoVoluntarios() {
        voluntarios = new ArrayList<>();
    }

    public void addVoluntario(Voluntario v) {
        voluntarios.add(v);
    }
}