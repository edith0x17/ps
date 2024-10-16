import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main{

    static StringBuilder sb = new StringBuilder();
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] a = new int[n + 1];
        int[] sum = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++){
            a[i] = Integer.parseInt(st.nextToken());
        }
        for(int i = 1; i <= n; i++){
            sum[i] = sum[i - 1] + a[i];
        }
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            if(start == end){
                sb.append(a[start] + "\n");
            }else if(start == 1){
                sb.append(sum[end] + "\n");
            }else{
                sb.append(sum[end] - sum[start - 1] + "\n");
            }
        }
        bw.write(sb + "");
        bw.flush();
        bw.close();
    }
}