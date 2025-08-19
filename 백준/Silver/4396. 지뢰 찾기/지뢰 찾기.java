import java.io.*;
import java.util.*;

public class Main {
    static final int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static final int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
    static int n;
    static char[][] oriMap, map, answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        oriMap = new char[n][n];
        map = new char[n][n];
        answer = new char[n][n];

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < n; j++) oriMap[i][j] = s.charAt(j);
        }
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < n; j++) map[i][j] = s.charAt(j);
        }
        for (int i = 0; i < n; i++) Arrays.fill(answer[i], '.');

        boolean hitMine = false;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 'x') { //열린 칸
                    if (oriMap[i][j] == '*') { //지뢰O
                        hitMine = true;
                    } else { //지뢰X
                        int cnt = 0;
                        for (int d = 0; d < 8; d++) {
                            int nx = i + dx[d], ny = j + dy[d];
                            if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                            if (oriMap[nx][ny] == '*') cnt++;
                        }
                        answer[i][j] = (char) ('0' + cnt);
                    }
                } //열리지 않은 칸
            }
        }
        if (hitMine) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (oriMap[i][j] == '*') answer[i][j] = '*';
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(answer[i]).append('\n');
        }
        System.out.print(sb.toString());
    }
}