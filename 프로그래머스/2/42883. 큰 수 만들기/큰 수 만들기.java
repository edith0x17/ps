import java.util.*;

class Solution {
    public String solution(String number, int k) {
        String answer = "";
        Stack<Integer> stk = new Stack<>();
        stk.push(number.charAt(0) - '0');
        int cnt = 0;
        for (int i = 1; i < number.length(); i++) {
            int num = number.charAt(i) - '0';
            while (cnt < k && !stk.isEmpty() && num > stk.peek()) {
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
        for (int num : stk) {
            sb.append(num);
        }
        return sb.toString();
    }
}