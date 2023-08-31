package exhaustiveSearch;

public class Q7 {

    public int solution(String word) {
        int answer = 0;

        // A: 1번째, I:1563번째 -> A와 E 사이 A로 만들 수 있는 단어: 781개
        // 맨 앞자리가 바뀌면 781 차이
        // 2번째 자리: 781 / 5 = 156
        // .. 3: 31, 4: 6, 5: 1

        int diff = 781;
        String str = "AEIOU";

        for (String s : word.split("")) {

            // "A"는 첫번째 -> 781 * 0 + 1
            answer += diff * str.indexOf(s) + 1;
            diff /= 5;
        }

        return answer;
    }

    public static void main(String[] args) {
        Q7 q7 = new Q7();
        System.out.println(q7.solution("AAAAE"));
        System.out.println(q7.solution("AAAE"));
        System.out.println(q7.solution("I"));
        System.out.println(q7.solution("EIO"));

    }

}
