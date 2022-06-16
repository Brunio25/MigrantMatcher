package app.domain;

/**
 * Voluntario
 */
public class Voluntario {
    private final String contacto;
    
    public Voluntario(String contacto) {
        this.contacto = contacto;
    }

    public String getContacto() {
        return this.contacto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof Voluntario)) {
            return false;
        }

        Voluntario voluntario = (Voluntario) o;
        return this.contacto.equals(voluntario.contacto);
    }
}