import java.io.*;
import java.util.*;

public class Main {
    //8방향
    static final int[] dx = {0, -1, -1, -1, 0, 1, 1, 1};
    static final int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int n, m;
    static int[][] map;
    static ArrayList<Data> commands = new ArrayList<>(); //d, s
    static ArrayList<Data> clouds = new ArrayList<>(); //x, y

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken()) - 1;
            int s = Integer.parseInt(st.nextToken());
            commands.add(new Data(d, s));
        }
        //(N, 1), (N, 2), (N-1, 1), (N-1, 2)
        clouds.add(new Data(n - 1, 0));
        clouds.add(new Data(n - 1, 1));
        clouds.add(new Data(n - 2, 0));
        clouds.add(new Data(n - 2, 1));
        for (int i = 0; i < m; i++) {
            Data cmd = commands.get(i);
            moveClouds(cmd);
            rain();
            copyWater();
            makeNewClouds();
        }
        int answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                answer += map[i][j];
            }
        }
        System.out.println(answer);
    }

    static void moveClouds(Data cmd) {
        ArrayList<Data> moved = new ArrayList<>();
        for (Data cloud : clouds) { //
            int dir = cmd.x;
            int dist = cmd.y;
            //(x % n + n) % n
            int nx = ((cloud.x + dx[dir] * dist) % n + n) % n;
            int ny = ((cloud.y + dy[dir] * dist) % n + n) % n;
            moved.add(new Data(nx, ny));
        }
        clouds = moved;
    }

    static void rain() {
        for (Data cloud : clouds) {
            map[cloud.x][cloud.y]++;
        }
    }

    static boolean isRange(int x, int y) {
        return 0 <= x && x <= n - 1 && 0 <= y && y <= n - 1;
    }

    static void copyWater() {
        int[] diagDx = {-1, -1, 1, 1};
        int[] diagDy = {-1, 1, -1, 1};
        for (Data cloud : clouds) {
            int cnt = 0;
            for (int d = 0; d < 4; d++) {
                int nx = cloud.x + diagDx[d];
                int ny = cloud.y + diagDy[d];
                if (isRange(nx, ny) && map[nx][ny] > 0) {
                    cnt++;
                }
            }
            map[cloud.x][cloud.y] += cnt;
        }
    }

    static void makeNewClouds() {
        boolean[][] wasCloud = new boolean[n][n];
        for (Data cloud : clouds) {
            wasCloud[cloud.x][cloud.y] = true;
        }
        ArrayList<Data> newClouds = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!wasCloud[i][j] && map[i][j] >= 2) {
                    newClouds.add(new Data(i, j));
                    map[i][j] -= 2;
                }
            }
        }
        clouds = newClouds;
    }

    static class Data {
        int x, y; //d s

        public Data(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}