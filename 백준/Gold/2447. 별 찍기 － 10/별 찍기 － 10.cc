#include<iostream>

using namespace std;

void recur(int i, int j, int x) {
    if (x == 1) {
        cout << "*";
        return;
    }
    else if ((i/(x/3)) % 3 == 1 && (j/(x/3)) % 3 == 1) {
        cout << " ";
    }
    else {
        recur(i, j, (x/3));
    }
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    int n;
    cin >> n;
    
    for(int i=0; i<n; i++) {
        for(int j=0; j<n; j++) {
            recur(i, j, n);
        }
        cout << "\n";
    }

    return 0;
}