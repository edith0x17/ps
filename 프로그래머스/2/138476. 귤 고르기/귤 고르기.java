import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        Map<Integer, Integer> mp = new HashMap<>();
        for (int i : tangerine) {
            mp.put(i, mp.getOrDefault(i, 0) + 1);
        }
        ArrayList<Data> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : mp.entrySet()) {
            //System.out.println(entry.getKey() + " " + entry.getValue());
            list.add(new Data(entry.getKey(), entry.getValue()));            
        }
        Collections.sort(list, (a, b) -> b.cnt - a.cnt);//오름차순
        int sum = 0, idx = 0;
        for(int i = 0; i < list.size(); i++){
            idx++;
            sum += list.get(i).cnt;
            if(sum >= k){
                answer = idx;
                break;
            }
        }
        return answer;
    }
    
    static class Data{
        int num, cnt;
        
        public Data(int num, int cnt){
            this.num = num;
            this.cnt = cnt;
        }
    }
}