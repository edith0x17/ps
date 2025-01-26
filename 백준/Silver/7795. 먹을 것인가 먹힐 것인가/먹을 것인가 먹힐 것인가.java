import java.io.*;
import java.util.*;

public class Main{
    static int t, n, m;
    static int [] a, b;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            int answer = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            a = new int[n];
            b = new int[m];
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < n; i++){
                a[i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < m; i++){
                b[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(b);
            for(int i = 0; i < n; i++){
                int cnt = 0;
                int left = 0, right = m - 1;
                while(left <= right){
                    int mid = (left + right)/ 2;
                    if(a[i] <= b[mid]){// => 더 작게 시도
                        right = mid - 1;
                    }else{// a[i] > b[mid] => 더 크게 시도
                        cnt = mid + 1;
                        left = mid + 1;
                    }
                }
                answer += cnt;
            }
            System.out.println(answer);
        }
    }
}