package src;

import java.util.ArrayList;
import java.util.List;

public class Familia extends Migrante {
    private final int numeroDePessoas;
    private final List<String> nomes;
    private String contacto;
    


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
        this.nomes.add(nome);
    }
}
