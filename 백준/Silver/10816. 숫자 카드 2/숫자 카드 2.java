import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static Map<Integer, Integer> mp = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            mp.put(num, mp.getOrDefault(num, 0) + 1);
        }
        st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            int tmp = Integer.parseInt(st.nextToken());
            sb.append(mp.getOrDefault(tmp, 0)).append(" ");
        }
        System.out.println(sb);
    }
}