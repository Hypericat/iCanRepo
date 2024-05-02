import Network.Node;
import Network.NodeHandler;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Initializer {
    public Initializer() {
        File file = new File("network.txt");
        try {
            if (!file.exists()) file.createNewFile();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
    public void loadFile(NodeHandler handler) {
        File networkFile;
        Scanner scanner;
        try {
            //idc if it doesn't exist im not handling it
            networkFile = new File("network.txt");
            scanner = new Scanner(networkFile);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        while (scanner.hasNextLine()) {
            handler.processNode(scanner.nextLine());
        }
    }
}
