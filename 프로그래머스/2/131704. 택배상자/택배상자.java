// 15
import java.util.*;

class Solution {
    public int solution(int[] order) {
        int answer = 0;
        int box = 1;
        Stack<Integer> stk = new Stack<>();
        for(int i = 0; i < order.length; i++){
            while(box <= order[i]){
                stk.push(box++);
            }
                
            if(stk.pop() == order[i])answer++;
            else break;
        }
        return answer;
    }
}