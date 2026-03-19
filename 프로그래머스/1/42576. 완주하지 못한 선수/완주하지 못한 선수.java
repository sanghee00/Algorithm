import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> map = new HashMap<>();
        String answer = "";
        
        // {"mislav" : 2, "stanko" : 1}
        for (String name : participant) {
             map.put(name, map.getOrDefault(name, 0) + 1);
        }
        
        // {"mislav" : 1, "stanko" : 0}
        for (String name : completion) {
            map.put(name, map.get(name) - 1);
        }
        
        for (String name : map.keySet()) {
            // 0이 아닌 경우는 완주를 못함
            if (map.get(name) != 0) {
                answer = name;
            }
        }
        
        return answer;
    }
}