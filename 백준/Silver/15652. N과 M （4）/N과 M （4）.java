import java.io.*;
import java.util.StringTokenizer;

public class Main{
    static int n, m;
    static int[] a, ret;
    static boolean[] visited;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        a = new int[n + 4];
        for(int i = 0; i < n; i++){
            a[i] = i + 1;
        }
        ret = new int[m + 4];
        visited = new boolean[n + 4];

        combi(0, 0);

        bw.flush();
        bw.close();
    }

    static void combi(int depth, int start) throws IOException{
        if(depth == m){
            print();
            return;
        }

        for(int i = start; i < n; i++){
            ret[depth] = a[i];
            combi(depth + 1, i );
            //
        }
    }

    static void print() throws IOException{
        for(int i = 0; i < m; i++){
//            System.out.printf("%d ", ret[i]);
            bw.write(ret[i] + " ");
        }
//        System.out.println();
        bw.write("\n");
    }
}