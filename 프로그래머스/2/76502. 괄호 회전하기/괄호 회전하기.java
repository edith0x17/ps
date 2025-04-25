import java.io.*;
import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        int l = s.length();
        int cnt = 0;
        while (cnt < l) {
            String temp = "";
            for (int i = cnt; i < l + cnt; i++) {
                temp += s.charAt(i % l);
            }

            if (checkValid(temp)) {
                answer++;
            }

            cnt++;
        }
        return answer;
    }

    static boolean checkValid(String str) {
        Stack<Character> stk = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == '(' || ch == '[' || ch == '{') {
                stk.push(ch);
            } else {
                if (stk.isEmpty()) return false;
                char open = stk.pop();
                if (!isMatching(open, ch)) return false;
            }
        }
        return stk.isEmpty();
    }

    static boolean isMatching(char open, char close) {
        return (open == '(' && close == ')') ||
               (open == '[' && close == ']') ||
               (open == '{' && close == '}');
    }
}