import java.util.*;

class Solution {
    public ArrayList<Integer> solution(int[] progresses, int[] speeds) {
        Deque<Integer> progressesDeque = new ArrayDeque<>();
        Deque<Integer> speedDeque = new ArrayDeque<>();
        Deque<Integer> newSpeedDeque = new ArrayDeque<>();
        Deque<Integer> finishedDeque = new ArrayDeque<>();
        int answerValue = 1;
        ArrayList<Integer> answer = new ArrayList<>();
        
        Arrays.stream(progresses).boxed().forEach(progressesDeque::addLast);
        Arrays.stream(speeds).boxed().forEach(speedDeque::addLast);
        
        int endCount = progresses.length;
        while(true) {
            if (progressesDeque.size() <= 0) {
                break;
            }
            answerValue = 1;
            
            // 맨 앞에 꺼 빼옴
            int progress = progressesDeque.poll();
            int speed = speedDeque.poll();
            
            int count = 0;
            // 100이 될때까지 계속 돌린다.
            for (int i = progress; progress < 100; progress += speed) {
                count++;
            }
        
            int nowPrgressSize = progressesDeque.size();
            // 반복된 수 만큼 뒤에 있는 변수들도 process + (count * speed)를 더해준다.
            for (int i = 0; i < nowPrgressSize; i++) {
                int nextSpeed = speedDeque.poll();
                finishedDeque.addLast(
                    progressesDeque.poll() + (count * nextSpeed)
                );
                newSpeedDeque.addLast(nextSpeed);
            }
            
            // Call by Value
            progressesDeque = finishedDeque;
            speedDeque = newSpeedDeque;
            
            
            // 100이상이 있는지 확인한다. 하지만 앞에 프로세스가 100이 아니면 뒤에꺼는 중단이 불가능함
            for (int num : progressesDeque) {
                if (num >= 100) {
                    progressesDeque.poll();
                    speedDeque.poll();
                    answerValue++;
                } else { // 아니면 바로 탈출
                    break;
                }
            }
            
            answer.add(answerValue);
            finishedDeque = new ArrayDeque<>();
            endCount--;
        }
        
        
        return answer;
    }
}