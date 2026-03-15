import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] days = new int[progresses.length];
        ArrayList<Integer> answer = new ArrayList<>();
        
        for (int i = 0; i < progresses.length; i++) {
            days[i] = (int) Math.ceil((100.0 - progresses[i]) / speeds[i]);
        }
        
        int i = 0;
        while (i < days.length) {
            int day = days[i];
            int count = 1; // 자기 자신 포함
            
            // 뒤에 있는 기능 중 같이 배포 가능한 것 세기
            while (i + count < days.length && days[i + count] <= day) {
                count++;
            }
            
            answer.add(count);
            i += count; // 배포한 만큼 건너뛰기
        }
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}