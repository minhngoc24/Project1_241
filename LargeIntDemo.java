/* Name: Minh Ngoc Le
   Class: COMP 241 - Section 1
   Description: Build a LargeInt class to have an integer data type that never overflows
   Pledge: I have neither given nor received unauthorized aid on this program.
 */
public class LargeIntDemo {
    public static void main(String[] args) {
        System.out.println("Factorials from 0 to 100: ");
        for (int i = 0; i <= 100; i++) {
            LargeInt fact = new LargeInt(i);
            System.out.println(i + " factorial is " + factorial(fact) + " and has " + factorial(fact).numDigits() + " digits.");
        }
    }

    // Caculate the factorial of a LargeInt.
    // Return the result of factorial of a LargeInt.
    public static LargeInt factorial(LargeInt li) {
        LargeInt result = new LargeInt(1);
        int i = 1;
        LargeInt count = new LargeInt(i);
        while (!count.equals(li.add(new LargeInt(1)))) {
            result = result.multiply(count);
            i++;
            count = new LargeInt(i);
        }

        return result;
    }

}
