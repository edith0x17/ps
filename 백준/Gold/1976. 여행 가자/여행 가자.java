import java.io.*;
import java.util.*;

public class Main {
    static int[] p = new int[204];
    static int n, m;
    public static void main(String[] args) throws IOException {
        for(int i = 0; i < 204; i++)p[i] = i;
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        for(int i = 1; i <= n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= n; j++){
                int temp = Integer.parseInt(st.nextToken());
                if(temp == 1){
                    Union(i, j);
                }
            }
        }
        boolean flag = false;
        st = new StringTokenizer(br.readLine());
        int start = Find(Integer.parseInt(st.nextToken()));
        for(int i = 1; i < m; i++){
            int next = Integer.parseInt(st.nextToken());
            if(start != Find(next)){
                flag = true;
                break;
            }
        }
        if(flag) System.out.println("NO\n");
        else System.out.println("YES");
    }
    static int Find(int x){
        if(x == p[x])return x;
        else return p[x] = Find(p[x]);
    }
    static void Union(int x, int y){
        x = Find(x);
        y = Find(y);
        if(x < y)p[y] = x;
        else p[x] = y;
    }
}