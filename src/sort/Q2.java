package sort;

import java.util.Arrays;
import java.util.Comparator;

public class Q2 {
    public String solution(int[] numbers) {

        String[] arr = new String[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            arr[i] = Integer.toString(numbers[i]);
        }

        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                String str1 = s1 + s2;
                String str2 = s2 + s1;
                System.out.println(str1.compareTo(str2));
                return str1.compareTo(str2);

            }

        });

        if (arr[0].equals("0")) {
            return "0";
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Q2 sol = new Q2();
        System.out.println(sol.solution(new int[]{3, 30, 34, 5, 9}));
    }
}
