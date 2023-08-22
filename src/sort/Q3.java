package sort;

import java.util.Arrays;

public class Q3 {
    public int solution(int[] citations) {
        Arrays.sort(citations);
        int h = 0;
        for (int i = 0; i < citations.length; i++) {
            h = citations.length - i;
            if (citations[i] >= h) {
                return h;
            }
        }
        return citations[h];
    }

    public static void main(String[] args) {
        Q3 sol = new Q3();
        System.out.println(sol.solution(new int[]{9,8,6,3,0}));

    }
}
