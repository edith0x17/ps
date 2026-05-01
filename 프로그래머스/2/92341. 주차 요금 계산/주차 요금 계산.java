import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        Map<Integer, Integer> mp = new HashMap<>();//차 시간
        ArrayList<Data> list = new ArrayList<>();
        for (String s : records) {
            String[] tmp = s.split(" ");
            //tmp[0] tmp[1] tmp[2]
            //시간 차 type
            int t = timeCal(tmp[0]), num = Integer.parseInt(tmp[1]);

            if (tmp[2].equals("IN")) {
                mp.put(num, t);//차 시간
            } else {//OUT
                list.add(new Data(num, t - mp.get(num)));
                mp.remove(num);
            }
        }
        for (Map.Entry<Integer, Integer> entry : mp.entrySet()) {
            int num = entry.getKey();
            int parked = timeCal("23:59") - entry.getValue();
            list.add(new Data(num, parked));
        }

        mp = new HashMap<>();
        for (Data d : list) {
            mp.put(d.num, mp.getOrDefault(d.num, 0) + d.price);
        }
        list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : mp.entrySet()) {
            int num = entry.getKey();
            int time = entry.getValue();
            int fee = fees[1];
            if (time > fees[0]) fee += (int) Math.ceil((double) (time - fees[0]) / fees[2]) * fees[3];
            list.add(new Data(num, fee));
        }
        list.sort((a, b) -> a.num - b.num);
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i).price;
        }
        return answer;
    }

    static int timeCal(String s) {
        int h = Integer.parseInt(s.substring(0, 2));
        int m = Integer.parseInt(s.substring(3, 5));
        return h * 60 + m;
    }

    static class Data {
        int num, price;//price -> 주차, 가격

        public Data(int num, int price) {
            this.num = num;
            this.price = price;
        }
    }
}