package hash;

import java.util.ArrayList;
import java.util.HashMap;

public class Q5 {

    // idx, plays 정보를 담을 music 객체 생성
    public class Music {
        int idx;
        int plays;

        public Music(int idx, int plays) {
            this.idx = idx;
            this.plays = plays;
        }
    }

    public int[] solution(String[] genres, int[] plays) {

        HashMap<String, ArrayList<Music>> musicMap = new HashMap<>();
        HashMap<String, Integer> cntMap = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {

            // index, plays 넣어서 생성
            Music music = new Music(i, plays[i]);

            ArrayList<Music> list = musicMap.get(genres[i]);

            // genre에 따라 music 객체 저장
            if (list != null) {
                list.add(music);
            } else {
                list = new ArrayList<>();
                list.add(music);
            }

            musicMap.put(genres[i], list);
            cntMap.put(genres[i], cntMap.getOrDefault(genres[i], 0) + plays[i]);

        }

        ArrayList<String> keyList = new ArrayList<>(cntMap.keySet());

        // keyList를 총 재생횟수가 많은 장르대로 정렬
        keyList.sort((o1, o2) -> cntMap.get(o2) - cntMap.get(o1));
        ArrayList<Integer> ansList = new ArrayList<>();

        for (String key : keyList) {
            ArrayList<Music> list = musicMap.get(key);
            // 장르 내에 재생 횟수가 많은 순으로 정렬
            list.sort((o1, o2) -> o2.plays - o1.plays);

            // 가장 많이 재생된 노래를 추가
            ansList.add(list.get(0).idx);

            // 2곡 이상이라면 2곡 추가
            if (list.size() >= 2) {
                ansList.add(list.get(1).idx);
            }
        }


        // ArrayList<Integer>를 int[] 변환
        int[] answer = ansList.stream().mapToInt(Integer::intValue).toArray();

        return answer;
    }

    public static void main(String[] args) {
        Q5 q5 = new Q5();
        String[] genres = new String[]{"classic", "pop", "classic", "classic", "pop"};
        int[] plays = new int[]{500, 600, 150, 800, 2500};
        int[] answer = q5.solution(genres, plays);

        for (int a : answer) {
            System.out.println(a);
        }

    }

}
