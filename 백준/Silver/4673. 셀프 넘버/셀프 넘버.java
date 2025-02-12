import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static boolean[] check = new boolean[10_001];
    public static void main(String[] args) throws IOException {
        int num = 1;
        while(num <= 10_000){
            int d = num;
            if(!check[d]){// f -> t
                while(d <= 10_000){
                    int sum = d;
                    String temp = String.valueOf(d);
                    for(int i = 0; i < temp.length(); i++){
                        sum += temp.charAt(i) - '0';
                    }
                    if(sum >= 10_001){
                        break;
                    }else{
                        check[sum] = true;
                        d = sum;
                    }
                }
            }
            num++;
        }
        for(int i = 1; i < 10_001; i++){
            if(!check[i])sb.append(i + "\n");
        }
        bw.write(sb  +"");
        bw.flush();
        bw.close();
    }
}