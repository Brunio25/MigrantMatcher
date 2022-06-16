package app.domain;

import app.strategies.AddBy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CatalogoAjudas {
    private static HashMap<Ajuda, Voluntario> ajudasCatalogo;
    private static CatalogoAjudas instance;
    private static List<Ajuda> ajudas;

    public static CatalogoAjudas getInstance() {
        if (instance == null) {
            instance = new CatalogoAjudas();
        }

        return instance;
    }

    private CatalogoAjudas() {
        ajudasCatalogo = new HashMap<>();
        ajudas = new ArrayList<>();
    }

    public void addAjuda(Ajuda ajuda, Voluntario voluntario, AddBy addBy) {
        ajudasCatalogo.put(ajuda, voluntario);
        ajudas = addBy.add(ajuda, ajudas);
    }

    public List<Ajuda> getList() {
        return ajudas;
    }


    public List<Ajuda> getListaRegiao(Regiao regiao) {
        List<Ajuda> ajudas = getList();
        List<Ajuda> ajudasRegiao = new ArrayList<>();

        for (Ajuda ajuda : ajudas) {
            if (ajuda instanceof Alojamento) {
                Alojamento alojamento = (Alojamento) ajuda;
                if (alojamento.getRegiao().equals(regiao)) {
                    ajudasRegiao.add(ajuda);
                }
            }
            else {
                ajudasRegiao.add(ajuda);
            }
        }

        return ajudasRegiao;
    }

    public Voluntario getVoluntario(Ajuda a) {
        return ajudasCatalogo.get(a);
    }

    public List<Voluntario> getVoluntariosAjudas(List<Ajuda> ajudas) {
        List<Voluntario> voluntariosAjudas = new ArrayList<>();

        for (Ajuda ajuda : ajudas) {
            Voluntario v = getVoluntario(ajuda);
            if (!voluntariosAjudas.contains(v)) {
                voluntariosAjudas.add(v);
            }
        }

        return voluntariosAjudas;
    }
}