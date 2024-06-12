import java.io.*;

public class Main{
    static class Data{
        int x;
        int y;

        public Data(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy= {0, 1, 0, -1};
    static StringBuilder sb = new StringBuilder();
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int n, ret1, ret2;
    static int[][] a, visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        a = new int[n][n];
        visited = new int[n][n];

        for(int i = 0; i < n; i++){
            String s = br.readLine();
            for(int j = 0; j < n; j++){
                if(s.charAt(j) == 'R')a[i][j] = 3;
                else if(s.charAt(j) == 'G')a[i][j] = 2;
                else if(s.charAt(j) == 'B')a[i][j] = 1;
            }
        }

        // 정상
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(visited[i][j] == 0){ // 방문 X -> dfs()
                    ret1++;
                    dfs(i, j, a[i][j]);
                }
            }
        }

        // ...
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(a[i][j] == 3)a[i][j] = 2;
            }
        }
        // 초기화
        visited = new int[n][n];

        // 적록색맹
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(visited[i][j] == 0){ // 방문 X -> dfs()
                    ret2++;
                    dfs(i, j, a[i][j]);
                }
            }
        }

        sb.append(ret1 + " " + ret2);

        bw.write(sb + "");
        bw.flush();
        bw.close();
    }

    static void dfs(int x, int y, int value){
        visited[x][y] = 1;

        for(int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx < 0 || nx >= n || ny < 0 || ny >= n || visited[nx][ny] != 0)continue; // 범위 || 방문

            if(a[nx][ny] == value){
                dfs(nx, ny, value);
            }
        }
    }
}