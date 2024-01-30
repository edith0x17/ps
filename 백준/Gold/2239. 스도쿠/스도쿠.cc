#include <bits/stdc++.h>
using namespace std;
string s[9];
pair<int, int> pos[81];
int n;
bool col[9][10], row[9][10], rc[9][10];
bool flag = false;
void dfs(int idx) {
    if (flag)return;
    if (idx >= n) {
        flag = true;
        for (int i = 0; i < 9; i++)cout << s[i] << '\n';
        return;
    }
    int x = pos[idx].first, y = pos[idx].second;
    for (int i = 1; i < 10; i++) {
        if (row[x][i] == false && col[y][i] == false && rc[(x / 3) * 3 + y / 3][i] == false) {
            s[x][y] = i + '0';
            row[x][i] = true; col[y][i] = true; rc[(x / 3) * 3 + y / 3][i] = true;
            dfs(idx + 1);
            if (flag)return;
            row[x][i] = false; col[y][i] = false; rc[(x / 3) * 3 + y / 3][i] = false;
            s[x][y] = '0';
        }
    }
}
int main() {
    ios_base::sync_with_stdio(false); cin.tie(NULL);
    n = 0;
    for (int i = 0; i < 9; i++) {
        cin >> s[i];
        for (int j = 0; j < 9; j++) {
            if (s[i][j] == '0') {
                pos[n].first = i; pos[n].second = j;
                n++;
            }
            else {
                row[i][s[i][j] - '0'] = true;
                col[j][s[i][j] - '0'] = true;
                int sum = (i / 3) * 3 + j / 3;
                rc[sum][s[i][j] - '0'] = true;
            }
        }
    }
    dfs(0);


}