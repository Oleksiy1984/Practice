package ua.nure.orlovskyi.Practice2;

import java.util.Iterator;

/**
 * Iterator.
 */
public interface ListIterator extends Iterator<Object> {

	/**
	 * Returns true if this list iterator has more elements when traversing the list
	 * in the reverse direction.
	 *
	 * @return true if this list iterator has more elements when traversing the list
	 *         in the reverse direction.
	 */
	boolean hasPrevious();

	/**
	 * Returns the previous element in the list and moves the cursor position
	 * backwards.
	 * @return the previous element in the list.
	 */
	Object previous();

	/**
	 * Replaces the last element returned by next or previous with the specified
	 * element.
	 *
	 * @param e element to be set.
	 */
	void set(Object e);

	/**
	 * Removes from the list the last element that was returned by next or previous.
	 */
	void remove();
}
