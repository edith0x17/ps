import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        HashMap<String, Integer> inTime = new HashMap<>();   //현재 입차 시간
        HashMap<String, Integer> total = new HashMap<>();    //누적 주차 시간
        for (String s : records) {
            String[] ss = s.split(" ");
            if (ss[2].equals("IN")) {
                inTime.put(ss[1], timeCal(ss[0]));
            } else {//"OUT"
                int time = timeCal(ss[0]) - inTime.get(ss[1]);
                total.put(ss[1], total.getOrDefault(ss[1], 0) + time);
                inTime.remove(ss[1]);
            }
        }
        for (Map.Entry<String, Integer> entry : inTime.entrySet()) {
            int time = timeCal("23:59") - entry.getValue();
            total.put(entry.getKey(), total.getOrDefault(entry.getKey(), 0) + time);
        }

        //차량번호 오름차순 정렬
        ArrayList<String> cars = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : total.entrySet()) {
            cars.add(entry.getKey());
        }
        Collections.sort(cars);
        int[] answer = new int[total.size()];
        int idx = 0;
        for (String car : cars) {
            int time = total.get(car);
            int price;
            if (time <= fees[0]) price = fees[1];
            else price = fees[1] + (int) Math.ceil((double) (time - fees[0]) / fees[2]) * fees[3];
            answer[idx++] = price;
        }
        return answer;
    }

    static int timeCal(String s) {
        int h = Integer.parseInt(s.substring(0, 2));
        int m = Integer.parseInt(s.substring(3, 5));
        return h * 60 + m;
    }
}