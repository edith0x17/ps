import java.io.*;
import java.util.*;
public class Main{
    static int n, answer;
    static boolean flag = false;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        for(int i = 1; i <= 1_000_000; i++){
            int sum = i;
            String s =Integer.toString(i);
            for(int j = 0; j < s.length(); j++){
                sum += s.charAt(j) - '0';
            }
            if(sum == n){
                flag = true;
                answer = i;
                break;
            }
        }
        if (flag) {
            System.out.println(answer);
        }else{
            System.out.println(0);
        }
    }
}