package app.domain;

/**
 * Indidual
 */
public class Individual extends Migrante {
    private final String nome;

    public Individual(String nome, String telefone) {
        super();

        this.nome = nome;
        super.contacto = telefone;
    }
}