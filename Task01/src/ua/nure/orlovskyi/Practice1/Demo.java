package ua.nure.orlovskyi.Practice1;

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
	 * Entry point of the Java application.
	 *
	 * @param args
	 *            the command line argument.
	 */
	public static void main(final String[] args) {

		print("Part1. Hello, World.");
		Part1.main(new String[] {});

		print("Part2. Sum of two numbers.");
		Part2.main(new String[] {"6.6", "3"});

		print("Part3. Greatest common divisor.");
		Part3.main(new String[] {"10", "20"});

		print("Part4. Sum of digits in the number.");
		Part4.main(new String[] {"50", "541", "123"});

		print("Part5. Determining the index of the column, the column by the index.");
		Part5.main(new String[] {"A", "B", "Z", "AA", "AZ", "BA", "ZZ", "AAA"});

	}

	/**
	 * Print the task.
	 * @param task message to be print.
	 */
	private static void print(final String task) {
		System.out.println("-------------------------------------------------------");
		System.out.println(task);
	}
}
