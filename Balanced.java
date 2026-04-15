import java.util.Stack;

public class Balanced {
    public static void main(String[] args) {
        String[] str = {"({[]})","({[})", "((()))", "({)}"};
        
        for (String s : str) {
            System.out.println(s + " -> " + isBalanced(s));
        }
    }

    public static boolean isBalanced(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {

            // If opening bracket → push
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            }
            // If closing bracket
            else {
                if (stack.isEmpty()) {
                    return false;
                }

                char top = stack.pop();

                if ((c == ')' && top != '(') ||
                    (c == '}' && top != '{') ||
                    (c == ']' && top != '[')) {
                    return false;
                }
            }
        }

        // If stack is empty → balanced
        return stack.isEmpty();
    }
}