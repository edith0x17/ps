import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static String s;
    static Set<String> uniqueSet = new HashSet<>();
    static Set<String> set = new HashSet<>();
    static int k, answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        s = st.nextToken();
        if(s.equals("Y")){
            k = 1;
        }else if(s.equals("F")){
            k = 2;
        }else{
            k = 3;
        }
        for(int i = 0; i < n; i++){
            String temp = br.readLine();
            if(uniqueSet.contains(temp))continue;
            set.add(temp);
            if(set.size() == k){
                answer++;
                set = new HashSet<>();
            }
            uniqueSet.add(temp);
        }
        System.out.println(answer);
    }
}