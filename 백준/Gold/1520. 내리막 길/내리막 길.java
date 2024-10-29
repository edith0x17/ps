import java.io.*;
import java.util.StringTokenizer;

public class Main{
    static StringBuilder sb = new StringBuilder();
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int n, m;
    static int[][] map, visited;
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n + 4][m + 4];
        visited = new int[n + 4][m + 4];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                visited[i][j] = -1;
            }
        }
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        sb.append(dfs(0, 0));
        bw.write(sb + "");
        bw.flush();
        bw.close();
    }
    static int dfs(int x, int y){
        if(x == n - 1 && y == m - 1)return 1;
        if(visited[x][y] != -1)return visited[x][y];
        visited[x][y] = 0;
        for(int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx < 0 || nx >= n || ny < 0 || ny >= m)continue;
            if(map[x][y] > map[nx][ny]){
                visited[x][y] += dfs(nx, ny);
            }
        }
        return visited[x][y];
    }
}