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
    static int n;
    static int[] a, answer;
    static Stack<Integer> stk = new Stack<>();// idx 넣기
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        a = new int[n];
        answer = new int[n];
        for(int i = 0; i < n; i++){
            answer[i] = -1;
        }
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            a[i] = Integer.parseInt(st.nextToken());
            while(!stk.isEmpty() && a[stk.peek()] < a[i]){// (있냐 없냐 && a[stk.top()] < a[now])
                int idx = stk.peek();
                stk.pop();
                answer[idx] = a[i];
            }
            stk.add(i);// idx 넣기
        }
        for(int i = 0; i < n; i++){
            sb.append(answer[i] + " ");
        }
        System.out.println(sb);
    }
}