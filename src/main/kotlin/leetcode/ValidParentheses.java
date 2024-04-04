package leetcode;

import java.util.Stack;

public class ValidParentheses {
    /**
     * https://leetcode.com/problems/valid-parentheses/description/
     * 20. Valid Parentheses
     * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']',
     * determine if the input string is valid.
     * An input string is valid if:
     * Open brackets must be closed by the same type of brackets.
     * Open brackets must be closed in the correct order.
     * Every close bracket has a corresponding open bracket of the same type.
     *
     * Example 1:
     *
     * Input: s = "()"
     * Output: true
     * Example 2:
     *
     * Input: s = "()[]{}"
     * Output: true
     * Example 3:
     *
     * Input: s = "(]"
     * Output: false
     *
     *
     * Constraints:
     *
     * 1 <= s.length <= 104
     * s consists of parentheses only '()[]{}'.
     * **/
    public static void main(String[] args) {

    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            if (chars[i] == '(' ||
                    chars[i] == '[' ||
                    chars[i] == '{'
            ) {
                stack.push(chars[i]);
            } else {
                if (!stack.isEmpty() && stack.peek() == '(' && chars[i] == ')' ||
                        !stack.isEmpty() && stack.peek() == '[' && chars[i] == ']' ||
                        !stack.isEmpty() && stack.peek() == '{' && chars[i] == '}'
                )
                    stack.pop();
                else
                    return false;
            }
        }
        return stack.isEmpty();
    }

    public boolean isValid1(String s) {
        boolean done = false;
        String str = s;
        while (!done){
            String temp = str.replace("()", "").replace("[]", "").replace("{}", "");
            done = (temp.length() == str.length());
            str = temp;
        }
        return str.length() == 0;
    }
}
