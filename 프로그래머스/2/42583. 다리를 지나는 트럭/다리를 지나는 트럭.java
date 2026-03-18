import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        Queue<Integer> bridge = new LinkedList<>();
        Queue<Integer> truckWeightsQueue = new LinkedList<>(
            Arrays.stream(truck_weights).boxed().collect(Collectors.toList())
        );
        
        for (int i = 0; i < bridge_length; i++) {
            bridge.add(0);
        }
        
        int currentBridgeWeight = 0;
        while(!bridge.isEmpty()) {
            answer++; // time 1초 증가
            
            currentBridgeWeight -= bridge.poll(); // 하나를 뺀다.
            
            // 대기 중인 트럭이 있을시 실행
            if (!truckWeightsQueue.isEmpty()) {
                // 해당 원소로 최대 무게 초과 하는지 확인
                if ((currentBridgeWeight + truckWeightsQueue.peek()) > weight) {
                    bridge.add(0); // 무게가 초과하면 0이 들어감
                } else {
                    int nextTruck = truckWeightsQueue.poll(); // 실제 큐에서 맨앞에 있는 원소를 뺌
                    bridge.add(nextTruck);
                    currentBridgeWeight += nextTruck;
                }
            }
            
        }
        
        return answer;
    }
}