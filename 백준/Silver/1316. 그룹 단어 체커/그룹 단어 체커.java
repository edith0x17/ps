import java.io.*;
import java.util.*;

public class Main{
    static int n, answer;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++){
            boolean flag = false;
            String s = br.readLine();
            int[] a = new int[26];
            char prev = 'A';
            for(int j = 0; j < s.length(); j++){
                if(prev == s.charAt(j))continue;
                else{
                    if(a[s.charAt(j) - 'a'] >= 1){
                        flag = true;
                        break;
                    }else a[s.charAt(j) - 'a']++;
                }
                prev = s.charAt(j);
            }
            if(!flag){
//                System.out.println(s);
                answer++;
            }
        }
        System.out.println(answer);
    }
}