import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strings = br.readLine().trim().split(" ");
        int answer = 0;
        for (String str : strings) {
            if (!str.isEmpty()) answer++;
        }
        System.out.println(answer);
    }
}