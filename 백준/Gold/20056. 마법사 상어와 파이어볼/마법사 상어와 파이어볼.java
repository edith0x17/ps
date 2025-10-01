import java.io.*;
import java.util.*;

public class Main {
    static final int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static final int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
    static int n, m, k;
    static ArrayList<FireBall> fireBalls = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()); //m
            int d = Integer.parseInt(st.nextToken()); //s
            int e = Integer.parseInt(st.nextToken()); //d
            fireBalls.add(new FireBall(a, b, c, d, e));
        }

        while (k-- > 0) {
            ArrayList<FireBall>[][] temp = new ArrayList[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    temp[i][j] = new ArrayList<>();
                }
            }

            for (FireBall f : fireBalls) {
                int nx = (f.x + dx[f.d] * f.s % n + n * 1000) % n;
                int ny = (f.y + dy[f.d] * f.s % n + n * 1000) % n;
                temp[nx][ny].add(new FireBall(nx, ny, f.m, f.s, f.d));
            }

            fireBalls = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    int size = temp[i][j].size();
                    if (size == 0) continue;
                    if (size == 1) {
                        fireBalls.add(temp[i][j].get(0));
                    } else {
                        int mSum = 0, sSum = 0;
                        boolean allEven = true;
                        boolean allOdd = true;
                        for (FireBall f : temp[i][j]) {
                            mSum += f.m;
                            sSum += f.s;
                            if (f.d % 2 == 0) allOdd = false; //짝수
                            else allEven = false;
                        }

                        int newM = mSum / 5;
                        if (newM == 0) continue;
                        int newS = sSum / size;
                        int[] dirs = (allEven || allOdd) ? new int[]{0, 2, 4, 6} : new int[]{1, 3, 5, 7};
                        for (int d : dirs) {
                            fireBalls.add(new FireBall(i, j, newM, newS, d));
                        }
                    }
                }
            }
        }
        int answer = 0;
        for (FireBall f : fireBalls) {
            answer += f.m;
        }
        System.out.println(answer);
    }

    static class FireBall {
        int x, y, m, s, d;

        public FireBall(int x, int y, int m, int s, int d) {
            this.x = x;
            this.y = y;
            this.m = m;
            this.s = s;
            this.d = d;
        }
    }
}