#include <iostream>
using namespace std;

int a[26];

int main(){
    ios_base::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);

    string s;
    cin >> s;
    for(int i = 0; i < s.size(); i++){
        a[s[i] - 97]++;
    }

    for(int i = 0; i < 26; i++){
        cout << a[i] << ' ';
    }
    
    return 0;
}