import java.io.*;
import java.util.*;

public class Main {
    static int[][] gear = new int[4][8];
    static int k, a, b;
    static int[] dir;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        for (int i = 0; i < 4; i++) {
            String s = br.readLine();
            for (int j = 0; j < 8; j++) {
                gear[i][j] = s.charAt(j) - '0';
            }
        }
        k = Integer.parseInt(br.readLine());
        while (k-- > 0) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken()) - 1;
            b = Integer.parseInt(st.nextToken());
            dir = new int[4];
            dir[a] = b;
            //왼
            for (int i = a; i >= 1; i--) {
                if (gear[i][6] != gear[i - 1][2]) {
                    dir[i - 1] = -dir[i];
                } else {
                    break;
                }
            }
            //오
            for (int i = a; i <= 2; i++) {
                if (gear[i][2] != gear[i + 1][6]) {
                    dir[i + 1] = -dir[i];
                } else {
                    break;
                }
            }
            //회전
            for (int i = 0; i < 4; i++) {
                if (dir[i] != 0) rotate(i, dir[i]);
            }
        }
        int ans = 0;
        if (gear[0][0] == 1) ans += 1;
        if (gear[1][0] == 1) ans += 2;
        if (gear[2][0] == 1) ans += 4;
        if (gear[3][0] == 1) ans += 8;
        System.out.println(ans);
    }

    static void rotate(int i, int dir) {
        if (dir == 1) {//시계
            int tmp = gear[i][7];
            gear[i][7] = gear[i][6];
            gear[i][6] = gear[i][5];
            gear[i][5] = gear[i][4];
            gear[i][4] = gear[i][3];
            gear[i][3] = gear[i][2];
            gear[i][2] = gear[i][1];
            gear[i][1] = gear[i][0];
            gear[i][0] = tmp;
        } else if (dir == -1) {//반시계
            int tmp = gear[i][0];
            gear[i][0] = gear[i][1];
            gear[i][1] = gear[i][2];
            gear[i][2] = gear[i][3];
            gear[i][3] = gear[i][4];
            gear[i][4] = gear[i][5];
            gear[i][5] = gear[i][6];
            gear[i][6] = gear[i][7];
            gear[i][7] = tmp;
        }
    }
}