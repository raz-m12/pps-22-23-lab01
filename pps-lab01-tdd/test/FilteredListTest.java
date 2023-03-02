import lab01.filteredNext.FilteredList;
import lab01.filteredNext.ListIntegerFinder;
import lab01.filteredNext.SimpleFilteredList;
import lab01.tdd.CircularList;
import lab01.tdd.SimpleCircularList;
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
}
