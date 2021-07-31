package aisd.ProjektIndywidualny.corps;

public class Prod extends Corp {
    private int stock;

    public Prod(int id, String name, int stock) {
        super(id, name);
        this.stock = stock;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int sold) {
        stock -= sold;
    }
}
