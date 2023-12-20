package programmers.dfsbfs;

public class Q1 {

    int answer;

    public int solution(int[] numbers, int target) {
        answer = 0;
        dfs(numbers, 0, target, 0);
        return answer;
    }

    public void dfs(int[] numbers, int depth, int target, int sum) {

        if (depth == numbers.length) {
            if (sum == target) {
                answer++;
            }
        } else {
            dfs(numbers, depth + 1, target, sum + numbers[depth]);
            dfs(numbers, depth + 1, target, sum - numbers[depth]);
        }
    }


    public static void main(String[] args) {
        Q1 q1 = new Q1();

        int[] numbers1 = {1, 1, 1, 1, 1};
        int target1 = 3;
        int[] numbers2 = {4, 1, 2, 1};
        int target2 = 4;


        System.out.println(q1.solution(numbers1, target1));
        System.out.println(q1.solution(numbers2, target2));
    }
}
