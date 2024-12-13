import java.io.*;
import java.util.*;

public class Main{
    static class Data implements Comparable<Data>{
        String s;
        public Data(){

        }
        public Data(String s) {
            this.s = s;
        }

        @Override
        public int compareTo(Data o){
            if(this.s.length() == o.s.length()){
                return this.s.compareTo(o.s);// 사전순
            }
            return this.s.length() - o.s.length();// 오름차순
        }
    }
    static int n;
    static TreeSet<Data> treeSet = new TreeSet<Data>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        while(n-- > 0){
            treeSet.add(new Data(br.readLine()));
        }
        for(Data data: treeSet){
            System.out.println(data.s);
        }
    }
}