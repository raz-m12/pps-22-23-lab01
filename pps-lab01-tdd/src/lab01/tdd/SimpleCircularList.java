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
            var endNode = getTailOf(this.current);
            next.prev = endNode;
            endNode.next = next;
        }
        this.size++;
    }

    private Node getTailOf(Node node) {
        if(isNull(node.next))
            return node;
        else
            return getTailOf(node.next);
    }

    private Node getHeadOf(Node node) {
        if(isNull(node.prev))
            return node;
        else
            return getHeadOf(node.prev);
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
        Optional<Integer> result = getCurrentValue();
        if(!isNull(this.current))
            this.current = this.current.next == null? this.getHeadOf(this.current): this.current.next;

        return result;
    }

    @Override
    public Optional<Integer> previous() {
        Optional<Integer> result = getCurrentValue();
        if(!isNull(this.current))
            this.current = this.current.prev == null? this.getTailOf(this.current): this.current.prev;

        return result;
    }

    private Optional<Integer> getCurrentValue() {
        return !isNull(this.current) ? Optional.of(this.current.value): Optional.empty();
    }

    @Override
    public void reset() {

    }
}
