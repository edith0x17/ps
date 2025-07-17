import java.io.*;
import java.util.*;

public class Main {
    static final int[] dx = {-1, 0, 1, 0};
    static final int[] dy = {0, 1, 0, -1};
    static int r, c, swanX, swanY, day;
    static int[][] a;
    static boolean[][] visitedSwan, visitedWater;
    static Queue<Data> swanQ = new ArrayDeque<>(), swanTempQ = new ArrayDeque<>(), waterQ = new ArrayDeque<>(), waterTempQ = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        a = new int[r][c];
        visitedSwan = new boolean[r][c];
        visitedWater = new boolean[r][c];
        for (int i = 0; i < r; i++) {
            String s = br.readLine();
            for (int j = 0; j < c; j++) {
                if (s.charAt(j) == '.') { // 물
                    visitedWater[i][j] = true;
                    waterQ.offer(new Data(i, j));
                    a[i][j] = 0;
                }
                if (s.charAt(j) == 'L') { // 백조(물)
                    swanX = i;
                    swanY = j;
                    a[i][j] = 2;
                    visitedWater[i][j] = true;
                    waterQ.offer(new Data(i, j));
                } else if (s.charAt(j) == 'X') { // 빙판 공간
                    a[i][j] = 1;
                }
            }
        }
        visitedSwan[swanX][swanY] = true;
        swanQ.offer(new Data(swanX, swanY));
        while (true) {
            if (moveSwan()) break;
            waterMelt();
            swanQ = swanTempQ;
            waterQ = waterTempQ;
            swanTempQ = new ArrayDeque<>();
            waterTempQ = new ArrayDeque<>();
            day++;
        }
        System.out.println(day);
    }

    static void waterMelt() {
        while (!waterQ.isEmpty()) {
            Data now = waterQ.poll();
            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                if (nx < 0 || nx >= r || ny < 0 || ny >= c || visitedWater[nx][ny]) continue; // 범위 || 방문
                if (a[nx][ny] == 1) {
                    visitedWater[nx][ny] = true;
                    waterTempQ.offer(new Data(nx, ny));
                    a[nx][ny] = 0;
                }
            }
        }
    }

    static boolean moveSwan() {
        while (!swanQ.isEmpty()) {
            Data now = swanQ.poll();
            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                if (nx < 0 || nx >= r || ny < 0 || ny >= c || visitedSwan[nx][ny]) continue; // 범위 || 방문
                visitedSwan[nx][ny] = true;
                if (a[nx][ny] == 0) swanQ.offer(new Data(nx, ny));
                else if (a[nx][ny] == 1) swanTempQ.offer(new Data(nx, ny));
                else if (a[nx][ny] == 2) return true;
            }
        }
        return false;
    }

    static class Data {
        int x, y;

        public Data(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}