/* Name: Minh Ngoc Le
   Class: COMP 241 - Section 1
   Description: Build a LargeInt class to have an integer data type that never overflows
   Pledge: I have neither given nor received unauthorized aid on this program.
 */

import java.util.ArrayList;

public class LargeInt implements Comparable<LargeInt> {
    private ArrayList<Integer> digits;
    private boolean isnegative = false;

    // Default constructor
    public LargeInt() {
        digits = new ArrayList<>();

    }

    // Constructor that initialize a LargeInt from a String
    public LargeInt(String string) {
        digits = new ArrayList<>();
        for (int i = 0; i < string.length(); i++) {
            digits.add(Integer.parseInt(String.valueOf(string.charAt(i))));
        }
    }

    // Constructor that initializes a LargeInt from an int
    public LargeInt(int i) {
        digits = new ArrayList<>();
        if (i == 0) {
            digits.add(0);
        }
        while (i > 0) {
            int last_digit = i % 10;
            digits.add(0, last_digit);
            i = i / 10;
        }
    }

    // Calculate the number of digits of the LargeInt.
    // Return the number of digits in the LargeInt.
    public int numDigits() {
        return digits.size();
    }

    // Test if two integers are the same
    // Return true if two integers are the same
    // Return false if two integers are not the same.
    @Override
    public boolean equals(Object other) {

        if (this == other) {
            return true;
        }
        if (other == null) {
            return false;
        }
        if (other.getClass() != this.getClass()) {
            return false;
        }
        LargeInt large = (LargeInt) other;
        return digits.equals(large.digits);
    }

    @Override
    // Compare two LargeInts.
    // Return -1 if this LargeInt is less than other LargeInt.
    // Return 0 if this LargeInt is equal other LargeInt.
    // Return 1 if this LargeInt is greater than other LargeInt.
    public int compareTo(LargeInt other) {
        this.sameSize(other);
        for (int i = 0; i < this.digits.size(); i++) {
            if (this.digits.get(i) < other.digits.get(i)) {
                return -1;
            } else if (this.digits.get(i) > other.digits.get(i)) {
                return 1;
            }
        }
        return 0;
    }

    // Add two LargeInt together
    // Return the sum of two LargeInts.
    public LargeInt add(LargeInt other) {
        LargeInt result = new LargeInt();
        this.sameSize(other);

        int hold = 0;
        for (int i = this.digits.size() - 1; i >= 0; i--) {
            int sum = this.digits.get(i) + other.digits.get(i) + hold;
            int last_digit = sum % 10;
            hold = sum / 10;
            result.digits.add(0, last_digit);
            if (i == 0) {
                if (hold != 0) {
                    result.digits.add(0, hold);
                }
            }
        }
        return result;

    }

    // Subtract two LargeInt together
    // Return the difference of two LargeInts.
    public LargeInt subtract(LargeInt other) {
        LargeInt result = new LargeInt();
        this.sameSize(other);

        if (this.compareTo(other) == -1) {
            this.swap(other);
            result.isnegative = true;
        }
        int hold = 0;
        for (int i = this.digits.size() - 1; i >= 0; i--) {
            int sub = 0;
            if (this.digits.get(i) < other.digits.get(i)) {
                sub = this.digits.get(i) + 10 - other.digits.get(i) - hold;
                hold = 1;
                result.digits.add(0, sub);
            } else {
                sub = this.digits.get(i) - other.digits.get(i) - hold;
                result.digits.add(0, sub);
            }
        }
        if (result.isnegative) {
            this.swap(other);
        }

        return result;

    }

    // Multiply two LargeInts
    // Return the product of two LargeInts.
    public LargeInt multiply(LargeInt other) {
        LargeInt result = new LargeInt();
        LargeInt li = new LargeInt(0);
        while (li.compareTo(other) == -1) {
            result = result.add(this);
            li = li.add(new LargeInt(1));
        }
        return result;
    }

    // Divide two LargeInts
    // Return the quotient of two LargeInts.
    public LargeInt division(LargeInt other) {
        LargeInt result;
        int count = 0;
        // check if the divisior is 0 or not
        if (other.compareTo(new LargeInt(0)) == 0) {
            System.err.println("Error: The divisor must not be zero");
            return null;
        }
        if (this.compareTo(other) == -1) {
            result = new LargeInt(0);
        } else if (this.compareTo(other) == 0) {
            result = new LargeInt(1);
        } else {
            ArrayList<Integer> copyThis = new ArrayList<>(this.digits);
            LargeInt copy = new LargeInt();
            copy.digits = copyThis;
            while (copy.compareTo(other) >= 0) {
                copy = copy.subtract(other);
                count++;
            }
            result = new LargeInt(count);
        }
        return result;
    }

    // Divide two LargeInts
    // Return the remainder of two LargeInts.
    public LargeInt remainder(LargeInt other) {
        if (other.compareTo(new LargeInt(0)) == 0) {
            System.err.println("Error: The divisor must not be zero");
            return null;
        }
        LargeInt result = new LargeInt();
        LargeInt q = this.division(other);
        LargeInt dq = q.multiply(other);
        result = this.subtract(dq);
        return result;
    }

    // Make two LargeInts to have the same size
    // This method is a helper for add, subtract and compareTo
    private void sameSize(LargeInt other) {
        while (this.digits.size() < other.digits.size()) {
            this.digits.add(0, 0);
        }
        while (other.digits.size() < this.digits.size()) {
            other.digits.add(0, 0);
        }
    }

    // This method is just a helper for subtract method
    // It makes this to become other and other to become this.
    private void swap(LargeInt other) {
        ArrayList<Integer> hold = new ArrayList<>(this.digits);
        hold = this.digits;
        this.digits = other.digits;
        other.digits = hold;
    }

    @Override
    public String toString() {
        String string = "";
        for (int i = 0; i < digits.size(); i++) {
            string += digits.get(i);
        }
        if (isnegative) {
            string = "- " + string;
        }
        return string;
    }


}
