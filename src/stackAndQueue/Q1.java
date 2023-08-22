package stackAndQueue;

import java.util.Stack;

import static java.util.Arrays.stream;

public class Q1 {
    public int[] solution(int[] arr) {

        Stack<Integer> stack = new Stack<>();

        stack.push(arr[0]);

        for (int i = 1; i < arr.length; i++) {
            if (stack.peek() != arr[i]) {
                stack.push(arr[i]);
            }
        }

        int[] answer = new int[stack.size()];
        for (int i = answer.length - 1; i >= 0; i--) {
            answer[i] = stack.pop();
        }

        return answer;
    }

    public static void main(String[] args) {
        Q1 ob = new Q1();
        int[] arr = ob.solution(new int[]{1, 1, 3, 3, 0, 1, 1});
        stream(arr).forEach(System.out::println);
    }
}
