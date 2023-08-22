package stackAndQueue;


import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Stack;

public class Q4 {
    public int solution(int[] priorities, int location) {
        int answer = 0;

        return answer;

    }

    public static void main(String[] args) {
        Q4 sol = new Q4();
        int[] p1 = {2, 1, 3, 2};
        int[] p2 = {1, 1, 9, 1, 1, 1};

        // 1
        //System.out.println(sol.solution(p1, 2));
        // 3
        //System.out.println(sol.solution(p1, 0));
        // 5
        System.out.println(sol.solution(p2, 0));
        // 4
        System.out.println(sol.solution(p2, 5));
    }
}
