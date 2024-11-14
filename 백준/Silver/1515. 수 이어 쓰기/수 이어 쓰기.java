import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int base = 0, pt = 0;
        while(base++ <= 30000){
            String tmp = String.valueOf(base);
            for (int i = 0; i < tmp.length(); i++) {
                if (tmp.charAt(i) == s.charAt(pt))pt++;
                if (pt == s.length()) {
                    sb.append(base);
                    System.out.println(sb);
                    return;
                }
            }
        }
    }
}