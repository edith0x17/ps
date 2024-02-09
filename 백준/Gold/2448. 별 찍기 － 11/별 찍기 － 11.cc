#include <iostream>
using namespace std;
char a[4000][6200];
int n;
void star(int k, int i, int j);
int main() {
    ios_base::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);

    cin >> n;

    for (int i = 0; i < n; i++) {

        // 1/ 2 + 1/ 2
        for (int j = 0; j < 2 * n; j++) { // 2n - 1 까지
            a[i][j] = ' ';
        }
    }

    star(n, 0, n - 1);

    for (int i = 0; i < n; i++) { // n - 1 까지

        for (int j = 0; j < 2 * n; j++) { // 2n - 1 까지

            cout << a[i][j];
        }
        cout << '\n';
    }

}
void star(int k, int i, int j) {
    if (k == 3) {
        // 1층
        a[i][j] = '*';
        // 2층
        a[i + 1][j - 1] = '*';
        a[i + 1][j + 1] = '*';
        // 3층
        for (int k = j - 2; k <= j + 2; k++)

            a[i + 2][k] = '*';
        return;
    }

    star(k / 2, i, j); // 아래
    star(k / 2, i + k / 2, j - k / 2); // 왼
    star(k / 2, i + k / 2, j + k / 2); // 오
}