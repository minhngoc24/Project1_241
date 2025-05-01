/* Name: Minh Ngoc Le
   Class: COMP 241 - Section 1
   Description: Build a LargeInt class to have an integer data type that never overflows
   Pledge: I have neither given nor received unauthorized aid on this program.
 */

import java.util.ArrayList;

public class LargeIntTester {
    public static void main(String args[]) {
        //testConstructors();
        //testNumDigits();
        //testAdd();
        //testEquals();
        //testCompareTo();
        //testMultiply();
        //testSorting();
        //testSubtract();
        //testDivision();
        //testRemainder();
    }

    public static void testConstructors() {
        // Test Default Constructor
        LargeInt largeInt_1 = new LargeInt();
        System.out.println("LargeInt 1 is: " + largeInt_1);
        // Test Constructor that initializes a LargeInt from a String
        LargeInt largeInt_2 = new LargeInt("123456777");
        System.out.println("LargeInt 2 is: " + largeInt_2);
        // Test Constructor that initializes a LargeInt from an Int
        LargeInt largeInt_3 = new LargeInt(347975);
        System.out.println("LargeInt 3 is: " + largeInt_3);
        LargeInt largeInt_4 = new LargeInt(0);
        System.out.println("LargeInt 4 is: " + largeInt_4);

    }

    public static void testNumDigits() {
        LargeInt largeInt1 = new LargeInt();
        LargeInt largeInt2 = new LargeInt("1234567890");
        LargeInt largeInt3 = new LargeInt(1234567890);
        LargeInt largeInt4 = new LargeInt(0);

        System.out.println("LargeInt 1 has: " + largeInt1.numDigits() + " digits.");
        System.out.println("LargeInt 2 has: " + largeInt2.numDigits() + " digits.");
        System.out.println("LargeInt 3 has: " + largeInt3.numDigits() + " digits.");
        System.out.println("LargeInt 4 has: " + largeInt4.numDigits() + " digits.");
    }

    public static void testEquals() {
        LargeInt largeInt1 = new LargeInt();
        LargeInt largeInt2 = new LargeInt("1234567890");
        LargeInt largeInt3 = new LargeInt(1234567890);
        LargeInt largeInt4 = new LargeInt(0);

        System.out.println("LargeInt 1 equals LargeInt 2: " + largeInt1.equals(largeInt2));
        System.out.println("LargeInt 1 equals LargeInt 3: " + largeInt1.equals(largeInt3));
        System.out.println("LargeInt 2 equals LargeInt 3: " + largeInt2.equals(largeInt3));
        System.out.println("LargeInt 1 equals LargeInt 4: " + largeInt1.equals(largeInt4));

    }

    public static void testAdd() {
        LargeInt largeInt_1 = new LargeInt();
        LargeInt largeInt_2 = new LargeInt("17");
        LargeInt largeInt_3 = new LargeInt(17);

        System.out.println("Sum of 2 LargeInts is: " + largeInt_1.add(largeInt_3));
        System.out.println("Sum of 2 LargeInts is: " + largeInt_2.add(largeInt_3));
    }

    public static void testMultiply() {
        LargeInt largeInt_1 = new LargeInt();
        LargeInt largeInt_2 = new LargeInt("7");
        LargeInt largeInt_3 = new LargeInt(5);

        System.out.println("Product of 2 LargeInts is: " + largeInt_3.multiply(largeInt_2));
        System.out.println("Product of 2 LargeInts is: " + largeInt_2.multiply(largeInt_3));

    }

    public static void testCompareTo() {
        LargeInt largeInt1 = new LargeInt(25);
        LargeInt largeInt2 = new LargeInt(25);
        LargeInt largeInt3 = new LargeInt(134);

        System.out.println(largeInt1.compareTo(largeInt3));
        System.out.println(largeInt2.compareTo(largeInt1));
        System.out.println(largeInt3.compareTo(largeInt1));
    }

    public static void testSubtract() {
        LargeInt largeInt_1 = new LargeInt();
        LargeInt largeInt_2 = new LargeInt(25);
        LargeInt largeInt_3 = new LargeInt(19);
        LargeInt largeInt_4 = new LargeInt(25);

        System.out.println("Difference between 2 LargeInts is: " + largeInt_3.subtract(largeInt_2));
        System.out.println("Difference between 2 LargeInts is: " + largeInt_2.subtract(largeInt_3));
        System.out.println("Difference between 2 LargeInts is: " + largeInt_2.subtract(largeInt_4));


    }

    public static void testDivision() {
        LargeInt largeInt_1 = new LargeInt(17);
        LargeInt largeInt_2 = new LargeInt(3);
        LargeInt largeInt_3 = new LargeInt(3);
        LargeInt largeInt_4 = new LargeInt(0);

        System.out.println("The quotient of two LargeInts are: " + largeInt_1.division(largeInt_2));
        System.out.println("The quotient of two LargeInts are: " + largeInt_2.division(largeInt_3));
        System.out.println("The quotient of two LargeInts are: " + largeInt_2.division(largeInt_4));
        System.out.println("The quotient of two LargeInts are: " + largeInt_2.division(largeInt_1));

    }

    public static void testRemainder() {
        LargeInt largeInt_1 = new LargeInt(17);
        LargeInt largeInt_2 = new LargeInt(3);
        LargeInt largeInt_3 = new LargeInt(0);

        System.out.println("The remainder of two LargeInts is: " + largeInt_1.remainder(largeInt_2));
        System.out.println("The remainder of two LargeInts is: " + largeInt_1.remainder(largeInt_3));
        System.out.println("The remainder of two LargeInts is: " + largeInt_3.remainder(largeInt_2));
        System.out.println("The remainder of two LargeInts is: " + largeInt_2.remainder(largeInt_1));
    }

    public static void testSorting() {
        ArrayList<LargeInt> randomNumbers = new ArrayList<>();
        for (int x = 0; x < 10; x++) {
            randomNumbers.add(new LargeInt((int) (Math.random() * 100000)));
        }
        randomNumbers.sort(null);  // null means use the built-in compareTo() method
        System.out.println(randomNumbers);
    }


}
