import java.lang.reflect.Array;
import java.util.*;

class Solution {
    public String[] solution(String[][] plans) {
        String[] answer = {};
        ArrayList<Data> list = new ArrayList<>();
        for (String[] plan : plans) {
            list.add(new Data(plan[0], timeCal(plan[1]), Integer.parseInt(plan[2])));
        }
        list.sort((a, b) -> a.start - b.start);//start오름차순
        ArrayList<String> ret = new ArrayList<>();
        Stack<Data> stk = new Stack<>();
        for (int i = 0; i < list.size() - 1; i++) {
            Data cur = list.get(i);
            Data next = list.get(i + 1);
            int available = next.start - cur.start;
            if (cur.playTime <= available) {
                ret.add(cur.name);
                int extra = available - cur.playTime;
                while (!stk.isEmpty() && extra > 0) {
                    Data prev = stk.pop();

                    if (extra >= prev.playTime) {
                        ret.add(prev.name);
                        extra -= prev.playTime;
                    } else {
                        prev.playTime -= extra;
                        stk.push(prev);
                        extra = 0;
                    }
                }
            } else {
                cur.playTime -= available;
                stk.push(cur);
            }
        }
        //list, stk순
        ret.add(list.get(list.size() - 1).name);
        while (!stk.isEmpty()) {
            Data prev = stk.pop();
            ret.add(prev.name);
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
        int start, playTime;

        public Data(String name, int start, int playTime) {
            this.name = name;
            this.start = start;
            this.playTime = playTime;
        }
    }
}