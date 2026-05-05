import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        Map<String, Integer> mp = new HashMap<>();//번호, 시각
        ArrayList<Data> list = new ArrayList<>();
        for (String record : records) {
            String[] tmp = record.split(" ");//시각, 차량번호, 내역
            if (tmp[2].equals("IN")) {
                mp.put(tmp[1], timeCal(tmp[0]));//차량번호, 시각
            } else {//OUT
                list.add(new Data(tmp[1], timeCal(tmp[0]) - mp.get(tmp[1])));//차량번호, 시각
                mp.remove(tmp[1]);
            }
        }
        for (Map.Entry<String, Integer> entry : mp.entrySet()) {
            String num = entry.getKey();
            int time = entry.getValue();
            list.add(new Data(num, timeCal("23:59") - time));
        }
        mp = new HashMap<>();
        for (Data d : list) {
            mp.put(d.num, mp.getOrDefault(d.num, 0) + d.time);
        }
        ArrayList<Data> ret = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : mp.entrySet()) {
            String num = entry.getKey();
            int time = entry.getValue();
            //기본 시간(분), 기본 요금(원), 단위 시간(분), 단위 요금(원)
            int price = fees[1];
            if (time > fees[0]) price += (int) Math.ceil((double) (time - fees[0]) / fees[2]) * fees[3];
            ret.add(new Data(num, price));
        }
        ret.sort((a, b) -> a.num.compareTo(b.num));//문자열비교
        int[] answer = new int[ret.size()];
        for (int i = 0; i < ret.size(); i++) {
            answer[i] = ret.get(i).time;
        }
        return answer;
    }

    static int timeCal(String s) {
        int h = Integer.parseInt(s.substring(0, 2));
        int m = Integer.parseInt(s.substring(3, 5));
        return h * 60 + m;
    }

    static class Data {
        String num;
        int time;

        public Data(String num, int time) {
            this.num = num;
            this.time = time;
        }
    }
}