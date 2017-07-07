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
	 * @param args the args
	 */
	public static void main(final String[] args) {

		final Logger log = Logger.getLogger(Demo.class.getName());

		// Part 1

		// Initilize
		final MyListImpl con = new MyListImpl();
		final MyListImpl test = new MyListImpl();
		final Object myObject = new Object();
		final Integer myInteger = 5;
		con.add("A");
		con.add(myInteger);
		con.add(777);
		//con.add(null);
		con.add(myObject);
		test.add("A");
		test.add(myInteger);
		test.add(777);
		//test.add(null);
		test.add(myObject);

		// Testing
		log.info("Test contains All: " + con.containsAll(test));
		//log.info("Test remove: " + con.remove(myObject));
		log.info("Test toString: " + con);
		log.info("Test size: " + con.size());
		log.info("Test contains 777: " + con.contains(777));
		con.clear();
		log.info("Test clear. MyList was cleared: " + con.toString());
		// Part 2

		// Initilize
		final MyListImpl part2 = new MyListImpl();
		part2.add("A");
		part2.add(myInteger);
		part2.add(1);
		part2.add(myObject);

		// Testing
		for (Object o : part2) {
			System.out.println(o);
		}

		Iterator<Object> it = part2.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
	}

}
