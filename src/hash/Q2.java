package hash;

import java.util.HashMap;
import java.util.Map;

public class Q2 {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> hmap = new HashMap<>();

        for (int i = 0; i < participant.length; i++) {

            // hmap에 이미 참가자가 존재한다면, 그 값에 + 1 아니라면 1 넣기
            hmap.put(participant[i], hmap.getOrDefault(participant[i], 0) + 1);
        }

        for (int i = 0; i < completion.length; i++) {
            // hmap에서 완주한 사람을 찾아서 그 값에서 -1
            hmap.put(completion[i], hmap.get(completion[i]) - 1);
        }

        for (String s : hmap.keySet()) {
            if (hmap.get(s) != 0) {
                return s;
            }
        }


        return "";
    }

    public static void main(String[] args) {
        Q2 q2 = new Q2();
        System.out.println(q2.solution(new String[]{"leo", "kiki", "eden"}, new String[]{"eden", "kiki"}));
        System.out.println(q2.solution(new String[]{"marina", "josipa", "nikola", "vinko", "filipa"}, new String[]{"josipa", "filipa", "marina", "nikola"}));
        System.out.println(q2.solution(new String[]{"mislav", "stanko", "mislav", "ana"}, new String[]{"stanko", "ana", "mislav"}));

    }
}
