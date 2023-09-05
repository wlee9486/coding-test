package hash;

import java.util.HashMap;

public class Q4 {
    public int solution(String[][] clothes) {
        int answer = 1;

        HashMap<String, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < clothes.length; i++) {
            String key = clothes[i][1];
            // 카테고리별로 개수 카운팅해서 map 구성
            hashMap.put(key, hashMap.getOrDefault(key, 0) + 1);
        }



        for (String s : hashMap.keySet()) {
            // 카테고리 개수 + 1 로 곱셈 결과 축적
            answer *= hashMap.get(s) + 1;
        }

        return answer - 1;
    }

    public static void main(String[] args) {
        Q4 q4 = new Q4();
        String[][] sArr1 = new String[][]{{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
        String[][] sArr2 = new String[][]{{"crow_mask", "face"}, {"blue_sunglasses", "face"}, {"smoky_makeup", "face"}};

        System.out.println(q4.solution(sArr1));
        System.out.println(q4.solution(sArr2));
    }
}
