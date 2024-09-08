#include <bits/stdc++.h>
using namespace std;

string s, common;
vector<string> v;
int main() {
    ios_base::sync_with_stdio(false); cin.tie(nullptr); cout.tie(nullptr);

    getline(cin, s);

    bool flag = false;
    string temp = "";
    for (int i = 0; i < s.size(); i++) {
        if (flag == false && s[i] == ' ') {
            flag = true;
            common = temp;
            temp = "";
            continue;
        }
        if (s[i] == ' ')continue;
        if (s[i] == ',' || s[i] == ';') {
            v.push_back(temp);
            temp = "";
            continue;
        }
        temp += s[i];
    }
    for (auto at : v) {
        string ans = common;
        int pos = -1;
        for (int i = at.size() - 1; i >= 0; i--) {
            if (at[i] == '[') {
                ans += "]";
            }
            else if (at[i] == ']') {
                ans += "[";
            }

            else if ('a' <= at[i] && at[i] <= 'z' || 'A' <= at[i] && at[i] <= 'Z') {
                pos = i;
                break;
            }
            else {
                ans += at[i];
            }

        }
        ans += " ";
        for (int i = 0; i <= pos; i++) {
            ans += at[i];
        }
        ans += ";";
        cout << ans << "\n";
    }

    return 0;
}