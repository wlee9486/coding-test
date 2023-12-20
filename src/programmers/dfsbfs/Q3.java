package programmers.dfsbfs;

import java.util.LinkedList;
import java.util.Queue;

// 1. bfs를 사용해서 최단 경로 탐색 (dfs 사용시에 모든 경로를 탐색)
// 2. 벽에 부딪히거나 이미 갔던 길은 X
// 3. 현재까지 움직인 거리를 트래킹

public class Q3 {
    int[][] coordinates = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int solution(int[][] maps) {

        int answer = 0;
        int[][] visited = new int[maps.length][maps[0].length];

        bfs(maps, visited);

        answer = visited[maps.length - 1][maps[0].length - 1];

        if (answer == 0) {
            return -1;
        }

        return answer;
    }


    public void bfs(int[][] maps, int[][] visited) {
        visited[0][0] = 1;
        Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[]{0, 0});

        while (!queue.isEmpty()) {

            int[] current = queue.poll();

            for (int i = 0; i < 4; i++) {

                int x = current[0] + coordinates[i][0];
                int y = current[1] + coordinates[i][1];
                int cnt = visited[current[0]][current[1]];

                if (x < 0 || x > maps.length - 1 || y < 0 || y > maps[0].length - 1) {
                    continue;
                }


                if (visited[x][y] == 0 && maps[x][y] == 1) {
                    visited[x][y] = cnt + 1;
                    queue.add(new int[]{x, y});
                }


            }


        }

    }

    public static void main(String[] args) {
        int[][] map1 = {{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 1}, {0, 0, 0, 0, 1}};
        int[][] map2 = {{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 0}, {0, 0, 0, 0, 1}};

        Q3 q3 = new Q3();

        System.out.println(q3.solution(map1));
        System.out.println(q3.solution(map2));
    }
}
