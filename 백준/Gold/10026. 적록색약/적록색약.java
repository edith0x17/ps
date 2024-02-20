import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int n;
    static int[][] a;
    static boolean[][] visited;
    static int cntA, cntB;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        a = new int[n][n];

        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) == 'R') a[i][j] = 1;
                else if (s.charAt(j) == 'G') a[i][j] = 2;
                else if (s.charAt(j) == 'B') a[i][j] = 3;
            }
        }

        for (int i = 0; i < n; i++) {

            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    cntA++;
                    dfs(i, j);
                }
            }
        }

        // 방문 초기화 -> 1, 2 통일
        visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {

            for (int j = 0; j < n; j++) {
                if (a[i][j] == 2) a[i][j] = 1;
            }
        }

        for (int i = 0; i < n; i++) {

            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    cntB++;
                    dfs(i, j);
                }
            }
        }

        System.out.println(cntA + " " + cntB);
    }

    static void dfs(int x, int y) {
        visited[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;

            if (a[nx][ny] == a[x][y] && !visited[nx][ny]) {
                dfs(nx, ny);
            }
        }
    }
}