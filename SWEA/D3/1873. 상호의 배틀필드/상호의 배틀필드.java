import java.util.Scanner;

public class Solution {
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    static class Tank {
        int dirY, dirX;
        int posY, posX;

        Tank(int y, int x, int dirY, int dirX) {
            this.posY = y;
            this.posX = x;
            this.dirY = dirY;
            this.dirX = dirX;
        }

        @Override
        public String toString() {
            return "Tank{" +
                    "dirY=" + dirY +
                    ", dirX=" + dirX +
                    ", posY=" + posY +
                    ", posX=" + posX +
                    '}';
        }
    }

    public static void move(Tank tank, int direction, char[][] a, int h, int w) {
        tank.dirY = dy[direction];
        tank.dirX = dx[direction];

        int ny = tank.posY + dy[direction];
        int nx = tank.posX + dx[direction];

        if (ny < 0 || ny >= h || nx < 0 || nx >= w || a[ny][nx] != '.') return;

        tank.posY = ny;
        tank.posX = nx;
    }

    public static void shoot(Tank tank, char[][] a, int h, int w) {
        int shootY = tank.posY;
        int shootX = tank.posX;
        while (true) {
            shootY += tank.dirY;
            shootX += tank.dirX;
            if (shootY < 0 || shootY >= h || shootX < 0 || shootX >= w) break;

            if (a[shootY][shootX] == '#') break;

            if (a[shootY][shootX] == '*') {
                a[shootY][shootX] = '.';
                break;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        scanner.nextLine(); // 개행 문자 처리
        for (int tc = 1; tc <= t; tc++) {
            int h = scanner.nextInt();
            int w = scanner.nextInt();
            scanner.nextLine(); // 개행 문자 처리

            char[][] a = new char[h][w];
            Tank tank = null;

            for (int i = 0; i < h; i++) {
                String ss = scanner.nextLine();
                for (int j = 0; j < ss.length(); j++) {
                    a[i][j] = ss.charAt(j);

                    if (Character.compare(a[i][j], '^') == 0) {
                        tank = new Tank(i, j, -1, 0);
                        a[i][j] = '.';
                    } else if (Character.compare(a[i][j], 'v') == 0) {
                        tank = new Tank(i, j, 1, 0);
                        a[i][j] = '.';
                    } else if (Character.compare(a[i][j], '<') == 0) {
                        tank = new Tank(i, j, 0, -1);
                        a[i][j] = '.';
                    } else if (Character.compare(a[i][j], '>') == 0) {
                        tank = new Tank(i, j, 0, 1);
                        a[i][j] = '.';
                    }
                }
            }

//            System.out.println(tank);

            int n = scanner.nextInt();
            scanner.nextLine(); // 개행 문자 처리

            String s = scanner.nextLine();
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == 'U') move(tank, 0, a, h, w);
                else if (s.charAt(i) == 'D') move(tank, 2, a, h, w);
                else if (s.charAt(i) == 'L') move(tank, 3, a, h, w);
                else if (s.charAt(i) == 'R') move(tank, 1, a, h, w);
                else shoot(tank, a, h, w);
            }

            System.out.print("#" + tc + " ");
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (tank.posY == i && tank.posX == j) {
                        if (tank.dirY == -1 && tank.dirX == 0) System.out.print("^");
                        else if (tank.dirY == 0 && tank.dirX == 1) System.out.print(">");
                        else if (tank.dirY == 0 && tank.dirX == -1) System.out.print("<");
                        else System.out.print("v");
                    } else System.out.print(a[i][j]);
                }
                System.out.println();
            }
        }
    }
}
