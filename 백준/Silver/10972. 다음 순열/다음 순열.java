import java.util.Arrays;
import java.util.Scanner;

public class Main{

    static int N;
    static int[] input;
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        input = new int[N]; // 입력 수 배열

        for (int i = 0; i < N; i++) {
            input[i] = sc.nextInt();
        }


        if(np(input)){
            for(int i: input){
                System.out.printf("%d ", i);
            }
        }else{
            System.out.println(-1);
        }

    }

    // NextPermutation(사전순 다음 순열)
    // 순열의 뒷쪽부터 작은 변화를 준다!!
    static boolean np(int[] p) { // 현 순열의 사전순 다음 순열 생성(p: 현 순열)

        final int N = p.length;

        // step1 : 교환위치 찾기(뒤쪽부터 꼭대기를 찾으면 꼭대기 이전이 교환위치가 됨)
        int i = N - 1;
        while(i > 0 && p[i - 1] >= p[i]) --i; // p[i - 1] -> 꼭대기
        if(i == 0)return false; // 현순열의 상태가 가장 큰순열이므로 np 없다

        // step2 : 교환위치(i - 1)에 넣을 값 뒤쪽부터 찾기(큰 값 중 최소값)
        int j = N - 1;
        while(p[i - 1] >= p[j]) --j; // 큰 값 중 최소값 찾으면 탈출
        // 꼭대기가 있어서 못 찾을 일이 없다

        // step3 : 교환위치(i - 1) 값과 찾은 위치(j)값 교환
        swap(p, i - 1, j);

        // step4 : 꼭대기(i)위치부터 맨뒤까지 오름차순 정렬
        int k = N - 1;
        while(i < k)swap(p, i++, k--); // i는 꼭대기, i - 1는 꼭대기 바로 직전, k는 끝

        return true;
    }

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}