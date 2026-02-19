import java.io.*;
import java.util.*;

public class Main {
    static String[] cro = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
    static String s;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        s = br.readLine();
        for (String c : cro) {
            s = s.replace(c, "*");
        }
        System.out.println(s.length());
    }
}