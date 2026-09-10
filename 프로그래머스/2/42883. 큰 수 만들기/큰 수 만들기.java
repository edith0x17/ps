import java.util.*;

class Solution {
    public String solution(String number, int k) {
        String answer = "";
        Stack<Integer> stk = new Stack<>();
        int cnt = 0;
        for (int i = 0; i < number.length(); i++) {
            int num = number.charAt(i) - '0';
            while (!stk.isEmpty() && cnt < k && stk.peek() < num) {
                cnt++;
                stk.pop();
            }
            stk.push(num);
        }
         while (cnt < k) {
            stk.pop();
            cnt++;
        }

        StringBuilder sb = new StringBuilder();
        for (int i : stk) {
            sb.append(i + "");
        }
        answer = sb.toString();
        return answer;
    }
}