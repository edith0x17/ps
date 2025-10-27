class Solution {
    public long solution(int r1, int r2) {
        long count = 0;
        for (long x = 1; x <= r2; x++) {
            long maxY = (long)Math.floor(Math.sqrt((long)r2 * r2 - x * x));
            long minY = (x < r1) ? (long)Math.ceil(Math.sqrt((long)r1 * r1 - x * x)) : 0;
            count += (maxY - minY + 1);
        }
        return count * 4; // 제1사분면만 계산했으니 4배 해줌
    }
}