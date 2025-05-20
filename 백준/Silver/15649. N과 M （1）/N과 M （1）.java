import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n, m;
    static int[] a, ret;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        a = new int[n];
        ret = new int[m];
        for(int i = 0; i < n; i++){
            a[i] = i + 1;
        }
        visited = new boolean[n];
        go(0);
        bw.write(sb + "");
        bw.flush();
    }
    static void go(int depth){
        if(depth == m){
            for(int i = 0; i < m; i++){
                sb.append(ret[i] + " ");
            }
            sb.append("\n");
            return;
        }
        for(int i = 0; i < n; i++){
            if(visited[i])continue;
            visited[i] = true;
            ret[depth] = a[i];
            go(depth + 1);
            visited[i] = false;
        }
    }
}