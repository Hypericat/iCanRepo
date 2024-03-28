package Dijkstra;

import Network.Node;
import Network.NodeHandler;

import java.util.ArrayList;
import java.util.List;

public class TotalNode extends Node {
    int bestLength = Integer.MAX_VALUE;
    TotalNode past;
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
