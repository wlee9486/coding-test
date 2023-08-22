package heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Q3 {
    public int[] solution(String[] operations) {
        int[] answer = new int[]{0, 0};

        // 내림차순 정렬 큐
        PriorityQueue<Integer> maxPq = new PriorityQueue(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        // 오름차순 정렬 큐
        PriorityQueue<Integer> minPq = new PriorityQueue();

        for (int i = 0; i < operations.length; i++) {

            // operations에서 첫 번째 연산 가져오기
            String str = operations[i];
            // 부호가 있다면 가져오기
            String sign = str.substring(2, 3);

            if (str.startsWith("I")) {
                int n = Integer.parseInt(str.substring(2));

                // I뒤에 붙은 값을 각 큐에 넣기
                minPq.add(n);
                maxPq.add(n);


            } else {

                // 큐에 값이 없다면 삭제 불가로 계속 진행
                if (maxPq.size() < 1) {
                    continue;
                }

                // 최솟값 삭제의 경우
                if (sign.equals("-")) {

                    // 오름차순 정렬 큐에서 가장 앞에 있는 값을 뺀 후
                    int min = minPq.poll();
                    // 같은 값을 내림차순 정렬 큐에서 삭제
                    // 각 큐를 같은 길이로 유지
                    maxPq.remove(min);

                // 최댓값 삭제
                } else {
                    // 내림차순 정렬 큐에서 가장 앞의 값 빼고
                    int max = maxPq.poll();
                    // 오름차순 정렬 큐에서 해당 값 삭제
                    minPq.remove(max);
                }
            }
        }

        // 아직 큐에 값이 남아있다면
        if(maxPq.size() > 0 ) {
            answer[0] = maxPq.poll();
            answer[1] = minPq.poll();
        }


        return answer;
    }

    public static void main(String[] args) {
        Q3 sol = new Q3();

        int[] answer = sol.solution(new String[]{"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"});
        System.out.println(answer[0] + " :  " + answer[1]);

        answer = sol.solution(new String[]{"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"});
        System.out.println(answer[0] + " :  " + answer[1]);

        answer = sol.solution(new String[]{"I 1", "I 2", "I 3", "I 4", "I 5", "I 6", "I 7", "I 8", "I 9", "I 10", "D 1", "D -1", "D 1", "D -1", "I 1", "I 2", "I 3", "I 4", "I 5", "I 6", "I 7", "I 8", "I 9", "I 10", "D 1", "D -1", "D 1", "D -1"});
        System.out.println(answer[0] + " :  " + answer[1]);
    }
}
