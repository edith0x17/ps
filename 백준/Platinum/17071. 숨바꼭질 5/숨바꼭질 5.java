import java.io.*;
import java.util.*;

public class Main {
    static final int max = 500_000;
    static int n, k, turn = 1;
    static Queue<Integer> q = new ArrayDeque<>();
    static int[][] visited = new int[2][max + 4];
    static boolean flag;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        if (n == k) { // 조건1
            System.out.println(0);
            return;
        }

        visited[0][n] = 1;
        q.offer(n);
        while (!q.isEmpty()) {
            k += turn;

            if (k > max) break; // 조건2

            if (visited[turn % 2][k] != 0) { // 조건3 먼저 방문
                flag = true;
                break;
            }

            int qSize = q.size();
            for (int i = 0; i < qSize; i++) {
                int now = q.poll();
                for (int next : new int[]{now - 1, now + 1, now * 2}) {
                    if (next < 0 || next > max || visited[turn % 2][next] != 0) continue; // 범위 || 방문
                    visited[turn % 2][next] = visited[(turn + 1) % 2][now] + 1; // 방문

                    if (next == k) { // 조건4 방문
                        flag = true;
                        break;
                    }

                    q.offer(next);
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