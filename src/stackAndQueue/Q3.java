package stackAndQueue;

import java.util.Stack;

public class Q3 {
    boolean solution(String s) {
        boolean answer = true;

        Stack<Character> stack = new Stack<Character>();


        char[] cArr = s.toCharArray();

        if (cArr[0] == ')' || cArr.length == 1) {
            return false;
        }

        for (int i = 0; i < cArr.length; i++) {

            if (cArr[i] == '(') {
                stack.push(cArr[i]);
            } else {
                if (!stack.empty()) {
                    stack.pop();
                }
            }

        }

        if (!stack.empty()) {
            return false;
        }


        return answer;
    }

    public static void main(String[] args) {
        Q3 ob = new Q3();
        System.out.println(ob.solution(")()("));
    }
}
