import java.util.*;

class Solution {
    public int solution(int[] elements) {
        int answer = 0;
        int n = elements.length;
        Set<Integer> set = new HashSet<>();
        for(int l = 1; l <= n; l++){
            for(int start = 0; start < n; start++){
                int sum = 0;
                for(int i = start; i < start + l; i++){
                    sum += elements[i % n];
                }
                set.add(sum);
            }
        }
        answer = set.size();
        return answer;
    }
}