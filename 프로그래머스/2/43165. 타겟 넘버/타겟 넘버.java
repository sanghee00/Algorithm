class Solution {
    static int count = 0;
    
    public int solution(int[] numbers, int target) {
        dfs(numbers, 0, target, 0);    
        return count;
    }
    
    void dfs(int[] numbers, int number, int target, int index) {
        if (numbers.length == index) {
            if (target == number) {
                count++;   
            }
            return;
        }
        
        dfs(numbers, number + numbers[index], target, index + 1);
        dfs(numbers, number - numbers[index], target, index + 1);
        
    }
    
}