import java.util.*;

class Solution {
    public String solution(String p) {
        String answer = go(p);
        return answer;
    }

    static String go(String p) {
        if (p.length() == 0) return "";
        int left = 0, right = 0, idx = 0;
        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '(') left++;
            else right++;

            if (left == right) {
                idx = i;
                break;
            }
        }
        String u = p.substring(0, idx + 1);
        String v = p.substring(idx + 1);

        // 여기서부터
        // 3. u가 올바른 괄호인지 확인
        // 4. 맞으면 u + go(v)
        // 5. 아니면 문제에서 준 변환 규칙
        if (check(u)) return u + go(v);
        StringBuilder sb = new StringBuilder();
        sb.append("(");
        sb.append(go(v));
        sb.append(")");
        for (int i = 1; i < u.length() - 1; i++) {
            if (u.charAt(i) == '(') sb.append(')');
            else sb.append('(');
        }
        return sb.toString();
    }

    static boolean check(String u) {
        Stack<Character> stk = new Stack<>();
        for (int i = 0; i < u.length(); i++) {
            char ch = u.charAt(i);
            if (ch == '(') stk.push(ch);//push
            else {//pop
                if (stk.isEmpty()) return false;
                stk.pop();
            }
        }
        return stk.isEmpty();
    }
}