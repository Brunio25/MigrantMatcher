import app.domain.Ajuda;
import app.domain.Alojamento;
import app.domain.Item;
import app.strategies.AddBy;
import app.strategies.AddByAsc;
import app.strategies.AddByType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class AddByTest {
    static List<Ajuda> data = new ArrayList<>();

    @BeforeAll
    public static void setUp() {

        data.add(new Item("comida"));
        data.add(new Alojamento(7));
        data.add(new Item("bebida"));
        data.add(new Alojamento(1000));
        data.add(new Item("roupa"));
        data.add(new Alojamento(2));
        data.add(new Item("234234!"));
        data.add(new Alojamento(16));
    }

    @Test
    public void runAddByAsc() {
        AddBy addBy = new AddByAsc();
        List<Ajuda> newList = new ArrayList<>();

        for (Ajuda ajuda : data) {
            addBy.add(ajuda, newList);
        }

        for (int i = 0; i < data.size(); i++) {
            assertEquals(data.get(i), newList.get(i));
        }
    }

    @Test
    public void runAddByType() {
        List<Ajuda> newList = new ArrayList<>();
        AddBy addBy = new AddByType();
        int counter = 0;

        for (Ajuda ajuda : data) {
            addBy.add(ajuda, newList);
        }

        boolean result = true;
        boolean aloj = true;
        for (int i = 0; i < data.size(); i++) {
            if (newList.get(i) instanceof Item && aloj) {
                aloj = false;
            } else if (newList.get(i) instanceof Alojamento && !aloj) {
                result = false;
            }
        }

        assertTrue(result);

    }
}
