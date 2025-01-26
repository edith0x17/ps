import java.io.*;
import java.util.*;

public class Main{
    static int m, n, sum, answer;
    static int[] arr;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        int left = 1, right = arr[n - 1];
        while(left <= right){
            int mid = (left + right)/ 2;

            int cnt = 0;
            for(int i = 0 ; i < n; i++)cnt += arr[i]/ mid;

            if(m <= cnt){
                answer = mid;
                left = mid + 1;
            }else{// m > sum
                right = mid - 1;
            }
        }
        System.out.println(answer);
    }
}