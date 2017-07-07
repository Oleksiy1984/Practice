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
	private Object[] arr = {};
	/**
	 * The size of the MyList (the number of elements it contains).
	 */
	private int size;

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
		size = arr.length;
		Object[] temp = new Object[size + 1];
		System.arraycopy(arr, 0, temp, 0, size);
		temp[temp.length - 1] = e;
		arr = temp;
	}

	/**
	 * Removes all of the elements from this list.
	 */
	@Override
	public void clear() {
		Iterator<Object> e = iterator();
		while (e.hasNext()) {
			e.next();
			e.remove();
		}
	}

	/**
	 * Removes the first occurrence of the specified element from this list.
	 */
	@Override
	public boolean remove(final Object o) {
		size = arr.length;
		if (o == null) {
			for (int i = 0; i < size; i++) {
				if (arr[i] == null) {
					Object[] arr2 = new Object[size - 1];
					System.arraycopy(arr, 0, arr2, 0, i);
					System.arraycopy(arr, i + 1, arr2, i, arr2.length - i);
					arr = arr2;
					return true;
				}
			}
		} else {
			for (int i = 0; i < size; i++) {
				if (o.equals(arr[i])) {
					Object[] arr2 = new Object[size - 1];
					System.arraycopy(arr, 0, arr2, 0, i);
					System.arraycopy(arr, i + 1, arr2, i, arr2.length - i);
					arr = arr2;
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
		return Arrays.copyOf(arr, size());
	}

	/**
	 * Returns the number of elements in this list.
	 */
	@Override
	public int size() {
		return size;
	}

	/**
	 * Returns true if this list contains the specified element.
	 */
	@Override
	public boolean contains(final Object o) {
		Iterator<Object> e = iterator();
		if (o == null) {
			while (e.hasNext()) {
				if (e.next() == null) {
					return true;
				}
			}
		} else {
			while (e.hasNext()) {
				if (o.equals(e.next())) {
					return true;
				}
			}
		}
		return false;
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
		size = arr.length;
		
		

		StringBuilder sb = new StringBuilder();
		sb.append("{");
		for (int i = 0; i < size; i++) {
			if (toArray()[i] == null) {
				sb.append("[" + "null" + "],");
				continue;
			}
			sb.append("[" + arr[i].toString() + "],");
		}
		if (sb.length() > 1) {
			sb.replace(sb.length() - 1, sb.length(), "");
		}
		sb.append("}");
		return sb.toString();
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
		 * Index of the element of the array.
		 */
		private int index = -1;

		/**
		 * Return index.
		 * 
		 * @return index
		 */
		public int getIndex() {
			return index;
		}

		/**
		 * Next or previous element.
		 */
		private boolean nextOrPrevious = false;
		/**
		 * Condition while call remove().
		 */
		private boolean condition = true;

		/**
		 * Returns true if the iteration has more elements.
		 * 
		 * @return true if the iteration has more elements.
		 */
		public boolean hasNext() {
			if (index < toArray().length - 1) {
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
			nextOrPrevious = false;
			return toArray()[++index];
		}

		/**
		 * Removes from the underlying collection the last element returned by this
		 * iterator.
		 */
		public void remove() {
			//
			if (isCondition()) {
				throw new IllegalStateException();
			}
			int i = 0;
			if (!isNextOrPrevious()) {
				i = index--;
			} else {
				i = ++index;
			}
			Object[] arr2 = new Object[arr.length - 1];
			System.arraycopy(arr, 0, arr2, 0, i);
			System.arraycopy(arr, i + 1, arr2, i, arr2.length - i);
			arr = arr2;
			condition = true;
			if (isNextOrPrevious()) {
				--index;
			}
		}

		/**
		 * Return if list has next or previous element.
		 * 
		 * @return nextOrPrevious.
		 */
		public boolean isNextOrPrevious() {
			return nextOrPrevious;
		}

		/**
		 * Return condition expression.
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

		@Override
		public boolean hasPrevious() {
			if (getIndex() >= 0) {
				return true;
			}
			return false;
		}

		@Override
		public Object previous() {

			return toArray()[getIndex() - 1];
		}

		@Override
		public void set(Object e) {
			// TODO Auto-generated method stub
		}

	}

}
