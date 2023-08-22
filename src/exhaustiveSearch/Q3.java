package exhaustiveSearch;

import java.util.HashSet;
import java.util.Set;

public class Q3 {

    // 중복된 값이 들어가지 않도록 Set 이용
    static Set<Integer> result = new HashSet<>();

    public static int solution(String numbers) {

        int len = numbers.length();
        int[] arr = new int[len];

        // String으로 주어진 숫자를 int 배열에 하나씩 넣기
        for (int i = 0; i < len; i++) {
            arr[i] = numbers.charAt(i) - '0';
        }

        // 순열
        // 1개의 숫자부터 3개의 숫자까지 선택 가능 - 순열의 길이 1 ~ 3
        for (int i = 1; i <= len; i++) {

            // 맨 처음에 depth = 0
            permutation(arr, 0, len, i);
        }

        return result.size();
    }

    public static void permutation(int[] arr, int depth, int n, int r) {

        // 선택한 숫자의 개수가 순열의 길이와 일치
        if (depth == r) {
            String num = "";
            for (int i = 0; i < r; i++) {
                // 현재까지 선택된 숫자들을 number에 넣음
                num += arr[i];
            }

            // number가 소수이면 result 추가
            int number = Integer.valueOf(num);

            if (isPrime(number)) {
                result.add(number);
            }

            return;
        }

        for (int i = depth; i < n; i++) {

            // depth의 위치와 i 위치의 숫자를 교환
            swap(arr, depth, i);
            permutation(arr, depth + 1, n, r);
            // 교환한 숫자 원상복귀
            swap(arr, depth, i);
        }
    }

    public static void swap(int[] arr, int depth, int i) {
        int temp = arr[depth];
        arr[depth] = arr[i];
        arr[i] = temp;
    }

    public static boolean isPrime(int n) {

        // 0 이나 1
        if (n < 2) {
            return false;
        }


        for (int i = 2; i * i <= n; i++) {

            // 나누어 떨어지면 소수가 아님
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Q3 q3 = new Q3();
        System.out.println(q3.solution("011"));
    }

}
