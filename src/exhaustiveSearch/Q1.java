package exhaustiveSearch;

import java.util.Arrays;

public class Q1 {
    public int solution(int[][] sizes) {
        int answer = 0;

        int[] width = new int[sizes.length];
        int[] height = new int[sizes.length];

        for (int i = 0; i < sizes.length; i++) {

            // 각 쌍에서 작은 값이 width로 들어갈 수 있도록
            if (sizes[i][0] > sizes[i][1]) {
                width[i] = sizes[i][1];
                height[i] = sizes[i][0];
            } else {
                width[i] = sizes[i][0];
                height[i] = sizes[i][1];
            }
        }

        // 두 배열을 오름차순으로 정렬
        Arrays.sort(width);
        Arrays.sort(height);

        // 최대 높이 * 넓이로 면적 구하기
        answer = width[width.length - 1] * height[height.length - 1];

        return answer;
    }

    public static void main(String[] args) {
        Q1 q1 = new Q1();

        int[][] arr1 = new int[][]{{60, 50}, {30, 70}, {60, 30}, {80, 40}};
        int[][] arr2 = new int[][]{{10, 7}, {12, 3}, {8, 15}, {14, 7}, {5, 15}};
        int[][] arr3 = new int[][]{{14, 4}, {19, 6}, {6, 16}, {18, 7}, {7, 11}};

        System.out.println(q1.solution(arr1));
        System.out.println(q1.solution(arr2));
        System.out.println(q1.solution(arr3));

    }
}
