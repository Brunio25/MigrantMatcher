package app.strategies;

import app.domain.Ajuda;

import java.util.List;

public class AddByAsc implements AddBy {

    public AddByAsc() {
    }

    @Override
    public List<Ajuda> add(Ajuda ajuda, List<Ajuda> ajudas) {
        ajudas.add(ajuda);
        return ajudas;
    }
}
