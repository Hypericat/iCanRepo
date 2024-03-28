package Dijkstra;

import Network.Node;
import Network.NodeHandler;
import Network.Path;

import java.util.ArrayList;
import java.util.List;

public class PathFinder {
    private List<TotalNode> queue;
    private NodeHandler handler;
    private List<TotalNode> doneNodes = new ArrayList<>();
    private int endId = -1;
    private TotalNode endNode;
    private int bestEnd = Integer.MAX_VALUE;
    public PathFinder(NodeHandler handler) {
        this.handler = handler;
        queue = new ArrayList<>();
    }
    public List<Node> getShortestPath(int startId, int endId) {
        TotalNode start = new TotalNode(handler.getNode(startId));
        start.setBestLength(0);
        TotalNode end = new TotalNode(handler.getNode(endId));
        this.endId = endId;
        addToQueue(start);
        while (!queue.isEmpty()) {
            processNode();
        }
        //System.out.println("found best length " + bestEnd);
        //System.out.println("Best path :");
        TotalNode n = endNode;
        List<Node> path = new ArrayList<>();
        path.add(start);
        while (n.past != null) {
            path.add(1, n);
            n = n.past;
        }
        return path;
    }
    public void processNode() {
        TotalNode n1 = getNextNode();
        //System.out.println(n1.getBestLength());
        //System.out.println(n1.getId());
        explore(n1);
        doneNodes.add(n1);
        queue.remove(n1);
        //AHHH MY HEAD HURTS

    }
    public TotalNode getNextNode() {
        if (queue.isEmpty()) return null;
        int bestLength = Integer.MAX_VALUE;
        TotalNode best = null;
        for (TotalNode n : queue) {
            if (n.getBestLength() < bestLength) {
                best = n;
                bestLength = n.getBestLength();
            }
        }
        if (bestLength == Integer.MAX_VALUE) return queue.get(0);
        return best;
    }
    public void explore(TotalNode n) {
        path : for (Path p : n.getPaths()) {
            for (TotalNode node : doneNodes) {
                if (node.getId() == p.getOther(n.getId())) continue path;
            }
            if (hasQueueNode(p.getOther(n.getId()))) {
                TotalNode newNode = queue.get(getQueueNodeIndex(p.getOther(n.getId())));
                if (newNode.getBestLength() > n.getBestLength() + p.getLength()) {
                    newNode.past = n;
                    //System.out.println("Set new past of node " + newNode.getId() + " to node " + n.getId());
                }
                newNode.setBestLength(Math.min(newNode.getBestLength(), n.getBestLength() + p.getLength()));
                if (newNode.getId() == endId && newNode.getBestLength() < bestEnd) bestEnd = newNode.getBestLength();
                continue;
            }
            TotalNode newNode = new TotalNode(handler.getNode(p.getOther(n.getId())));
            newNode.setBestLength(n.getBestLength() + p.getLength());
            newNode.past = n;
            //System.out.println("Created new  node " + newNode.getId() + " past node " + n.getId());

           StringBuilder builder = new StringBuilder();
            if (newNode.getId() == endId) endNode = newNode;
            if (newNode.getId() == endId && newNode.getBestLength() < bestEnd) bestEnd = newNode.getBestLength();
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
