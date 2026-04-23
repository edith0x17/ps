import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        int answer = 0;
        ArrayList<Data> list = new ArrayList<>();
        for (int i = 0; i < book_time.length; i++) {
            int start = timeCal(book_time[i][0]);
            int end = timeCal(book_time[i][1]);
            list.add(new Data(start, end + 10));
        }
        Collections.sort(list, (a, b) -> a.start - b.start);//오름차순정렬
        PriorityQueue<Integer> pq = new PriorityQueue<>();//end
        for (int i = 0; i < list.size(); i++) {
            Data cur = list.get(i);
            if (!pq.isEmpty() && pq.peek() <= cur.start) {
                pq.poll();
            }
            pq.offer(cur.end);
        }
        return pq.size();
    }

    static int timeCal(String s) {
        int h = Integer.parseInt(s.substring(0, 2));
        int m = Integer.parseInt(s.substring(3, 5));
        return h * 60 + m;
    }

    static class Data {
        int start, end;

        public Data(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}