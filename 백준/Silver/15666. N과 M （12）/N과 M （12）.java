import java.io.*;
import java.util.*;

public class Main{
    static StringBuilder sb = new StringBuilder();
    static int n, m;
    static int[] arr, ret;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];
        ret = new int[m];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        combi(0, 0);
        System.out.println(sb);
    }
    static void combi(int depth, int start){
        if(depth == m){
            for(int j: ret){
                sb.append(j + " ");
            }
            sb.append("\n");
            return;
        }

        int prev = 0;
        for(int i = start; i < n; i++){
            if(prev != arr[i]){
                ret[depth] = arr[i];
                prev = arr[i];
                combi(depth + 1, i);
            }
        }
    }
}
