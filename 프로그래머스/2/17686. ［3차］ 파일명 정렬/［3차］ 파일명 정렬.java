import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

class Solution {
    public String[] solution(String[] files) {
        ArrayList<Data> list = new ArrayList<>();
        for (int idx = 0; idx < files.length; idx++) {
            int s = -1, e = -1;
            for (int i = 0; i < files[idx].length(); i++) {
                if ('0' <= files[idx].charAt(i) && files[idx].charAt(i) <= '9') {
                    s = i;
                    break;
                }
            }
            e = s;
            while (e < files[idx].length() && Character.isDigit(files[idx].charAt(e))) {
                e++;
            }
            String head = files[idx].substring(0, s);
            String number = files[idx].substring(s, e);
            list.add(new Data(files[idx], head, Integer.parseInt(number), idx));
        }
        Collections.sort(list);
        String[] answer = new String[files.length];
        for (int i = 0; i < files.length; i++) {
            answer[i] = list.get(i).ori;
        }
        return answer;
    }

    static class Data implements Comparable<Data> {
        String ori;
        String head;
        int number;
        int idx;

        public Data(String ori, String head, int number, int idx) {
            this.ori = ori;
            this.head = head;
            this.number = number;
            this.idx = idx;
        }

        @Override
        public int compareTo(Data o) {
            int cmp = head.compareToIgnoreCase(o.head);
            if (cmp != 0) return cmp;
            if (number != o.number) return Integer.compare(number, o.number);
            return Integer.compare(idx, o.idx);
        }
    }
}
//head, number, tail
//head 대소문자 구분X -> how???
//number Integer.parseInt()
//tail -> 원래