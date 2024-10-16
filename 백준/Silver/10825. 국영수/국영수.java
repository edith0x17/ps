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
    static int n;
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        n = Integer.parseInt(br.readLine());
        PriorityQueue<Data> pq = new PriorityQueue<>();
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            Data data = new Data(st.nextToken(), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            pq.offer(data);
        }

        while(!pq.isEmpty()){
            Data data = pq.poll();
            sb.append(data.name + "\n");
        }
        bw.write(sb + "");
        bw.flush();
        bw.close();
    }

    static class Data implements Comparable<Data>{
        String name;
        int a, b, c;// 국어 수학 영어
        Data(){

        }
        Data(String name, int a, int b, int c){
            this.name = name;
            this.a = a;
            this.b = b;
            this.c = c;
        }

        @Override
        public int compareTo(Data o) {
            if(o.a == this.a){
                if(this.b == o.b){
                    if(o.c == this.c){
                        return this.name.compareTo(o.name);// 이름 증가
                    }
                    return o.c - this.c;// 수학 점수 감소
                }
                return this.b - o.b;// 영어 점수 증가
            }
            return o.a - this.a;// 국어 점수 감소
        }
    }
}