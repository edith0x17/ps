import java.io.*;
import java.util.*;

public class Main{
    static int n, answer;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++){
            String s = br.readLine();
            boolean flag = false;
            char prev = 'A';
            int[] a = new int[26];
            for(int j = 0; j < s.length(); j++){
                if(prev == s.charAt(j)){// prev
                    continue;
                }else{// aba
                    if(a[s.charAt(j) - 'a'] >= 1){
                        flag = true;
                        break;
                    }else{
                        a[s.charAt(j) - 'a']++;
                    }
                }
                prev = s.charAt(j);
            }
            if(!flag){
                answer++;
            }
        }
        System.out.println(answer);
    }
}