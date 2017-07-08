package ua.khpi.orlovskyi.task02;

import java.util.Arrays;
import java.util.Iterator;

/**
 *
 * Implementation of MyList.
 *
 */
public class MyListImpl implements MyList, ListIterable {

	/**
	 * Internally using array of objects.
	 */
	private Object[] elementData = {};
	/**
	 * The size of the MyList (the number of elements it contains).
	 */
	private int currentSize;

	// Modification Operations

	/**
	 * Appends the specified element to the end of this list.
	 *
	 * @param e
	 *            element to be appended to this list
	 *
	 */
	@Override
	public void add(final Object e) {
		currentSize = elementData.length;
		Object[] newArray = new Object[currentSize + 1];
		System.arraycopy(elementData, 0, newArray, 0, currentSize);
		newArray[newArray.length - 1] = e;
		elementData = newArray;
	}

	/**
	 * Removes all of the elements from this list.
	 */
	@Override
	public void clear() {
		elementData = new Object[] {};
	}

	/**
	 * Removes the first occurrence of the specified element from this list.
	 */
	@Override
	public boolean remove(final Object o) {
		currentSize = elementData.length;
		if (o == null) {
			for (int i = 0; i < currentSize; i++) {
				if (elementData[i] == null) {
					Object[] arr2 = new Object[currentSize - 1];
					System.arraycopy(elementData, 0, arr2, 0, i);
					System.arraycopy(elementData, i + 1, arr2, i, arr2.length - i);
					elementData = arr2;
					return true;
				}
			}
		} else {
			for (int i = 0; i < currentSize; i++) {
				if (o.equals(elementData[i])) {
					Object[] arr2 = new Object[currentSize - 1];
					System.arraycopy(elementData, 0, arr2, 0, i);
					System.arraycopy(elementData, i + 1, arr2, i, arr2.length - i);
					elementData = arr2;
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * Returns an array containing all of the elements in this list in proper
	 * sequence.
	 */
	@Override
	public Object[] toArray() {
		return Arrays.copyOf(elementData, size());
	}

	/**
	 * Returns the number of elements in this list.
	 */
	@Override
	public int size() {
		return elementData.length;
	}

	/**
	 * Returns true if this list contains the specified element.
	 */
	@Override
	public boolean contains(final Object o) {
		return indexOf(o) >= 0;
	}

	/**
	 * Returns the index of the first occurrence of the specified element in this
	 * list, or -1 if this list does not contain the element.
	 *
	 * @param o
	 *            element whose presence in this list is to be tested
	 * @return returns the lowest index or -1 if there is no such index
	 */
	private int indexOf(final Object o) {
		if (o == null) {
			for (int i = 0; i < elementData.length; i++) {
				if (elementData[i] == null) {
					return i;
				}
			}
		} else {
			for (int i = 0; i < elementData.length; i++) {
				if (o.equals(elementData[i])) {
					return i;
				}
			}
		}
		return -1;
	}

	/**
	 * Returns true if this list contains all of the elements of the specified list.
	 */
	@Override
	public boolean containsAll(final MyList list) {
		Iterator<Object> e = list.iterator();
		while (e.hasNext()) {
			if (!contains(e.next())) {
				return false;
			}
		}
		return true;
	}

	@Override
	public final String toString() {
		Iterator<Object> it = iterator();
		if (!it.hasNext()) {
			return "{}";
		}

		StringBuilder sb = new StringBuilder();
		sb.append('{');
		for (;;) {
			Object e = it.next();
			sb.append('[').append(e).append(']');
			if (!it.hasNext()) {
				return sb.append('}').toString();
			}
			sb.append(',').append(' ');
		}
	}

	@Override
	public final Iterator<Object> iterator() {
		return new IteratorImpl();
	}

	/**
	 *
	 * Iterator implementation.
	 *
	 */
	private class IteratorImpl implements Iterator<Object> {
		/**
		 * Current index of element of the array.
		 */
		private int currentIndex = -1;

		/**
		 * Return current index.
		 *
		 * @return current index.
		 */
		public int getCurrentIndex() {
			return currentIndex;
		}

		/**
		 * Condition while call remove().
		 */
		private boolean condition = true;
		//private boolean nextOrPrevious = false;
		//public boolean isNextOrPrevious() {
			//return nextOrPrevious;
		//}

		/**
		 * Returns true if the iteration has more elements.
		 *
		 * @return true if the iteration has more elements.
		 */
		public boolean hasNext() {
			if (currentIndex < elementData.length - 1) {
				return true;
			}
			return false;
		}

		/**
		 * Returns the next element in the iteration.
		 *
		 * @return the next element in the iteration.
		 */
		public Object next() {
			condition = false;
			return elementData[++currentIndex];
		}

		/**
		 * Removes from the underlying collection the last element returned by this
		 * iterator.
		 */
		public void remove() {
			if (isCondition()) {
				throw new IllegalStateException();
			}
			//int i = 0;
//			if (!isNextOrPrevious()) {
//				i = currentIndex--;
//			} else {
//				i = ++currentIndex;
//			}
			Object[] arr2 = new Object[elementData.length - 1];
			System.arraycopy(elementData, 1, arr2, 0, arr2.length);
			elementData = arr2;
			condition = true;
			--currentIndex;
//			if (isNextOrPrevious()) {
//				--currentIndex;
//			}
		}

		/**
		 * Return true if before calling remove(), was not called next() or before
		 * calling remove(), was called remove() (repeated call remove()).
		 *
		 * @return condition.
		 */
		public boolean isCondition() {
			return condition;
		}
	}

	/**
	 * ListIterator.
	 *
	 * @return new ListIteratorImpl.
	 */
	public ListIterator listIterator() {
		return new ListIteratorImpl();
	}

	/**
	 *
	 * ListIterator implementation.
	 *
	 */
	private class ListIteratorImpl extends IteratorImpl implements ListIterator {

		/**
		 * Returns true if this list iterator has more elements when traversing
		 * the list in the reverse direction.
		 *
		 * @return true if this list iterator has more elements when traversing
		 * the list in the reverse direction.
		 */
		@Override
		public boolean hasPrevious() {
			if (getCurrentIndex() >= 0) {
				return true;
			}
			return false;
		}

		/**
		 * Returns the previous element in the list and moves the cursor position backwards.
		 */
		@Override
		public Object previous() {

			return elementData[getCurrentIndex() - 1];
		}

		/**
		 * Replaces the last element returned by next or previous with the specified element.
		 */
		@Override
		public void set(final Object e) {
			
		}
		/**
		 *  Removes from the list the last element that was returned by next or previous.
		 */
		@Override
		public void remove() {
			
		}

	}

}
