import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int answer = 0, l = 1, r = 100_000;
        while(l <= r){
            int mid = (l + r)/ 2;
            long sum = 0;
            int time_prev = 0;
            for(int i = 0; i < diffs.length; i++){
                if(mid < diffs[i]){
                    sum += (time_prev + times[i]) * (diffs[i] - mid) + times[i];
                }else if(mid >= diffs[i]){
                    sum += times[i];
                }
                time_prev = times[i];
            }
            if(limit >= sum){
                answer = mid;
                //더작게
                r = mid - 1;
            }else{//limit < sum
                //더크게
                l = mid + 1;
            }
        }
        return answer;
    }
}