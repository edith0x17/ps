import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static boolean[][] trains;
    static int op, i, num;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        trains = new boolean[n + 1][24]; //1기준
        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            op = Integer.parseInt(st.nextToken());
            if (op == 1 || op == 2) {
                i = Integer.parseInt(st.nextToken());
                num = Integer.parseInt(st.nextToken());
                if (op == 1) trains[i][num] = true;
                else trains[i][num] = false;
            } else { // op == 3 || op == 4
                i = Integer.parseInt(st.nextToken());
                if (op == 3) {
                    for (int j = 20; j >= 1; j--) {
                        trains[i][j] = trains[i][j - 1];
                    }
                } else {
                    for (int j = 1; j <= 20; j++) {
                        trains[i][j] = trains[i][j + 1];
                    }
                }
            }
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 1; i <= n; i++) {
            int mask = 0;
            for (int j = 1; j <= 20; j++) {
                if (trains[i][j]) mask |= (1 << (j - 1)); //
            }
            set.add(mask);
        }
        System.out.println(set.size());
    }
}