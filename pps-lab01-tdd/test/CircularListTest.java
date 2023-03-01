import lab01.tdd.CircularList;
import lab01.tdd.SimpleCircularList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test suite for testing the CircularList implementation
 */
public class CircularListTest {

    private CircularList list;

    @BeforeEach
    void beforeEach(){
        list = new SimpleCircularList();
    }

    @Test
    public void testAddElement() {
        list.add(1);
        Assertions.assertEquals(1, list.size());
    }

    @Test
    public void testIsEmpty() {
        Assertions.assertTrue(list.isEmpty());
    }

    @Test
    public void testIsNotEmpty() {
        list.add(1);
        Assertions.assertFalse(list.isEmpty());
    }

    @Test
    public void testNextOnEmptyList() {
        Assertions.assertTrue(list.next().isEmpty());
    }

    @Test
    public void testNextRetrievesValue() {
        list.add(1);
        list.add(2);
        list.add(3);
        Assertions.assertEquals(1, list.next().get());
        Assertions.assertEquals(2, list.next().get());
        Assertions.assertEquals(3, list.next().get());
        Assertions.assertEquals(1, list.next().get());
    }

    @Test
    public void testPreviousValue() {
        list.add(1);
        list.add(2);
        list.add(3);

        Assertions.assertEquals(1, list.previous().get());
        Assertions.assertEquals(3, list.previous().get());
        Assertions.assertEquals(2, list.previous().get());
    }


    @Test
    public void testResetToHead() {
        list.add(1);
        list.add(2);
        list.next();
        list.reset();

        Assertions.assertEquals(1, list.next().get());
    }
    
}
