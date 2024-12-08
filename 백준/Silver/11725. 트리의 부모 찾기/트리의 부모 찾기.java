import java.io.*;
import java.util.*;

public class Main{
    static int n;
    static ArrayList<Integer>[] adj;
    static boolean[] visited;
    static int[] answer;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        n = Integer.parseInt(br.readLine());
        adj = new ArrayList[n + 1];
        for(int i = 0; i < n + 1; i++){
            adj[i] = new ArrayList<>();
        }
        visited = new boolean[n + 1];
        answer = new int[n + 1];
        for(int i = 0; i < n - 1; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adj[a].add(b);
            adj[b].add(a);
        }
        Queue<Integer> q = new ArrayDeque<>();
        visited[1] = true;// visited
        q.offer(1);// push
        // logic
        while(!q.isEmpty()){
            int here = q.poll();
            for(int there: adj[here]){
                if(visited[there])continue;
                visited[there] = true;// visited
                q.offer(there);// push
                answer[there] = here;// logic
            }
        }
        for(int i = 2; i < n + 1; i++){
            System.out.println(answer[i]);
        }
    }
}