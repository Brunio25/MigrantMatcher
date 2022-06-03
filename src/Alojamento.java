package src;

/**
 * Alojamento
 */
public class Alojamento extends Ajuda {
    private final int nrPessoas;
    private Regiao regiao;

    public Alojamento(int nrPessoas) {
        super();
        this.nrPessoas = nrPessoas;
    }

    private void setRegiao(int id, CatalogoRegioes catalogoRegioes) {

        this.regiao = catalogoRegioes.getByID(id);
    }
    
}