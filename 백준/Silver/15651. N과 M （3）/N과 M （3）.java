import java.io.*;
import java.util.StringTokenizer;

public class Main{

    static int n, m;
    static int[] a, ret;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        a = new int[n + 4];
        ret = new int[m + 4];

        for(int i = 0; i < n; i++){
            a[i] = i + 1;
        }

        go(0);

        bw.flush();
        bw.close();
    }

    static void go(int depth) throws IOException{
        if(depth == m){
            print();
            return;
        }

        for(int i = 0; i < n; i++){
            ret[depth] = a[i];

            go(depth + 1);

            //
        }
    }

    static void print() throws IOException {
        for(int i = 0; i < m; i++){
            bw.write(ret[i] + " ");
        }
        bw.write("\n");
    }
}