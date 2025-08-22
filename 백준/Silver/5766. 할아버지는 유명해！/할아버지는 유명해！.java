import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[] a;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        while(true){
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            if(n ==0 && m == 0)break;
            a = new int[10001];
            for(int i = 0; i < n; i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < m; j++){
                    int num = Integer.parseInt(st.nextToken());
                    a[num]++;
                }
            }
            ArrayList<Integer> answer = new ArrayList<>();
            int cnt = 0, maxCnt = 0;
            for(int i = 1; i <= 10000; i++){
                maxCnt = Math.max(maxCnt, a[i]);
            }
            for(int i = 1; i <= 10000; i++){
                if(maxCnt == a[i])continue;
                
                if(cnt <= a[i]){
                    if(cnt == a[i]){
                        answer.add(i);
                    }else{ //cnt < a[i]
                        cnt = a[i];
                        answer.clear();
                        answer.add(i);
                    }
                }
            }
            for(int i: answer){
                System.out.printf(i + " ");
            }
            System.out.println();
        }
    }
}