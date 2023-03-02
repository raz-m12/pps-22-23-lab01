package lab01.filteredNext;

import lab01.shared.Node;

import java.util.Optional;

import static lab01.shared.Utils.*;

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
    public Optional<Integer> filteredNext(ListIntegerFinder condition) {

        if(isNull(current)) return Optional.empty();

        var startNode = current;
        do {
            if(condition.satisfies(current)) {
                return Optional.of(current.value);
            }
            else {
                current = isNull(current.next) ? getHeadOf(current): current.next;
            }
        } while(current != startNode);
        return Optional.empty();
    }
}
