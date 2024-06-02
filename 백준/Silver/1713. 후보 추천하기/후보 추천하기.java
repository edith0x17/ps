import java.io.*;
import java.util.*;

public class Main {
    static class Data implements Comparable<Data> {
        int num;
        int recommend;
        int date;

        public Data(int num, int recommend, int date) {
            this.num = num;
            this.recommend = recommend;
            this.date = date;
        }

        @Override
        public int compareTo(Data o) {
            if (this.recommend == o.recommend) {
                return -(this.date - o.date); // 추천 횟수가 같으면 날짜 내림차순
            }
            return -(this.recommend - o.recommend); // 추천 횟수 내림차순
        }
    }

    static StringBuilder sb = new StringBuilder();
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n, k;
    static List<Data> list = new ArrayList<>();
    static Map<Integer, Data> map = new HashMap<>(); // <key, value>

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            int temp = Integer.parseInt(st.nextToken());

            if (map.containsKey(temp)) {
                // num이 있는 경우
                Data data = map.get(temp);
                data.recommend++;
            } else {
                // num이 없는 경우
                if(n < list.size() + 1){
                    Collections.sort(list); // 정렬

                    map.remove(list.get(list.size() - 1).num);
                    list.remove(list.size() - 1);
                }

                Data data = new Data(temp, 1, i);
                map.put(temp, data);
                list.add(data);
            }
        }

        List<Integer> ret = new ArrayList<>();
        for (Data data : list) {
            ret.add(data.num);
        }

        Collections.sort(ret);

        for (int num: ret) {
            sb.append(num).append(" ");
        }

        bw.write(sb + "");
        bw.flush();
        bw.close();
    }
}