import java.io.*;
import java.util.*;

public class Main {
    static final int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static final int[] dy = {0, -1, -1, -1, 0, 1, 1, 1};
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        Data[][] map = new Data[4][4];
        for (int i = 0; i < 4; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 4; j++) {
                int num = Integer.parseInt(st.nextToken());
                int dir = Integer.parseInt(st.nextToken()) - 1;
                map[i][j] = new Data(num, dir);
            }
        }

        // 상어가 (0,0)의 물고기 먹고 시작
        Data first = map[0][0];
        int sum = first.num;
        int initDir = first.dir;

        map[0][0] = null; // 상어가 먹음 → 빈칸 처리
        dfs(map, 0, 0, initDir, sum);

        System.out.println(answer);
    }

    static void dfs(Data[][] map, int sx, int sy, int sDir, int total) {
        answer = Math.max(answer, total);

        // 1️⃣ 물고기 이동
        moveFishes(map, sx, sy);

        // 2️⃣ 상어 이동 (1~3칸)
        for (int step = 1; step <= 3; step++) {
            int nx = sx + dx[sDir] * step;
            int ny = sy + dy[sDir] * step;

            if (!check(nx, ny)) break;
            if (map[nx][ny] == null) continue;

            Data[][] newMap = deepCopy(map);
            int eaten = newMap[nx][ny].num;
            int newDir = newMap[nx][ny].dir;

            // 상어가 이동해서 먹음
            newMap[sx][sy] = null;
            newMap[nx][ny] = null;

            dfs(newMap, nx, ny, newDir, total + eaten);
        }
    }

    static void moveFishes(Data[][] map, int sx, int sy) {
        for (int num = 1; num <= 16; num++) {
            int fx = -1, fy = -1;

            // 현재 번호 물고기 위치 찾기
            find:
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    if (map[i][j] != null && map[i][j].num == num) {
                        fx = i;
                        fy = j;
                        break find;
                    }
                }
            }

            if (fx == -1) continue; // 이미 먹힌 물고기

            int dir = map[fx][fy].dir;
            for (int d = 0; d < 8; d++) {
                int nd = (dir + d) % 8;
                int nx = fx + dx[nd];
                int ny = fy + dy[nd];

                if (!check(nx, ny)) continue;
                if (nx == sx && ny == sy) continue; // 상어가 있는 칸은 이동 불가

                // 스왑 or 이동
                Data temp = map[nx][ny];
                map[nx][ny] = new Data(map[fx][fy].num, nd);
                map[fx][fy] = (temp == null) ? null : new Data(temp.num, temp.dir);
                break;
            }
        }
    }

    static boolean check(int x, int y) {
        return 0 <= x && x < 4 && 0 <= y && y < 4;
    }

    static Data[][] deepCopy(Data[][] src) {
        Data[][] copy = new Data[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (src[i][j] != null) {
                    Data d = src[i][j];
                    copy[i][j] = new Data(d.num, d.dir);
                }
            }
        }
        return copy;
    }

    static class Data {
        int num, dir;

        public Data(int num, int dir) {
            this.num = num;
            this.dir = dir;
        }
    }
}