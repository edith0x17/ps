import java.io.*;
import java.util.*;

public class Main {
    static String str;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str = br.readLine();
        visited = new boolean[str.length()];
        go(0, str.length() - 1);
        System.out.println(sb);
    }

    static void go(int left, int right) {
        if (left > right) return;

        int idx = left;
        for (int i = left; i <= right; i++) {
            if (str.charAt(idx) > str.charAt(i)) {
                idx = i;
            }
        }
        visited[idx] = true;
        for (int i = 0; i < str.length(); i++) {
            if (visited[i]) {
                sb.append(str.charAt(i));
            }
        }
        sb.append("\n");
        go(idx + 1, right);
        go(left, idx - 1);
    }
}