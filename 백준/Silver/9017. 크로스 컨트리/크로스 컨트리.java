import java.io.*;
import java.util.*;

public class Main {
    static int t;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] a = new int[n];
            ArrayList<Integer>[] adj = new ArrayList[201]; // ✅ 팀 번호는 1~200
            for (int i = 1; i <= 200; i++) {
                adj[i] = new ArrayList<>();
            }
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] count = new int[201];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(st.nextToken());
                count[a[i]]++;
            }
            int idx = 1;
            for (int i = 0; i < n; i++) {
                if (count[a[i]] >= 6) {
                    adj[a[i]].add(idx++);
                }
            }
            int answer = 0, winSum = Integer.MAX_VALUE, five = Integer.MAX_VALUE;
            for (int i = 1; i <= 200; i++) {
                if (adj[i].size() < 6) continue;
                
                int sum = 0;
                for (int j = 0; j < 4; j++) {
                    sum += adj[i].get(j);
                }
                if (winSum > sum) {
                    answer = i;
                    winSum = sum;
                    five = adj[i].get(4);
                } else if (winSum == sum) {
                    if (adj[i].get(4) < five) {
                        answer = i;
                        five = adj[i].get(4);
                    }
                }
            }
            System.out.println(answer);
        }
    }
}