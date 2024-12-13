import java.io.*;
import java.util.*;

public class Main{
    static int n, answer;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        while(n > 0){
            if(n % 5 == 0){
                answer += n / 5;
                break;
            }
            n -= 2;
            answer++;
        }
        if(n >= 0) System.out.println(answer);
        else System.out.println(-1);
    }
}