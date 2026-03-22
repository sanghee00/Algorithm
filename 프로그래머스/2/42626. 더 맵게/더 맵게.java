import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        
        for (int s : scoville) {
            minHeap.offer(s);
        }
        if (minHeap.peek() >= K) {
            return answer;
        }
    
        while (!(minHeap.peek() >= K)) {
            if (minHeap.size() < 2) {
                return -1;
            }
            int firstScoville = minHeap.poll();
            int secondScoville = minHeap.poll();
            minHeap.offer(firstScoville + (secondScoville * 2));
            answer++;
        }
        
        return answer;
    }
}