package exhaustiveSearch;

import java.util.ArrayList;
import java.util.List;

public class Q2 {
    public int[] solution(int[] answers) {

        int[] p1 = new int[]{1, 2, 3, 4, 5};
        int[] p2 = new int[]{2, 1, 2, 3, 2, 4, 2, 5};
        int[] p3 = new int[]{3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int[] scores = new int[3];

        for (int i = 0; i < answers.length; i++) {

            // answer[0] 와 p1[0 % 5] -> p[0] 비교
            if (answers[i] == p1[i % 5]) {
                scores[0]++;
            }

            if (answers[i] == p2[i % 8]) {
                scores[1]++;
            }

            if (answers[i] == p3[i % 10]) {
                scores[2]++;
            }

        }

        // 문제를 가장 많이 맞힌 사람의 점수 찾기
        int max = Math.max(scores[0], scores[1]);
        max = Math.max(scores[2], max);

        List<Integer> list = new ArrayList<>();

        // 최고점을 맞은 사람이 더 있는지 확인
        for (int i = 0; i < scores.length; i++) {
            if (scores[i] == max) {

                // 0번 idx -> 1번 사람
                list.add(i + 1);
            }
        }

        int[] rank = new int[list.size()];

        // 최고점을 맞은 사람들을 오름차순으로 배열에 넣기
        for (int i = 0; i < list.size(); i++) {
            rank[i] = list.get(i);
        }


        return rank;
    }

    public static void main(String[] args) {
        Q2 q2 = new Q2();

        int[] arr1 = new int[]{1, 2, 3, 4, 5};
        int[] answer = q2.solution(arr1);
        for (int n : answer) {
            System.out.println(n);
        }

        int[] arr2 = new int[]{1, 3, 2, 4, 2};
        answer = q2.solution(arr2);
        for (int n : answer) {
            System.out.println(n);
        }
    }
}