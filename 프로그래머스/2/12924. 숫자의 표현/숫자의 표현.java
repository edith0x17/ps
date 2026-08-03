class Solution {
    public int solution(int n) {
        int answer = 0;
        for(int i = 1; i <= n; i++){
            int sum = 0;
            for(int j = i; j <= n + 1; j++){
                if(sum == n){
                    answer++;
                    break;
                }else if(sum > n)break;
                sum += j;
            }
        }
        return answer;
    }
}