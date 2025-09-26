import java.io.*;
import java.util.*;

public class Main {
    static String s;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        s = br.readLine();
        String[] ss = s.split(",");
        System.out.println(ss.length);
    }
}