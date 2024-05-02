package DataStructure.Linked;

public class DoublyLinkedList<T> extends LinkedList<T> {
    @Override
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
        Node newNode = new Node(value);
        node.setNext(newNode);
        newNode.setPrev(newNode);
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
        if (deadNode.getPrev() != null) {
            deadNode.getPrev().setNext(deadNode.getNext());
        }
        if (deadNode.getNext() != null) {
            deadNode.getNext().setPrev(deadNode.getPrev());
        }
    }
    @Override
    public void reverse() {
        Node pastNode = null;
        Node curNode = head;
        Node nextNode;
        while ((curNode.getNext()) != null) {
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
