package lab01.tdd;

import lab01.shared.Node;
import static lab01.shared.Utils.*;

import java.util.Optional;


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
            this.current = isNull(this.current.next)? getHeadOf(this.current): this.current.next;

        return result;
    }

    @Override
    public Optional<Integer> previous() {
        Optional<Integer> result = getCurrentValue();
        if(!isNull(this.current))
            this.current = isNull(this.current.prev)? getTailOf(this.current): this.current.prev;

        return result;
    }

    @Override
    public void reset() {
        this.current = getHeadOf(this.current);
    }
    private Optional<Integer> getCurrentValue() {
        return !isNull(this.current) ? Optional.of(this.current.value): Optional.empty();
    }
}
