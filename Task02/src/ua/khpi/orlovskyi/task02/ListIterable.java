package ua.khpi.orlovskyi.task02;

/**
 * Implementing this interface allows an object to be the target of the "foreach" statement..
 */
interface ListIterable {
	/**
	 * ListIterator.
	 *
	 * @return an iterator over a set of elements.
	 */
	ListIterator listIterator();
}
