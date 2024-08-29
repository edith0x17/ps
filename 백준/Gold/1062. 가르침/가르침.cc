#include <bits/stdc++.h>
using namespace std;

int n, k;
vector<string> s;
bool alpha[26];
int mx = 0;

void combi(int idx, int start) {
    if (idx == k - 5) {
        int wordCount = 0;
        for (const string& word : s) {
            bool canRead = true;
            for (char ch : word) {
                if (!alpha[ch - 'a']) {
                    canRead = false;
                    break;
                }
            }
            if (canRead) wordCount++;
        }
        mx = max(mx, wordCount);
        return;
    }

    for (int i = start; i < 26; i++) {
        if (!alpha[i]) {
            alpha[i] = true;
            combi(idx + 1, i + 1);  // idx 증가, start를 i+1로 갱신하여 다음 문자 선택
            alpha[i] = false;
        }
    }
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);

    cin >> n >> k;
    if (k < 5) {
        cout << 0 << "\n";
        return 0;
    }

    for (int i = 0; i < n; i++) {
        string temp;
        cin >> temp;
        temp = temp.substr(4, temp.size() - 8);  // "anta"와 "tica"를 제거
        s.push_back(temp);
    }

    // 필수 알파벳 설정
    alpha['a' - 'a'] = true;
    alpha['c' - 'a'] = true;
    alpha['i' - 'a'] = true;
    alpha['n' - 'a'] = true;
    alpha['t' - 'a'] = true;

    combi(0, 0);  // 시작은 idx = 0, start = 0
    cout << mx << "\n";
    return 0;
}