package app.handlers;

import app.domain.*;
import com.pidgeonsmssender.sdk.PidgeonSMSSender;

import java.util.List;

public class MigranteHandler {
    private Migrante migrante;

    public MigranteHandler() {
    }


    public void registarIndividual(String nome, String nrTelefone) {
        this.migrante = new Individual(nome, nrTelefone);
    }

    public void indicarNumeroPessoas(int NrPessoas) {
        this.migrante = new Familia(NrPessoas);
    }

    public void indicarNomeContacto(String nome, String contacto) {
        ((Familia) this.migrante).setInfo(nome, contacto);
    }

    public void indicarNome(String nome) {
        ((Familia) this.migrante).setNome(nome);
    }

    public List<Regiao> listaRegioes(CatalogoRegioes catRegioes) {
        return catRegioes.getRegioes();
    }


    public List<Ajuda> indicarRegiao(int id, CatalogoAjudas catalogoAjuda, CatalogoRegioes catalogoRegioes) {
        return catalogoAjuda.getListaRegiao(catalogoRegioes.getByID(id));
    }

    public void indicarAjuda(Ajuda ajuda) {
        this.migrante.setAjudasMigrante(ajuda);
    }

    public void indicarConfirmacao(CatalogoMigrantes catMigrantes) {
        catMigrantes.addMigrante(this.migrante);
    }

    public void enviarSms(CatalogoAjudas catAjudas) {
        PidgeonSMSSender smsSender = new PidgeonSMSSender();

        catAjudas.getVoluntariosAjudas(this.migrante.getAjudas())
                .forEach(v -> smsSender.send(v.getContacto(), "Uma das suas ajudas foi selecionada."));
    }
}
