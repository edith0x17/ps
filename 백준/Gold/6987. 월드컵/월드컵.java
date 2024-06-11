import java.io.*;
import java.util.StringTokenizer;

public class Main{
    static StringBuilder sb = new StringBuilder();
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int[] home = {0, 0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 3, 3, 4};
    static int[] away = {1, 2, 3, 4, 5, 2, 3, 4, 5, 3, 4, 5, 4, 5, 5};
    static int[][] score = new int[6][3];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int i = 0; i < 4; i++){
            int total = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());

            // 6개 국가 * 승/무/패
            for(int j = 0; j < 6; j++){
                for(int k = 0; k < 3; k++){
                    score[j][k] = Integer.parseInt(st.nextToken());
                    total += score[j][k];
                }
            }

            if(total > 30) {
                sb.append(0 + " ");
                continue;
            }

            if(go(0)) sb.append(1 + " ");
            else sb.append(0 + " ");
        }

        bw.write(sb + "");
        bw.flush();
        bw.close();
    }

    static boolean go(int idx){
        if(idx == 15){
            return true;
        }

        /*
        승/무/패
        score["home[idx]" -> "국가번호"]
        score["away[idx]" -> "국가번호"]
        */

        // 홈 팀이 이기는 경우
        if(score[home[idx]][0] > 0 && score[away[idx]][2] > 0) {
            score[home[idx]][0]--;
            score[away[idx]][2]--;
            if(go(idx + 1)) return true;
            score[home[idx]][0]++;
            score[away[idx]][2]++;
        }

        // 비기는 경우
        if(score[home[idx]][1] > 0 && score[away[idx]][1] > 0) {
            score[home[idx]][1]--;
            score[away[idx]][1]--;
            if(go(idx + 1)) return true;
            score[home[idx]][1]++;
            score[away[idx]][1]++;
        }

        // 어웨이 팀이 이기는 경우
        if(score[home[idx]][2] > 0 && score[away[idx]][0] > 0) {
            score[home[idx]][2]--;
            score[away[idx]][0]--;
            if(go(idx + 1)) return true;
            score[home[idx]][2]++;
            score[away[idx]][0]++;
        }

        return false;
    }
}