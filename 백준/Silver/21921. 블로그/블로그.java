import java.io.*;
import java.util.*;

public class Main{
    static int n, x;
    static int[] arr;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        arr = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int sum = 0;
        for(int i = 0; i< x; i++){
            sum += arr[i];
        }
        int mx = sum, cnt = 1;
        for(int i = x; i < n; i++){
            sum += arr[i] - arr[i - x];
            if(mx == sum)cnt++;
            if(mx < sum){
                mx = sum;
                cnt = 1;
            }
        }
        if(mx == 0){
            System.out.println("SAD");
        }else{
            System.out.println(mx);
            System.out.println(cnt);
        }
    }
}