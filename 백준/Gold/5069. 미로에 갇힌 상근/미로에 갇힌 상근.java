import java.io.*;
import java.util.*;

public class Main {

    static int[] dx = {-1, -1, 0, 1, 1, 0};
    static int[] dy = {0, 1, 1, 0, -1, -1};

    static final int SIZE = 31;
    static final int OFFSET = 15;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            long[][][] dp = new long[n + 1][SIZE][SIZE];
            dp[0][OFFSET][OFFSET] = 1;

            for (int step = 0; step < n; step++) {
                for (int x = 0; x < SIZE; x++) {
                    for (int y = 0; y < SIZE; y++) {
                        if (dp[step][x][y] == 0) continue;
                        for (int dir = 0; dir < 6; dir++) {
                            int nx = x + dx[dir];
                            int ny = y + dy[dir];
                            if (nx >= 0 && nx < SIZE && ny >= 0 && ny < SIZE) {//범위
                                dp[step + 1][nx][ny] += dp[step][x][y];
                            }
                        }
                    }
                }
            }
            System.out.println(dp[n][OFFSET][OFFSET]);
        }
    }
}