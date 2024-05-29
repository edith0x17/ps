import java.io.*;

public class Main {

    static int m;
    static boolean[] a = new boolean[21];  // 1부터 20까지 사용
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        m = Integer.parseInt(br.readLine());
        while (m-- > 0) {
            String s = br.readLine();
            String[] parts = s.split(" ");
            
            String command = parts[0];
            int index = (parts.length > 1) ? Integer.parseInt(parts[1]) : 0;

            switch (command) {
                case "add":
                    a[index] = true;
                    break;
                case "remove":
                    a[index] = false;
                    break;
                case "check":
                    bw.write(a[index] ? "1\n" : "0\n");
                    break;
                case "toggle":
                    a[index] = !a[index];
                    break;
                case "all":
                    for (int i = 1; i <= 20; i++) {
                        a[i] = true;
                    }
                    break;
                case "empty":
                    for (int i = 1; i <= 20; i++) {
                        a[i] = false;
                    }
                    break;
                default:
                    bw.write("Invalid command\n");
                    break;
            }
        }

        bw.flush();
        bw.close();
    }
}