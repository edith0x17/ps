import java.io.*;
import java.util.StringTokenizer;

public class Main{

    static int n;
    static long[] s, b; // 신맛(곱), 쓴맛(합)
    static long ret = Long.MAX_VALUE;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        s = new long[n];
        b = new long[n];

        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            s[i] = Long.parseLong(st.nextToken());
            b[i] = Long.parseLong(st.nextToken());
        }

        for(int i = 1; i < (1 << n); i++){
            long sour = 1;
            long bitter = 0;
            for(int j = 0; j < n; j++){
                if((i & (1 << j)) != 0){ // 선택O
                    sour *= s[j];
                    bitter += b[j];
                }else{ // 선택X
                    continue;
                }
            }
            ret = Math.min(ret, Math.abs(sour - bitter));
        }

        bw.write(ret + "\n");
        bw.flush();
        bw.close();
    }
}