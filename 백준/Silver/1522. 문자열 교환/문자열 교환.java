import java.io.*;
import java.util.*;

public class Main {
    static int windowSize, idx, answer = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == 'a')windowSize++;
        }
        int aCount = 0, bCount = 0;
        for(int i = 0; i < windowSize; i++){
            if(str.charAt(i) == 'a')aCount++;
            else bCount++;
        }
        str = str + str;
        for(int i = windowSize; i < str.length(); i++){
            // front
            if(str.charAt(i) == 'a')aCount++;
            else bCount++;
            // back
            if(str.charAt(idx++) == 'a')aCount--;
            else bCount--;

            answer = Math.min(answer, bCount);
        }
        System.out.println(answer);
    }
}