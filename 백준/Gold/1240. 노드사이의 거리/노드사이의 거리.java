import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static ArrayList<Data>[] adj;
    static boolean[] visited;
    static int s, e, answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        adj = new ArrayList[n + 1];
        for(int i = 0; i < n + 1; i++){
            adj[i] = new ArrayList<>();
        }
        for(int i = 0; i < n - 1; i++){
            st = new StringTokenizer(br.readLine());
            int f = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            adj[f].add(new Data(t, d));
            adj[t].add(new Data(f, d));
        }
        for(int i = 0; i < m; i++){
            visited = new boolean[n + 1];
            st = new StringTokenizer(br.readLine());
            s = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());
            dfs(s, 0);
            System.out.println(answer);
        }
    }
    static void dfs(int here, int ret){
        visited[here] = true;
        for(Data there: adj[here]){
            if(visited[there.to])continue;
            if(there.to == e){
                answer = ret + there.distance;
                return;
            }
            dfs(there.to, ret + there.distance);
        }
    }
    static class Data{
        int to, distance;
        public Data(int to, int distance) {
            this.to = to;
            this.distance = distance;
        }
    }
}