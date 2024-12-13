import java.io.*;
import java.util.*;

public class Main{
    static int n, answer;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        while(true){
            if(n < 0){
                answer = -1;
                break;
            }

            if(n % 5 == 0){
                answer += n / 5;
                break;
            }else{
                n = n - 2;
                answer++;
            }
        }
        System.out.println(answer);
    }
}