import lab01.filteredNext.FilteredList;
import lab01.filteredNext.ListIntegerFinder;
import lab01.filteredNext.SimpleFilteredList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FilteredListTest {

    private FilteredList list;

    @BeforeEach
    void beforeEach(){
        list = new SimpleFilteredList();
    }

    @Test
    public void testFilteredNextOnEmptyList() {
        ListIntegerFinder condition = (a) -> a.value == 5;
        Assertions.assertTrue(list.filteredNext(condition).isEmpty());
    }

    @Test
    public void testFilteredNextFindsInsertedValues() {
        list.add(4);
        list.add(5);
        list.add(2);
        list.add(6);

        ListIntegerFinder condition = (a) -> a.value == 4;
        Assertions.assertEquals(4, list.filteredNext(condition).get());

        condition = (a) -> a.value == 2;
        Assertions.assertEquals(2, list.filteredNext(condition).get());

        condition = (a) -> a.value == 6;
        Assertions.assertEquals(6, list.filteredNext(condition).get());

        condition = (a) -> a.value == 5;
        Assertions.assertEquals(5, list.filteredNext(condition).get());
    }

    @Test
    public void testFilteredNextElementNotFound() {
        list.add(4);

        ListIntegerFinder condition = (a) -> a.value == 55;
        Assertions.assertTrue(list.filteredNext(condition).isEmpty());
    }
}
