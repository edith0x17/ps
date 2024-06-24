import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static class Data {
        int x;
        int y;
        int type;

        public Data(int x, int y, int type) {
            this.x = x;
            this.y = y;
            this.type = type;
        }
    }

    static int dx[] = {-1, 0, 1, 0};
    static int dy[] = {0, 1, 0, -1};

    // possible combination
    static int[][][] mode = {
            {{0}},
            {{0}, {1}, {2}, {3}}, // 1번 CCTV
            {{0, 2}, {1, 3}}, // 2번 CCTV
            {{0, 1}, {1, 2}, {2, 3}, {3, 0}}, // 3번 CCTV
            {{3, 0, 1}, {0, 1, 2}, {1, 2, 3}, {2, 3, 0}}, // 4번 CCTV
            {{0, 1, 2, 3}} // 5번 CCTV
    };

    static int n, m, ans = 987654321;
    static ArrayList<Data> cctv = new ArrayList<>();
    public static int[][] mapOri;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        mapOri = new int[n][m];

        // input
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < m; j++) {
                mapOri[i][j] = Integer.parseInt(st.nextToken());

                if (1 <= mapOri[i][j] && mapOri[i][j] <= 5) {
                    cctv.add(new Data(i, j, mapOri[i][j]));
                }
            }
        }

        dfs(0, mapOri);

        sb.append(ans);

        bw.write(ans + "");
        bw.flush();
        bw.close();
    }

    static void dfs(int depth, int[][] currentMap) {
        if (depth == cctv.size()) {
            int cnt = check(currentMap);
            ans = Math.min(ans, cnt);
            return;
        }

        int x = cctv.get(depth).x;
        int y = cctv.get(depth).y;
        int cctvType = cctv.get(depth).type;

        // 
        for (int i = 0; i < mode[cctvType].length; i++) {

            // 원상복구
            int[][] mapTemp = new int[n][m];
            for (int k = 0; k < n; k++) {
                mapTemp[k] = currentMap[k].clone();
            }

            // direction
            for (int j = 0; j < mode[cctvType][i].length; j++) {
                int dir = mode[cctvType][i][j];

                int nx = x + dx[dir];
                int ny = y + dy[dir];

                while (true) {
                    if (nx < 0 || nx >= n || ny < 0 || ny >= m || currentMap[nx][ny] == 6) break;

                    mapTemp[nx][ny] = -1;
                    nx += dx[dir];
                    ny += dy[dir];
                }
            }

            dfs(depth + 1, mapTemp);
        }
    }

    // blind spot
    static int check(int[][] currentMap) {
        int cnt = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (currentMap[i][j] == 0) {
                    cnt++;
                }
            }
        }
        return cnt;
    }
}