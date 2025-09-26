import java.io.*;
import java.util.*;

public class Main {
    static int x, answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        x = Integer.parseInt(br.readLine());
        while(x > 0){
            if(x % 2 != 0)answer++;
            x = x / 2;
        }
        System.out.println(answer);
    }
}