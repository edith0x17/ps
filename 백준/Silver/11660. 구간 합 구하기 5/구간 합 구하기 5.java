import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

//F[x][y] = F[x - 1][y] + F[x][y - 1] + MAP[x][y] - F[x - 1][y - 1]
// F[xx][yy] - F[xx][y - 1] - F[x - 1][yy] + F[x - 1][y - 1]
public class Main{
    static int n, m;
    static int[][] a, d;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());


        a = new int[n + 4][n + 4];
        d = new int[n + 4][n + 4];

        // a 완성
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                a[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // d 완성
        for(int x = 1; x <= n; x++){
            for(int y = 1; y <= n; y++){
                d[x][y] = d[x - 1][y] + d[x][y - 1] + a[x][y] - d[x - 1][y - 1];
            }
        }


//        System.out.println(Arrays.toString(a));

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());

            int x1, y1, x2, y2;

            x1 = Integer.parseInt(st.nextToken());
            y1 = Integer.parseInt(st.nextToken());

            x2 = Integer.parseInt(st.nextToken());
            y2 = Integer.parseInt(st.nextToken());

            go(x1, y1, x2, y2);
        }
    }

    static void go(int x1, int y1, int x2, int y2){
        StringBuilder sb = new StringBuilder();

        int ret =  d[x2][y2] - d[x2][y1 - 1] - d[x1 - 1][y2] + d[x1 - 1][y1 - 1];

        System.out.println(ret);
    }

}