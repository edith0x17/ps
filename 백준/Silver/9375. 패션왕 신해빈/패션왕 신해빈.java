import java.io.*;
import java.util.*;

public class Main {
    static int t;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            Map<String, Integer> mp = new HashMap<>();
            for (int i = 0; i < n; i++) {
                String s = br.readLine();
                String[] ss = s.split(" ");
                mp.put(ss[1], mp.getOrDefault(ss[1], 0) + 1);
            }
            int answer = 1;
            for (Map.Entry<String, Integer> entry : mp.entrySet()) {
                answer *= entry.getValue() + 1;
            }
            System.out.println(answer - 1);
        }
    }
}