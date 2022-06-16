package app.domain;

import java.util.ArrayList;
import java.util.List;

public class Familia extends Migrante {
    private final int numeroDePessoas;
    private final List<String> nomes;

    public Familia(int nrPessoas) {
        super();

        this.nomes = new ArrayList<>();
        this.numeroDePessoas = nrPessoas;
    }

    public void setInfo(String nome, String contacto) {
        this.contacto = contacto;
        this.nomes.add(nome);
    }

    public void setNome(String nome) {
        if (this.nomes.size() < this.numeroDePessoas) {
            this.nomes.add(nome);
        }
    }
}
