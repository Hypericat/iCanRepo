package Network;

import java.util.ArrayList;
import java.util.List;

public class NodeHandler {
    List<Node> nodes = new ArrayList<>();
    public NodeHandler() {

    }
    public void processNode(String str) {
        String[] nodes = str.split(" ");
        Node n1 = initNode(nodes[0]);
        Node n2 = initNode(nodes[1]);
        Path p = new Path(n1.getId(), n2.getId(), Integer.parseInt(nodes[2]));
        add(n1);
        add(n2);
        n1.addPath(p);
        n2.addPath(p);
    }
    private Node initNode(String str) {
        //let it throw again idc just dont mess up the file
        if (!isNode(Integer.parseInt(str))) {
            return new Node(Integer.parseInt(str));
        }
        return getNode(Integer.parseInt(str));
    }
    public void add(Node node) {
        nodes.add(node);
    }
    public boolean isNode(int id) {
        for (Node n : nodes) {
            if (n.getId() == id) return true;
        }
        return false;
    }
    public Node getNode(int id) {
        for (Node n : nodes) {
            if (n.getId() == id) return n;
        }
        return null;
    }
}
