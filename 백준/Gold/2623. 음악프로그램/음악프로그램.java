import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n, m, cnt;
    static int[] ind = new int[1004];
    static ArrayList<Integer>[] adj;
    static ArrayList<Integer> ret = new ArrayList<>();
    static Queue<Integer> q = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        // 인접 리스트
        adj = new ArrayList[n + 4]; // 리스트
        for (int i = 0; i < n + 4; i++) { // 리스트 안에 리스트
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int k = Integer.parseInt(st.nextToken());
            int prev = Integer.parseInt(st.nextToken());
            for (int j = 1; j < k; j++) {
                int singer = Integer.parseInt(st.nextToken());
               adj[prev].add(singer);
                ind[singer]++;

                prev = singer;
            }
        }

        for (int i = 1; i <= n; i++) {
            if (ind[i] == 0) q.add(i); // indegree == 0거 q에 넣기
        }

        while (!q.isEmpty()) {
            int nowNode = q.poll(); // front, pop
            ret.add(nowNode);

            for (int nextNode : adj[nowNode]) {
                ind[nextNode]--; // indegree--

                if (ind[nextNode] == 0) {
                    q.add(nextNode);// indegree == 0거 q에 넣기
                }
            }
        }

        if (ret.size() != n) {
            System.out.println(0);
        } else {
            for (int i : ret)
                System.out.println(i);
        }

    }
}