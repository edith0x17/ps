import java.io.*;
import java.util.*;

public class Main{
    static int n, x, answer;
    static int[] a;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        a = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            a[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        x = Integer.parseInt(st.nextToken());
        Arrays.sort(a);
        int l = 0, r = n - 1;
        while(l < r){
            int sum = a[l] + a[r];
            if(x < sum)r--;
            else if(x == sum){
                answer++;
                l++;
                r--;
            }else l++;
        }
        System.out.println(answer);
    }
}