package ua.khpi.orlovskyi.task02;

import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

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
		elementData = Arrays.copyOf(elementData, currentSize + 1);
		elementData[currentSize++] = e;
	}

	/**
	 * Removes all of the elements from this list.
	 */
	@Override
	public void clear() {
		for (int i = 0; i < currentSize; i++) {
			elementData[i] = null;
		}
		currentSize = 0;
	}

	/**
	 * Removes the first occurrence of the specified element from this list.
	 */
	@Override
	public boolean remove(final Object o) {
		if (o == null) {
			for (int index = 0; index < currentSize; index++) {
				if (elementData[index] == null) {
					fastRemove(index);
					return true;
				}
			}
		} else {
			for (int index = 0; index < currentSize; index++) {
				if (o.equals(elementData[index])) {
					fastRemove(index);
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * Private remove method that skips bounds checking and does not return the
	 * value removed.
	 */
	private void fastRemove(final int index) {
		int numMoved = currentSize - index - 1;
		if (numMoved > 0) {
			System.arraycopy(elementData, index + 1, elementData, index, numMoved);
		}
		elementData[--currentSize] = null; // Let gc do its work
	}

	/**
	 * Returns an array containing all of the elements in this list in proper
	 * sequence.
	 */
	@Override
	public Object[] toArray() {
		return Arrays.copyOf(elementData, currentSize);
	}

	/**
	 * Returns the number of elements in this list.
	 */
	@Override
	public int size() {
		return currentSize;
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
		 * Index of next element to return.
		 */
		int cursor;

		/**
		 * Index of last element returned; -1 if no such.
		 */
		int lastRet = -1;

		/**
		 * Returns true if the iteration has more elements.
		 *
		 * @return true if the iteration has more elements.
		 */
		public boolean hasNext() {
			return cursor != currentSize;
		}

		/**
		 * Returns the next element in the iteration.
		 *
		 * @return the next element in the iteration.
		 */
		public Object next() {
			int i = cursor;
			if (i >= currentSize) {
				throw new NoSuchElementException();
			}
			if (i >= elementData.length) {
				throw new ConcurrentModificationException();
			}
			cursor = i + 1;
			return elementData[lastRet = i];
		}

		/**
		 * Removes from the underlying collection the last element returned by this
		 * iterator.
		 */
		public void remove() {
			if (lastRet < 0) {
				throw new IllegalStateException();
			}

			try {
				remove(lastRet);
				cursor = lastRet;
				lastRet = -1;
			} catch (IndexOutOfBoundsException ex) {
				throw new ConcurrentModificationException();
			}
		}

		/**
		 * Removes the element at the specified position in this list. Shifts any
		 * subsequent elements to the left (subtracts one from their indices).
		 * 
		 * @param index
		 *            the index of the element to be removed
		 * @return the element that was removed from the list
		 */
		public Object remove(int index) {
			Object oldValue = elementData[index];

			int numMoved = currentSize - index - 1;
			if (numMoved > 0) {
				System.arraycopy(elementData, index + 1, elementData, index, numMoved);
			}
			elementData[--currentSize] = null; // Let gc do its work
			return oldValue;
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
		 * Returns true if this list iterator has more elements when traversing the list
		 * in the reverse direction.
		 *
		 * @return true if this list iterator has more elements when traversing the list
		 *         in the reverse direction.
		 */
		@Override
		public boolean hasPrevious() {
			return cursor != 0;
		}

		/**
		 * Returns the previous element in the list and moves the cursor position
		 * backwards.
		 */
		@Override
		public Object previous() {
			int i = cursor - 1;
			if (i < 0) {
				throw new NoSuchElementException();
			}

			if (i >= elementData.length) {
				throw new ConcurrentModificationException();
			}
			cursor = i;
			return elementData[lastRet = i];
		}

		/**
		 * Replaces the last element returned by next or previous with the specified
		 * element.
		 */
		@Override
		public void set(final Object e) {
			if (lastRet < 0) {
				throw new IllegalStateException();
			}

			try {
				elementData[lastRet] = e;
			} catch (IndexOutOfBoundsException ex) {
				throw new ConcurrentModificationException();
			}
		}

		/**
		 * Removes from the list the last element that was returned by next or previous.
		 */
		@Override
		public void remove() {
			if (lastRet < 0) {
				throw new IllegalStateException();
			}
			super.remove();
		}

	}

}
