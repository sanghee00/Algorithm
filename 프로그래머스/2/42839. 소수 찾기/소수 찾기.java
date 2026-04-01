import java.util.*;

class Solution {
    public int solution(String numbers) {
        int answer = 0;
        Set<Integer> result = new HashSet<>();
        boolean[] visited = new boolean[numbers.length()];
        dfs("", numbers, visited, result);
        
        for (int n : result) {
            // 0,1 은 소수 아님
            if (n < 2) {
                continue;
            }
            
            boolean isPrime = true; 
            for (int i = 2; i <= Math.sqrt(n); i++) {
                if (n % i == 0) {
                    isPrime = false; // 나누어 떨어지면 소수가 아님
                    break;
                }
            }
            
            if (isPrime) {
                answer++;
            }
        }
        
        return answer;
    }
    
    void dfs(String current, String numbers, boolean[] visited, Set<Integer> result) {
        if (!current.isEmpty()) {
            result.add(Integer.parseInt(current));
        }        
        
        for (int i = 0; i < numbers.length(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(current + numbers.charAt(i), numbers, visited, result);
                visited[i] = false;
            }
        }
    }
}