import java.util.*;

class Solution {
    public int solution(int[] order) {
        int answer = 0, num = 1;
        Stack<Integer> stk = new Stack<>();
        for(int i = 0; i < order.length; i++){
            while(num <= order[i]){
                stk.push(num++);
            }
            if(!stk.isEmpty() && order[i] == stk.pop())answer++;
            else break;
        }
        return answer;
    }
}