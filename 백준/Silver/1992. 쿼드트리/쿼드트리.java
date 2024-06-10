import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int n;
    static int[][] a;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        a = new int[n][n];

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < n; j++) {
                a[i][j] = s.charAt(j) - '0';
            }
        }

        go(n, 0, 0);

        bw.write(sb + "");
        bw.flush();
        bw.close();
    }

    static boolean check(int s, int x, int y) {
        int prev = a[x][y];

        for (int i = x; i < x + s; i++) {
            for (int j = y; j < y + s; j++) {
                if (prev != a[i][j]) return false;
            }
        }
        return true;
    }

    static void go(int s, int x, int y) {
        if (check(s, x, y)) {
            if (a[x][y] == 1) sb.append(1);
            else sb.append(0);

            return;
        }
        sb.append("(");
        int halfS = s / 2;

        go(halfS, x, y);
        go(halfS, x, y + halfS);
        go(halfS, x + halfS, y);
        go(halfS, x + halfS, y + halfS);
        sb.append(")");
    }
}