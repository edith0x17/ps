#include <iostream>
using namespace std;
char a[4000][6200];
int n;
void star(int k, int i, int j);
int main() {
    ios_base::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);

    cin >> n;

    for (int i = 0; i < n; i++) {

        for (int j = 0; j < n; j++) { 
            a[i][j] = ' ';
        }
    }

    star(n, 0, 0);

    for (int i = 0; i < n; i++) { // n - 1 까지

        for (int j = 0; j < n; j++) { // 2n - 1 까지

            cout << a[i][j];
        }
        cout << '\n';
    }

}
void star(int k, int i, int j) {
    if (k == 3) {

        a[i][j] = a[i][j + 1] = a[i][j + 2] = '*'; // 1층

        a[i + 1][j] = a[i + 1][j + 2] = '*'; // 2층

        a[i + 2][j] = a[i + 2][j + 1] = a[i + 2][j + 2] = '*'; // 3층
        return;
    }

    int a = k / 3; 
    int b =  a * 2;

    star(k / 3, i, j);
    star(k / 3, i, j + a);
    star(k / 3, i, j + b);

    star(k / 3, i + a, j);
    star(k / 3, i + a, j + b);

    star(k / 3, i + b, j);
    star(k / 3, i + b, j + a);
    star(k / 3, i + b, j + b);
}
