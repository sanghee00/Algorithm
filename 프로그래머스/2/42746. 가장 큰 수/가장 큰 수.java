import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        if (Arrays.stream(numbers).allMatch(n -> n == 0)) {
            return "0";
        }
        
        String answer = "";
        String[] numberForString = 
            Arrays.stream(numbers).mapToObj(String::valueOf).toArray(String[]::new);
        
        Arrays.sort(numberForString, (a, b) -> {
            return Integer.parseInt(b + a) - Integer.parseInt(a + b);
        });
            
        for (String s: numberForString) {
            answer += s;
        }
        
        return answer;
    }
}