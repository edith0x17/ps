import java.io.*;
import java.util.*;

public class Main {
    static int k;
    static String mi = "", mx = ""; // 최소, 최대를 문자열로
    static Character[] operaters;
    static int[] ret;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        k = Integer.parseInt(br.readLine());
        operaters = new Character[k]; // k
        ret = new int[k + 1]; // k + 1
        visited = new boolean[10];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            operaters[i] = st.nextToken().charAt(0);
        }
        go(0);
        System.out.println(mx);
        System.out.println(mi);
    }

    static boolean good(char ch, int first, int second) {
        if (ch == '>') return first > second;
        if (ch == '<') return first < second;
        return false;
    }

    static boolean check() {
        for (int i = 0; i < k; i++) {
            if (!good(operaters[i], ret[i], ret[i + 1])) return false;
        }
        return true;
    }

    static void go(int depth) {
        if (depth == k + 1) {
            if (check()) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < k + 1; i++) {
                    sb.append(ret[i]);
                }
                String value = sb.toString();
                if (mx.equals("") || value.compareTo(mx) > 0) mx = value; // mx
                if (mi.equals("") || value.compareTo(mi) < 0) mi = value; // mi
            }
            return;
        }
        for (int i = 0; i < 10; i++) {
            if (visited[i]) continue; // 해당 숫자가 쓰임 안쓰임
            visited[i] = true; // 해당 숫자 사용
            ret[depth] = i; // 해당 숫자 사용

            go(depth + 1);

            visited[i] = false; // 해당 숫자 미사용
        }
    }
}