import java.io.*;
import java.util.*;

public class Main{
    static int n;
    static int[] arr, dp;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n + 1];
        dp = new int[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= i; j++){
                dp[i] = Math.max(dp[i], arr[j] + dp[i - j]);
                // 카드 j개가 들어있는 카드팩을 구매하고, 카드 i-j개를 구입한다
            }
        }
        System.out.println(dp[n]);
    }
}