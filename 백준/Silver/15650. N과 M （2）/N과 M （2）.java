import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int n, m;
    static int[] a;
    static boolean[] visited;
    static int[] ret;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        a = new int[n];
        for(int i = 0; i < n; i++){
            a[i] = i + 1;
        }
        visited = new boolean[n];
        ret = new int[m];
        combi(0, 0);
        System.out.println(sb);
    }
    static void combi(int depth, int start){
        if(depth == m){
            for(int i = 0; i < m; i++){
                sb.append(ret[i] + " ");
            }
            sb.append("\n");
            return;
        }
        for(int i = start; i < n; i++){
            ret[depth] = a[i];
            combi(depth + 1, i + 1);
        }
    }
}