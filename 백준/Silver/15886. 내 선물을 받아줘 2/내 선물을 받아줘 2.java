import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();
        int ans = 0;
        for (int i = 0; i + 1 < s.length(); i++) {
            if (s.charAt(i) == 'E' && s.charAt(i + 1) == 'W') ans++;
        }
        System.out.println(ans);
    }
}