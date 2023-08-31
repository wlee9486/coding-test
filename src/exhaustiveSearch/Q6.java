package exhaustiveSearch;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Q6 {
    public int solution(int n, int[][] wires) {

        int answer = Integer.MAX_VALUE;

        // 리스트로 구성된 리스트 graph 선언
        List<List<Integer>> graph = new ArrayList<>();

        // 전선 개수만큼 graph 구성
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] wire : wires) {

            // 전선간의 연결을 기록
            // 전선1에 전선3 추가
            graph.get(wire[0]).add(wire[1]);
            // 전선3에 전선1 추가
            graph.get(wire[1]).add(wire[0]);
        }

        // 연결된 전선들로 넓이우선탐색 함수 순회
        for (int[] wire : wires) {

            // 넓이우선탐색 - 송신탑 개수, 연결된 전선 한쌍
            int result = bfs(n, graph, wire[0], wire[1]);

            // 탐색 후 가장 작은 값을 매번 기록
            // e.g. 9 - (2 * 1) = 7
            answer = Math.min(answer, Math.abs(n - 2 * result));
        }


        return answer;
    }

    // p1과 p2의 연결을 끊는다고 가정,
    public int bfs(int n, List<List<Integer>> graph, int p1, int p2) {

        // index n-1 하지 않기 위해
        // p1과 연결된 전선들 기록
        boolean[] flag = new boolean[n + 1];

        Queue<Integer> queue = new LinkedList<>();

        // p1: 첫번째 전선을 순회
        // queue 추가
        flag[p1] = true;
        // queue.off(1)
        queue.offer(p1);

        int cnt = 0;

        while (!queue.isEmpty()) {

            // curr = 1
            int curr = queue.poll();
            // cnt = 1;
            cnt++;

            // 현재 전선과 연결된 전선들의 개수만큼
            for (int conn : graph.get(curr)) {
                // 아직 탐색하지 않은 전선, 그리고 p2가 아닌 다른 연결된 전선이라면
                // e.g. 전선1과 연결된 전선은 3번뿐
                if (!flag[conn] && conn != p2) {
                    // queue 추가
                    queue.offer(conn);
                    // p1과 연결되어 있어서 true로 기록
                    flag[conn] = true;
                }
            }
        }

        // 1 반환
        return cnt;
    }


    public static void main(String[] args) {
        Q6 q6 = new Q6();

        System.out.println(q6.solution(9, new int[][]{{1, 3}, {2, 3}, {3, 4}, {4, 5}, {4, 6}, {4, 7}, {7, 8}, {7, 9}}));
        System.out.println(q6.solution(4, new int[][]{{1, 2}, {2, 3}, {3, 4}}));
        System.out.println(q6.solution(7, new int[][]{{1, 2}, {2, 7}, {3, 7}, {3, 4}, {4, 5}, {6, 7}}));


    }

}
