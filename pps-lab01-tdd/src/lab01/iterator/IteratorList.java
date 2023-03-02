package lab01.iterator;

import java.util.Iterator;

/**
 * Represents a list of integers. Provides two ways of iterating over the list.
 * Forward and backward iterators permit iteration in both directions. Both are circular.
 * Example: suppose forward iterator is used with a list like {1,2,3}.
 * The first call of next() returns 1, the second call returns 2, the third returns 3, the fourth returns 1, and so on.
 * Backward iterator is similar but works in the opposite direction.
 */
public interface IteratorList {
    /**
     * Adds an element to the list, namely, after the last inserted one.
     * @param element the element to be added to the list
     */
    void add(final int element);

    /**
     * Provides a way of forward iterating over the elements of the list.
     * @return an iterator enabling forward iteration of the list.
     */
    Iterator<Integer> forwardIterator();

    /**
     * Provides a way of backward iterating over the elements of the list.
     * @return an iterator enabling backward iteration of the list.
     */
    Iterator<Integer> backwardIterator();
}
