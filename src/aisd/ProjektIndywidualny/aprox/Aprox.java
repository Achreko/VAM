package aisd.ProjektIndywidualny.aprox;

import aisd.ProjektIndywidualny.corps.Connection;
import aisd.ProjektIndywidualny.corps.Pharma;
import aisd.ProjektIndywidualny.load.State;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Aprox {
    private final State state;

    public Aprox(State state) {
        this.state = state;
    }

    public void approximate() {
        int x = state.getPharmaVector().size();
        while (x-- > 0) {
            transportToPharma();
        }
    }

    public void transportToPharma() {
        Connection currentCon = null;
        Pharma currentPharma = null;

        double min = Double.MAX_VALUE;

        for (Pharma Pharma : state.getPharmaVector()) {
            if (Pharma.getNeed() > 0) {
                for (Connection connection : Pharma.getConnections()) {
                    if (connection.getCost() <= min) {
                        currentCon = connection;
                        min = currentCon.getCost();
                        currentPharma = connection.getPharma();
                    }
                }
            }
        }
        if (currentPharma == null) {
            return;
        }
        while (currentPharma.getNeed() > 0) {
            min = Double.MAX_VALUE;

            for (Connection connection : currentPharma.getConnections()) {
                if (connection.getCost() <= min && connection.getSent() == 0
                        && connection.getProd().getStock() > 0) {
                    min = connection.getCost();
                    currentCon = connection;
                }
            }
            makeLimits(currentCon, currentPharma);
        }
    }

    public void makeLimits(Connection con, Pharma ph) {
        List<Integer> limits = new ArrayList<>();

        limits.add(con.getAvailability());
        limits.add(ph.getNeed());
        limits.add(con.getProd().getStock());

        Collections.sort(limits);

        con.setSent(limits.get(0));
        ph.setNeed(limits.get(0));
        con.getProd().setStock(limits.get(0));
    }


}
