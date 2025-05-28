import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n, m, r;
    static int[][] a;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        a = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                a[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int cnt = Math.min(n, m) / 2; // 돌아 갈 라인의 수
        for (int k = 0; k < r; k++) {
            for (int i = 0; i < cnt; i++) {

                int temp = a[i][i];
                // 위쪽
                for (int j = i; j < m - 1 - i; j++) {
                    a[i][j] = a[i][j + 1];
                }
                // 오른쪽
                for (int j = i; j < n - 1 - i; j++) {
                    a[j][m - 1 - i] = a[j + 1][m - 1 - i];
                }
                // 아래쪽
                for (int j = m - 1 - i; j > i; j--) {
                    a[n - 1 - i][j] = a[n - 1 - i][j - 1];
                }
                // 왼쪽
                for (int j = n - 1 - i; j > i; j--) {
                    a[j][i] = a[j - 1][i];
                }
                a[i + 1][i] = temp;  // 마지막에 temp 복원
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sb.append(a[i][j]).append(" ");
            }
            sb.append("\n");
        }
        bw.write(sb + "");
        bw.flush();
        bw.close();
    }
}