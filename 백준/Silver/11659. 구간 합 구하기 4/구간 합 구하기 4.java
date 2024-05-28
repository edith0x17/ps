import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{

    static int n, m; // n개의 수, m번
    static int[] a, aSum;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        a = new int[n + 4];
        aSum = new int[n + 4];

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++){
            a[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 1; i <= n; i++){
            aSum[i] = aSum[i - 1] + a[i]; // 전 + 현
        }

//        System.out.println(Arrays.toString(a));
//        System.out.println(Arrays.toString(aSum));

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            int ret = aSum[e] - aSum[s - 1];
            bw.write(ret + "");
            bw.write("\n");
        }

        bw.flush();
        bw.close();
    }
}
