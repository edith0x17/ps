import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.StringTokenizer;

public class Solution{

    static int[] p;
    static int n, m;
    static int op, a, b;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        for(int tc = 1; tc <= t; tc++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            StringBuilder sb = new StringBuilder();
            sb.append("#").append(tc).append(' ');
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            p = new int[1000004];
            for(int i = 0; i <= n + 1; i++)p[i] = i; // make-set

            for(int i = 0; i < m; i++){
                st = new StringTokenizer(br.readLine());
                op = Integer.parseInt(st.nextToken());
                a = Integer.parseInt(st.nextToken());
                b = Integer.parseInt(st.nextToken());

                if(op == 0){ // union
                    Union(a, b);
                }else{ // find
                    int t1 = Find(a); int t2 = Find(b);

                    if(t1 != t2)sb.append(0);
                    else sb.append(1);
                }
            }
            System.out.println(sb);
        }

    }

    static int Find(int x){
        if(x == p[x])return x; // I == P
        else return p[x] = Find(p[x]); // I != P
    }
    static void Union(int x, int y){
        x = Find(x);
        y = Find(y);
        p[y] = p[x];
    }
}