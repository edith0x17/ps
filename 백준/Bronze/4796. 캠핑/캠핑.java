import java.io.*;
import java.util.*;

public class Main {
    static long l, p, v;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = 1;
        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            l = Integer.parseInt(st.nextToken());
            p = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());
            if(l == 0 && p == 0 && v == 0)break;
            if(v%p >= l)System.out.printf("Case %d: %d\n", cnt, (v/p)*l + l);
            else System.out.printf("Case %d: %d\n", cnt, (v/p)*l + v%p);
            cnt++;
        }
    }
}