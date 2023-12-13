package fr.istic.vv;

import java.util.Stack;

public class StringUtils {

    private StringUtils() {
    }

    public static boolean isOpenSymbol(char ch) {
        return ch == '{' || ch == '[' || ch == '(';
    }

    public static boolean isClosedSymbol(char ch) {
        return ch == '}' || ch == ']' || ch == ')';
    }

    public static boolean isMatchingPair(char open, char close) {
        return open == '{' && close == '}' || open == '[' && close == ']' || open == '(' && close == ')';
    }

    public static boolean isBalanced(String str) {
        Stack<Character> stack = new Stack<>();

        if (str != null) {
            for (char ch : str.toCharArray()) {
                if (isOpenSymbol(ch)) {
                    stack.push(ch);
                } else if (isClosedSymbol(ch)) {
                    if (stack.isEmpty() || !isMatchingPair(stack.pop(), ch)) {
                        return false;
                    }
                }
            }
        }

        return stack.isEmpty();
    }
}
