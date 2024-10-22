import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.*;
import java.util.*;

public class Main{
    static StringBuilder sb = new StringBuilder();
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[][] map, dp;
    static int mx = -1, mi = Integer.MAX_VALUE;
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int n = Integer.parseInt(br.readLine());
        map = new int[n + 1][3];
        dp = new int[n + 1][3];
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 3; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i = 0; i < 3; i++){
            dp[0][i] = map[0][i];
        }
        for(int i = 1; i < n; i++){
            for(int j = 0; j < 3; j++){
                if(j ==0){
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j + 1]) + map[i][j];
                }else if(j == 2){
                    dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + map[i][j];
                }else{// j == 1
                    dp[i][j] = Math.max(Math.max(dp[i - 1][j - 1], dp[i - 1][j]), dp[i - 1][j + 1]) + map[i][j];
                }
            }
        }
        for(int i = 0; i < 3; i++){
            mx = Math.max(mx, dp[n - 1][i]);
        }

        dp = new int[n + 1][3];
        for(int i = 0; i < 3; i++){
            dp[0][i] = map[0][i];
        }
        for(int i = 1; i < n; i++){
            for(int j = 0; j < 3; j++){
                if(j ==0){
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j + 1]) + map[i][j];
                }else if(j == 2){
                    dp[i][j] = Math.min(dp[i - 1][j - 1], dp[i - 1][j]) + map[i][j];
                }else{
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i - 1][j]), dp[i - 1][j + 1]) + map[i][j];
                }
            }
        }
        for(int i = 0; i < 3; i++){
            mi = Math.min(mi, dp[n - 1][i]);
        }
        sb.append(mx + " " + mi);
        bw.write(sb + "");
        bw.flush();
        bw.close();
    }
}