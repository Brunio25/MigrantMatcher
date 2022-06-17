package app.handlers;

import app.domain.*;
import com.pidgeonsmssender.sdk.PidgeonSMSSender;

import java.util.List;
import java.util.Random;

public class VoluntarioHandler {
    private Voluntario voluntario;
    private CatalogoAjudas catalogoAjuda;
    private Ajuda ajuda;
    private String codigo;


    public VoluntarioHandler(String contacto) {
        this.voluntario = new Voluntario(contacto);
        this.catalogoAjuda = CatalogoAjudas.getInstance();
    }

    public List<Regiao> indicarNrPessoas(int nrPessoas) {
        ajuda = new Alojamento(nrPessoas);

        return CatalogoRegioes.getInstance().getRegioes();
    }

    public boolean indicarRegiao(int id, CatalogoRegioes catRegioes) {
        if (catRegioes.isRegiao(id) && ajuda instanceof Alojamento) {
            ((Alojamento) ajuda).setRegiao(id, catRegioes);

            enviarSms();
            return true;
        }

        return false;
    }

    public void indicarItem(String descricao) {
        ajuda = new Item(descricao);

        enviarSms();
    }


    public void indicarCodigo(String codigo, CatalogoVoluntarios catVoluntario) {
        if (this.codigo.equals(codigo)) {
            catVoluntario.addVoluntario(this.voluntario);
            catalogoAjuda.addAjuda(ajuda, voluntario);
        }
    }

    public void enviarSms() {
        this.codigo = String.format("%04d", new Random().nextInt(10000));
        new PidgeonSMSSender().send(voluntario.getContacto(), codigo);
    }
}
