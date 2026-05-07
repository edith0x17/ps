import java.util.*;

class Solution {
    public long solution(int price, int money, int count) {
        long answer = 0, sum = 0;
        int cnt = 0;
        while(cnt != count){
            sum += (long)price * (cnt + 1);
            cnt++;
        }
        return Math.max(0, sum - money);
    }
}