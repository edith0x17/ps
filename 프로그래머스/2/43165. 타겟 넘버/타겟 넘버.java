import java.io.*;
import java.util.*;

class Solution {
    static int answer = 0;
    public int solution(int[] numbers, int target) {
        go(0, 0, numbers, target);
        return answer;
    }
    static void go(int idx, int sum, int[] numbers, int target){
        if(idx == numbers.length){
            if(sum == target)answer++;
            return;
        }
        go(idx + 1, sum + numbers[idx], numbers, target);
        go(idx + 1, sum - numbers[idx], numbers, target);
    }
}