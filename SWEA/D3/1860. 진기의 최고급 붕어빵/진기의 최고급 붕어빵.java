import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution{

    static int n, m, k;
    static int[] a;
    static int[] v;
    static boolean flag;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int tc = 1; tc <= t; tc++){
            flag = false;

            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());

            a = new int[n];

            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < n; i++){
                a[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(a);
            v = new int[a[n - 1] + 4];

            go(); // 붕어빵 만들기

            for(int i = 0; i < a.length; i++){
                
                if(v[a[i]] <= 0){ // a[i] 도착시간
                    flag = true;
                    break;
                }else{
                    for(int j = a[i]; j <= a[n - 1]; j++){
                        v[j]--;
                    }
                }
            }

            if(flag) sb.append("#").append(tc).append(" ").append("Impossible").append("\n");
            else  sb.append("#").append(tc).append(" ").append("Possible").append("\n");
        }

        System.out.println(sb);
    }

    static void go(){

        for(int i = m; i <= a[n - 1]; i++){
            if(i == m){
                v[i] = k;
                continue;
            }

            if(i != m && i % m == 0){
                v[i] = v[i - 1] + k;
            }else{
                v[i] = v[i - 1];
            }
        }
    }
}