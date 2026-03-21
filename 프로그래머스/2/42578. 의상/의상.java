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
            answer *= (count + 1); // + 1을 하는 이유는 안 입는다는 조건이 있기 때문에
        }
        
        // 곱의 법칙을 하는 경우, { "안 입음", "안 입음" } 이 존재 해버리기 때문에 1을 빼야 한다.
        return answer - 1;
    }
}