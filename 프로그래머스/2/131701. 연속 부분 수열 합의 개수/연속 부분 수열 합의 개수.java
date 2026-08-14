import java.util.*;

class Solution {
    public int solution(int[] elements) {
        int answer = 0;
        int[] a = new int[elements.length * 2];
        for (int i = 0; i < elements.length; i++) {
            a[i] = elements[i];
        }
        for (int i = elements.length; i < elements.length * 2; i++) {
            a[i] = elements[i - elements.length];
        }
        HashSet<Integer> set = new HashSet<>();
        for (int len = 1; len <= elements.length; len++) {//len
            for (int start = 0; start < elements.length; start++) {//start
                int sum = 0;
                for (int k = start; k < start + len; k++) {
                    sum += a[k];
                }
                set.add(sum);
            }
        }
        return set.size();
    }
}