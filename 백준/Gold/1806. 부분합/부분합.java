import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int n, S, answer = Integer.MAX_VALUE;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int left = 0, right = 0, sum = 0;
        while(true){
            if(S <= sum){
                answer = Math.min(answer, right - left);
                sum -= arr[left++];
            }
            else if(right == n)break;
            else sum += arr[right++];
        }
        if(answer == Integer.MAX_VALUE) System.out.println(0);
        else System.out.println(answer);
    }
}