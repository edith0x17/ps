import java.util.*;

class Solution {

    static boolean[] visited;
    static int[] ret;
    static HashSet<Integer> set = new HashSet<>();

    public int solution(String numbers) {

        visited = new boolean[numbers.length()];
        ret = new int[numbers.length()];

        for (int len = 1; len <= numbers.length(); len++) {
            go(0, len, numbers);
        }

        return set.size();
    }

    static void go(int depth, int len, String numbers) {

        if (depth == len) {

            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < len; i++) {
                sb.append(numbers.charAt(ret[i]));
            }

            int num = Integer.parseInt(sb.toString());

            if (isPrime(num)) {
                set.add(num);
            }

            return;
        }

        for (int i = 0; i < numbers.length(); i++) {

            if (visited[i]) continue;

            visited[i] = true;
            ret[depth] = i;

            go(depth + 1, len, numbers);

            visited[i] = false;
        }
    }

    static boolean isPrime(int num) {

        if (num < 2) return false;

        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) return false;
        }

        return true;
    }
}