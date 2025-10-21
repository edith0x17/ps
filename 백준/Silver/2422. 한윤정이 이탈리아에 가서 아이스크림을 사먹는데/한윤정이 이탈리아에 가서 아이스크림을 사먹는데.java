import java.io.*;
import java.util.*;

public class Main {
    static int n, m, answer;
    static boolean[][] bad;  // 금지된 쌍 저장용

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        bad = new boolean[n + 1][n + 1];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            bad[a][b] = true;
            bad[b][a] = true;  // 양방향 금지
        }

        // 조합: i < j < k
        for (int i = 1; i <= n; i++) {
            for (int j = i + 1; j <= n; j++) {
                if (bad[i][j]) continue;
                for (int k = j + 1; k <= n; k++) {
                    if (bad[i][k] || bad[j][k]) continue;
                    answer++;
                }
            }
        }

        System.out.println(answer);
    }
}