import java.io.*;
import java.util.*;

public class Main{
    static int a, b, c;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        long answer = go(a, b, c);
        System.out.println(answer);
    }
    static long go(long base, long exponent, long C){
        if(exponent == 1){
            return base % C;
        }
        long temp = go(base, exponent/ 2, C);// base

        // finally
        if(exponent % 2 == 1){
            return ((((temp % C) * (temp % C)) % C) * (base % C)) % C;
        }
        return ((temp % C) * (temp % C)) % C;
    }
}