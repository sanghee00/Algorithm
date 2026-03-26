import java.util.*;

class Solution {
    public int[] solution(int[] command, int[][] commands) {
        int[] answer = new int[commands.length];
        
        int idx = 0;
        for (int[] c : commands) {
            int[] cutArrays = Arrays.copyOfRange(command, c[0] - 1, c[1]);
            Arrays.sort(cutArrays);
            answer[idx] = cutArrays[c[2] - 1];
            idx++;
        }
        
        return answer;
    }
}