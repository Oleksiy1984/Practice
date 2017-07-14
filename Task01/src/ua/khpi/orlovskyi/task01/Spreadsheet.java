package ua.khpi.orlovskyi.task01;

/**
 *
 * Determining the digits of the Excel column by its characters and visa-versa.
 *
 */
public final class Spreadsheet {
	/**
	 * Private constructor.
	 */
	private Spreadsheet() {
		throw new UnsupportedOperationException("Unsupported operation.");
	}

	/**
	 * Convert digits of the Excel column to the characters.
	 *
	 * @param columnIndex
	 *            digits of the Excel column.
	 * @return characters of the column.
	 */
	private static String convertDigits2chars(int columnIndex) {

		StringBuilder colRef = new StringBuilder(2);

		while (columnIndex > 0) {
			int thisPart = columnIndex % 26;
			if (thisPart == 0) {
				thisPart = 26;
			}
			columnIndex = (columnIndex - thisPart) / 26;

			// The letter A is at 65
			char colChar = (char) (thisPart + 64);
			colRef.insert(0, colChar);
		}

		return colRef.toString();
	}

	/**
	 * Convert the characters of the Excel column to the digits.
	 *
	 * @param column
	 *            characters of the column.
	 * @return digits of the Excel column.
	 */
	private static int convertChars2digits(final String column) {
		int columnIndex = 0;
		char[] refs = column.toUpperCase().toCharArray();
		for (int k = 0; k < refs.length; k++) {
			char theChar = refs[k];
			columnIndex = (columnIndex * 26) + (theChar - 'A' + 1);
		}
		return columnIndex;
	}

	/**
	 * Determining the right column by its left column.
	 * @param column the excel column.
	 * @return the next right column.
	 */
	private static String rightColumn(final String column) {
		return convertDigits2chars(convertChars2digits(column) + 1);
	}

	/**
	 * Entry point of the Java application.
	 *
	 * @param args the command line arguments.
	 *
	 */
	public static void main(final String[] args) {

		for (int i = 0; i < args.length; i++) {
			String arg = args[i];
			int columnIndex = convertChars2digits(arg);
			String columnRef = convertDigits2chars(columnIndex);
			if (arg.equals(columnRef)) {
				System.out.println(arg + " ==> " + columnIndex + " ==> " + columnRef);
			}
		}
		System.out.println("Determining right column.");
		for (int i = 0; i < args.length; i++) {
			String arg = args[i];
			System.out.println(arg + " ==> " + rightColumn(arg));
		}
	}
}
