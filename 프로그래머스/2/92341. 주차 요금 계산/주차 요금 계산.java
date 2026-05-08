import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        Map<Integer, Integer> mp = new HashMap<>();//<num, time>
        ArrayList<Data> list = new ArrayList<>();
        for(String s : records){//time, num, in/out
            String[] ss = s.split(" ");
            if(ss[2].equals("IN")){
                mp.put(Integer.parseInt(ss[1]), timeCal(ss[0]));
            }else{//"OUT"
                int num = Integer.parseInt(ss[1]);
                int time = timeCal(ss[0]) - mp.get(num);
                mp.remove(num);
                list.add(new Data(num, time));
            }
        }
        for(Map.Entry<Integer, Integer> entry : mp.entrySet()){
            int num = entry.getKey();
            int time = timeCal("23:59") - entry.getValue();
            list.add(new Data(num, time));
        }
        mp = new HashMap<>();
        for(int i = 0; i < list.size(); i++){
            Data cur = list.get(i);
            mp.put(cur.num, mp.getOrDefault(cur.num, 0) + cur.price);
        }
        list = new ArrayList<>();
        for(Map.Entry<Integer, Integer> entry : mp.entrySet()){
            int num = entry.getKey();
            int time = entry.getValue();
            int price = fees[1];
            if(time >= fees[0]){
                price += (int)Math.ceil((double)(time - fees[0]) / fees[2]) * fees[3];
            }
            list.add(new Data(num, price));
        }
        list.sort((a, b) -> a.num - b.num);
        int[] answer = new int[list.size()];
        for(int i = 0; i < list.size(); i++){
            answer[i] = list.get(i).price;
        }
        return answer;
    }
    
    static int timeCal(String s){
        int h = Integer.parseInt(s.substring(0, 2));
        int m = Integer.parseInt(s.substring(3, 5));
        return h * 60 + m;
    }
    
    static class Data{
        int num, price;//시간 -> 가격
        
        public Data(int num, int price){
            this.num = num;
            this.price = price;
        }
    }
}

// map + 23:59 -> list -> map -> ret ->