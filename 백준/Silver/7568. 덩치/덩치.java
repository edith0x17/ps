import java.util.*;

class Pair {
    int x;
    int y;

    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }

    int getX(){
        return x;
    }

    int getY(){
        return y;
    }
}

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        ArrayList<Pair> arrList = new ArrayList<>();

        for(int i = 0; i < n; i++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            arrList.add(new Pair(x, y));
        }

//        for(Pair pair: arrList){
//            System.out.printf("%d ", pair.x);
//            System.out.printf("%d\n", pair.y);
//        }

        for(Pair i: arrList){
            int k = 0; // i.x i.y
            for(Pair j: arrList){
                if(j.x > i.x && j.y > i.y){
                    k++;
                }
            }
            System.out.printf("%d ", k + 1);
        }
    }
}