import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        int answer = 0;
        ArrayList<Data> list = new ArrayList<>();
        for (String[] s : book_time) {
            list.add(new Data(timeCal(s[0]), timeCal(s[1]) + 10));
        }
        list.sort((a, b) -> a.s - b.s);//시작 오름차순
        PriorityQueue<Integer> pq = new PriorityQueue<>(); // 현재 사용 중인 객실들의 종료 시간
        for (int i = 0; i < list.size(); i++) {
            Data cur = list.get(i);
            while (!pq.isEmpty() && pq.peek() <= cur.s) {
                pq.poll();
            }
            pq.offer(cur.e);
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
        int s, e;

        public Data(int s, int e) {
            this.s = s;
            this.e = e;
        }
    }
}