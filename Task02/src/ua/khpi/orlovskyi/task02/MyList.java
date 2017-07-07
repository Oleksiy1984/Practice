package ua.khpi.orlovskyi.task02;

/**
 * Interface MyList.
 *
 */
public interface MyList extends Iterable<Object> {
	/**
	 * Appends the specified element to the end of this list.
	 *
	 * @param e
	 *            Object to be added
	 */
	void add(Object e);

	/**
	 * Removes all of the elements from this list.
	 */
	void clear();

	/**
	 * Removes the first occurrence of the specified element from this list.
	 *
	 * @param o
	 *            Object to be removed.
	 * @return if it was successful.
	 */
	boolean remove(Object o);

	/**
	 * Returns an array containing all of the elements in this list in proper
	 * sequence.
	 *
	 * @return array.
	 */
	Object[] toArray();

	/**
	 * Returns the number of elements in this list.
	 *
	 * @return the number of elements in this list.
	 */
	int size();

	/**
	 * Returns true if this list contains the specified element.
	 * @param o Object to be checked if it contains in array.
	 * @return true if this list contains the specified element.
	 */
	boolean contains(Object o);

	/**
	 * Returns true if this list contains all of the elements of the specified list.
	 *
	 * @param c list to be checked.
	 * @return true if this list contains all of the elements of the specified list.
	 */
	boolean containsAll(MyList c);
}
