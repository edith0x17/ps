// 8
import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        int answer = 0;
        int[][] tmp = new int[book_time.length][2];
        for(int i = 0; i < book_time.length; i++){
            tmp[i][0] = timeCal(book_time[i][0]);
            tmp[i][1] = timeCal(book_time[i][1]) + 10;
        }
        Arrays.sort(tmp, (a, b) -> a[0] - b[0]);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int[] ary: tmp){
            int s = ary[0], e = ary[1];
            while(!pq.isEmpty() && pq.peek() <= s){
                pq.poll();
            }
            pq.offer(e);
            answer = Math.max(answer, pq.size());
        }
        return answer;
    }
    
    static int timeCal(String s){
        int h = Integer.parseInt(s.substring(0, 2));
        int m = Integer.parseInt(s.substring(3, 5));
        return h * 60 + m;
    }
}