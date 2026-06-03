import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        int answer = 0;
        ArrayList<Data> list = new ArrayList<>();
        for (String[] ss : book_time) {
            //ss[0] ss[1]
            int start = timeCal(ss[0]);
            int end = timeCal(ss[1]) + 10;
            list.add(new Data(start, end));
        }
        Collections.sort(list, (a, b) -> (a.start - b.start));
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < list.size(); i++) {
            Data cur = list.get(i);
            if (!pq.isEmpty() && pq.peek() <= cur.start) pq.poll();
            pq.offer(cur.end);
            answer = Math.max(answer, pq.size());
        }
        return answer;
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