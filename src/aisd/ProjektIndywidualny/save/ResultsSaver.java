package aisd.ProjektIndywidualny.save;

import aisd.ProjektIndywidualny.corps.Connection;
import aisd.ProjektIndywidualny.corps.Prod;
import aisd.ProjektIndywidualny.load.State;

import java.io.FileWriter;
import java.io.IOException;

public class ResultsSaver {
    public void save(State state) {
        try {
            FileWriter fileWriter = new FileWriter("result.txt");
            double sum = 0;

            for (Prod el : state.getProdVector()) {
                for (Connection con : el.getConnections()) {
                    if (con.getSent() == 0) {
                        continue;
                    }
                    double conPrice = con.getSent() * con.getCost();
                    sum += conPrice;
                    fileWriter.write(el.getName() + " -> " + con.getPharma().getName()
                            + " [Koszt = " + con.getSent() + " * " + con.getCost() + " = " + conPrice + " zł]\n");
                }
            }
            fileWriter.write("\n");
            fileWriter.write("Opłaty całkowite: " + sum + " zł");
            fileWriter.close();
        } catch (IOException e) {
            System.out.println("Nie można utworzyć pliku lub zapisać do niego danych");
        }
    }

}
