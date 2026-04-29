import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        Map<Integer, Integer> mp = new HashMap<>();//num, inTime
        ArrayList<Data> list = new ArrayList<>();//num, parkedTime
        for (int i = 0; i < records.length; i++) {
            String[] arr = records[i].split(" ");
            int t = timeCal(arr[0]), num = Integer.parseInt(arr[1]);
            String type = arr[2];
            if (type.equals("IN")) {
                mp.put(num, t);
            } else {
                int parked = t - mp.get(num);
                mp.remove(num);
                list.add(new Data(num, parked));
            }
        }
        for (Map.Entry<Integer, Integer> entry : mp.entrySet()) {
            int num = entry.getKey(), parked = timeCal("23:59") - entry.getValue();
            list.add(new Data(num, parked));
        }

        Map<Integer, Integer> total = new HashMap<>();
        for (Data d : list) {
            total.put(d.num, total.getOrDefault(d.num, 0) + d.price);
        }

        ArrayList<Data> result = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : total.entrySet()) {
            int num = entry.getKey(), time = entry.getValue();
            int fee = fees[1];
            if (time > fees[0]) {
                fee += (int) Math.ceil((double) (time - fees[0]) / fees[2]) * fees[3];
            }
            result.add(new Data(num, fee));
        }
        result.sort((a, b) -> a.num - b.num);
        int[] answer = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i).price;
        }
        return answer;
    }

    static int timeCal(String s) {
        int h = Integer.parseInt(s.substring(0, 2));
        int m = Integer.parseInt(s.substring(3, 5));
        return h * 60 + m;
    }

    static class Data {
        int num, price; // 여기서 price는 중간에는 parkedTime, 마지막에는 fee로 사용

        public Data(int num, int price) {
            this.num = num;
            this.price = price;
        }
    }
}