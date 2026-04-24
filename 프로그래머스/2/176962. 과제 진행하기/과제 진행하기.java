import java.util.*;

class Solution {
    public String[] solution(String[][] plans) {
        String[] answer = {};
        ArrayList<Data> list = new ArrayList<>();
        for (String[] p : plans) {
            list.add(new Data(p[0], timeCal(p[1]), Integer.parseInt(p[2])));
        }
        Collections.sort(list, (a, b) -> a.start - b.start);//오름차순

        ArrayList<String> ret = new ArrayList<>();
        Stack<Data> stk = new Stack<>();
        for (int i = 0; i < list.size() - 1; i++) {
            Data cur = list.get(i);
            Data next = list.get(i + 1);
            int available = next.start - cur.start;
            if (cur.remain <= available) {
                ret.add(cur.name);
                int extra = available - cur.remain;
                while (!stk.isEmpty() && extra > 0) {
                    Data prev = stk.pop();
                    if (prev.remain <= extra) {
                        ret.add(prev.name);
                        extra -= prev.remain;
                    } else {
                        prev.remain -= extra;
                        extra = 0;
                        stk.push(prev);
                    }
                }
            } else {
                cur.remain -= available;
                stk.push(cur);
            }
        }
        ret.add(list.get(list.size() - 1).name);//for
        while (!stk.isEmpty()) {//stk
            ret.add(stk.pop().name);
        }
        return ret.toArray(new String[0]);
    }

    static int timeCal(String s) {
        int h = Integer.parseInt(s.substring(0, 2));
        int m = Integer.parseInt(s.substring(3, 5));
        return h * 60 + m;
    }

    static class Data {
        String name;
        int start, remain;

        public Data(String name, int start, int remain) {
            this.name = name;
            this.start = start;
            this.remain = remain;
        }
    }
}