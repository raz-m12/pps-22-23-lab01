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

}
