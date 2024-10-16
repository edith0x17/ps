import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main{

    static StringBuilder sb = new StringBuilder();
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n;
    public static void main(String[] aggs) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        Stack<Integer> stk = new Stack<>();
        n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            String op = st.nextToken();
            if(op.equals("push")){
                stk.push(Integer.parseInt(st.nextToken()));
            }else if(op.equals("pop")){
                if(stk.size() != 0){
                    sb.append(stk.peek() + "\n");
                    stk.pop();
                }else{
                    sb.append(-1 + "\n");
                }
            }else if(op.equals("size")){
                sb.append(stk.size() + "\n");
            }else if(op.equals("empty")){
                if(stk.isEmpty()){
                    sb.append(1 + "\n");
                }else{
                    sb.append(0 + "\n");
                }
            }else{
                if(stk.size() != 0){
                    sb.append(stk.peek() + "\n");
                }else{
                    sb.append(-1 + "\n");
                }
            }
        }
        bw.write(sb + "");
        bw.flush();
        bw.close();
    }
}