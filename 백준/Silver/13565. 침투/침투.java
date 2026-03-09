import java.io.*;
import java.util.*;

public class Main {
    static final int[] dx = {-1, 0, 1, 0};
    static final int[] dy = {0, 1, 0, -1};
    static int n, m;
    static int[][] a, visited;
    static ArrayList<Data> adj = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        a = new int[n][m];
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                a[i][j] = s.charAt(j) - '0';
                if (i == 0 && a[i][j] == 0) {
                    adj.add(new Data(i, j));
                }
            }
        }
        boolean flag = false;
        for (int k = 0; k < adj.size(); k++) {
            Queue<Data> q = new ArrayDeque<>();
            visited = new int[n][m];

            Data data = adj.get(k);
            visited[data.x][data.y] = 1;
            q.offer(new Data(data.x, data.y));
            while (!q.isEmpty()) {
                Data here = q.poll();
                for (int i = 0; i < 4; i++) {
                    int nx = here.x + dx[i];
                    int ny = here.y + dy[i];
                    if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;//범위
                    if (visited[nx][ny] != 0) continue;//방문
                    if (a[nx][ny] == 1) continue;//장애물
                    visited[nx][ny] = visited[here.x][here.y] + 1;
                    q.offer(new Data(nx, ny));
                }
                for (int i = 0; i < m; i++) {
                    if (visited[n - 1][i] != 0) {
                        flag = true;
                        break;
                    }
                }
                if (flag) {
                    break;
                }
            }
            if (flag) {
                break;
            }
        }
//        for (int i = 0; i < m; i++) {
//            System.out.printf("%2d", visited[n - 1][i]);
//        }
        if (flag) System.out.println("YES");
        else System.out.println("NO");
    }

    static class Data {
        int x, y;

        public Data(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}