import java.util.*;

class Solution {
    public int solution(int[] order) {
        int answer = 0;
        Stack<Integer> stk = new Stack<>();
        int box = 1;
        for(int i = 0; i < order.length; i++){
            while(box <= order[i]){//자기자신도 넣기
                stk.push(box++);
            }
            if(!stk.isEmpty() && stk.pop() == order[i])answer++;
            else break;
        }
        return answer;
    }
}