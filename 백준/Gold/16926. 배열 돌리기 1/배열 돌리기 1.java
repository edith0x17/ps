import java.io.*;
import java.util.StringTokenizer;

public class Main{
    static StringBuilder sb = new StringBuilder();
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N, M, R;
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        map = new int[N + 4][M + 4];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int cnt = Math.min(N, M) / 2; // 돌아 갈 라인의 수

        for(int i = 0; i < R; i++){
            for(int j = 0; j < cnt; j++){
                int temp = map[j][j]; // (0, 0), (1, 1), (2, 2), ...

                // 위
                for(int k = j; k < M - 1 - j; k++) {
                    map[j][k] = map[j][k + 1];
                }

                // 오른쪽
                for(int k = j; k < N - 1 - j; k++) {
                    map[k][M - j - 1] = map[k + 1][M - j - 1];
                }

                // 아래
                for(int k = M - 1 - j; k > j; k--) {
                    map[N - 1 - j][k] = map[N - 1 - j][k - 1];
                }

                // 왼쪽
                for(int k = N - 1 - j; k > j; k--) {
                    map[k][j] = map[k - 1][j];
                }

                map[j + 1][j] = temp;
            }
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                sb.append(map[i][j]).append(" ");
            }
            sb.append("\n");
        }

        bw.write(sb + "");
        bw.flush();
        bw.close();
    }
}