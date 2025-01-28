import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n, m;
    static String[] a;
    static int[] b;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        a = new String[n];
        b = new int[n];
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            a[i] = st.nextToken();
            b[i] = Integer.parseInt(st.nextToken());
        }
        for(int i = 0; i < m; i++){
            int check = Integer.parseInt(br.readLine());

            int left = 0, right = n - 1, idx = 0;
            while(left <= right){
                int mid = (left + right)/ 2;
                if(check <= b[mid]){
                    idx = mid;
                    right = mid - 1;
                }else{// check > b[mid]
                    left = mid + 1;
                }
            }
            sb.append(a[idx] + "\n");
        }
        bw.write(sb + "");
        bw.flush();
        bw.close();
    }
}