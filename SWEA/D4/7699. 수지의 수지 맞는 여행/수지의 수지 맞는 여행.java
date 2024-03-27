import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution{
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int r, c, ret;
    static char[][] a;
    static boolean[] checked;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for(int tc = 1; tc <= t; tc++){
            ret = 0;

            StringTokenizer st = new StringTokenizer(br.readLine());
            r = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            a = new char[r + 4][c + 4];
            checked = new boolean[31];
            for(int i = 0; i < r; i++){
                String s = br.readLine();
                for(int j = 0; j < c; j++){
                    a[i][j] = s.charAt(j);
                }
            }

            checked[a[0][0] - 65] = true;
            dfs(0, 0, 1);
            
            System.out.println("#" + tc + " " + ret);
        }
    }

    static void dfs(int x, int y, int depth){
        if (depth > ret) ret = depth;

        for(int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx < 0 || nx >= r || ny < 0 || ny >= c || checked[a[nx][ny] - 65])continue;

            checked[a[nx][ny] - 65] = true;
            dfs(nx, ny, depth + 1);
            checked[a[nx][ny] - 65] = false;
        }
    }
}