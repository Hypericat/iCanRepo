import Dijkstra.PathFinder;
import Network.Node;
import Network.NodeHandler;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        //Init network
        Initializer initializer = new Initializer();
        NodeHandler handler = new NodeHandler();
        initializer.loadFile(handler);

        //Run Dijkstra
        PathFinder finder = new PathFinder(handler);
        List<Node> nodes = finder.getShortestPath(8, 4);

        for (Node n : nodes) {
            System.out.println(n.getId());
        }


    }
}