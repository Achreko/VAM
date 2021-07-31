package aisd.ProjektIndywidualny.load;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Loader {
    private final Parser parser = new Parser();

    public State read(String fileName) {
        State state = new State();

        String buffer;
        int commentAmount = -1;
        int sepCount;
        int sepAllowed = 2;

        try {
            File file = new File(fileName);
            FileReader fileReader = new FileReader(file);
            BufferedReader reader = new BufferedReader(fileReader);
            while ((buffer = reader.readLine()) != null) {
                sepCount = 0;
                if (buffer.trim().indexOf('#') == 0) {
                    commentAmount++;
                    if (commentAmount == 2) {
                        sepAllowed = 3;
                    }
                    continue;
                }
                for (int i = 0; i < buffer.length(); i++) {
                    if (buffer.charAt(i) == '|') {
                        sepCount++;
                    }
                }
                if (sepCount != sepAllowed) {
                    System.out.println("Niepoprawna ilość separatorów");
                    System.exit(1);
                }
                String[] bufferArray = buffer.split("\\s+\\|\\s+", 4);

                switch (commentAmount) {
                    case 0 -> parser.parseProd(state, bufferArray);
                    case 1 -> parser.parsePharma(state, bufferArray);
                    case 2 -> parser.parseConnection(state, bufferArray);
                }
            }
            state.checkConnections();
            reader.close();
            fileReader.close();

        } catch (IOException e) {
            System.out.println("Nie można znaleźć lub otworzyć pliku");
            System.exit(1);
        }
        return state;
    }


}
