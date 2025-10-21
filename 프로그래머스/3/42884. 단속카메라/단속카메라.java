import java.io.*;
import java.util.*;

class Solution {
    static PriorityQueue<Data> pq = new PriorityQueue<>();
    public int solution(int[][] routes) {
        int answer = 1;
        for(int i = 0; i < routes.length; i++){
            pq.offer(new Data(routes[i][0], routes[i][1]));
        }
        Data data = pq.poll();
        int start = data.s, end = data.e;
        while(!pq.isEmpty()){
            Data temp = pq.poll();
            if(temp.s > end){
                answer++;
                end = temp.e;
            }else{
                end = Math.min(end, temp.e);   
            }
        }
        return answer;
    }
    class Data implements Comparable<Data>{
        int s, e;
        Data(int s, int e){
            this.s = s;
            this.e = e;
        }
        @Override
        public int compareTo(Data o){
            if(this.s == o.s)return Integer.compare(this.e, o.e);
            return Integer.compare(this.s, o.s);
        }
    }
}