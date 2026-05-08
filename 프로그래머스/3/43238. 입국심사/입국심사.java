import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        Arrays.sort(times);
        long left = 1, right = 1_000_000_004 * (long)n;
        while(left <= right){
            long mid = (left + right) / 2;
            //mid
            long sum = 0;
            for(int i = 0; i < times.length; i++){
                sum += mid / times[i];
            }
            if(sum >= n){
                System.out.println(mid);
                answer = mid;
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return answer;
    }
}