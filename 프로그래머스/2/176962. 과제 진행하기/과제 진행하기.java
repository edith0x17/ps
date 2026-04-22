import java.util.*;
/*1. plans를 Data 배열로 변환

2. 시작 시간 기준 정렬

3. for문으로 현재 과제와 다음 과제 비교

4. 스택에 남은 과제 저장

5. 마지막 과제 처리 후 스택 비우기*/

class Solution {
    public String[] solution(String[][] plans) {
        String[] answer = {};
        ArrayList<Data> adj = new ArrayList<>();
        for (String[] p : plans) {
            adj.add(new Data(p[0], timeCal(p[1]), Integer.parseInt(p[2])));
        }
        adj.sort((a, b) -> a.start - b.start);//오름차순

        ArrayList<String> result = new ArrayList<>();
        Stack<Data> stk = new Stack<>();
        for (int i = 0; i < adj.size() - 1; i++) {
            Data cur = adj.get(i);
            Data next = adj.get(i + 1);
            int available = next.start - cur.start;//쓸 수 있는 시간
            if (cur.remain <= available) {
                result.add(cur.name);
                int extra = available - cur.remain;
                while (!stk.isEmpty() && extra > 0) {
                    Data prev = stk.pop();
                    if (prev.remain <= extra) {
                        extra -= prev.remain;
                        result.add(prev.name);
                    } else {
                        prev.remain -= extra;
                        stk.push(prev);
                        extra = 0;
                    }
                }
            } else {
                cur.remain -= available;
                stk.push(cur);
            }
        }
        result.add(adj.get(adj.size() - 1).name);
        while (!stk.isEmpty()) {
            result.add(stk.pop().name);
        }
        return result.toArray(new String[0]);
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