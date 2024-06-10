import java.io.*;
import java.util.StringTokenizer;

import static java.lang.Math.pow;

public class Main{
    static StringBuilder sb = new StringBuilder();
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int n;
    static int r, c;
    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        int N = (int) Math.pow(2, n);

        r = Integer.parseInt(st.nextToken());

        c = Integer.parseInt(st.nextToken());

        go(N, r, c);

        sb.append(cnt);

        bw.write(cnt + "");
        bw.flush();
        bw.close();
    }

    static void go(int size, int r, int c) {
        if(size == 1)
            return;

        if(r < size/2 && c < size/2) { // 제 1사분면
            go(size/2, r, c);
        }
        else if(r < size/2 && c >= size/2) { // 제 2사분면
            cnt += (size * size / 4) * 1;
            go(size/2, r, c - size/2);
        }
        else if(r >= size/2 && c < size/2) { // 제 3사분면
            cnt += (size * size / 4) * 2;
            go(size/2, r - size/2, c);
        }
        else { // 제 4사분면
            cnt += (size * size / 4) * 3;
            go(size/2, r - size/2, c - size/2);
        }
    }
}