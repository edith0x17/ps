import java.io.*;
import java.util.*;

public class Main {
    static long k;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        k = Long.parseLong(br.readLine());
        long sum = 0;
        long cnt = 2;
        long l = 1;
        while(sum + cnt < k){
            sum += cnt;
            cnt *= 2;
            l++;
        }
        long idx = k - sum - 1;
        String binary = Long.toBinaryString(idx);
        while (binary.length() < l) {
            binary = "0" + binary;
        }

        StringBuilder sb = new StringBuilder();
        for (char c : binary.toCharArray()) {
            sb.append(c == '0' ? '4' : '7');
        }
        System.out.println(sb);
    }
}