import java.io.*;
import java.util.*;

class Main {
    static StringBuilder sb = new StringBuilder();
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] map = new int[n][m];
        int[][] dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            String temp = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(String.valueOf(temp.charAt(j)));// String.valueOf...
            }
        }
        int answer = 0; // 초기값을 0으로 설정

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 || j == 0) {
                    // 첫 번째 행이나 첫 번째 열은 그 값을 그대로 사용
                    dp[i][j] = map[i][j];
                } else if (map[i][j] == 1) {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                }
                answer = Math.max(answer, dp[i][j]);
            }
        }
        sb.append(answer * answer); // 최대 크기의 정사각형 면적 반환
        bw.write(sb + "");
        bw.flush();
        bw.close();
    }
}