package ua.nure.orlovskyi.Practice2;

/**
 * Implementing this interface allows an object to be the target of the "foreach" statement..
 */
public interface ListIterable {
	/**
	 * ListIterator.
	 *
	 * @return an iterator over a set of elements.
	 */
	ListIterator listIterator();
}
