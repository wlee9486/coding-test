package heap;

import java.util.PriorityQueue;

public class Q1 {
    public int solution(int[] scoville, int K) {
        int answer = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < scoville.length; i++) {
            pq.add(scoville[i]);
        }


        while (true) {

            int curr = pq.poll();

            // 가장 작은 값이 목표치보다 이미 높을 경우
            if (curr >= K) {
                break;
            }

            // 가장 마지막에 남은 값이 목표치보다 낮을 경우
            if (curr < K && pq.isEmpty()) {
                answer = -1;
                break;

            }


            int next = pq.poll();

            // 새로운 수치 계산
            int newScoville = curr + (next * 2);

            // pq에 다시 넣음
            pq.add(newScoville);
            answer++;

        }

        return answer;
    }

    public static void main(String[] args) {
        Q1 sol = new Q1();
        System.out.println(sol.solution(new int[]{1, 2, 3, 9, 10, 12}, 7));

    }
}
