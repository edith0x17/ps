import java.awt.font.ShapeGraphicAttribute;
import java.io.*;
import java.util.*;

public class Main{
    static StringBuilder sb = new StringBuilder();
    static int n, m;
    static int[] ind;
    static ArrayList<Integer>[] adj;
    static Queue<Integer> q = new ArrayDeque<>();
    static int[] answer;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        ind = new int[n + 4];
        adj = new ArrayList[n + 4];
        for(int i = 0; i < n + 4; i++){
            adj[i] = new ArrayList<>();
        }
        answer = new int[n + 4];
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int f = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            adj[f].add(t);
            ind[t]++;
        }
        for(int i = 1; i <= n; i++){
            if(ind[i] == 0)q.offer(i);
        }
        int level = 0;
        while(!q.isEmpty()){
            level++;
            int qSize = q.size();
            for(int i = 0; i < qSize; i++){
                int here = q.poll();
//                sb.append("level = " + level + " " + here + "\n");
                answer[here] = level;
                for(int there: adj[here]){
                    ind[there]--;// POINT
                    if(ind[there] == 0)q.offer(there);
                }
            }
        }
        for(int i = 1; i <= n; i++){
            sb.append(answer[i] + " ");
        }
        System.out.println(sb);
    }
}