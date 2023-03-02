package lab01.filteredNext;

import java.util.Optional;


/**
 * TODO update description
 * Represents a list of integers, with a built-in iterator that is bidirectional and circular.
 * Example: with a list like {1,2,3}, the first call of next() returns 1, the second call returns 2,
 * the third returns 3, the fourth returns 1, and so on. Call to previous() goes in the other way.
 */
public interface FilteredList {
    /**
     * Adds an element to the list, namely, after the last inserted one.
     * @param element the element to be added to the list
     */
    void add(final int element);

    /**
     * Provides a way of searching over the elements of the list.
     * @return the first element in the list that satisfies the given condition.
     */
    Optional<Integer> filteredNext(ListIntegerFinder condition);

}
