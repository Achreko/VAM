package aisd.ProjektIndywidualny.corps;

import java.util.ArrayList;
import java.util.List;

public class Corp {
    protected final int id;
    protected final String name;
    protected List<Connection> connections = new ArrayList<>();

    public Corp(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Connection> getConnections() {
        return connections;
    }

    public void addConnection(Connection con) {
        connections.add(con);
    }

}
