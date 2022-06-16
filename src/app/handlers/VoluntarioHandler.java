package app.handlers;

import app.domain.*;
import app.strategies.AddBy;
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
    }

    public List<Regiao> indicarNrPessoas(int nrPessoas) {
        ajuda = new Alojamento(nrPessoas);

        return CatalogoRegioes.getInstance().getRegioes();
    }

    public boolean indicarRegiao(Alojamento alojamento, int id, CatalogoRegioes catRegioes) {
        if(catRegioes.isRegiao(id)) {
            alojamento.setRegiao(id, catRegioes);

            enviarSms();
            return true;
        }

        return false;
    }

    public void indicarItem(String descricao) {
        ajuda = new Item(descricao);

        enviarSms();
    }


    public void indicarCodigo(String codigo, CatalogoVoluntarios catVoluntario, AddBy addBy) {
        if (this.codigo.equals(codigo)) {
            catVoluntario.addVoluntario(this.voluntario);
            catalogoAjuda.addAjuda(ajuda, voluntario, addBy);
        }
    }

    public void enviarSms() {
        this.codigo = String.format("%04d", new Random().nextInt(10000));
        new PidgeonSMSSender().send(voluntario.getContacto(), codigo);
    }
}