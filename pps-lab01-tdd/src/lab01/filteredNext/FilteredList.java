package lab01.filteredNext;

import java.util.Optional;


/**
 * Represents a list of integers, with the ability to search over the list and find the next element which satisfies
 * a given condition. In case the end of the list is reached, the search continues from the beginning of the list.
 * Example: with a list like {1,2,3}, searching for element 1, retrieves the first element in the list.
 * Searching for the value 3 the third element is returned. Searching for 2, the end of the list is reached and
 * the search continues from the beginning eventually returning the matched element.
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
