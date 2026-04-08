class Solution {
    public int[] solution(int brown, int yellow) {
        int area = brown + yellow; // 전체의 색은 넒이다.
        
        // h가 3부터 시작하는 이유, 노란색은 무조건 1이상, 가로 세로는 같거나 가로가 길다.
        for (int h = 3; h <= area; h++) {
            // 넒이가 만약에 나누어 떨어지지 않으면 continue
            if (area % h != 0) {
                continue;
            }
            
            int w = area / h; // 높이를 나눠서 너비를 구한다.
            
            // 조건 중에 가로, 세로가 같거나 가로가 더 길어야 한다. 높이가 더 길면 break를 한다.
            if (w < h) {
                break;
            }
            
            // 노란색은 중앙에 있으니 각각의 너비, 높이의 끝을 하나씩 빼고 곱하면 노란색의 넒이가 나온다.
            if ((h - 2) * (w - 2) == yellow) {
                return new int[]{w, h};
            }
            
        }
        
        return new int[]{};
    }
}