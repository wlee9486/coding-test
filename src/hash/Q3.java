package hash;

import java.util.HashMap;

public class Q3 {
    public boolean solution(String[] phone_book) {
        boolean answer = true;

        HashMap<String, Integer> hashMap = new HashMap<>();

        // 각 문자열은 key 값으로 하여 hashMap에 삽입 - value는 상관x
        for (int i = 0; i < phone_book.length; i++) {
            hashMap.put(phone_book[i], i);
        }

        for (int i = 0; i < phone_book.length; i++) {
            String s = phone_book[i];
            for (int j = 0; j < s.length(); j++) {
                // 문자열을 쪼개면서 key 중 일치하는 값이 있는지 확인
                String prefix = s.substring(0, j);
                if (hashMap.containsKey(prefix)) {
                    return false;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Q3 q3 = new Q3();
        String[] sArr1 = new String[]{"119", "97674223", "1195524421"};
        String[] sArr2 = new String[]{"123", "456", "789"};
        String[] sArr3 = new String[]{"12", "123", "1235", "567", "88"};
        System.out.println(q3.solution(sArr1));
        System.out.println(q3.solution(sArr2));
        System.out.println(q3.solution(sArr3));
    }
}
