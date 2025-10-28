import java.io.*;
import java.util.*;

class Solution {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    
    static int n;
    static boolean[][] visited;
    public int solution(int[][] game_board, int[][] table) {
        n = game_board.length;
        visited = new boolean[n][n];
        List<List<Data>> emptySpaces = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(game_board[i][j] == 0 && !visited[i][j]){ //
                    emptySpaces.add(extractShape(i, j, game_board, 0));
                }
            }
        }
        visited = new boolean[n][n];
        List<List<Data>> puzzlePieces = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(table[i][j] == 1 && !visited[i][j]){ //
                    puzzlePieces.add(extractShape(i, j, table, 1));
                }
            }
        }
        int answer = 0;
        boolean[] used = new boolean[puzzlePieces.size()];
        for(List<Data> space: emptySpaces){ //빈 공간들 <- 퍼즐들
            for (int i = 0; i < puzzlePieces.size(); i++) {
                if(used[i])continue;
                List<Data> piece = puzzlePieces.get(i);
                for(int rot = 0; rot < 4; rot++){
                    piece = rotate(piece);
                    if(check(space, piece)){
                        answer += piece.size();
                        used[i] = true;
                        break;
                    }
                }
                if(used[i])break;
            }
        }
        return answer;
    }
    
    static List<Data> normalize(List<Data> shape){
        ArrayList<Data> norm = new ArrayList<>();
        int minX = Integer.MAX_VALUE, minY = Integer.MAX_VALUE;
        for(Data d: shape){
            minX = Math.min(minX, d.x);
            minY = Math.min(minY, d.y);
        }
        for(Data d: shape){
            norm.add(new Data(d.x - minX, d.y - minY));
        }
        Collections.sort(norm);
        return norm;
    }
    
    static List<Data> extractShape(int x, int y, int[][] board, int target){
        List<Data> shape = new ArrayList<>();
        Queue<Data> q = new ArrayDeque<>();
        visited[x][y] = true;
        q.offer(new Data(x, y));
        while(!q.isEmpty()){
            Data data = q.poll();
            shape.add(data); //추가
            for(int i = 0; i < 4; i++){
                int nx = data.x + dx[i];
                int ny = data.y + dy[i];
                if(nx < 0 || nx >= n || ny < 0 || ny >= n)continue; //범위
                if(visited[nx][ny])continue; //방문
                if(board[nx][ny] == target){ //장애물
                    visited[nx][ny] = true;
                    q.offer(new Data(nx, ny));
                }

            }
        }
        return normalize(shape);
    }
    
    static List<Data> rotate(List<Data> shape) {
        List<Data> rotated = new ArrayList<>();
        for (Data d : shape) {
            rotated.add(new Data(d.y, -d.x)); //(x, y) -> (y, -x)
        }
        return normalize(rotated);
    }
    
    static boolean check(List<Data> a, List<Data> b){
        if(a.size() != b.size())return false;
        for (int i = 0; i < a.size(); i++) {
            if (a.get(i).x != b.get(i).x || a.get(i).y != b.get(i).y) return false;
        }
        return true;
    }
    
    static class Data implements Comparable<Data>{
        int x, y;
        Data(int x, int y){
            this.x = x;
            this.y = y;
        }
        @Override
        public int compareTo(Data o){
            if(this.x == o.x)return Integer.compare(this.y, o.y);
            return Integer.compare(this.x, o.x);
        }
    }
}