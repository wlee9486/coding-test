package exhaustiveSearch;

public class Q5 {
    public static boolean[] flag;
    static int answer = 0;

    public int solution(int k, int[][] dungeons) {

        // 던전의 탐험 여부 기록
        flag = new boolean[dungeons.length];

        int cnt = 0;

        dfs(k, dungeons, cnt);

        return answer;

    }

    public void dfs(int k, int[][] dungeons, int cnt) {

        // dungeon 배열의 길이만큼 순회
        for (int i = 0; i < dungeons.length; i++) {

            // 아직 방문하지 않은 던전 && 최소 필요 피로도를 현재 충족
            if (!flag[i] && dungeons[i][0] <= k) {

                flag[i] = true;

                // 피로도를 재설정, 방문 + 1하고 다른 던전 순회
                // i = 0, 던전1 순회 -> 재귀 함수 호출
                // i = 0 이면서 그 안에서 다시 i 0부터 2까지 순회
                // 던전 1 - 2 - 3 순서로 순회 -> 3은 탐험 못 하고 return 됨
                // 던전1 탐험이 된 상황, 밖의 i = 0, 호출된 함수의 i = 2 로 던전3 탐험하고 던전2 탐험
                dfs(k - dungeons[i][1], dungeons, cnt + 1);

                flag[i] = false;
            }
        }

        // 가장 많은 던전을 탐험했을 때로 갱신
        answer = Math.max(answer, cnt);
    }

    public static void main(String[] args) {
        Q5 q5 = new Q5();
        int k = 80;
        int[][] dungeons = new int[][]{{80, 20}, {50, 40}, {30, 10}};
        System.out.println(q5.solution(k, dungeons));

    }

}
