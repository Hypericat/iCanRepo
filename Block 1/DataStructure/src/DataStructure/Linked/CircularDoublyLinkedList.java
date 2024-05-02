package DataStructure.Linked;

public class CircularDoublyLinkedList<T> extends DoublyLinkedList<T> {
    protected Node last;
    @Override
    public void add(T value) {
        //test for non initialized
        if (head == null) {
            head = new Node(value);
            head.setNext(head);
            head.setPrev(head);
            last = head;
            return;
        }
        Node newNode = new Node(value);
        last.setNext(newNode);
        newNode.setNext(head);
        newNode.setPrev(newNode);
        last = newNode;
    }
    @Override
    public void remove(int index) {
        if (index == 0 && head.getNext() == null) {
            head = null;
            return;
        }
        Node node = head;
        for (int i = 0; i < index; i++) {
            if (node.getNext() == null) throw new IndexOutOfBoundsException();
            node = node.getNext();
        }
        Node deadNode = node;
        if (deadNode == head) {
            head = deadNode.getNext();
            return;
        }
        deadNode.getPrev().setNext(deadNode.getNext());
        deadNode.getNext().setPrev(deadNode.getPrev());


        if (last == deadNode)
            last = deadNode.getPrev();
    }
    @Override
    public int getLength() {
        int count = 1;
        Node node = head;
        while (node != last) {
            count ++;
            node = node.getNext();
        }
        return count;
    }
    @Override
    public void reverse() {
        Node pastNode = null;
        Node curNode = head;
        Node nextNode;
        while (curNode != last) {
            nextNode = curNode.getNext();
            curNode.setNext(pastNode);
            curNode.setPrev(nextNode);
            pastNode = curNode;
            curNode = nextNode;
            nextNode = null;
        }
        curNode.setNext(pastNode);
        head = curNode;
    }
}
