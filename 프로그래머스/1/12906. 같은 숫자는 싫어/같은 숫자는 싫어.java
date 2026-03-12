import java.util.*;

public class Solution {
    public Stack<Integer> solution(int []arr) {
        Stack<Integer> answer = new Stack<>();
        answer.push(arr[0]);
            
        for (int i = 1; i < arr.length; i++) {
            int amswerLength = answer.size() - 1;
            if (arr[i] == answer.get(amswerLength)) {
                continue;
            }
            
            answer.push(arr[i]);
        }

        return answer;
    }
}