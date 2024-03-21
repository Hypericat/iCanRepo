import Dijkstra.PathFinder;
import Network.NodeHandler;

public class Main {
    public static void main(String[] args) {
        //Init network
        Initializer initializer = new Initializer();
        NodeHandler handler = new NodeHandler();
        initializer.loadFile(handler);

        //Run Dijkstra
        PathFinder finder = new PathFinder(handler);
        finder.getShortestPath(0, 4);
    }
}