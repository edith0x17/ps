import java.util.Arrays;
import java.util.Scanner;

public class Solution{
    final static int[] dx = {0, 1, 0, -1};
    final static int[] dy = {1, 0, -1, 0};

    static int t, tc;
    static int n;
    static  int[][] a;
    static boolean[][] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        t = sc.nextInt();

        for(tc = 1; tc <= t; tc++){
            n = sc.nextInt();

            a = new int[n][n];
            visited = new boolean[n][n];

            System.out.println("#" + tc);

            dfs(0, 0, 0, 0);

        }
    }

    static void dfs(int x, int y, int depth, int dir){ // depth -> n * n
        // 종료
            // 시뮬레이션
        // 실행
        // 재귀호출

        if(depth == n * n){
            print();
            return;
        }

        a[x][y] = depth + 1;
        visited[x][y] = true;

        int nx = x + dx[dir];
        int ny = y + dy[dir];

        if(nx < 0 || nx >= n || ny < 0 || ny >= n || visited[nx][ny]) { // dir 변경
            nx = x + dx[(dir + 1) % 4];
            ny = y + dy[(dir + 1) % 4];
            dfs(nx, ny, depth + 1, (dir + 1) % 4);
        }else{ // dir 변경 X
            dfs(nx, ny, depth + 1, dir);
        }
    }

    static void print(){
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                System.out.printf("%d ", a[i][j]);
            }
            System.out.println();
        }
    }

}