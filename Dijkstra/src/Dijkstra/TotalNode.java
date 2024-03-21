package Dijkstra;

import Network.Node;
import Network.NodeHandler;

public class TotalNode extends Node {
    int bestLength = Integer.MAX_VALUE;
    public TotalNode(int id) {
        super(id);
    }
    public TotalNode(Node n) {
        super(n.getId());
        this.paths = n.getPaths();
    }

    public int getBestLength() {
        return bestLength;
    }

    public void setBestLength(int bestLength) {
        this.bestLength = bestLength;
    }
}
