import java.io.*;
import java.util.*;

public class Main {
    static int n, answer = Integer.MIN_VALUE;
    static int[][] a;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        a = new int[n][6];
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 6; j++) {
                a[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < 6; i++) {
            go(1, i, 0);
        }
        System.out.println(answer);
    }

    static void go(int cnt, int bottom, int sum) {
        int top = pair(bottom);
        int tempMax = 0;
        for (int i = 0; i < 6; i++) { //현재 옆면 계산
            if (i == bottom || i == top) continue;
            tempMax = Math.max(tempMax, a[cnt - 1][i]);
        }
        sum += tempMax;

        if (cnt == n) {
            answer = Math.max(answer, sum);
            return;
        }

        for (int i = 0; i < 6; i++) {
            if (a[cnt - 1][top] == a[cnt][i]) { //현재 윗면 == 미래 아래면
                go(cnt + 1, i, sum);
            }
        }
    }

    static int pair(int i) {
        if (i == 0) return 5;
        else if (i == 1) return 3;
        else if (i == 2) return 4;
        else if (i == 3) return 1;
        else if (i == 4) return 2;
        else if (i == 5) return 0;
        return 0;
    }
}