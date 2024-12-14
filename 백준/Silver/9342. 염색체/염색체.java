import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int t;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());
        String str = "[A-F]?A+F+C+[A-F]?$";
        /*
        ? 있다 혹은 없다
        + 1개 이상
        $ 문자열 끝
         */
        while(t --> 0) {
            sb.append(br.readLine().matches(str) ? "Infected!" : "Good").append("\n");
        }
        System.out.print(sb);
    }
}