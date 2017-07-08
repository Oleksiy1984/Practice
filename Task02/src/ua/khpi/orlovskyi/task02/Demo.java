package ua.khpi.orlovskyi.task02;

import java.util.Iterator;
import java.util.logging.Logger;

/**
 *
 * Demo of Task01.
 *
 */
public final class Demo {
	/**
	 * Private constructor.
	 */
	private Demo() {
		throw new UnsupportedOperationException("Unsupported operation.");
	}

	/**
	 * Entry point in Demo.
	 * 
	 * @param args
	 *            the args
	 */
	public static void main(final String[] args) {

		final Logger log = Logger.getLogger(Demo.class.getName());

		// Part 1

		// Initialize
		final MyListImpl con = new MyListImpl();
		final MyListImpl test = new MyListImpl();
		final Object myObject = new Object();
		final Integer myInteger = 5;
		con.add("A");
		con.add(myInteger);
		con.add(777);
		con.add(null);
		con.add(myObject);
		test.add("A");
		test.add(myInteger);
		test.add(777);
		test.add(null);
		test.add(myObject);

		// Testing
		log.info("Test toString: " + con);
		log.info("Test contains All: " + con.containsAll(test));
		log.info("Test remove: " + con.remove(myInteger));
		log.info("Test toString: " + con);
		log.info("Test size: " + con.size());
		log.info("Test contains null: " + con.contains(null));
		con.clear();
		log.info("Test clear. MyList was cleared: " + con.toString());

		// Part 2

		// Initialize
		final MyListImpl part2 = new MyListImpl();
		part2.add("A");
		part2.add(myInteger);
		part2.add(1);
		part2.add(myObject);
		part2.add(null);

		// Testing
		for (Object o : part2) {
			System.out.print(o + " ");
		}
		System.out.println();
		Iterator<Object> it = part2.iterator();
		while (it.hasNext()) {
			System.out.print(it.next() + " ");
			// it.remove();
		}
		System.out.println("\nList=" + part2);

		// Part 3
		System.out.print("---Part 3 ---- ");
		// Initialize
		final MyListImpl list = new MyListImpl();
		list.add("A");
		list.add(myInteger);
		list.add(1);
		list.add(myObject);
		list.add(null);

		// Testing
		ListIterator iterator = list.listIterator();
		while (iterator.hasPrevious()) {
			System.out.print(iterator.previous() + " ");
		}
	}
}
