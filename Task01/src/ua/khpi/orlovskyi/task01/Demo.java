package ua.khpi.orlovskyi.task01;

public class Demo {

    public static void main(String[] args) {
        print("Part1. Hello, World.");
        Hello.main(new String[]{});

        print("Part2. Sum of two numbers.");
        Sum.main(new String[]{"6.6", "3"});

        print("Part3. Greatest common divisor.");
        Gcd.main(new String[]{"10", "20"});

        print("Part4. Sum of digits in the number.");
        SumOfDigits.main(new String[]{"50", "541", "123"});

        print("Part5. Determining the index of the column, the column by the index.");
        Spreadsheet.main(new String[]{"A", "B", "Z", "AA", "AZ", "BA", "ZZ", "AAA"});

    }

    private static void print(String task) {
        System.out.println("-------------------------------------------------------");
        System.out.println(task);
    }
}  
