import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main{
    static StringBuilder sb = new StringBuilder();
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n;
    static int[] a, aCnt, answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        a = new int[n];
        aCnt = new int[1_000_001];
        answer = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
            aCnt[a[i]]++;
        }
        Stack<Integer> stk = new Stack<>();// idx
        for(int i = 0; i < n; i++){
            while(!stk.isEmpty() && aCnt[a[stk.peek()]]< aCnt[a[i]]){
                answer[stk.pop()] = a[i];
            }
            stk.add(i);
        }

        while(!stk.isEmpty()){
            answer[stk.pop()] = -1;
        }
        for(int i = 0; i < n; i++){
            sb.append(answer[i]).append(" ");
        }
        System.out.println(sb);
    }
}