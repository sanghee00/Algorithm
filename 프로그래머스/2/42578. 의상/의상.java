import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        Map<String ,Integer> map = new HashMap<>();
        
        for (String[] cloth : clothes) {
            map.put(cloth[1], map.getOrDefault(cloth[1], 0) + 1);
        }
        
        // *= 을 해야되서 기본 1로 설정, 0으로 하면 다 0임
        int answer = 1;
        for (int count : map.values()) {
            answer *= (count + 1);
        }
        
        return answer - 1;
    }
}