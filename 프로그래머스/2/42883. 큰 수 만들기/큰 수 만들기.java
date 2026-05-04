import java.util.*;

class Solution {
    public String solution(String number, int k) {
        String answer = "";
        Stack<Character> stk = new Stack<>();
        for (char c : number.toCharArray()) {
            while (!stk.isEmpty() && k > 0 && stk.peek() < c) {
                stk.pop();
                k--;
            }
            stk.push(c);
        }
        while (!stk.isEmpty() && k > 0) {
            stk.pop();
            k--;
        }
        StringBuilder sb = new StringBuilder();
        for (char c : stk) {
            sb.append(c);
        }
        return sb.toString();
    }
}