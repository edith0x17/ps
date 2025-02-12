import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int k, answer;
    static Stack<Integer> stk = new Stack<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        k = Integer.parseInt(br.readLine());
        for(int i = 0; i < k; i++){
            int num = Integer.parseInt(br.readLine());
            if(num == 0)stk.pop();
            else stk.push(num);
        }
        while(!stk.isEmpty()){
            answer += stk.peek();
            stk.pop();
        }
        System.out.println(answer);
    }
}