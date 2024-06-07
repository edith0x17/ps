import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main{

    static class Data implements Comparable<Data>{
        int start;
        int end;

        public Data(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Data o) {
            if(this.end == o.end){
                return (this.start - o.start); // 시작 -> 오름차순
            }

            return (this.end - o.end); // 끝 -> 오름차순
        }

        @Override
        public String toString() {
            return "Data{" +
                    "start=" + start +
                    ", end=" + end +
                    '}';
        }
    }
    static StringBuilder sb = new StringBuilder();
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int n;
    static PriorityQueue<Data> pq = new PriorityQueue<>();
    static int ret;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            pq.offer(new Data(start, end));
        }

        int last = -1;
        while(!pq.isEmpty()){
            Data data = pq.poll();
            if(last <= data.start){
                ret++;
                last = data.end;
            }
        }

        sb.append(ret);

        bw.write(sb + "");
        bw.flush();
        bw.close();
    }
}