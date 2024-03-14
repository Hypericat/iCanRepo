package DataStructure.Linked;

public class LinkedList<T> {
    protected Node head;
    public LinkedList() {

    }
    public void add(T value) {
        //test for non initialized
        if (head == null) {
            head = new Node(value);
            return;
        }
        Node node = head;
        while (node.getNext() != null) {
            node = node.getNext();
        }
        node.setNext(new Node(value));
    }
    public void remove(int index) {
        if (index == 0 && head.getNext() == null) {
            head = null;
            return;
        }
        if (index == 0) {
            head = head.getNext();
            return;
        }
        Node node = head;
        for (int i = 0; i < index - 1; i++) {
            if (node.getNext() == null) throw new IndexOutOfBoundsException();
            node = node.getNext();
        }
        if (node == head) {
            head = node.getNext();
        }
        node.setNext(node.getNext().getNext());
    }
    public T get(int index) {
        return (T) getNode(index).getValue();
    }
    private Node getNode(int index) {
        Node node = head;
        for (int i = 0; i < index; i++) {
            if (node.getNext() == null) throw new IndexOutOfBoundsException();
            node = node.getNext();
        }
        return node;
    }
    public int getLength() {
        int count = 1;
        Node node = head;
        while (node.getNext() != null) {
            count ++;
            node = node.getNext();
        }
        return count;
    }
    public void reverse() {
        Node pastNode = null;
        Node curNode = head;
        Node nextNode;
        while ((curNode.getNext()) != null) {
            nextNode = curNode.getNext();
            curNode.setNext(pastNode);
            pastNode = curNode;
            curNode = nextNode;
            nextNode = null;
        }
        curNode.setNext(pastNode);
        head = curNode;
    }
    public void swap(int index1, int index2) {
        Node n1 = getNode(index1);
        Node n2 = getNode(index2);
        Object n1Val = n1.getValue();
        n1.setValue(n2.getValue());
        n2.setValue(n1Val);
    }
}
