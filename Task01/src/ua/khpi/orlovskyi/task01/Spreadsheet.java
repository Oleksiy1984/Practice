package ua.khpi.orlovskyi.task01;

public class Spreadsheet {

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

    private static int convertChars2digits(String column) {
        int columnIndex = 0;
        char[] refs = column.toUpperCase().toCharArray();
        for (int k = 0; k < refs.length; k++) {
            char theChar = refs[k];
            columnIndex = (columnIndex * 26) + (theChar - 'A' + 1);
        }
        return columnIndex;
    }

    private static String rightColumn(String column) {
        return convertDigits2chars(convertChars2digits(column) + 1);
    }

    public static void main(String[] args) {

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
