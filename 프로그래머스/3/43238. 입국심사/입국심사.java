import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        Arrays.sort(times);
        long l = 1, r = (long)times[times.length - 1] * n;
        while(l <= r){
            long mid = (l + r) / 2;
            long cnt = 0;
            for(int i = 0; i < times.length; i++){
                cnt += mid / times[i];
            }
            if(cnt >= n){
                answer = mid;
                r = mid - 1;
            }else{
                l = mid + 1;
            }
        }
        return answer;
    }
}