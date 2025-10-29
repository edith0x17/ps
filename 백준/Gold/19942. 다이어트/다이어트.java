import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[] requiredNutrients; // 단백질, 지방, 탄수화물, 비타민
    static int[][] foodInfo;
    static ArrayList<Integer> selectedFoods;
    static StringBuilder bestFoodSet = new StringBuilder(); // 최적 식재료 조합
    static boolean found = false;
    static int minCost = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        requiredNutrients = new int[4];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            requiredNutrients[i] = Integer.parseInt(st.nextToken());
        }

        foodInfo = new int[n][5]; // [단백질, 지방, 탄수화물, 비타민, 가격]
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                foodInfo[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int bitmask = 1; bitmask < (1 << n); bitmask++) {
            selectedFoods = new ArrayList<>();
            for (int bit = 0; bit < n; bit++) {
                if ((bitmask & (1 << bit)) != 0) {
                    selectedFoods.add(bit);
                }
            }
            if (isValidCombination()) {
                found = true;
            }
        }

        if (found) {
            System.out.println(minCost);
            System.out.println(bestFoodSet.toString().trim());
        } else {
            System.out.println(-1);
        }
    }

    static boolean isValidCombination() {
        int protein = 0, fat = 0, carb = 0, vitamin = 0, totalCost = 0;
        StringBuilder currentSet = new StringBuilder();

        for (int idx : selectedFoods) {
            protein += foodInfo[idx][0];
            fat += foodInfo[idx][1];
            carb += foodInfo[idx][2];
            vitamin += foodInfo[idx][3];
            totalCost += foodInfo[idx][4];
            currentSet.append((idx + 1)).append(" ");
        }

        if (protein >= requiredNutrients[0] &&
            fat >= requiredNutrients[1] &&
            carb >= requiredNutrients[2] &&
            vitamin >= requiredNutrients[3]) {

            if (minCost > totalCost) {
                minCost = totalCost;
                bestFoodSet = currentSet;
            } else if (minCost == totalCost) {
                if (bestFoodSet.toString().compareTo(currentSet.toString()) > 0) {
                    bestFoodSet = currentSet;
                }
            }

            return true;
        }

        return false;
    }
}