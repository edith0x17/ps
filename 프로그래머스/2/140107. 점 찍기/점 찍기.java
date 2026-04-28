class Solution {
    public long solution(int k, int d) {
        long answer = 0;
        //x를 하나 고정하고, 그 x에서 가능한 y 개수를 세자
        for (long x = 0; x <= d; x += k) {
            long maxY = (long) Math.sqrt((long) d * d - x * x);
            answer += maxY / k + 1;//0포함 + 1
        }
        return answer;
    }
}