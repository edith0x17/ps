import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main{
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int n;
    static int[][] a;
    static boolean[][] visited;
    static ArrayList<Integer> arrayList = new ArrayList<>();
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());

        a = new int[n + 4][n + 4];
        visited = new boolean[n + 4][n + 4];

        for(int i = 0; i < n; i++){
            String s = br.readLine();
            for(int j = 0; j < s.length(); j++){
                a[i][j] = Integer.parseInt(String.valueOf(s.charAt(j))); // String.valueOf => 문자열
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(a[i][j] == 1 && !visited[i][j]){ // 집 O && 방문 X
                    int temp = dfs(i, j);
                    arrayList .add(temp);
                }
            }
        }

        Collections.sort(arrayList);

        sb.append(arrayList.size()).append('\n');
        for(int i: arrayList){
            sb.append(i).append('\n');
        }
        System.out.println(sb);
    }

    static int dfs(int x, int y){
        int ret = 1;
        visited[x][y] = true;

        for(int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx < 0 || nx >= n | ny < 0 || ny >= n)continue; // 범위

            if(a[nx][ny] == 1 && !visited[nx][ny]){ // 집 O && 방문 X
                ret += dfs(nx, ny);
            }

        }

        return ret;
    }
}