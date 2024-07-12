#include <bits/stdc++.h>
using namespace std;
string s;
stack<char> stk;
int ans;
int main(){
    /*
    1) '(' push
    2) ')'
        (1) 레이저
            stk.pop();
            + stk.size()
        (2) 막대 끝 
            stk.pop();
            + 1
    */
    ios_base::sync_with_stdio(false); cin.tie(nullptr); cout.tie(nullptr);

    cin >> s;

    for(int i = 0; i < s.length(); i++){
        if(s[i] == '(')stk.push('('); //'('
        else{ //')'
            if(s[i - 1] == '('){
                stk.pop();
                ans += stk.size();
            }else{
                stk.pop();
                ans += 1;
            }
        }
    }

    cout << ans << "\n";

    return 0;
}