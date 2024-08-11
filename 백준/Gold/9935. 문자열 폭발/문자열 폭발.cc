#include <bits/stdc++.h>
using namespace std;

string s, bomb;
stack<char> stk;

int main(){
    ios_base::sync_with_stdio(false); cin.tie(nullptr); cout.tie(nullptr);

    cin >> s >> bomb;

    for(int i = 0; i < s.size(); i++){
        stk.push(s[i]);

        // 스택에 bomb 길이만큼 요소가 있는지 확인
        if(stk.size() >= bomb.size() && s[i] == bomb[bomb.size() - 1]){
            // 폭발 가능성 체크
            string temp = "";
            for(int j = 0; j < bomb.size(); j++){
                temp += stk.top();
                stk.pop();
            }

            reverse(temp.begin(), temp.end());

            // temp가 bomb와 같으면 폭발, 아니면 다시 스택에 넣기
            if(temp == bomb){
                continue;
            }else{
                for(int j = 0; j < temp.size(); j++){
                    stk.push(temp[j]);
                }
            }
        }
    }
    
    // 결과 출력
    if(stk.empty()){
        cout << "FRULA" << "\n";
    }else{
        string ret = "";
        while(!stk.empty()){
            ret += stk.top();
            stk.pop();
        }

        reverse(ret.begin(), ret.end());

        cout << ret << "\n";
    }

    return 0;
}