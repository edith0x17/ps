import java.io.*;
import java.util.StringTokenizer;

public class Main{

    static int k;
    static int[] S, ret;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            k  = Integer.parseInt(st.nextToken());
            if(k == 0)break;
            S = new int[k + 4];
            ret = new int[6];

            for(int i = 0; i < k; i++){
                S[i] = Integer.parseInt(st.nextToken());
            }

            combi(0, 0);
            bw.write("\n");
        }

        bw.flush();
        bw.close();
    }

    static void combi(int depth, int start) throws IOException{
        if(depth == 6){
            print();
            return;
        }

        for(int i = start; i < k; i++){
            ret[depth] = S[i];
            combi(depth + 1, i + 1);
            //
        }
    }

    static void print() throws IOException{
        for(int i = 0; i < 6; i++){
            bw.write(ret[i] + " ");
        }
        bw.write("\n");
    }
}