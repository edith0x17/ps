import java.io.*;
import java.util.*;

public class Main {
    static final int[] dx = {-1, 0, 1, 0};
    static final int[] dy = {0, 1, 0, -1};
    static int n, m;
    static int[][] aOri;
    static boolean[][] visited;
    static ArrayList<Data> adj = new ArrayList<>();
    static int[] ret;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        aOri = new int[n][n];
        ret = new int[m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                aOri[i][j] = Integer.parseInt(st.nextToken());
                if (aOri[i][j] == 2) {
                    adj.add(new Data(i, j, 0));
                }
            }
        }

        combi(0, 0);
        System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
    }

    static void combi(int depth, int start) {
        if (depth == m) {
            go();
            return;
        }
        for (int i = start; i < adj.size(); i++) {
            ret[depth] = i;
            combi(depth + 1, i + 1);
        }
    }

    static void go() {
        visited = new boolean[n][n];
        Queue<Data> q = new ArrayDeque<>();

        for (int i = 0; i < m; i++) {
            Data d = adj.get(ret[i]);
            visited[d.x][d.y] = true;
            q.offer(new Data(d.x, d.y, 0)); // 활성화 바이러스 시작
        }

        int maxTime = 0;

        while (!q.isEmpty()) {
            Data cur = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
                if (visited[nx][ny] || aOri[nx][ny] == 1) continue; // 벽은 못 감

                visited[nx][ny] = true;
                q.offer(new Data(nx, ny, cur.time + 1));

                // 빈 칸에 퍼질 때만 시간 기록
                if (aOri[nx][ny] == 0) {
                    maxTime = Math.max(maxTime, cur.time + 1);
                }
            }
        }

        // BFS 후, 퍼지지 않은 빈 칸이 있다면 실패
        if (!checkAllInfected()) return;

        // 모든 빈 칸에 퍼졌다면 최소 시간 갱신
        answer = Math.min(answer, maxTime);
    }

    static boolean checkAllInfected() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (aOri[i][j] == 0 && !visited[i][j]) return false;
            }
        }
        return true;
    }

    static class Data {
        int x, y, time;
        public Data(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }
}