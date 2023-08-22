package stackAndQueue;

import java.util.Stack;

public class Q6 {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

        Stack<Integer> stack = new Stack<>();
        // 처음 가격의 index를 stack에 담고 시작
        stack.push(0);

        for (int i = 1; i < prices.length; i++) {

            // stack에는 index가 담겨 있음
            // stack의 가장 위에 있는 index의 위치의 price가 현재의 price보다 크면
            // stack에서 pop
            // answer에 index 값들의 차이만큼 넣기
            // 더 이상 현재의 price보다 큰 값이 없을 때까지 수행
            while (!stack.empty() && prices[i] < prices[stack.peek()]) {
                int x = stack.pop();
                answer[x] = i - x;
            }
            stack.push(i);
        }

        // 가격이 끝까지 떨어지지 않아서 stack에 남은 index 처리
        while (!stack.isEmpty()) {
            // 가장 위의 index를 꺼낸 후
            int x = stack.pop();
            answer[x] = prices.length - x - 1;
        }


        return answer;
    }

    public static void main(String[] args) {
        Q6 sol = new Q6();
        int[] prices = {1, 2, 3, 2, 3};
        System.out.println(sol.solution(prices));

    }
}
