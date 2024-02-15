import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

    static int n;
    static int[] customerX;
    static int[] customerY;
    static boolean[] visited;
    static int d = 987654321;
    static int homeX, homeY, companyX, companyY;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= t; tc++) {
            d = 987654321;

            n = Integer.parseInt(br.readLine());
            customerX = new int[n];
            customerY = new int[n];
            visited = new boolean[n];

            StringTokenizer st = new StringTokenizer(br.readLine());
            companyX = Integer.parseInt(st.nextToken());
            companyY = Integer.parseInt(st.nextToken());
            homeX = Integer.parseInt(st.nextToken());
            homeY = Integer.parseInt(st.nextToken());

            for (int i = 0; i < n; i++) {
                customerX[i] = Integer.parseInt(st.nextToken());
                customerY[i] = Integer.parseInt(st.nextToken());
            }

            go(0, 0, companyX, companyY);

            System.out.println("#" + tc + " " + d);
        }
    }

    static void go(int idx, int sum, int x, int y) {

        if (idx == n) {
            sum += Math.abs(x - homeX) + Math.abs(y - homeY);

            d = Math.min(d, sum);
            return;
        }

        for (int i = 0; i < n; i++) {

            if (!visited[i]) {
                int oriX = x;
                int oriY = y;

                visited[i] = true;
                sum += Math.abs(x - customerX[i]) + Math.abs(y - customerY[i]);
                x = customerX[i];
                y = customerY[i];

                go(idx + 1, sum, x, y);

                x = oriX;
                y = oriY;
                sum -= (Math.abs(x - customerX[i]) + Math.abs(y - customerY[i]));
                visited[i] = false;
            }
        }
    }
}