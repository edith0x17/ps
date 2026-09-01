import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        int[] answer = {};
        Map<String, Integer> mp1 = new HashMap<>();//<차, 시간>
        TreeMap<String, Integer> mp2 = new TreeMap<>();//<차, 시간>
        for(String s : records){
            String[] ss = s.split(" ");
            //"05:34 5961 IN"
            int time = timeCal(ss[0]);
            String num = ss[1];
            if(ss[2].equals("IN")){
                mp1.put(num, time);
            }else{//OUT
                int start = mp1.get(num), end = timeCal(ss[0]);
                mp1.remove(num);
                mp2.put(num, mp2.getOrDefault(num, 0) + end - start);
            }
        }
        for(Map.Entry<String, Integer> entry : mp1.entrySet()){
            mp2.put(entry.getKey(), mp2.getOrDefault(entry.getKey(), 0) + timeCal("23:59") - entry.getValue());
        }
        answer = new int[mp2.size()];
        int idx = 0;
        for(Map.Entry<String, Integer> entry : mp2.entrySet()){
            int time = entry.getValue();
            int price = fees[1];
            System.out.println((int)Math.ceil((time - fees[0]) / fees[2]));
            if(time > fees[0])price += (int)Math.ceil(((double)time - fees[0]) / fees[2]) * fees[3];
            answer[idx++] = price;
        }
        return answer;
    }
    
    static int timeCal(String s){
        int h = Integer.parseInt(s.substring(0, 2));
        int m = Integer.parseInt(s.substring(3, 5));
        return h * 60 + m;
    }
}