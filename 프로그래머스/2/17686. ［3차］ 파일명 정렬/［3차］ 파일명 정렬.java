import java.util.*;

class Solution {
    public String[] solution(String[] files) {
        String[] answer = {};
        ArrayList<Data> list = new ArrayList<>();
        for (int i = 0; i < files.length; i++) {
            int s = -1, e = -1;
            for (int j = 0; j < files[i].length(); j++) {
                if (files[i].charAt(j) >= '0' && files[i].charAt(j) <= '9') {
                    s = j;
                    break;
                }
            }
            e = s;
            while (e < files[i].length() && files[i].charAt(e) >= '0' && files[i].charAt(e) <= '9') {
                e++;
            }
            String head = files[i].substring(0, s);
            String number = files[i].substring(s, e);
            list.add(new Data(files[i], head, Integer.parseInt(number), i));
        }
        Collections.sort(list);
        answer = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i).ori;
        }
        return answer;
    }

    static class Data implements Comparable<Data> {
        String ori, head;
        int number, idx;

        public Data(String ori, String head, int number, int idx) {
            this.ori = ori;
            this.head = head;
            this.number = number;
            this.idx = idx;
        }

        @Override
        public int compareTo(Data o) {
            int cmp = this.head.toLowerCase().compareTo(o.head.toLowerCase());
            if (cmp != 0) return this.head.toLowerCase().compareTo(o.head.toLowerCase());
            if (this.number != o.number) return Integer.compare(this.number, o.number);
            return Integer.compare(this.idx, o.idx);
        }
    }
}
//head number tail