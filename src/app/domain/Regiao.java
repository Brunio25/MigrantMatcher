package app.domain;

/**
 * Regiao
 */
public class Regiao {
    private final String nome;

    public Regiao (String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof Regiao)) {
            return false;
        }

        Regiao regiao = (Regiao) o;
        return this.nome.equals(regiao.getNome());
    }
}
