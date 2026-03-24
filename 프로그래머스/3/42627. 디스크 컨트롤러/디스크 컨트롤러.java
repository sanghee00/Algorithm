import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        Arrays.sort(jobs, (a, b) -> a[0] - b[0]); // 요청 시간이 빠른 것부터 정렬
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[1] - b[1]); // 작업의 소요 시간 짧은 것 정렬
        
        int time = 0;
        int totalTime = 0;
        int idx = 0;
        
        while (idx < jobs.length || !minHeap.isEmpty()) {
            // 작업이 요청이 되는 시간이 현재 시간과 같거나 시간이 더 크면 힙에 넣는다.
            while (idx < jobs.length && jobs[idx][0] <= time) {
                minHeap.offer(jobs[idx]);
                idx++;
            }
            
            // 힙이 비어 있지 않다면
            if (!minHeap.isEmpty()) {
                int[] job = minHeap.poll(); // 힙을 꺼낸다.
                time += job[1]; // 작업이 요청된 시간과 현재 시간을 더한다.
                totalTime += time - job[0]; // 현재 시간과 작업이 수행한 시간을 뺀 후 토탈 시간에 더한다.
            } else { // 힙이 비어 있다면 이미 idx가 +1이 된 상태이기 때문에 그냥 점프한다.
                time = jobs[idx][0]; // 다음 요청 시간으로 점프한다.
            }
        }
        
        return totalTime / jobs.length;
    }
}