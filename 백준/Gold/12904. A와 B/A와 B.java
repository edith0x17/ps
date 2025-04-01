import java.io.*;

public class Main {
    static String s, t;
    static boolean flag = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        s = br.readLine();
        t = br.readLine();

        dfs(t);
        System.out.println(flag ? 1 : 0);
    }

    static void dfs(String current) {
        if (current.length() < s.length()) return;
        if (current.equals(s)) {
            flag = true;
            return;
        }

        // 1. A 제거
        if (current.charAt(current.length() - 1) == 'A') {
            dfs(current.substring(0, current.length() - 1));
        }

        // 2. B 제거 + 뒤집기
        if (current.charAt(current.length() - 1) == 'B') {
            String reversed = new StringBuilder(current.substring(0, current.length() - 1)).reverse().toString();
            dfs(reversed);
        }
    }
}
