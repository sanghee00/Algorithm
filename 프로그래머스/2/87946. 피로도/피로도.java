import java.util.*;

class Solution {
    public int solution(int k, int[][] dungeons) {
        boolean[] visited = new boolean[dungeons.length];
        
        return dfs(dungeons, visited, k);
    }
    
    int dfs(int[][] dungeons, boolean[] visited, int k) {
        int result = 0;

        for (int i = 0; i < dungeons.length; i++) {
            if (!visited[i] && k >= dungeons[i][0]) {
                visited[i] = true;
                result = Math.max(result, 1 + dfs(dungeons, visited, k - dungeons[i][1]));
                visited[i] = false;
            }
        }

        return result;
    }
    
}