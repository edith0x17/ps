import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Solution{

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for(int tc = 1; tc <= t; tc++){
            ArrayList<String> arrayList = new ArrayList<>();
            
            int k = Integer.parseInt(br.readLine());
            String s = br.readLine();

            for(int i = 0; i < s.length(); i++){
                String temp = "";
                for(int j = i; j < s.length(); j++){
                    temp += s.charAt(j);
                }
                arrayList.add(temp);
            }
            
            // sort
            Collections.sort(arrayList);

            // output
            System.out.println("#" + tc + " " + arrayList.get(k - 1));
        }

    }
}