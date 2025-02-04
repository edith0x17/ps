import java.io.*;
import java.util.*;

public class Main {
    static class Data implements Comparable<Data>{
        String s;
        public Data(String s) {
            this.s = s;
        }

        @Override
        public int compareTo(Data d){
            if(this.s.length() == d.s.length()){
                int ret = check1(this.s, d.s);
                if(ret == 0){
                    return this.s.compareTo(d.s);// 3
                }
                return ret;// 2
            }
            return this.s.length() - d.s.length();// 1
        }
    }
    static StringBuilder sb = new StringBuilder();
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n;
    static ArrayList<Data> adj = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++){
            adj.add(new Data(br.readLine()));
        }
        Collections.sort(adj);
        for(Data data: adj){
            sb.append(data.s + "\n");
        }
        bw.write(sb + "");
        bw.flush();
        bw.close();
    }
    static int check1(String a, String b){
        int aSum = 0, bSum = 0;
        for(int i = 0; i < a.length(); i++){
            if('0' <= a.charAt(i) && a.charAt(i) <= '9')aSum += a.charAt(i) - '0';
        }
        for(int i = 0; i < b.length(); i++){
            if('0' <= b.charAt(i) && b.charAt(i) <= '9')bSum += b.charAt(i) - '0';
        }
        return aSum - bSum;
    }
}