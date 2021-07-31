package aisd.ProjektIndywidualny.load;

import aisd.ProjektIndywidualny.corps.Pharma;
import aisd.ProjektIndywidualny.corps.Prod;

import java.util.Vector;

public class State {
    private final Vector<Pharma> pharmaVector = new Vector<>();
    private final Vector<Prod> prodVector = new Vector<>();


    public Vector<Pharma> getPharmaVector() {
        return pharmaVector;
    }

    public Vector<Prod> getProdVector() {
        return prodVector;
    }

    public void addPharma(Pharma ph) {
        pharmaVector.add(ph);
    }

    public void addProd(Prod pr) {
        prodVector.add(pr);
    }

    public Pharma getPharmaById(int id) {
        Pharma pharma = null;
        for (Pharma el : pharmaVector) {
            if (el.getId() == id) {
                pharma = el;
                break;
            }
        }
        return pharma;
    }

    public Prod getProdById(int id) {
        Prod prod = null;
        for (Prod el : prodVector) {
            if (el.getId() == id) {
                prod = el;
                break;
            }
        }
        return prod;
    }

    public Pharma getPharmaByName(String name) {
        Pharma pharma = null;
        for (Pharma el : pharmaVector) {
            if (el.getName().equals(name)) {
                pharma = el;
                break;
            }
        }
        return pharma;
    }

    public Prod getProdByName(String name) {
        Prod prod = null;
        for (Prod el : prodVector) {
            if (el.getName().equals(name)) {
                prod = el;
                break;
            }
        }
        return prod;
    }

    public void checkConnections() {
        int prodCount = prodVector.size();
        for (Pharma el : pharmaVector) {
            if (el.getConnections().size() != prodCount) {
                String message = "Apteka " + el.getName() + " nie jest połączona ze wszystkimi producentami";
                System.out.println(message);
                System.exit(1);
            }
        }
    }
}
