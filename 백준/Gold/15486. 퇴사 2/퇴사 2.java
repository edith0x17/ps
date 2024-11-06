import java.io.*;
import java.util.*;

public class Main{
    static StringBuilder sb = new StringBuilder();
    static int n;
    static int[] t, p, dp;
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        t = new int[n + 4];
        p = new int[n + 4];
        dp = new int[n + 4];
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            t[i] = Integer.parseInt(st.nextToken());
            p[i] = Integer.parseInt(st.nextToken());
        }
        for(int i = 0; i < n; i++){
            if(i + t[i] <= n){
                dp[i + t[i]] = Math.max(dp[i + t[i]], dp[i] + p[i]);// 전, 현재
            }
            dp[i + 1] = Math.max(dp[i +1], dp[i]);
        }
        sb.append(dp[n]);
        System.out.println(sb);
    }
}