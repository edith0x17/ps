import java.io.*;
import java.util.*;

public class Main {
    static int g;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        g = Integer.parseInt(br.readLine());
        boolean flag = false;
        int start = 2, end = 1;
        while(end < 100000){
            int now = start * start;
            int prev = end * end;
            if(now - prev == g){
                flag = true;
                System.out.println(start);
            }

            if(now - prev >= g){
                end++;
            }else{// now - prev < g
                start++;
            }
        }
        if(!flag) System.out.println(-1);
    }
}