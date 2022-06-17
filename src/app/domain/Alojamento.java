package app.domain;

/**
 * Alojamento
 */
public class Alojamento implements Ajuda {
    private final int nrPessoas;
    private Regiao regiao;

    public Alojamento(int nrPessoas) {
        this.nrPessoas = nrPessoas;
    }

    public void setRegiao(int id, CatalogoRegioes catalogoRegioes) {
        this.regiao = catalogoRegioes.getByID(id);
    }

    public Regiao getRegiao() {
        return regiao;
    }
}