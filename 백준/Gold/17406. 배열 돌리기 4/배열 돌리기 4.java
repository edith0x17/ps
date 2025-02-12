import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int n, m, k, minRowSum = Integer.MAX_VALUE;;
    static int[][] originalBoard, rotationInfo;
    static boolean[] visited;
    static int[] operationOrder;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        originalBoard = new int[n][m];
        rotationInfo = new int[k][3];
        visited = new boolean[k];
        operationOrder = new int[k];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                originalBoard[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            rotationInfo[i][0] = Integer.parseInt(st.nextToken()) - 1;
            rotationInfo[i][1] = Integer.parseInt(st.nextToken()) - 1;
            rotationInfo[i][2] = Integer.parseInt(st.nextToken());
        }
        generatePermutations(0);
        System.out.println(minRowSum);
    }

    public static void generatePermutations(int depth) {
        if (depth == k) {
            int[][] copiedBoard = new int[n][m];
            for (int i = 0; i < n; i++) {
                System.arraycopy(originalBoard[i], 0, copiedBoard[i], 0, m);
            }
            applyOperations(copiedBoard);
            return;
        }

        for (int i = 0; i < k; i++) {
            if (!visited[i]) {
                visited[i] = true;
                operationOrder[depth] = i;
                generatePermutations(depth + 1);
                visited[i] = false;
            }
        }
    }

    public static void applyOperations(int[][] boardCopy) {
        for (int i = 0; i < operationOrder.length; i++) {
            int r = rotationInfo[operationOrder[i]][0];
            int c = rotationInfo[operationOrder[i]][1];
            int s = rotationInfo[operationOrder[i]][2];

            int startRow = r - s;
            int startCol = c - s;
            int endRow = r + s;
            int endCol = c + s;

            rotateMatrix(startRow, startCol, endRow, endCol, boardCopy);
        }
        calculateMinRowSum(boardCopy);
    }

    public static void calculateMinRowSum(int[][] boardCopy) {
        for (int i = 0; i < boardCopy.length; i++) {
            int rowSum = 0;
            for (int j = 0; j < boardCopy[i].length; j++) {
                rowSum += boardCopy[i][j];
            }
            minRowSum = Math.min(minRowSum, rowSum);
        }
    }

    public static void rotateMatrix(int startRow, int startCol, int endRow, int endCol, int[][] boardCopy) {
        if (startRow == endRow && startCol == endCol) {
            return;
        }

        int[] tempValues = new int[3]; // 보존해야 하는 값들 저장
        tempValues[0] = boardCopy[startRow][endCol]; // 오른쪽 상단 값
        tempValues[1] = boardCopy[endRow][endCol]; // 오른쪽 하단 값
        tempValues[2] = boardCopy[endRow][startCol]; // 왼쪽 하단 값

        // 1️⃣ 오른쪽 이동 (맨 위쪽 행)
        for (int col = endCol; col > startCol; col--) {// <-
            boardCopy[startRow][col] = boardCopy[startRow][col - 1];
        }

        // 2️⃣ 아래쪽 이동 (맨 오른쪽 열)
        for (int row = endRow; row > startRow; row--) {// <-
            if (row == startRow + 1) boardCopy[row][endCol] = tempValues[0];
            else boardCopy[row][endCol] = boardCopy[row - 1][endCol];
        }

        // 3️⃣ 왼쪽 이동 (맨 아래쪽 행)
        for (int col = startCol; col < endCol; col++) {// ->
            if (col == endCol - 1) boardCopy[endRow][col] = tempValues[1];
            else boardCopy[endRow][col] = boardCopy[endRow][col + 1];
        }

        // 4️⃣ 위쪽 이동 (맨 왼쪽 열)
        for (int row = startRow; row < endRow; row++) {// ->
            if (row == endRow - 1) boardCopy[row][startCol] = tempValues[2];
            else boardCopy[row][startCol] = boardCopy[row + 1][startCol];
        }

        // 내부 작은 사각형을 재귀적으로 회전
        rotateMatrix(startRow + 1, startCol + 1, endRow - 1, endCol - 1, boardCopy);
    }
}