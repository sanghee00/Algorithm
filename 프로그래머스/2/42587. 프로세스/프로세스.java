import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        Queue<int[]> queue = new LinkedList<>();
        int count = 0;
        
        for (int i = 0; i < priorities.length; i++) {
            queue.add(new int[]{priorities[i], i});
        }
        
        while (true) {
            if (queue.isEmpty()) {
                break;
            }
            
            // 맨 앞에 있는 것을 뺌
            int[] current = queue.poll();
            
            // 현재 꺼낸 프로세스보다 높은 순위가 있는 확인
            boolean higher = queue.stream().anyMatch(p -> p[0] > current[0]);
            
            // 있는 경우 다시 큐에 넣음
            if (higher) {
                queue.add(current);
            } else { // 없는 경우 빠지는 순서 카운터
                count++;
                if (current[1] == location) {
                    break;
                }
            }
            
        }
        
        
        return count;
    }
}