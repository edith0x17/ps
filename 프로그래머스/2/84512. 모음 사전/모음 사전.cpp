#include <iostream>
#include <string>
#include <vector>
#include <unordered_map>
using namespace std;
int cnt;
unordered_map<string, int> mp;
void dfs(string s, string aeiou) {
    if(s.size() == 6)return;
    // 현재 문자열을 mp에 저장하고 카운트 증가
    mp.insert({s, cnt++});

    // aeiou 중 하나를 추가하여 새로운 문자열을 만들고 재귀 호출
    for (char c : aeiou) {
        string next = s + c;  // 현재 문자열에 'aeiou' 중 하나를 추가
        if (mp.find(next) != mp.end()) continue;  // 이미 처리된 문자열은 스킵
        dfs(next, aeiou);  // 재귀적으로 새로운 문자열을 탐색
    }
}

int solution(string word) {
    int answer = 0;
    dfs("", "AEIOU");
    answer = mp[word];
    return answer;
}