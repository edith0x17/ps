#include <bits/stdc++.h>
using namespace std;
struct A{
    int k;
    int e;
    int m;
    string name;
};
struct cmp{

    bool operator()(const A &a, const A &b){
        if(a.k == b.k){
            if(a.e == b.e){
                if(a.m == b.m){
                    return a.name > b.name; //이름 사전순
                }
                
                return a.m < b.m; //수학 내림차순
            }

            return a.e > b.e; //영어 오름차순 
        }

        return a.k < b.k; //국어 내림차순
    }
};
priority_queue<A, vector<A>, cmp> pq;

int n;
int main(){
    ios_base::sync_with_stdio(false); cin.tie(nullptr); cout.tie(nullptr);

    cin >> n;

    for(int i = 0; i < n; i++){
        //이름, 국어, 영어, 수학
        A temp;
        cin >> temp.name >> temp.k >> temp.e >> temp.m;

        pq.push(temp);
    }

    while(!pq.empty()){
        cout << pq.top().name << "\n";
        pq.pop();
    }
    
    return 0;
}