import java.io.*;
import java.util.*;
public class Main{
    static int n, m, l, r, answer = Integer.MAX_VALUE;
    static int[] a;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        a = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            a[i] = Integer.parseInt(st.nextToken());
            l = Math.max(l, a[i]);
            r += a[i];
        }
        while(l <= r){
            int mid = (l + r)/ 2;// 시간
            int sum = a[0], cnt = 1;// 마지막 구간 반영
            for(int i = 1; i < n; i++){
                if(sum + a[i] > mid){
                    cnt++;
                    sum = a[i];
                }else{// sum + a[i] <= mid
                    sum += a[i];
                }
            }
            if(cnt > m){
                l = mid + 1;
            }else{// cnt <= m
                answer = Math.min(answer, mid);
                r = mid - 1;
            }
        }
        sb.append(answer);
        bw.write(sb + "");
        bw.flush();
        bw.close();
    }
}