package lab01.filteredNext;

import lab01.shared.Node;

/**
 * Commodity interface that adds the ability to use lambda functions for searching elements of the list.
 * Used internally by the FilteredList inside the filteredNext method.
 */
public interface ListIntegerFinder {
    boolean satisfies(Node node);
}
