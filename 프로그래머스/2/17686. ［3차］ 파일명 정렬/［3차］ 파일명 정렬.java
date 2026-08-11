import java.util.*;

class Solution {
    public String[] solution(String[] files) {
        String[] answer = new String[files.length];
        PriorityQueue<Data> pq = new PriorityQueue<>();
        for (int i = 0; i < files.length; i++) {
            String s = files[i];
            int start = 0;
            while (start < s.length() && !Character.isDigit(s.charAt(start))) {
                start++;
            }
            int end = start;
            while (end < s.length() && Character.isDigit(s.charAt(end))) {
                end++;
            }
            //start, end -> 다음꺼
            String head = s.substring(0, start);
            int num = Integer.parseInt(s.substring(start, end));
            String tail = s.substring(end);
            pq.offer(new Data(s, head, tail, num, i));
        }
        int idx = 0;
        while (!pq.isEmpty()) {
            answer[idx++] = pq.poll().ori;
        }
        return answer;
    }

    static class Data implements Comparable<Data> {
        String ori, head, tail;
        int num, idx;

        public Data(String ori, String head, String tail, int num, int idx) {
            this.ori = ori;
            this.head = head;
            this.tail = tail;
            this.num = num;
            this.idx = idx;
        }

        @Override
        public int compareTo(Data o) {
            if (this.head.toUpperCase().compareTo(o.head.toUpperCase()) == 0) {
                if (this.num == o.num) {
                    return Integer.compare(this.idx, o.idx);//idx
                }
                return Integer.compare(this.num, o.num);//num
            }
            return this.head.toUpperCase().compareTo(o.head.toUpperCase());//head
        }
    }
}