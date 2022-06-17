import app.MigrantMatcher;
import app.domain.*;
import app.handlers.MigranteHandler;
import app.sessoes.MSessao;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GetAjudasTests {
    MigrantMatcher migMatch = new MigrantMatcher();
    int numBase = 912563998;

    @Test
    public void getAjudasFamilia() {
        String[] nomes = {"Joana", "Ines", "Filipe", "Lopes"};

        CatalogoVoluntarios catVol = CatalogoVoluntarios.getInstance();
        CatalogoAjudas catAju = CatalogoAjudas.getInstance();

        popularCatalogos(catVol, catAju);

        for (int i = 0; i < 4; i++) {
            MSessao sessao = migMatch.receberMigrante(i);
            MigranteHandler migHandler = sessao.getMigranteHandler();
            migHandler.indicarNomeContacto(nomes[i], i + numBase + "");

            for (String nome : nomes) {
                migHandler.indicarNome(nome);
            }

            List<Regiao> regioes = migHandler.listaRegioes(CatalogoRegioes.getInstance());

            List<Ajuda> ajudas = migHandler.indicarRegiao(i, catAju, CatalogoRegioes.getInstance());

            migHandler.indicarAjuda(ajudas.get(0));
            migHandler.indicarConfirmacao(CatalogoMigrantes.getInstance());
        }

        CatalogoMigrantes catMig = CatalogoMigrantes.getInstance();

        assertEquals(4, catMig.nrMigrantes());
    }

    private void popularCatalogos(CatalogoVoluntarios catVol, CatalogoAjudas catAju) {
        for (int i = 0; i < 4; i++) {
            Voluntario v = new Voluntario(i + numBase + "");
            catVol.addVoluntario(v);

            Alojamento al = new Alojamento(i);
            al.setRegiao(i, CatalogoRegioes.getInstance());

            catAju.addAjuda(al, v);
        }
    }
}
