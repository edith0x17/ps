import java.io.*;
import java.util.*;

public class Main{
    static class Data implements Comparable<Data>{
        int s, t;
        public Data(int s, int t) {
            this.s = s;
            this.t = t;
        }
        @Override
        public int compareTo(Data o){
            if(this.s == o.s){
                return this.t - o.t;
            }
            return this.s - o.s;
        }
    }
    static int n;
    static PriorityQueue<Data> pq = new PriorityQueue<>();
    static PriorityQueue<Integer> room = new PriorityQueue<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            pq.offer(new Data(s, t));
        }
        room.offer(0);// 끝 저장
        while(!pq.isEmpty()){
            Data data = pq.poll();
            if(room.peek() <= data.s){// 끝(room) <= 끝(pq), 끝 업데이트
                int temp = room.poll();
                temp = data.t;
                room.offer(temp);
            }else{// 끝(pq) 삽입
                room.offer(data.t);
            }
        }
        System.out.println(room.size());
    }
}