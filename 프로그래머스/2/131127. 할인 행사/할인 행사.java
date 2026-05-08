// 54
import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        Map<String, Integer> wt = new HashMap<>();
        for(int i = 0; i < want.length; i++){
            wt.put(want[i], number[i]);
        }
        for(int i = 0; i <= discount.length - 10; i++){
            Map<String, Integer> tmp = new HashMap<>();
            for(int j = i; j < i + 10; j++){
                tmp.put(discount[j], tmp.getOrDefault(discount[j], 0) + 1);
            }
            if(check(wt, tmp))answer++;
        }
        return answer;
    }
    
    static boolean check(Map<String, Integer> wt, Map<String, Integer> tmp){
        for(Map.Entry<String, Integer> entry : wt.entrySet()){
                String s = entry.getKey();
                int num = entry.getValue();
                if(tmp.containsKey(s)){
                    if(tmp.get(s) < num)return false;
                }else return false;
        }
        return true;
    }
}