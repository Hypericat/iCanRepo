package Network;

import java.util.ArrayList;
import java.util.List;

public class Node {
    protected int id;
    protected List<Path> paths;
    public int getId() {
        return id;
    }
    public Node(int id) {
        paths = new ArrayList<>();
        this.id = id;
    }
    public void addPath(Path p) {
        paths.add(p);
    }
    public void removePath(int index) {
        paths.remove(index);
    }
    public List<Path> getPaths() {
        return paths;
    }
    public void removePath(Path p) {
        paths.remove(p);
    }
    public Path getPath(int nodeId) {
        for (Path p : paths) {
            if (p.isNode(nodeId)) return p;
        }
        return null;
    }
}
