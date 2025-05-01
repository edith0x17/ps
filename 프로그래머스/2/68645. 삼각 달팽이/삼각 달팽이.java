import java.io .*;
import java.util .*;

class Solution {
    // 하, 우, 상좌
    static final int[] dx = {1, 0, -1};
    static final int[] dy = {0, 1, -1};
    static int[][] a;

    public int[] solution(int n) {
        int cnt = 0;
        a = new int[n][];
        for (int i = 0; i < n; i++) {
            a[i] = new int[i + 1];
            cnt += i + 1;
        }
        int num = 1;
        int x = 0, y = 0, dir = 0;
        while (num <= cnt) {
            a[x][y] = num++;
            int nx = x + dx[dir];
            int ny = y + dy[dir];
            if (nx < 0 || nx >= n || ny < 0 || ny >= a[nx].length || a[nx][ny] != 0) {// 범위 밖이면
                dir = (dir + 1) % 3;
                nx = x + dx[dir];
                ny = y + dy[dir];
            }
            x = nx;
            y = ny;
        }
        int idx = 0;
        int[] answer = new int[cnt];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < a[i].length; j++) {
                answer[idx++] = a[i][j];
            }
        }
        return answer;
    }
}