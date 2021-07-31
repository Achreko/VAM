package aisd.ProjektIndywidualny.corps;

public class Connection  {
    private final Prod Prod;
    private final Pharma Pharma;
    private int availability;
    private final double cost;
    private int sent;

    public Connection(Prod prod, Pharma pharma, int availability, double cost, int sent) {
        this.Prod = prod;
        this.Pharma = pharma;
        this.availability = availability;
        this.cost = cost;
        this.sent = sent;
    }

    public Prod getProd() {
        return Prod;
    }

    public Pharma getPharma() {
        return Pharma;
    }

    public int getAvailability() {
        return availability;
    }

    public double getCost() {
        return cost;
    }

    public int getSent() {
        return sent;
    }

    public void setSent(int sent) {
        this.sent = sent;
    }

}
