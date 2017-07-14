package ua.khpi.orlovskyi.task02;

import java.util.Iterator;
import java.util.logging.Logger;

/**
 *
 * Demo of Task02.
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
	 * Entry point of the Java application.
	 *
	 * @param args
	 *            the command line argument.
	 */
	public static void main(final String[] args) {

		final Logger log = Logger.getLogger(Demo.class.getName());

		// Part 1. Modification methods.
		System.out.println("----- Modification methods ----- ");

		// Initialize
		final MyListImpl con = new MyListImpl();
		final MyListImpl test = new MyListImpl();
		final Object myObject = new Object();
		final Integer myInteger = 5;
		con.add("A");
		con.add(myInteger);
		con.add(777);
		con.add(myObject);
		test.add("A");
		test.add(myInteger);
		test.add(777);
		test.add(myObject);

		// Testing
		log.info("Objects added to the array: " + con + ", size:" + con.size());
		log.info("Test contains All: " + con.containsAll(test));
		log.info("Object myInteger = 5 was removed: " + con.remove(myInteger) + " " + con);
		log.info("Test contains 777: " + con.contains(777));
		con.clear();
		log.info("Test clear. MyList was cleared: " + con.toString());

		// Part 2. Iterator.
		System.out.println("----- Iterator ----- ");

		// Initialize
		final MyListImpl part2 = new MyListImpl();
		part2.add("A");
		part2.add(myInteger);
		part2.add(1);
		part2.add(myObject);
		Iterator<Object> it = part2.iterator();

		// Testing
		part2.forEach(o -> System.out.print(o + " "));
		System.out.println();
		// it.remove(); //(remove() before next()) uncomment this to receive the
		// IllegalStateException().
		while (it.hasNext()) {
			System.out.print(it.next() + " ");
		}
		it.remove();
		// it.remove(); //(remove() after remove() uncomment this to receive the
		// IllegalStateException().
		System.out.println("\nmyObject was removed");
		System.out.println("list=" + part2);

		// Part 3. ListIterator.
		System.out.println("----- ListIterator ----- ");

		// Initialize
		final MyListImpl list = new MyListImpl();
		list.add("A");
		list.add(myInteger);
		list.add(1);
		list.add(myObject);
		ListIterator li = list.listIterator();

		// Testing
		// li.remove(); //remove() before next() or previous(), uncomment this to
		// receive the IllegalStateException().
		// li.set(999); //set() before next() or previous(), uncomment this to receive
		// the IllegalStateException().
		while (li.hasNext()) {
			System.out.print(li.next() + " ");
		}
		System.out.println();
		li.set("String");
		System.out.println("Test the set() method: myObject was replaced with \"String\":");
		while (li.hasPrevious()) {
			System.out.print(li.previous() + " ");
		}
		li.remove();
		// li.remove(); //(remove() after remove() uncomment this to receive the
		// IllegalStateException().
		System.out.println("\nTest the remove() method: \"A\" was removed.");
		System.out.println(list);
	}
}
