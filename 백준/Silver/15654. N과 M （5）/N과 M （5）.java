import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
    static int n, m;
    static int[] a, ret;
    static boolean[] visited;
    static BufferedWriter bw = new BufferedWriter (new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        a = new int[n];
        ret = new int[m];

        visited = new boolean[n];

        st= new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            a[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(a);

        dfs(0);

        bw.flush();

        br.close();
        bw.close();
    }

    static void dfs(int depth) throws IOException{
        if(depth == m){
            for(int i: ret){
                bw.write(i + " ");
            }
            bw.write("\n");
            return;
        }

        for(int i = 0; i < n; i++){
            if(!visited[i]){
                visited[i] = true; // 중복순열시 제거
                ret[depth] = a[i];

                dfs(depth + 1);

                // ret[depth] = 0
                visited[i] = false; // 중복순열시 제거
            }
        }
    }
}