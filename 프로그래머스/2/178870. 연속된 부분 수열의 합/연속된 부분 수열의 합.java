import java.util.*;

class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = {};
        int l = 0, r = 0, sum = 0, ml = Integer.MAX_VALUE;
        while(true){
            if(sum >= k)sum -= sequence[l++];
            else if(r == sequence.length)break;
            else if(sum < k)sum += sequence[r++];
            
            if(sum == k){
                //[l, r)
                int len = r - l;
                if(ml > len){
                    ml = len;
                    answer = new int[]{l, r - 1};   
                }
            }
        }
        return answer;
    }
}