package hash;

import java.util.HashSet;
import java.util.Set;

public class Q1 {
    public int solution(int[] nums) {

        int max = nums.length / 2;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }

        if (max >= set.size()) {
            return set.size();
        } else {
            return max;
        }
    }

    public static void main(String[] args) {
        Q1 q1 = new Q1();
        System.out.println(q1.solution(new int[]{3, 1, 2, 3}));
        System.out.println(q1.solution(new int[]{3, 3, 3, 2, 2, 4}));
        System.out.println(q1.solution(new int[]{3, 3, 3, 2, 2, 2}));
    }
}
