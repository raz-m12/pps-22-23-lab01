package lab01.tdd;

import java.util.Optional;

class Node {
    Node(int val) {
        value = val;
    }
    int value;
    Node prev;
    Node next;
}
public class SimpleCircularList implements CircularList{
    private int size;
    private Node current = null;

    @Override
    public void add(int element) {
        var next = new Node(element);
        if(isNull(this.current)) {
            this.current = next;
        } else {
            var endNode = getLastNodeOf(this.current);
            endNode.next = next;
        }
        this.size++;
    }

    private Node getLastNodeOf(Node node) {
        if(isNull(node.next))
            return node;
        else
            return getLastNodeOf(node.next);
    }

    private boolean isNull(Node node) {
        return node == null;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public Optional<Integer> next() {
        Optional<Integer> result = current != null? Optional.of(this.current.value): Optional.empty();
        if(!isNull(this.current))
            this.current = this.current.next;

        return result;
    }

    @Override
    public Optional<Integer> previous() {
        return Optional.empty();
    }

    @Override
    public void reset() {

    }
}
