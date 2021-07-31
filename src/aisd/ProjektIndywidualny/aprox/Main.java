package aisd.ProjektIndywidualny.aprox;

import aisd.ProjektIndywidualny.load.Loader;
import aisd.ProjektIndywidualny.load.State;
import aisd.ProjektIndywidualny.save.ResultsSaver;

public class Main {

    public static void main(String[] args) {
        String fileName;
        try {
            fileName = args[0];
        } catch (ArrayIndexOutOfBoundsException e) {
            fileName = "dane.txt";
        }
        Loader loader = new Loader();
        State state = loader.read(fileName);

        Aprox aprox = new Aprox(state);
        aprox.approximate();

        ResultsSaver resultsSaver = new ResultsSaver();
        resultsSaver.save(state);
    }

}
