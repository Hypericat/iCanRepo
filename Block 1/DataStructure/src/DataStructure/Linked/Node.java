package DataStructure.Linked;

public class Node {
    private Node next;
    private Node prev;
    private Object value;
    public Node() {

    }
    public Node(Object value) {
        this.value = value;
    }
    public Node(Node next, Object value) {
        this(value);
        this.next = next;
    }
    public Node(Node next, Node prev, Object value) {
        this(value);
        this.next = next;
        this.prev = prev;
    }
    public Node(Node next) {
        this.next = next;
    }
    public Node(Node next, Node prev) {
        this.next = next;
        this.prev = prev;
    }
    public void setValue(Object value) {
        this.value = value;
    }
    public Object getValue() {
        return value;
    }
    public Node getNext() {
        return next;
    }

    public Node getPrev() {
        return prev;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public void setPrev(Node prev) {
        this.prev = prev;
    }
}
