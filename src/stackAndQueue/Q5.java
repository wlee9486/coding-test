package stackAndQueue;

import java.util.LinkedList;
import java.util.Queue;

public class Q5 {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> queue = new LinkedList<>();
        int sum = 0;
        int time = 0;

        for (int i = 0; i < truck_weights.length; i++) {
            int truck = truck_weights[i];

            while (true) {

                // 다리 위에 트럭이 없는 경우
                if (queue.isEmpty()) {
                    queue.add(truck);
                    time++;
                    // 현재 무게 기록
                    sum += truck;
                    // 다음 트럭으로 이동
                    break;

                    // 다리위에 트럭이 다 차있거나,
                    // 하나의 트럭이 끝에 도달
                } else if (queue.size() == bridge_length) {
                    // 트럭을 마지막 이동
                    time++;
                    // 다리에서 내려옴
                    sum -= queue.poll();

                    // 무게가 넘지 않는 경우 새로운 트럭 진입
                    if (sum + truck <= weight) {
                        queue.add(truck);
                        sum += truck;
                        // 다음 트럭으로 이동
                        break;

                        // 무게가 넘으면 빈 공간을 넣어줌
                        // 앞으로 한칸씩 이동
                    } else {
                        queue.add(0);
                    }

                    // 다리위에 트럭이 더 올라올 수 있을 때
                } else {

                    // 트럭 이동
                    time++;

                    // 무게가 넘지 않는 경우 새로운 트럭 진입
                    if (sum + truck <= weight) {
                        queue.add(truck);
                        sum += truck;
                        // 다음 트럭으로 이동
                        break;

                    } // 무게가 넘으면 빈 공간을 넣어줌
                    // 앞으로 한칸씩 이동
                    else {
                        queue.add(0);
                    }

                }
            }
        }

        // 마지막 트럭의 진입에서 반복문 종료
        // 다리 길이 만큼 더해주기
        return time + bridge_length;
    }

    public static void main(String[] args) {
        Q5 sol = new Q5();
        int[] p1 = {7, 4, 5, 6};
        int[] p2 = {10, 10, 10, 10, 10, 10, 10, 10, 10, 10};

        System.out.println(sol.solution(2, 10, p1));
        //System.out.println(sol.solution(100, 100, p2));
    }
}
