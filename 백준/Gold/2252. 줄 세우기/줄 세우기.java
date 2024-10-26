import java.io.*;
import java.util.*;

public class Main {

    static StringBuilder sb = new StringBuilder();
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] ind;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        ArrayList<Integer>[] adj = new ArrayList[n + 1];
        for (int i = 0; i < n + 1; i++) {
            adj[i] = new ArrayList<>();
        }
        ind = new int[n + 1];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int f = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            adj[f].add(t);
            ind[t]++;
        }
        for (int i = 1; i <= n; i++) {
            if (ind[i] == 0) {
                pq.offer(i);
            }
        }
        while (!pq.isEmpty()) {
            int here = pq.poll();
            sb.append(here + " ");

            for (int there : adj[here]) {
                ind[there]--;
                if (ind[there] == 0) {
                    pq.offer(there);
                }
            }
        }
        bw.write(sb + " ");
        bw.flush();
        bw.close();
    }
}