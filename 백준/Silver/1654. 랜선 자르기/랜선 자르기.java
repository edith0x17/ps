import java.io.*;
import java.util.*;

public class Main{
    static int n, k;
    static int[] a;
    static long l = 1, r, answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        k = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        a = new int[k + 4];
        for(int i = 0; i < k; i++){
            a[i] = Integer.parseInt(br.readLine());
            r = Math.max(r, a[i]);
        }
        while(l <= r){
            long mid = (l + r)/ 2;// mid는 현재 길이
            int cnt = 0;
            for(int i = 0; i < k; i++){
                if(a[i] == 0)continue;
                cnt += a[i]/ mid;
            }
            if(cnt >= n){// 더 크게, ex)100/ 100
                answer = mid;
                l = mid + 1;
            }else{// 더 작게, ex)100/ 50
                r = mid - 1;
            }
        }
        System.out.println(answer);
    }
}