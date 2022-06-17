import app.MigrantMatcher;
import app.domain.*;
import app.handlers.VoluntarioHandler;
import app.sessoes.VSessao;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AddAjudasTests {
    MigrantMatcher migMatch = new MigrantMatcher();
    Random rd = new Random();

    @Test
    public void novoAlojamento() {
        String[] volContacto = new String[4];
        int[] regioesAloj = new int[4];

        for (int i = 0; i < 4; i++) {
            volContacto[i] = rd.nextInt(1000000000) + "";
            VSessao sessao = migMatch.receberVoluntario(volContacto[i]);
            VoluntarioHandler volHandler = sessao.getVoluntarioHandler();
            List<Regiao> regioes = volHandler.indicarNrPessoas(regioesAloj[i]);

            regioesAloj[i] = rd.nextInt(regioes.size());
            volHandler.indicarRegiao(regioesAloj[i], CatalogoRegioes.getInstance());

            String codigo = simulaEnviarSms();
            volHandler.indicarCodigo(codigo, CatalogoVoluntarios.getInstance());
        }

        List<Ajuda> ajudas = CatalogoAjudas.getInstance().getList();
        assertEquals(0, ajudas.size());

        List<Voluntario> vols = CatalogoAjudas.getInstance().getVoluntariosAjudas(ajudas);
        List<String> contactos = new ArrayList<>();
        for (Voluntario v : vols) {
            contactos.add(v.getContacto());
        }
    }

    private String simulaEnviarSms() {
        return String.format("%04d", new Random().nextInt(10000));
    }
}
