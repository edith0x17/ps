import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main{

    static int n, m, cnt;
    static ArrayList<Integer>[] adj;
    static int[] visited;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        adj = new ArrayList[n + 1];
        for (int i = 0; i < n + 1; i++) {
            adj[i] = new ArrayList<>();
        }
        visited = new int[n + 1];

        for(int i = 0; i < m; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int f = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());

            adj[f].add(t);
            adj[t].add(f);
        }

        dfs(1);

        System.out.println(cnt);
    }

    static void dfs(int here){
        visited[here] = 1;
        for(int there: adj[here]){

            if(visited[there] == 0){ // 방문하지 않았으면...
                cnt++;
                dfs(there);
            }
        }
    }
}