import lab01.iterator.IteratorCircularList;
import lab01.iterator.IteratorList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Iterator;

/**
 * The test suite for testing the IteratorList implementation
 */
public class IteratorListTest {
    private IteratorList list;
    private Iterator<Integer> forwardIterator;
    private Iterator<Integer> backwardIterator;

    @BeforeEach
    void beforeEach(){
        list = new IteratorCircularList();
        forwardIterator = list.forwardIterator();
        backwardIterator = list.backwardIterator();
    }

    @Test
    public void testForwardIterationEmptyCollection() {
        Assertions.assertFalse(forwardIterator.hasNext());
    }

    @Test
    public void testForwardIteration() {
        list.add(4);
        list.add(5);

        Assertions.assertEquals(4, forwardIterator.next());
        Assertions.assertEquals(5, forwardIterator.next());
        Assertions.assertEquals(4, forwardIterator.next());
    }

    @Test
    public void testBackwardIteration() {
        list.add(4);
        list.add(5);
        list.add(6);

        Assertions.assertEquals(4, backwardIterator.next());
        Assertions.assertEquals(6, backwardIterator.next());
        Assertions.assertEquals(5, backwardIterator.next());
    }

}
