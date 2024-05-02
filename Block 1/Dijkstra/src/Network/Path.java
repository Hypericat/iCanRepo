package Network;

public class Path {
    private int idNode1;
    private int idNode2;
    private int length;
    public Path(int idNode1, int idNode2, int length) {
        this.idNode1 = idNode1;
        this.idNode2 = idNode2;
        this.length = length;
    }
    public int getIdNode1() {
        return idNode1;
    }

    public int getIdNode2() {
        return idNode2;
    }

    public int getOther(int id) {
        if (id == idNode1) return idNode2;
        if (id == idNode2) return idNode1;
        return -1;
    }
    public boolean isNode(int id) {
        return idNode1 == id || idNode2 == id;
    }
    public int getLength() {
        return this.length;
    }

}
