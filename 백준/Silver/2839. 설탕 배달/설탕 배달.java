import java.io.*;
import java.util.StringTokenizer;

public class Main{

    static StringBuilder sb = new StringBuilder();
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int n, ret;
    static boolean flag;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        while(true){

            if(n < 0){
                ret = -1;
                break;
            }

            if(n % 5 == 0){
                ret += n / 5;
                break;
            }else{
                n = n - 3;
                ret++;
            }
        }

//        if(!flag)ret = -1;

        sb.append(ret);
        bw.write(sb + "");
        bw.flush();
        bw.close();
    }
}