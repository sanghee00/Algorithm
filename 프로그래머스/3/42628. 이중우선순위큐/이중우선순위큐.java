import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        // 1. 최소 힙
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        // 2. 최대 힙
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        // 3. operations의 최대 갯수를 count하는 count 변수
        int count = 0;
        
        for (String operation : operations) {
            // Input 명령어가 온 경우
            if (operation.charAt(0) == 'I') {
                String subStr = operation.substring(2, operation.length());
                int stringToInteger = Integer.parseInt(subStr);
                minHeap.offer(stringToInteger);
                maxHeap.offer(stringToInteger);
                count++;
            } else if (count != 0 && operation.equals("D 1")) { // 최댓값 삭제
                int removeNumber = maxHeap.poll();
                minHeap.remove(removeNumber);
                count--;
            } else if (count != 0 && operation.equals("D -1")) { // 최솟값 삭제
                int removeNumber = minHeap.poll();
                maxHeap.remove(removeNumber);
                count--;
            }
        }
        
        if (count == 0) {
            return new int[2];
        }
        
        int[] answer = new int[2];
        answer[0] = maxHeap.poll();
        answer[1] = minHeap.poll();
        
        return answer;
    }
}