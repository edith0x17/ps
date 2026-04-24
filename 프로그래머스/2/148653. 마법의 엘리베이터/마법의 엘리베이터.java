class Solution {
    public int solution(int storey) {
        int answer = 0;
        while (storey > 0) {
            int d = storey % 10, next = (storey / 10) % 10;

            if (d < 5) {//d
                answer += d;
            } else if (d > 5) {//10 - d
                answer += 10 - d;
                storey += 10;//carry
            } else {
                if (next >= 5) {//10 - d
                    answer += 10 - d;
                    storey += 10;//carry
                } else {//d
                    answer += d;
                }
            }
            storey /= 10;
        }
        return answer;
    }
}