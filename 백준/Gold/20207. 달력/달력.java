import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[] days = new int[366];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            for (int j = s; j <= e; j++) {
                days[j]++;
            }
        }
        int answer = 0;
        int cnt = 0, mx = 0;
        for (int i = 1; i <= 365; i++) {
            if (days[i] == 0) {
                answer += cnt * mx;
                cnt = 0;
                mx = 0;
            } else {
                cnt++;
                mx = Math.max(mx, days[i]);
            }
        }
        answer += cnt * mx;
        System.out.println(answer);
    }
}