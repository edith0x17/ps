import java.io.*;
import java.util.*;

public class Main{
    static StringBuilder sb = new StringBuilder();
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int n, m, v;
    static ArrayList<Integer>[] adj;
    static int[] visited1, visited2;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());

        adj = new ArrayList[n + 4];
        for(int i = 0; i < n + 4; i++){
            adj[i] = new ArrayList<>();
        }

        visited1 = new int[n + 4];
        visited2 = new int[n + 4];

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            adj[a].add(b);
            adj[b].add(a);
        }

        for(int i = 0; i < n + 4; i++){
            Collections.sort(adj[i]);
        }

        dfs(v);
        sb.append("\n");
        bfs(v);

        bw.write(sb + "");
        bw.flush();
        bw.close();
    }

    static void dfs(int here){
        visited1[here] = 1;
        sb.append(here + " ");

        for(int there: adj[here]){
            if(visited1[there] != 0)continue;
            dfs(there);
        }
    }

    static void bfs(int here){
        Queue<Integer> q = new ArrayDeque<>();

        visited2[here] = 1;
        sb.append(here + " ");

        q.offer(here);
        while(!q.isEmpty()){
            int tempHere = q.poll();

            for(int there: adj[tempHere]){
                if(visited2[there] != 0)continue;

                visited2[there] = visited2[tempHere] + 1;
                sb.append(there + " ");

                q.offer(there);
            }
        }
    }
}