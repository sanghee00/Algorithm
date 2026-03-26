import java.util.*;

class Solution {
    public int[] solution(int[] command, int[][] commands) {
        int[] answer = new int[commands.length];
        
        for (int i = 0; i < commands.length; i++) {
            int[] cutArrays = Arrays.copyOfRange(command, commands[i][0] - 1, commands[i][1]);
            Arrays.sort(cutArrays);
            answer[i] = cutArrays[commands[i][2] - 1];
        }
        
        return answer;
    }
}