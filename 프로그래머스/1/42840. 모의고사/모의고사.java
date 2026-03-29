import java.util.*;

class Solution {
    public List<Integer> solution(int[] answers) {
        int[] answer = {};
        List<Integer> answerList = new ArrayList<>();
        // 수포자를 이중 배열에 넣는다.
        int[][] threeHuman = new int[][]{
            new int[]{1, 2, 3, 4, 5}, // 수포자 1
            new int[]{2, 1, 2, 3, 2, 4, 2, 5}, // 수포자 2
            new int[]{3, 3, 1, 1, 2, 2, 4, 4, 5, 5} // 수포자 3
        };
        
        // 수포자 만큼 횟수 반복
        for (int i = 0; i < threeHuman.length; i++) {
            int answerCount = 0;
            
            for (int j = 0; j < answers.length; j++) {
                // 핵심: 패턴이 계속 반복하게 함 -> 나머지 연산을 사용
                // 닶이 맞는 경우 정답 +1을 해준다.
                if (answers[j] == threeHuman[i][j % threeHuman[i].length]) {
                    answerCount++;
                }
            }
            answerList.add(answerCount);
        }
        
        int maxAnswer = Collections.max(answerList); // 가장 큰 값을 구한다.
        List<Integer> indexAnswerList = new ArrayList<>(); // 인덱스만 넣을 리스트
        for (int i = 0; i < answerList.size(); i++) {
            // 만약 최대값과 같다면, 그 값의 인덱스를 넣는다.
            if (maxAnswer == answerList.get(i)) {
                indexAnswerList.add(i + 1);
            }
        }
        
        return indexAnswerList;
    }
}