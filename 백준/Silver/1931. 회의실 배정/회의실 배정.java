import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main{

    static StringBuilder sb = new StringBuilder();
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Data> pq = new PriorityQueue<>();
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            pq.offer(new Data(start, end));
        }
        int answer = 0, endTime = -1;
        while(!pq.isEmpty()){
            Data data = pq.poll();
            if(endTime <= data.s){
                answer++;
                endTime = data.e;
            }
        }
        sb.append(answer);
        bw.write(answer + "");
        bw.flush();
        bw.close();
    }

    static class Data implements Comparable<Data>{
        int s, e;
        Data(){

        }
        Data(int s, int e){
            this.s = s;
            this.e = e;
        }

        @Override
        public int compareTo(Data o) {
            if(this.e == o.e){
                return this.s - o.s;
            }
            return this.e - o.e;
        }
    }
}