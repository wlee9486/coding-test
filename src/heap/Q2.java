package heap;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Q2 {
    public int solution(int[][] jobs) {

        int answer = 0;
        int currentTime = 0;

        // 요청시간이 이른 순으로 정렬
        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);

        // 소요시간이 적은 순으로 정렬
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> a[1] - b[1]);

        int index = 0;

        while (index < jobs.length || !heap.isEmpty()) {

            // 현재 시간에 또는 이전에 요청된 작업들을 우선순위 큐에 추가
            while (index < jobs.length && jobs[index][0] <= currentTime) {
                heap.offer(jobs[index]);
                index++;
            }

            if (!heap.isEmpty()) {

                // 가장 작은 소요시간을 가진 작업을 꺼냄
                int[] job = heap.poll();

                // 작업이 끝난 시간 기록
                currentTime += job[1];

                // 요청보다 작업이 늦게 시작된 경우를 고려해서 요청 시간을 빼줌
                // answer에 총 걸린시간 누적
                answer += currentTime - job[0];

            } else {

                // 큐가 비어있으면, 배열에서 그 다음으로 가장 이른 작업 요청시간으로 현재 시간 세팅
                currentTime = jobs[index][0];
            }
        }

        // 누적된 시간을 작업 수로 나누어 평균
        return answer / jobs.length;
    }

    public static void main(String[] args) {
        Q2 sol = new Q2();
        System.out.println(sol.solution(new int[][]{{1, 4}, {7, 9}, {1000, 3}}));

    }
}
