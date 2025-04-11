import java.io.*;
import java.util.*;

public class Main {
    static int f, s, g, u, d;
    static int[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        f = Integer.parseInt(st.nextToken());
        visited = new int[f + 1];
        s = Integer.parseInt(st.nextToken());
        g = Integer.parseInt(st.nextToken());
        u = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        Queue<Integer> q = new ArrayDeque<>();
        visited[s] = 1;
        q.offer(s);
        while(!q.isEmpty()){
            int here = q.poll();

            if(here == g)break;

            for(int there: new int[]{here + u, here - d}){
                if(there < 1 || there > f)continue; // 범위
                if(visited[there] != 0)continue; // 방문
                visited[there] = visited[here] + 1;
                q.offer(there);
            }
        }
        if(visited[g] != 0) System.out.println(visited[g] - 1);
        else System.out.println("use the stairs");
    }
}