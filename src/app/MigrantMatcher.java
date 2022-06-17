package app;

import app.domain.CatalogoAjudas;
import app.domain.CatalogoMigrantes;
import app.domain.CatalogoRegioes;
import app.domain.CatalogoVoluntarios;
import app.handlers.MigranteHandler;
import app.handlers.VoluntarioHandler;
import app.sessoes.MSessao;
import app.sessoes.VSessao;
import app.strategies.AddBy;
import app.strategies.AddByAsc;
import app.strategies.AddByType;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class MigrantMatcher {
    public static final String configPath = "/src/config.properties";
    private final CatalogoVoluntarios catVol;
    private final CatalogoAjudas catAjudas;
    private final CatalogoMigrantes catMig;
    private final CatalogoRegioes catReg;

    public MigrantMatcher() {
        this.catVol = CatalogoVoluntarios.getInstance();
        this.catAjudas = CatalogoAjudas.getInstance();
        this.catAjudas.setAddBy(readProperties(configPath));
        this.catMig = CatalogoMigrantes.getInstance();
        this.catReg = CatalogoRegioes.getInstance();
    }

    public VSessao receberVoluntario(String contacto) {
        return () -> new VoluntarioHandler(contacto);
    }

    public MSessao receberMigrante(String nome, String telefone) {
        MigranteHandler mh = new MigranteHandler();
        mh.registarIndividual(nome, telefone);
        return () -> mh;
    }

    public MSessao receberMigrante(int nrPessoas) {
        MigranteHandler mh = new MigranteHandler();
        mh.indicarNumeroPessoas(nrPessoas);
        return () -> mh;
    }

    private AddBy readProperties(String path) {
        Properties prop = new Properties();

        InputStream input = null;
        try {
            input = new FileInputStream(path);
            prop.load(input);

            if (prop.getProperty("ordenacao").equals("asc")) {
                return new AddByAsc();
            }

            return new AddByType();
        } catch (IOException e) {
            return new AddByAsc();
        }
    }

    private boolean telefoneValido(String contacto) {
        String trimmedContacto = contacto.trim();
        if (trimmedContacto.length() != 9) {
            return false;
        }

        return trimmedContacto.matches("[9][0-9]{8}");
    }
}
