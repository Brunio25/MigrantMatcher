package app.strategies;

import app.domain.Ajuda;
import app.domain.Alojamento;

import java.util.List;

public class AddByType implements AddBy {
    public AddByType() {
    }

    @Override
    public List<Ajuda> add(Ajuda ajuda, List<Ajuda> ajudas) {

        if (ajuda instanceof Alojamento) {
            ajudas.add(0, ajuda);
        } else {
            ajudas.add(ajuda);
        }


        return ajudas;
    }
}
