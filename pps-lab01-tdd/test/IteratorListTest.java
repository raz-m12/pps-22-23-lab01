import lab01.iterator.IteratorCircularList;
import lab01.iterator.IteratorList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test suite for testing the IteratorList implementation
 */
public class IteratorListTest {
    private IteratorList list;

    @BeforeEach
    void beforeEach(){
        list = new IteratorCircularList();
    }

    @Test
    public void testAddElement() {
        list.add(1);
        Assertions.assertEquals(1, list.size());
    }

}
