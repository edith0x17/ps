import java.io.*;
import java.util.*;

public class Main {
    static final int INF = Integer.MAX_VALUE;
    static int R, S;
    static char[][] map;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        map = new char[R][S];

        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            for (int j = 0; j < S; j++) map[i][j] = line.charAt(j);
        }
        int[] meteorBottom = new int[S];
        int[] groundTop = new int[S];
        Arrays.fill(meteorBottom, -1);
        Arrays.fill(groundTop, INF);
        for (int c = 0; c < S; c++) {
            for (int r = 0; r < R; r++) {
                if (map[r][c] == 'X') meteorBottom[c] = r;
                if (map[r][c] == '#' && groundTop[c] == INF) groundTop[c] = r;
            }
        }
        int d = INF;
        for (int c = 0; c < S; c++) {
            if (meteorBottom[c] != -1 && groundTop[c] != INF) {
                d = Math.min(d, groundTop[c] - meteorBottom[c] - 1);
            }
        }
        for (int r = R - 1; r >= 0; r--) {
            for (int c = 0; c < S; c++) {
                if (map[r][c] == 'X') {
                    map[r][c] = '.';
                    map[r + d][c] = 'X';
                }
            }
        }
        StringBuilder out = new StringBuilder();
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < S; j++) out.append(map[i][j]);
            out.append('\n');
        }
        System.out.print(out.toString());
    }
}