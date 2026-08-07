import java.util.*;

class Solution {
    static long[] arr = new long[360000];

    public String solution(String play_time, String adv_time, String[] logs) {
        for (int i = 0; i < logs.length; i++) {
            String[] ss = logs[i].split("-");
            int start = timeCal(ss[0]);
            int end = timeCal(ss[1]);
            /*arr[10] = 1//10초 ~ 11초 사이에 시청 중
            arr[11] = 0//11초 ~ 12초 사이에는 시청하지 않음*/
            arr[start]++;
            arr[end]--;
        }
        //첫 번째 누적합
        //arr[i] = i초에 보고 있는 사람 수
        for (int i = 1; i < arr.length; i++) {
            arr[i] += arr[i - 1];
        }
        //두 번째 누적합
        for (int i = 1; i < arr.length; i++) {
            arr[i] += arr[i - 1];
        }
        int play = timeCal(play_time);
        int adv = timeCal(adv_time);
        long max = arr[adv - 1];//0초부터 adv까지 누적합
        int answerTime = 0;
        for (int start = 1; start + adv <= play; start++) {//
            long sum = arr[start + adv - 1] - arr[start - 1];//arr[end] - arr[start - 1]
            if (sum > max) {
                max = sum;
                answerTime = start;
            }
        }
        return toTime(answerTime);
    }

    static String toTime(int n) {
        return String.format("%02d:%02d:%02d", n / 60 / 60, n / 60 % 60, n % 60);
    }

    static int timeCal(String str) {
        int h = Integer.parseInt(str.substring(0, 2));
        int m = Integer.parseInt(str.substring(3, 5));
        int sec = Integer.parseInt(str.substring(6, 8));
        return h * 60 * 60 + m * 60 + sec;
    }
}