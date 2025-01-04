import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n;
    static int[] arr;
    static int[] operators = new int[4];
    static StringBuilder s = new StringBuilder(); // String → StringBuilder로 변경
    static char[] ret;
    static boolean[] visited;
    static int mx = Integer.MIN_VALUE, mi = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            operators[i] = Integer.parseInt(st.nextToken());
        }

        // String은 불변 객체(immutable) -> StringBuilder로 최적화
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < operators[i]; j++) {
                if (i == 0) s.append("+");
                if (i == 1) s.append("-");
                if (i == 2) s.append("*");
                if (i == 3) s.append("/");
            }
        }

        ret = new char[s.length()];
        visited = new boolean[s.length()];
        go(0);

        sb.append(mx).append("\n").append(mi);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    static void go(int depth) {
        if (depth == s.length()) {
            int sum = arr[0];
            for (int j = 1; j < arr.length; j++) {
                sum = calculate(sum, arr[j], ret[j - 1]);
            }
            mx = Math.max(mx, sum);
            mi = Math.min(mi, sum);
            return;
        }
        for (int i = 0; i < s.length(); i++) {
            if (visited[i]) continue;
            visited[i] = true;
            ret[depth] = s.charAt(i);
            go(depth + 1);
            visited[i] = false;
        }
    }

    static int calculate(int A, int B, char operator) {
        if (operator == '+') return A + B;
        else if (operator == '-') return A - B;
        else if (operator == '*') return A * B;
        else return A / B;
    }
}