import java.util.*;

class Solution {
    public int solution(int[] elements) {
        Set<Integer> set = new HashSet<>();
        int n = elements.length;
        int[] a = new int[n + n];
        for(int i = 0; i < 2 * n; i++){
            a[i] = elements[i % n];
        }
        for(int k = 1; k <= n; k++){//길이
            for(int i = 0; i < n; i++){
                int sum = 0;
                for(int j = i; j < i + k; j++){
                    sum += a[j];
                }
                set.add(sum);
            }
        }
        return set.size();
    }
}