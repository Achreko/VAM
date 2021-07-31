package aisd.ProjektIndywidualny.load;

import aisd.ProjektIndywidualny.corps.Connection;
import aisd.ProjektIndywidualny.corps.Pharma;
import aisd.ProjektIndywidualny.corps.Prod;

public class Parser {
    public void parseProd(State state, String[] buffer) {
        int id = Integer.parseInt(buffer[0]);
        if (state.getProdById(id) != null || state.getProdByName(buffer[1]) != null) {
            String message = "Powtarza się producent " + state.getProdByName(buffer[1]) +
                    " z indeksem " + state.getProdById(id);
            System.out.println(message);
            System.exit(1);
        }
        Prod prod = new Prod(id, buffer[1], Integer.parseInt(buffer[2]));
        state.addProd(prod);
    }

    public void parsePharma(State state, String[] buffer) {
        int id = Integer.parseInt(buffer[0]);
        if (state.getPharmaById(id) != null || state.getPharmaByName(buffer[1]) != null) {
            String message = "Powtarza się apteka " + state.getPharmaByName(buffer[1]) +
                    " z indeksem " + state.getPharmaById(id);
            System.out.println(message);
            System.exit(1);
        }
        Pharma pharma = new Pharma(Integer.parseInt(buffer[0]), buffer[1], Integer.parseInt(buffer[2]));
        state.addPharma(pharma);
    }

    public void parseConnection(State state, String[] buffer) {
        int pharmaId = Integer.parseInt(buffer[1]);
        int prodId = Integer.parseInt(buffer[0]);
        Pharma pharma = state.getPharmaById(pharmaId);
        Prod prod = state.getProdById(prodId);

        if (pharma == null || prod == null || pharma.hasConnection(prod)) {
            String message = "Połączenia dublują się, nie istnieje producent o id "
                    + prodId + " lub nie istnieje apteka o id " + pharmaId;
            System.out.println(message);
            System.exit(1);
        }

        Connection connection = new Connection(
                prod, pharma, Integer.parseInt(buffer[2]), Double.parseDouble(buffer[3]), 0);
        prod.addConnection(connection);
        pharma.addConnection(connection);
    }
}

