import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static String string;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        string = br.readLine();
        String[] strings = string.split(" ");
        String baseType = strings[0];  // 기본 타입 저장

        for (int i = 1; i < strings.length; i++) {
            String temp = "";
            int j = 0;

            // 마지막 변수일 경우 세미콜론 제거
            strings[i] = strings[i].replace(";", "");

            // 뒤에서부터 변수형 기호 추출
            for (j = strings[i].length() - 1; j >= 0; j--) {
                char c = strings[i].charAt(j);
                if (c == ',' || c == ';') continue;
                else if (c == '[') temp += ']';
                else if (c == ']') temp += '[';
                else if (c == '*' || c == '&') temp += c;
                else break;  // 변수명 시작 위치 발견
            }

            // 변수명 추출
            String varName = strings[i].substring(0, j + 1);

            // 출력 조합
            sb.append(baseType);
            sb.append(temp);
            sb.append(" ");
            sb.append(varName);
            sb.append(";");
            sb.append("\n");
        }

        System.out.println(sb);
    }
}