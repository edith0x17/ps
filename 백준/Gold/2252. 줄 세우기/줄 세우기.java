import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int[] ind = new int[32004];
    static ArrayList<Integer>[] adj;
    static Queue<Integer> q = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        adj = new ArrayList[n + 4]; // 리스트
        for (int i = 0; i < n + 4; i++) { // 리스트 안에 리스트
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int f = Integer.parseInt(st.nextToken());

            adj[t].add(f);
            ind[f]++;
        }

        for (int i = 1; i <= n; i++) {
            if (ind[i] == 0) q.add(i);
        }

        while (!q.isEmpty()) {
            int nowNode = q.poll(); // front, pop
            System.out.printf("%d ", nowNode);
            for (int nextNode : adj[nowNode]) {
                ind[nextNode]--;

                if (ind[nextNode] == 0) {
                    q.add(nextNode);
                }
            }
        }

    }
}