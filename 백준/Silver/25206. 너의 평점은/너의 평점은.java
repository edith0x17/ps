import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static Map<String, Double> mp = new HashMap<>();// HashMap
    static double sum1, sum2;// 학점 학점 * 등급
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        mp.put("A+", 4.5);
        mp.put("A0", 4.0);
        mp.put("B+", 3.5);
        mp.put("B0", 3.0);
        mp.put("C+", 2.5);
        mp.put("C0", 2.0);
        mp.put("D+", 1.5);
        mp.put("D0", 1.0);
        mp.put("F", 0.0);
        StringTokenizer st = null;
        for(int i = 0; i < 20; i++){
            st = new StringTokenizer(br.readLine());
            st.nextToken();// 과목명
            double b = Double.parseDouble(st.nextToken());// 학점
            String c = st.nextToken();// 등급
            if(c.equals("P"))continue;
            sum1 += b;
            sum2 += b * mp.get(c);
        }
        System.out.printf("%.4f", sum2/ sum1);
    }
}