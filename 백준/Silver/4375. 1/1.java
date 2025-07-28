import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;
        while ((s = br.readLine()) != null) {
            int n = Integer.parseInt(s);
            int count = 1;
            int number = 1;
            while (true) {
                if (number % n == 0) break;
                number = (number * 10 + 1);
                number = number % n; //중간에 모듈러 연산
                count++;
            }
            System.out.println(count);
        }
    }
}