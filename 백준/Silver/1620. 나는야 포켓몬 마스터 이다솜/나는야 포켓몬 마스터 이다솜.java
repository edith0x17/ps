import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static Map<String, Integer> mp1 = new HashMap<>();
    static Map<Integer, String> mp2 = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            mp1.put(s, i + 1);
            mp2.put(i + 1, s);
        }
        for (int i = 0; i < m; i++) {
            String s = br.readLine();
            if (s.charAt(0) <= '9') {//숫자
                System.out.println(mp2.getOrDefault(Integer.parseInt(s), ""));
            } else {//문자
                System.out.println(mp1.getOrDefault(s, -1));
            }
        }
    }
}