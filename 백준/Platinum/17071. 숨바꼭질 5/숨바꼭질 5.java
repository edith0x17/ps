import java.io.*;
import java.util.*;

public class Main {
    static final int max_n = 500_000;
    static int n, k, turn = 1;
    static int[][] visited = new int[2][max_n + 4];
    static Queue<Integer> q = new ArrayDeque<>();
    static boolean flag;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        if (n == k) {
            System.out.println(0);
            return;
        }

        visited[0][n] = 1;
        q.offer(n);
        while (!q.isEmpty()) {
            k += turn;

            if (k > max_n) break;

            if (visited[turn % 2][k] != 0) {
                flag = true;
                break;
            }

            int qSize = q.size();
            for (int i = 0; i < qSize; i++) {
                int x = q.poll();
                for (int nx : new int[]{x - 1, x + 1, x * 2}) {
                    if (nx < 0 || nx > max_n || visited[turn % 2][nx] != 0) continue; // 범위 || 방문
                    visited[turn % 2][nx] = visited[(turn + 1) % 2][x] + 1; // 현재 <-> 이전

                    if (nx == k) {
                        flag = true;
                        break;
                    }

                    q.offer(nx);
                }
                if (flag) break;
            }
            if (flag) break;
            turn++;
        }
        if (flag) System.out.println(turn);
        else System.out.println(-1);
    }
}