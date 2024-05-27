import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static int[] a, ret;
    static boolean[] visited;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        a = new int[n];
        ret = new int[m];
        visited = new boolean[n];

        for(int i = 0; i < n; i++){
            a[i] = i + 1;
        }

        go(0);

        bw.flush();
        bw.close();
    }

    static void go(int idx) throws IOException {
        if(idx == m){
            print();
            return;
        }

        for(int i = 0; i < n; i++){
            if(!visited[i]){
                visited[i] = true;
                ret[idx] = a[i];

                go(idx + 1);

                visited[i] = false;
            }
        }
    }

    static void print() throws IOException {
        for(int i = 0; i < m; i++){
            bw.write(ret[i] + " ");
        }
        bw.write("\n");
    }
}