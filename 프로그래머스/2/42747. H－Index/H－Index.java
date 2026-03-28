import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 1;
        Arrays.sort(citations);
        
        for (int i = citations.length - 1; i >= 0; i--) {
            if (answer <= citations[i]) {
                answer++;
                continue;
            }
            
            break;
        }
        
        
        return answer - 1;
    }
}