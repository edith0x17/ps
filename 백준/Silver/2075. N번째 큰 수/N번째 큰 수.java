import java.io.*;
import java.util.*;

public class Main{
    static class Data implements Comparable<Data>{
        int i;
        public Data(int i) {
            this.i = i;
        }

        @Override
        public int compareTo(Data data){
            return -(this.i - data.i);// 역순
        }
    }
    static StringBuilder sb = new StringBuilder();
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n;
    static ArrayList<Data> adj = new ArrayList<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                adj.add(new Data(Integer.parseInt(st.nextToken())));
            }
        }
        Collections.sort(adj);
        int cnt = 0;
        for(Data data: adj){
            cnt++;
            if(cnt == n)sb.append(data.i);
        }
        bw.write(sb + "");
        bw.flush();
        bw.close();
    }
}