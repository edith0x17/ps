import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static String s;
    static int[] arr = new int[10];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        s = br.readLine();
        for(int i = 0; i < s.length(); i++){
            int temp = s.charAt(i) - '0';
            if(temp == 9)temp = 6;
            arr[temp]++;
        }
        int answer = 1;
        for(int i = 0; i < 10; i++){
            if(i == 6)answer = Math.max(answer, (int)Math.round((double)arr[i]/ 2));
            else answer = Math.max(answer, arr[i]);
        }
        System.out.println(answer);
    }
}