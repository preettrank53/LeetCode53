import java.util.Stack;

class Solution {
    public String reverseParentheses(String s) {
        Stack<Character> st = new Stack<>();
        int n = s.length();

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (ch == ')') {
                // Pop characters until '('
                StringBuilder temp = new StringBuilder();
                while (!st.isEmpty() && st.peek() != '(') {
                    temp.append(st.pop());
                }

                // Pop the '('
                if (!st.isEmpty() && st.peek() == '(') {
                    st.pop();
                }

                // Push reversed string back to stack
                for (int j = 0; j < temp.length(); j++) {
                    st.push(temp.charAt(j));
                }
            } else {
                st.push(ch);
            }
        }

        // Build final result
        StringBuilder result = new StringBuilder();
        while (!st.isEmpty()) {
            result.append(st.pop());
        }

        return result.reverse().toString(); // reverse because stack gives reversed order
    }
}
