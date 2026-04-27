import java.util.*;

class Solution {
    public int solution(int[] order) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        int box = 1;
        for (int target : order) {
            while (box <= order.length && box <= target) {
                stack.push(box);
                box++;
            }//다 넣고

            if (!stack.isEmpty() && stack.peek() == target) {//체크
                stack.pop();
                answer++;
            } else {
                break;
            }
        }
        return answer;
    }
}