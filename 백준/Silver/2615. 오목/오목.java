import java.io.*;
import java.util.*;

public class Main {
    static int[][] board = new int[19][19];
    static int[] dx = {0, 1, 1, -1};// 오른쪽, 아래, 오른쪽 아래, 오른쪽 위
    static int[] dy = {1, 0, 1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 19; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 19; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int x = 0; x < 19; x++) {
            for (int y = 0; y < 19; y++) {
                if (board[x][y] != 0) { // 바둑알
                    int color = board[x][y];
                    for (int d = 0; d < 4; d++) {// 방향
                        if (isValid(x, y, d, color)) {
                            System.out.println(color);
                            System.out.println((x + 1) + " " + (y + 1));
                            return;
                        }
                    }
                }
            }
        }
        System.out.println(0);
    }

    // 오목 조건을 만족하는지 체크
    static boolean isValid(int x, int y, int dir, int color) {
        // 이전
        int nx = x - dx[dir];
        int ny = y - dy[dir];
        if (inRange(nx, ny) && board[nx][ny] == color) return false;// 범위 && 장애물

        int count = 1;
        for (int i = 1; i < 5; i++) {
            nx = x + dx[dir] * i;
            ny = y + dy[dir] * i;
            if (!inRange(nx, ny)) break;// 범위
            if (board[nx][ny] != color) break;// 장애물
            count++;
        }

        // 이후
        nx = x + dx[dir] * 5;
        ny = y + dy[dir] * 5;
        if (count == 5 && (!inRange(nx, ny) || board[nx][ny] != color)) {// 5개 && (범위 || 장애물)
            return true;
        }
        return false;
    }
    static boolean inRange(int x, int y) {
        return x >= 0 && x < 19 && y >= 0 && y < 19;
    }
}