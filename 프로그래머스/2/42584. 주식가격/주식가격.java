import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < prices.length; i++) {
            
            // stack이 비워져있지 않거나, 전 가격이 더 크면 떨어진 시간을 구한다.
            while (!stack.isEmpty() && prices[i] < prices[stack.peek()]) {
                int popIndex = stack.pop();
                answer[popIndex] = i - popIndex;
            }
            
            stack.push(i);
        }
        
        while (!stack.isEmpty()) {
            int popIndex = stack.pop();
            answer[popIndex] = (prices.length - 1) - popIndex;
        }
    
        
        return answer;
    }
}