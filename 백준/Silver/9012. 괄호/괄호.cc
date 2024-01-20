#include <iostream>
#include <stack>
using namespace std;
int n;

int main(){
    cin >> n;
    for(int i = 0; i < n; i++){
        stack<char> stk;
        string s;
        cin >> s;
        bool flag = false;
        for(int j = 0; j < s.size(); j++){
            if(s[j] == '('){
                stk.push(s[i]);
            }else{
                if(stk.size()){
                    stk.pop();
                }else{
                    flag = true;
                  
                    break;
                }

            }
        }
        if(!flag && stk.size() == 0)cout << "YES\n";
        else cout << "NO\n";
    }
    return 0;
}