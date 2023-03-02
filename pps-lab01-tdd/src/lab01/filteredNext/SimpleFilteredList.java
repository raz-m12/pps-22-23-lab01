package lab01.filteredNext;

import lab01.shared.Node;

import java.util.Optional;

import static lab01.shared.Utils.getTailOf;
import static lab01.shared.Utils.isNull;

public class SimpleFilteredList implements FilteredList {

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
    public Optional<Integer> filteredNext(ListIntegerFinder condition) {
        return Optional.empty();
    }
}
