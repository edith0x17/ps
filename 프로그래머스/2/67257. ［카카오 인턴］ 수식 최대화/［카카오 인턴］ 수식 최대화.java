import java.util.*;

class Solution {
    static long answer;
    static ArrayList<Long> numbers = new ArrayList<>();
    static ArrayList<Character> ops = new ArrayList<>();
    static ArrayList<Character> priority = new ArrayList<>();
    static int n;
    static char[] ret;
    static boolean[] visited;

    public long solution(String expression) {
        String[] nums = expression.split("[+\\-*]");
        for (String s : nums) {
            numbers.add(Long.parseLong(s));
        }
        for (char c : expression.toCharArray()) {
            if (c == '+' || c == '-' || c == '*')
                ops.add(c);
        }
        if (expression.contains("+")) priority.add('+');
        if (expression.contains("-")) priority.add('-');
        if (expression.contains("*")) priority.add('*');

        n = priority.size();
        ret = new char[n];
        visited = new boolean[n];
        go(0);
        return answer;
    }

    static long check() {
        ArrayList<Long> number = new ArrayList<>(numbers);
        ArrayList<Character> op = new ArrayList<>(ops);
        for (char cur : ret) {
            for (int i = 0; i < op.size(); ) {
                if (op.get(i) == cur) {//ret
                    long a = number.get(i);
                    long b = number.get(i + 1);
                    long result = 0;

                    if (cur == '+') result = a + b;
                    else if (cur == '-') result = a - b;
                    else result = a * b;

                    number.set(i, result);
                    number.remove(i + 1);
                    op.remove(i);
                } else {
                    i++;
                }
            }
        }
        return Math.abs(number.get(0));
    }

    static void go(int depth) {
        if (depth == n) {
            answer = Math.max(answer, check());
            return;
        }
        for (int i = 0; i < n; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            ret[depth] = priority.get(i);
            go(depth + 1);
            visited[i] = false;
        }
    }
}