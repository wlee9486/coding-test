package sort;

import java.util.Arrays;

public class Q1 {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for (int i = 0; i < commands.length; i++) {
            int start = commands[i][0] - 1;
            int end = commands[i][1] - 1;
            int k = commands[i][2] - 1;

            int[] arr = new int[end - start + 1];
            int n = 0;

            if (end == start) {
                answer[i] = array[start];
                continue;
            }

            for (int j = start; j <= end; j++) {
                arr[n] = array[j];
                n++;
            }
            Arrays.sort(arr);
            answer[i] = arr[k];

        }

        return answer;
    }
}