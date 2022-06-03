package src;

import java.util.ArrayList;
import java.util.List;

/**
 * CatalogoVoluntario
 */
public class CatalogoVoluntario {
    private List<Voluntario> voluntarios;
    private static CatalogoVoluntario instance;

    public static CatalogoVoluntario getInstance(String contacto) {
            if (instance == null) {
                instance = new CatalogoVoluntario(contacto);
            }

            return instance;
    }
    
    private CatalogoVoluntario(String contacto) {
        this.voluntarios = new ArrayList<>();
        this.voluntarios.add(new Voluntario(contacto));
    }
}