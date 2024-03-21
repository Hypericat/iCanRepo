package Dijkstra;

import Network.Node;
import Network.NodeHandler;
import Network.Path;

import java.util.ArrayList;
import java.util.List;

public class PathFinder {
    private List<TotalNode> queue;
    private NodeHandler handler;
    private int endId = -1;
    private int bestEnd = Integer.MAX_VALUE;
    public PathFinder(NodeHandler handler) {
        this.handler = handler;
        queue = new ArrayList<>();
    }
    public List<Node> getShortestPath(int startId, int endId) {
        TotalNode start = new TotalNode(handler.getNode(startId));
        start.setBestLength(0);
        TotalNode end = new TotalNode(handler.getNode(endId));
        endId = end.getId();
        addToQueue(start);
        while (!queue.isEmpty()) {
            processNode();
        }
        System.out.println("found best length " + bestEnd);
        return null;
    }
    public void processNode() {
        TotalNode n1 = getNextNode();
        explore(n1);
        queue.remove(n1);
        //AHHH MY HEAD HURTS

    }
    public TotalNode getNextNode() {
        if (queue.isEmpty()) return null;
        int bestLength = Integer.MAX_VALUE;
        TotalNode best;
        for (TotalNode n : queue) {
            if (n.getBestLength() < bestLength) {
                best = n;
                bestLength = n.getBestLength();
            }
        }
        if (bestLength == Integer.MAX_VALUE) return queue.get(0);
        return null;
    }
    public void explore(TotalNode n) {
        for (Path p : n.getPaths()) {
            if (hasQueueNode(p.getOther(n.getId()))) {
                TotalNode newNode = queue.get(getQueueNodeIndex(p.getOther(n.getId())));
                newNode.setBestLength(Math.min(newNode.getBestLength(), n.getBestLength() + p.getLength()));
                if (newNode.getId() == endId) bestEnd = newNode.getBestLength();
            }
            TotalNode newNode = new TotalNode(p.getOther(n.getId()));
            newNode.setBestLength(n.getBestLength() + p.getLength());

            if (newNode.getId() == endId) bestEnd = newNode.getBestLength();

            addToQueue(newNode);
        }
    }
    public boolean hasQueueNode(int id) {
        for (TotalNode n : queue) {
            if (n.getId() == id) return true;
        }
        return false;
    }
    public int getQueueNodeIndex(int id) {
        int i = 0;
        for (TotalNode n : queue) {
            if (n.getId() == id) return i;
            i++;
        }
        return -1;
    }
    public void addToQueue(TotalNode n) {
        queue.add(n);
    }
}
