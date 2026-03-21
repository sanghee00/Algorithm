import java.util.*;

class Solution {
    public List<Integer> solution(String[] genres, int[] plays) {
        List<Integer> answer = new ArrayList<>();
        
        // map 구조
        // { "classic" : [[500, 0], [150, 1], [800, 3]], "pop" : [[600, 2]] }
        Map<String, List<int[]>> map = new HashMap<>();
        
        // sumMap 구조
        // { "classic" : 1450, "pop" : 3100}
        Map<String, Integer> sumMap = new HashMap<>();
        
        for (int i = 0; i < genres.length; i++) {
            String genre = genres[i];
            int play = plays[i];
            
            // computeIfAbsent -> 해당 키가 없으면 생성함
            map.computeIfAbsent(genre, k -> new ArrayList<>())
                .add(new int[]{play, i});
            // 장르별로 속한 노래가 많이 재생된 장르를 구한다.
            sumMap.put(genre, sumMap.getOrDefault(genre, 0) + play);
        }
    
        // 장르 별로 가장 큰 것을 내림차순으로 구한다.
        List<String> sortGenres = new ArrayList<>(sumMap.keySet());
        sortGenres.sort((a, b) -> sumMap.get(b) - sumMap.get(a)); 
        
        // 해당 장르별로 순회를 한다.
        for (String genre : sortGenres) {
            List<int[]> songs = map.get(genre);
            // 0은 노래 재생횟수, 1은 인덱스임
            songs.sort((a, b) -> {
                if (b[0] == a[0]) return a[1] - b[1]; // 인덱스 기준으로 오름차순
                return b[0] - a[0];
            });
            // 정렬이 끝. 이제 두개씩 반복하면서 앞에 있는 노래를 두개씩 가져오면 끝.
            for (int i = 0; i < Math.min(2, songs.size()); i++) {
                answer.add(songs.get(i)[1]);
            }
        }
        
        return answer;
    }
}