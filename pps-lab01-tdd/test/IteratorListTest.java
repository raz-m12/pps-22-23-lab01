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

    @BeforeEach
    void beforeEach(){
        list = new IteratorCircularList();
        forwardIterator = list.forwardIterator();
    }

    @Test
    public void testAddElement() {
        list.add(1);
        Assertions.assertEquals(1, list.size());
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

}
