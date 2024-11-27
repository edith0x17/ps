import java.io.*;
import java.util.*;

public class Main {
    static int n, m, answer;
    static int[] a;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        a = new int[n + 4];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int mx = -1;
        for(int i = 0; i < n; i++){
            a[i] = Integer.parseInt(st.nextToken());
            mx = Math.max(mx, a[i]);
        }
        m = Integer.parseInt(br.readLine());
        int l = 0, r = mx;
        while(l <= r){
            int mid = (l + r)/ 2;// mid == 상한액
            long sum = 0;
            for(int i = 0; i < n; i++){
                if(a[i] <= mid)sum += a[i];
                else sum += mid;
            }
            if(m >= sum){
                answer = mid;
                l = mid + 1;
            }else{// m < sum
                r = mid - 1;
            }
        }
        System.out.println(answer);
    }
}