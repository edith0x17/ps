import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static ArrayList<Data> arrayList = new ArrayList<>();
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        StringTokenizer st = null;
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arrayList.add(new Data(a, b));
        }
        Collections.sort(arrayList);
        int idx = 0;
        for(Data d: arrayList){
            arr[idx++] = d.b;
        }
        int answer = n - lis();
        System.out.println(answer);
    }
    static class Data implements Comparable<Data>{
        int a;
        int b;
        public Data(int a, int b) {
            this.a = a;
            this.b = b;
        }
        @Override
        public int compareTo(Data o){
            return this.a - o.a;
        }
    }
    static int lis(){
        ArrayList<Integer> d = new ArrayList<>();
        d.add(arr[0]);
        for(int i = 1; i < n; i++){
            if(arr[i] > d.get(d.size() - 1)){
                d.add(arr[i]);
            }else{
                int pos = Collections.binarySearch(d, arr[i]);
                if(pos < 0)pos = -(pos + 1);
                d.set(pos, arr[i]);
            }
        }
        return d.size();
    }
}