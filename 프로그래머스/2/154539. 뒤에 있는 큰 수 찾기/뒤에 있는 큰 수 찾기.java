import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        Stack<Integer> stk = new Stack<>();
        for(int i = 0; i < numbers.length; i++){
            while(!stk.isEmpty() && numbers[stk.peek()] < numbers[i]){
                int idx = stk.pop();
                answer[idx] = numbers[i];
            }
            stk.push(i);
        }
        
        while(!stk.isEmpty()){
            int idx = stk.pop();
            answer[idx] = -1;
        }
        return answer;
    }
}