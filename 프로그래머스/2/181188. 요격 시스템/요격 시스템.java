import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        ArrayList<Data> adj = new ArrayList<>();
        for(int i = 0; i < targets.length; i++){
            adj.add(new Data(targets[i][0], targets[i][1]));
        }
        Collections.sort(adj);
        int answer = 1, end = adj.get(0).e;
        for(int i = 1; i < adj.size(); i++){
            if(end > adj.get(i).s){
                end = Math.min(end, adj.get(i).e);
            }else{
                answer++;
                end = adj.get(i).e;
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