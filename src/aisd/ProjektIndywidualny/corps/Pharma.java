package aisd.ProjektIndywidualny.corps;

public class Pharma extends Corp {
    private int need;

    public Pharma(int id, String name, int need) {
        super(id, name);
        this.need = need;
    }

    public void setNeed(int given) {
        need -= given;
    }

    public int getNeed() {
        return need;
    }

    public boolean hasConnection(Prod prod) {
        for (Connection connection : connections) {
            if (connection.getProd() == prod) {
                return true;
            }
        }
        return false;
    }
}
