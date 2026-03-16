import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        Stack<Character> inspect = new Stack<>();
     
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            // 처음 부터 ')'가 나오면 false
            if (i == 0 && c == ')') {
                answer = false;
                break;
            }
            
            if (c == '(') {
                inspect.push(c);
            }
            
            if (c == ')') {
                if (inspect.isEmpty()) {
                    answer = false;
                    break;
                }
                inspect.pop();
            }
        }
        
        // 비어 있지 않다면
        if (!inspect.isEmpty()) {
            answer = false;
        }
        
        return answer;
    }
}