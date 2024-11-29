import java.io.*;
import java.util.*;

public class Main{
    static int n, m, answer;
    static int[] arr;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int l = 0, r = n - 1;
        while(l < r){
            int hap = arr[l] + arr[r];
            
            if(hap > m)r--;
            else if(hap == m){
                l++; r--;
                answer++;
            }
            else l++;
        }
        System.out.println(answer);
    }
}