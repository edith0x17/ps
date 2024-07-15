#include <bits/stdc++.h>
using namespace std;
struct A{
    int num;
    int age;
    string name;
};
struct cmp{
    bool operator()(const A &a, const A &b){
        if(a.age == b.age){
            return a.num > b.num; //오름차순
        }
        return a.age > b.age; //오름차순
    }
};
priority_queue<A, vector<A>, cmp> pq;

int n;
int main(){
    ios_base::sync_with_stdio(false); cin.tie(nullptr); cout.tie(nullptr);
    
    cin >> n ;

    for(int i = 0; i < n; i++){
        A temp;
        temp.num = i;
        cin >> temp.age >> temp.name;

        pq.push(temp);
    }

    while(!pq.empty()){
        cout << pq.top().age << " " << pq.top().name << "\n";
        pq.pop();
    }

    return 0;
}