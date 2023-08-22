package exhaustiveSearch;

public class Q4 {
    public int[] solution(int brown, int yellow) {

        int[] answer = new int[2];

        // 최소 brown, yellow -> 8, 1
        // b b b
        // b y b
        // b b b

        // 넓이: 9
        int area = brown + yellow;

        // 최소 변의 길이 : 3 -> i는 3부터 순회
        for (int i = 3; i * i <= area; i++) {

            // 가로가 세로보다 커야하기 때문에,j가 가로
            int j = area / i;
            // j가 약수가 아닐 때 다른 값이 들어가면서
            // (i - 2) * (j - 2) == yellow 조건을 만족할 수도 있어서
            // 나머지를 기록
            int r = area % i;

            // 노란 카펫은 테두리에 있을 수 없음
            // 각 변에서 -2 후 곱했을 때 노란 카펫과 일치
            if (r == 0 && (i - 2) * (j - 2) == yellow) {
                answer[0] = j;
                answer[1] = i;
            }

        }

        return answer;

    }

    public static void main(String[] args) {
        Q4 q4 = new Q4();

        int[] ans = q4.solution(10, 2);
        for (int n : ans) {
            System.out.println(n);
        }

        ans = q4.solution(8, 1);
        for (int n : ans) {
            System.out.println(n);
        }

        ans = q4.solution(24, 24);
        for (int n : ans) {
            System.out.println(n);
        }

        ans = q4.solution(18, 6);
        for (int n : ans) {
            System.out.println(n);
        }
    }

}
