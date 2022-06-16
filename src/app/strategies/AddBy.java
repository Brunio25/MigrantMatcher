package app.strategies;

import app.domain.Ajuda;

import java.util.List;

public interface AddBy {
    List<Ajuda> add(Ajuda ajuda, List<Ajuda> ajudas);
}
