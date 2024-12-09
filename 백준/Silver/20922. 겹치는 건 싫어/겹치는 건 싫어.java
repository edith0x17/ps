import java.io.*;
import java.util.*;

public class Main{
    static int n, k, answer;
    static int[] a, cnt;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        a = new int[n];
        cnt = new int[100_001];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            a[i] = Integer.parseInt(st.nextToken());
        }
        int start = 0, end = 0;
        while(start < n && end < n){// 둘 다 만족
            if(cnt[a[end]] < k){
                cnt[a[end]]++;
                end++;
                answer = Math.max(answer, end - start);// 업데이트
            }else{
                cnt[a[start]]--;
                start++;
            }
        }
        System.out.println(answer);
    }
}