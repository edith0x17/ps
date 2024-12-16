import java.io.*;
import java.util.*;

public class Main {
    static int t;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            bfs(A, B);
        }
    }

    static void bfs(int start, int target) {
        visited = new boolean[10_000];
        
        Queue<Data> q = new ArrayDeque<>();
        visited[start] = true;
        q.offer(new Data(start, ""));
        while (!q.isEmpty()) {
            Data current = q.poll();
            
            int number = current.num;
            if (number == target) {
                System.out.println(current.op);
                return;
            }

            int D = (2 * number) % 10_000;
            if (!visited[D]) {
                visited[D] = true;
                q.offer(new Data(D, current.op + "D"));
            }

            int S = (number == 0) ? 9999 : number - 1;
            if (!visited[S]) {
                visited[S] = true;
                q.offer(new Data(S, current.op + "S"));
            }

            int L = (number % 1000) * 10 + (number / 1000);
            if (!visited[L]) {
                visited[L] = true;
                q.offer(new Data(L, current.op + "L"));
            }

            int R = (number % 10) * 1000 + (number / 10);
            if (!visited[R]) {
                visited[R] = true;
                q.offer(new Data(R, current.op + "R"));
            }
        }
    }

    static class Data {
        int num;
        String op;

        public Data(int num, String op) {
            this.num = num;
            this.op = op;
        }
    }
}