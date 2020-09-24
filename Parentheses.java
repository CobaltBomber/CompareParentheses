/* *****************************************************************************
 *  Name:    Ada Lovelace
 *  NetID:   alovelace
 *  Precept: P00
 *
 *  Description:  Prints 'Hello, World' to the terminal window.
 *                By tradition, this is everyone's first program.
 *                Prof. Brian Kernighan initiated this tradition in 1974.
 *
 **************************************************************************** */

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;


public class Parentheses {

    //created identification for different types
    private static final char LPar = '(';
    private static final char RPar = ')';
    private static final char LBox = '[';
    private static final char RBox = ']';
    private static final char LBrac = '{';
    private static final char RBrac = '}';


    //method for checking if the types are balanced
    public static boolean isBalanced(String inputString) {


        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < inputString.length(); i++) {
            if (inputString.charAt(i) == LPar) {
                stack.push(LPar);
            }
            if (inputString.charAt(i) == LBrac) {
                stack.push(LBrac);
            }
            if (inputString.charAt(i) == LBox) {
                stack.push(LBox);
            }
            if (inputString.charAt(i) == RPar) {
                if (stack.isEmpty()) return false;
                if (stack.pop() != LPar) return false;
            }
            if (inputString.charAt(i) == RBrac) {
                if (stack.isEmpty()) return false;
                if (stack.pop() != LBrac) return false;
            }
            if (inputString.charAt(i) == RBox) {
                if (stack.isEmpty()) return false;
                if (stack.pop() != LBox) return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        In myIn = new In("parentheses.txt");
        String myString = myIn.readAll().trim();
        StdOut.println("Read in string: " + myString);
        StdOut.println("Is String Balanced? " + isBalanced(myString));

    }
}
