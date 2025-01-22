import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main{
    static int dx[] = {-1, 0, 1, 0};
    static int dy[] = {0, 1, 0, -1};
    static int m, n, k;
    static boolean[][] visited;
    static int answer;
    static ArrayList<Integer> adj = new ArrayList<>();
    public static void main(String[] args) throws IOException{
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         StringTokenizer st = new StringTokenizer(br.readLine());
         m = Integer.parseInt(st.nextToken());
         n = Integer.parseInt(st.nextToken());
         k = Integer.parseInt(st.nextToken());
         visited = new boolean[m][n];
         while(k-- > 0){
             st = new StringTokenizer(br.readLine());
             int y1 = Integer.parseInt(st.nextToken());
             int x1 = Integer.parseInt(st.nextToken());
             int y2 = Integer.parseInt(st.nextToken());
             int x2 = Integer.parseInt(st.nextToken());
             for(int i = x1; i < x2; i++){
                 for(int j = y1; j < y2; j++){
                     visited[i][j] = true;
                 }
             }
         }
         for(int i = 0; i < m; i++){
             for(int j = 0; j < n; j++){
                 if(visited[i][j])continue;
                 else{
                     answer++;
                     adj.add(go(i, j));
                 }
             }
         }
         StringBuilder sb = new StringBuilder();
         sb.append(answer + "\n");
         Collections.sort(adj);
         for(int i = 0; i < adj.size(); i++){
            sb.append(adj.get(i) + " ");
         }
        System.out.println(sb);
    }
    static int go(int x, int y){
        int ret = 1;
        visited[x][y] = true;
        for(int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx < 0 || nx >= m || ny < 0 || ny >= n || visited[nx][ny])continue;// 범위 || 방문
            ret += go(nx, ny);
        }
        return ret;
    }
}