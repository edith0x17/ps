import java.io.*;
import java.util.*;

class Solution {
    static Set<Integer> set = new HashSet<>();
    public int solution(int[] nums) {
        int answer = 0;
        for(int i: nums){
            set.add(i);
        }
        answer = Math.min(set.size(), nums.length/ 2);
        return answer;
    }
}