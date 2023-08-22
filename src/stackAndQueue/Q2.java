package stackAndQueue;

import java.util.LinkedList;
import java.util.Queue;

public class Q2 {

    public int[] solution(int[] progresses, int[] speeds) {


        Queue<Integer> queue = new LinkedList<>();
        int[] calc = new int[progresses.length];

        for (int i = 0; i < progresses.length; i++) {
            int n = (int) Math.ceil(((double) 100 - progresses[i]) / speeds[i]);
            calc[i] = n;
        }

        int cnt = 1;
        int max = calc[0];

        for (int i = 1; i < calc.length; i++) {
            if (calc[i] > max) {
                queue.add(cnt);
                cnt = 1;
                max = calc[i];
            } else {
                cnt++;
            }
        }
        queue.add(cnt);


        int[] answer = new int[queue.size()];
        int n = queue.size();
        for (int i = 0; i < n; i++) {
            answer[i] = queue.poll();
        }


        return answer;
    }

    public static void main(String[] args) {
        Q2 ob = new Q2();

        int[] progresses = {20, 99, 93, 30, 55, 10};
        int[] speeds = {5, 10, 1, 1, 30, 5};
        ob.solution(progresses, speeds);
    }
}