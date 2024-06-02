import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main{
    static class Data{
        int height;
        int num;

        public Data(int height, int num) {
            this.height = height;
            this.num = num;
        }
    }

    static StringBuilder sb = new StringBuilder();
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n;
    static int[] a = new int[500004];
    static Stack<Data> stk = new Stack<Data>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        stk.push(new Data(100000004, 0));

        n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++){
            int h = Integer.parseInt(st.nextToken());

            while(stk.peek().height < h){
                stk.pop();
            }

            sb.append(stk.peek().num).append(" ");

            stk.push(new Data(h, i));
        }

        bw.write(sb + "");
        bw.flush();
        bw.close();
    }
}