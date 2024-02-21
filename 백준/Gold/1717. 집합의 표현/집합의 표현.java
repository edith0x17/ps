import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.StringTokenizer;

public class Main{

    static int n, m;
    static int[] p = new int[1000004];
    static int type, a, b;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for(int i = 0; i <= n + 1; i++)p[i] = i;

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            type = Integer.parseInt(st.nextToken());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            if(type == 0){
                Union(a, b);
            }else{
                if(Find(a) != Find(b)) System.out.println("NO");
                else System.out.println("YES");
            }
        }
    }
    static int Find(int x){

        if(x == p[x])return x;
        else return p[x] = Find(p[x]); // p[x]는 x의 부모
    }
    static void Union(int x, int y){

        x = Find(x);
        y = Find(y);
        p[y] = p[x]; // Y의 부모 <- X의 부모
    }
}