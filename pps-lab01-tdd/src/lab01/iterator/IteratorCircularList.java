package lab01.iterator;

import lab01.shared.Node;

import java.util.Iterator;

import static lab01.shared.Utils.*;

public class IteratorCircularList implements IteratorList {

    Node current;
    int size = 0;
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

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public Iterator<Integer> forwardIterator() {
        return null;
    }

    @Override
    public Iterator<Integer> backwardIterator() {
        return null;
    }
}
