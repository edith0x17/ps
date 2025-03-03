import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int n, m, k;
    static int[][] a;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        a = new int[n][m];
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                a[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        k = Integer.parseInt(br.readLine());
        while(k-- > 0){
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken()) - 1;
            int y1 = Integer.parseInt(st.nextToken()) - 1;
            int x2 = Integer.parseInt(st.nextToken()) - 1;
            int y2 = Integer.parseInt(st.nextToken()) - 1;
            int sum = 0;
            for(int i = x1; i <= x2; i++){
                for(int j = y1; j <= y2; j++){
                    sum += a[i][j];
                }
            }
            sb.append(sum + "\n");
        }
        System.out.println(sb);
    }
}